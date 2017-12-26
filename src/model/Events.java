package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dev
 */
public class Events {

    private String codeNo;
    private String name;
    private String date;
    private String beginTime;
    private String endTime;

    public Events(String codeNo, String name, String date, String beginTime, String endTime) {
        this.codeNo = codeNo;
        this.name = name;
        this.date = date;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public String getCodeNo() {
        return this.codeNo;
    }

    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * them vao danh sach diem danh
     *
     * @param ac
     * @return
     */
    public boolean addCheckin(Account ac, boolean check) {
        String sql;
        boolean check2 = false;
        if (check) {
            sql = "update CHECKIN.dbo.CHECKIN set inputTime='" + new model.Date().getTime() + "'where codeID='" + ac.MASOID + "' and codeNo='" + this.codeNo + "' and inputTime is null";
        } else {
            sql = "update CHECKIN.dbo.CHECKIN set outTime='" + new model.Date().getTime() + "'where codeID='" + ac.MASOID + "' and codeNo='" + this.codeNo + "'";
        }
        if (checkRegister(ac)) {
            check2 = model.ConnectToSql.update(sql);
        }
        return check2;
    }

    public boolean addRegister(Account ac) {
        boolean check = false;
        String sql = "insert into CHECKIN.dbo.REGISTER values('" + this.codeNo + "','" + ac.RFID + "','" + ac.MASOID + "')";
        String sql2 = "INSERT INTO CHECKIN.dbo.CHECKIN (codeNO,codeID,fullName) VALUES('" + this.codeNo + "','" + ac.getMASOID() + "', N'" + ac.getName() + "');";
        check = model.ConnectToSql.update(sql);
        model.ConnectToSql.update(sql2);
        if (check) {
            //JOptionPane.showMessageDialog(null, "Đã thêm thành công " + ac.name + " vào sự kiện " + this.name);
        } else {
            JOptionPane.showMessageDialog(null, "Thêm thất bại: " + ac.name + " đã tồn tại trong danh sách của sự kiên " + this.name);
        }

        return check;
    }

    /**
     * giong nhu addRegister nhung khong xua ra thong bao
     *
     * @param ac
     * @return
     */
    public boolean addRegisterofexcel(Account ac) {
        boolean check = false;
        String sql = "insert into CHECKIN.dbo.REGISTER values('" + this.codeNo + "','" + ac.RFID + "','" + ac.MASOID + "')";
        String sql2 = "INSERT INTO CHECKIN.dbo.CHECKIN (codeNO,codeID,fullName) VALUES('" + this.codeNo + "','" + ac.getMASOID() + "', N'" + ac.getName() + "');";
        check = model.ConnectToSql.update(sql);
        model.ConnectToSql.update(sql2);
        return check;
    }

    /**
     * Kiem tra xem nguoi dung ac co dang ki hay chua neu roi thi return true
     *
     * @param
     * @return
     */
    public boolean checkRegister(Account ac) {
        try {
            String sql = "select * from CHECKIN.dbo.REGISTER where codeNo='" + this.codeNo + "' and RFID='" + ac.RFID + "'";
            ResultSet rs = model.ConnectToSql.select(sql);
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean refresh() {
        boolean check = false;
        try {
            String sql = "select * from CHECKIN.dbo.EVENTS where codeNo='" + this.codeNo + "'or name=N'" + this.name + "'";
            ResultSet rs = model.ConnectToSql.select(sql);
            while (rs.next()) {
                this.codeNo = rs.getString(1);
                this.name = rs.getString(2);
                this.date = rs.getString(3);
                this.beginTime = rs.getString(4);
                this.endTime = rs.getString(5);
                check = true;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(null, "EROR 128 from model.events");
        }
        return check;
    }

    public boolean addEvents() {
        String str = "";
        if (!(model.Regex.check_txtNotNULL(this.codeNo) && model.Regex.check_Time(this.beginTime) && model.Regex.check_Time(this.endTime) && model.Regex.check_Date(this.date))) {
            str = "Bạn chưa điền đầy đủ thông tin";
            if (!model.Regex.check_Time(this.endTime)) {
                str = "Định dạng thời gian ra chưa đúng: HH:mm";
            }
            if (!model.Regex.check_Time(this.beginTime)) {
                str = "Định dạng thời gian vào chưa đúng: HH:mm";
            }
            if (!model.Regex.check_Date(this.date)) {
                str = "Định dạng ngày chưa đúng: dd/mm/yyyy";
            }
            JOptionPane.showMessageDialog(null, str);
            return false;
        }
        if (this.refresh()) {
            JOptionPane.showMessageDialog(null, "Trùng mã số hoạc tên sự kiện");
            return false;
        }
        String sql = "INSERT INTO EVENTS VALUES ('" + this.getCodeNo() + "', N'" + this.getName() + "', '" + this.getDate()
                + "', '" + this.getBeginTime() + "', '" + this.getEndTime() + "')";
        return ConnectToSql.update(sql);
    }

    public static void listen2Update(JTable tbl, String where) {
        try {
            form.frmMain.TableModel = new DefaultTableModel();
            String[] colsName = {"MÃ SỐ", "TÊN SỰ KIỆN", "NGÀY TỔ CHỨC", "THỜI GIAN BẮT ĐẦU", "THỜI GIAN KẾT THÚC"};
            form.frmMain.TableModel.setColumnIdentifiers(colsName);
            tbl.setModel(form.frmMain.TableModel);
            String sql = "SELECT * FROM EVENTS" + where;
            System.out.println(sql);
            ResultSet rs = model.ConnectToSql.select(sql);
            while (rs.next()) {
                Object rows[] = new Object[5];
                rows[0] = rs.getString(1);
                rows[1] = rs.getString(2);
                rows[2] = rs.getString(3);
                rows[3] = rs.getString(4);
                rows[4] = rs.getString(5);
                form.frmMain.TableModel.addRow(rows);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public static String loadID() {

        try {
            String sql = "select COUNT(*) from EVENTS";
            ResultSet rs = model.ConnectToSql.select(sql);
            while (rs.next()) {
                int stt = rs.getInt(1);
                return "EV00" + (++stt);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return "EV001";
    }

    public static void loadEvents(JComboBox cbo) {
        try {
            String sql = "SELECT name FROM EVENTS";
            ResultSet rs = model.ConnectToSql.select(sql);
            while (rs.next()) {
                Object rows = new Object();
                rows = rs.getString(1);
                cbo.addItem(rows);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public static void edit2SaveEvents(JTable tbl) {
        try {
            for (int i = 0; i < tbl.getRowCount(); i++) {
                Object codeNo = form.frmMain.TableModel.getValueAt(i, 0);
                Object name = form.frmMain.TableModel.getValueAt(i, 1);
                Object date = form.frmMain.TableModel.getValueAt(i, 2);
                Object beginTime = form.frmMain.TableModel.getValueAt(i, 3);
                Object endTime = form.frmMain.TableModel.getValueAt(i, 4);
                String sql = "UPDATE EVENTS SET codeNo = '" + codeNo.toString() + "', name = N'" + name + "', date = '" + date + "', beginTime = '" + beginTime + "', endTime = '" + endTime + "' WHERE codeNo = '" + codeNo + "'";
                ConnectToSql.update(sql);
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
    }

    public static void loadTableCheckin(JTable tbl, String eventName) {
        Events ev = new Events("", eventName, "", "", "");
        ev.refresh();
        try {
            form.frmMain.TableModel = new DefaultTableModel();
            String[] colsName = {"MÃ SỐ", "HỌ VÀ TÊN", "THỜI GIAN VÀO", "THỜI GIAN RA"};
            form.frmMain.TableModel.setColumnIdentifiers(colsName);
            tbl.setModel(form.frmMain.TableModel);
            String sql = "select codeID,fullName,inputTime,outTime from CHECKIN.dbo.CHECKIN where codeNo='" + ev.codeNo + "'";
            ResultSet rs = model.ConnectToSql.select(sql);
            while (rs.next()) {
                Object rows[] = new Object[4];
                rows[0] = rs.getString(1);
                rows[1] = rs.getString(2);
                rows[2] = rs.getString(3);
                rows[3] = rs.getString(4);
                form.frmMain.TableModel.addRow(rows);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public static void deleteEvents(JTable tbl) {
        try {
            int r = tbl.getSelectedRow();
            Object id = form.frmMain.TableModel.getValueAt(r, 0);
            String sql = "DELETE FROM EVENTS WHERE codeNo='" + id + "'";
            ConnectToSql.update(sql);
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
    }
}
