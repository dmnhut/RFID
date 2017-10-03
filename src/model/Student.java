package model;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        if(this.RFID.matches("") || this.MASOID.matches("") || this.name.matches("") || this.lop.matches("") || this.nganh.matches("") || this.khoa.matches("") || this.nienKhoa.matches("")){
            return false;
        }
        super.themTaiKhoan();
        String insert = "INSERT INTO STUDENT VALUES('" + this.RFID + "','" + this.MASOID + "','" + this.name + "','"
                + this.lop + "','" + this.nganh + "','" + this.khoa + "','" + this.nienKhoa + "')";
        if (Regex.check_txtNULL(insert)) {
            return false;
        }
        return ConnectToSql.update(insert);
    }

    // sua co so du lieu trong csdl, neu thanh cong tra ve true
    public boolean suaTaiKhoan() {
        super.suaTaiKhoan();
        String update = "UPDATE STUDENT set masoID='" + this.MASOID + "',name='" + this.name + "',lop='" + this.lop
                + "',nganh='" + this.nganh + "',khoa='" + this.khoa + "',nienKhoa='" + this.nienKhoa + "' WHERE RFID='"
                + this.RFID + "'";
        return ConnectToSql.update(update);
    }

    // ham xoa tai khoan khoi csdl, neu xoa thanh cong tra ve true
    public boolean xoaTaiKhoan() {
        super.xoaTaiKhoan();
        String delete = "DELETE FROM STUDENT WHERE RFID='" + this.RFID + "'";
        return ConnectToSql.update(delete);
    }

    public static void listen2Update(JTable tbl, String where) {
        try {
            form.frmMain.TableModel = new DefaultTableModel();
            String[] colsName = {"MÃ SỐ", "HỌ VÀ TÊN", "LỚP", "NGÀNH", "KHOA", "NIÊN KHÓA"};
            form.frmMain.TableModel.setColumnIdentifiers(colsName);
            tbl.setModel(form.frmMain.TableModel);
            String sql = "SELECT * FROM STUDENT" + where;
            System.out.println(sql);
            ResultSet rs = model.ConnectToSql.select(sql);
            while (rs.next()) {
                Object rows[] = new Object[6];
                rows[0] = rs.getString(1);
                rows[1] = rs.getString(2);
                rows[2] = rs.getString(3);
                rows[3] = rs.getString(4);
                rows[4] = rs.getString(5);
                rows[5] = rs.getString(6);
                form.frmMain.TableModel.addRow(rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
