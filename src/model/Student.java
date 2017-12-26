package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dev
 */
public class Student extends Account {

    private String lop;
    private String nganh;
    private String khoa;
    private String nienKhoa;

    // ham khoi tao mat nhien
    public Student(String RFID, String MASOID, String name, String lop, String nganh, String khoa, String nienKhoa) {
        super(RFID, MASOID, name);
        this.lop = lop;
        this.nganh = nganh;
        this.khoa = khoa;
        this.nienKhoa = nienKhoa;
    }

    // them tai khoan vao csdl, neu them thanh cong tra ve true
    public boolean themTaiKhoan() {
        if (!(model.Regex.check_Number(this.RFID)&&model.Regex.check_Maso(this.MASOID)&&model.Regex.check_txtNotNULL(this.name)&&model.Regex.check_txtNotNULL(this.lop)&&model.Regex.check_txtNotNULL(this.nganh)&&model.Regex.check_txtNotNULL(this.khoa)&&model.Regex.check_txtNotNULL(this.nienKhoa))) {
            String str = "Bạn cần điền đầy đủ tất cả các thông tin";
            if (!model.Regex.check_Maso(this.MASOID)) {
                str = "Định dạng Mã số chưa đúng";
            }
            if (!model.Regex.check_Number(this.RFID)) {
                str = "Định dạng RFID chưa đúng";
            }
            JOptionPane.showMessageDialog(null, str);
            return false;
        }
        if(this.refresh()){
            JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại");
            return false;
        }
        super.themTaiKhoan();
        String insert = "INSERT INTO STUDENT VALUES('" + this.RFID + "','" + this.MASOID + "',N'" + this.name + "',N'"
                + this.lop + "',N'" + this.nganh + "',N'" + this.khoa + "','" + this.nienKhoa + "')";
        if (Regex.check_txtNULL(insert)) {
            return false;
        }
        return ConnectToSql.update(insert);
    }

    // sua co so du lieu trong csdl, neu thanh cong tra ve true
    public boolean suaTaiKhoan() {
        super.suaTaiKhoan();
        String update = "UPDATE STUDENT set masoID='" + this.MASOID + "N',name='" + this.name + "',lop='" + this.lop
                + "',nganh=N'" + this.nganh + "',khoa='" + this.khoa + "',nienKhoa='" + this.nienKhoa + "' WHERE RFID='"
                + this.RFID + "'";
        return ConnectToSql.update(update);
    }

    // ham xoa tai khoan khoi csdl, neu xoa thanh cong tra ve true
    public boolean xoaTaiKhoan() {
        super.xoaTaiKhoan();
        String delete = "DELETE FROM STUDENT WHERE RFID='" + this.RFID + "'";
        return ConnectToSql.update(delete);
    }

    public static void deleteStudent(JTable tbl) {
        try {
            int r = tbl.getSelectedRow();
            Object id = form.frmMain.TableModel.getValueAt(r, 0);
            String sql = "DELETE FROM CHECKIN.dbo.ACCOUNT WHERE RFID='" + id + "'";
            ConnectToSql.update(sql);
            sql = "DELETE FROM CHECKIN.dbo.STUDENT WHERE RFID='" + id + "'";
            ConnectToSql.update(sql);
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
    }
    
    public static void edit2SaveStudent(JTable tbl) {
        try {
            for (int i = 0; i < tbl.getRowCount(); i++) {
                Object RFID = form.frmMain.TableModel.getValueAt(i, 0);
                Object codeID = form.frmMain.TableModel.getValueAt(i, 1);
                Object fullName = form.frmMain.TableModel.getValueAt(i, 2);
                Object Class = form.frmMain.TableModel.getValueAt(i, 3);
                Object majors = form.frmMain.TableModel.getValueAt(i, 4);
                Object college = form.frmMain.TableModel.getValueAt(i, 5);
                Object schoolYear = form.frmMain.TableModel.getValueAt(i, 6);
                String sql = "UPDATE  CHECKIN.dbo.STUDENT SET RFID = '" + RFID.toString() +"',codeID = '" + codeID.toString() + 
                        "', fullName = N'" + fullName + "', class = N'" + Class+ "', majors = N'" + majors+ "', college = N'" + college+ "', schoolYear = '" + schoolYear+
                        "' WHERE RFID = '" + RFID + "' or codeID='"+codeID.toString()+"'";
                ConnectToSql.update(sql);
                sql = "UPDATE  CHECKIN.dbo.ACCOUNT   SET RFID = '" + RFID.toString() +"',codeID = '" + codeID.toString() + 
                        "', fullName = N'" + fullName +
                        "' WHERE RFID = '" + RFID + "' or codeID='"+codeID.toString()+"'";
                ConnectToSql.update(sql);
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
    }
    
    public static void listen2Update(JTable tbl, String where) {
        try {
            form.frmMain.TableModel = new DefaultTableModel();
            String[] colsName = {"RFID","MÃ SỐ", "HỌ VÀ TÊN", "LỚP", "NGÀNH", "KHOA", "NIÊN KHÓA"};
            form.frmMain.TableModel.setColumnIdentifiers(colsName);
            tbl.setModel(form.frmMain.TableModel);
            String sql = "SELECT * FROM STUDENT" + where;

            ResultSet rs = model.ConnectToSql.select(sql);
            while (rs.next()) {
                Object rows[] = new Object[7];
                rows[0] = rs.getString(1);
                rows[1] = rs.getString(2);
                rows[2] = rs.getString(3);
                rows[3] = rs.getString(4);
                rows[4] = rs.getString(5);
                rows[5] = rs.getString(6);
                rows[6] = rs.getString(7);
                form.frmMain.TableModel.addRow(rows);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    // ham refresh tu csdl theo RFID de load lay cac gia tri
    public boolean refresh_RFID() {
        String select = "SELECT * FROM STUDENT WHERE RFID='" + this.RFID + "'";
        ResultSet rs = ConnectToSql.select(select);
        try {
            this.RFID = rs.getString(0);
            this.MASOID = rs.getString(1);
            this.name = rs.getString(2);
            this.lop = rs.getString(3);
            this.nganh = rs.getString(4);
            this.khoa = rs.getString(5);
            this.nienKhoa = rs.getString(6);
            return true;
        } catch (SQLException e) {
            // e.printStackTrace();
            return false;
        }
    }

    // ham refresh tu csdl theo MASOID de load lay cac gia tri
    public boolean refresh_MASOID() {
        String select = "SELECT * FROM STUDENT WHERE RFID='" + this.MASOID + "'";
        ResultSet rs = ConnectToSql.select(select);
        try {
            this.RFID = rs.getString(0);
            this.MASOID = rs.getString(1);
            this.name = rs.getString(2);
            this.lop = rs.getString(3);
            this.nganh = rs.getString(4);
            this.khoa = rs.getString(5);
            this.nienKhoa = rs.getString(6);
            return true;
        } catch (SQLException e) {
            // e.printStackTrace();
            return false;
        }
    }
}
