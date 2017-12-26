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
public class Employer extends Account {

    private String email;
    private String boMon_To;
    private String khoa_Phong;

    // ham khoi tao mat nhien
    public Employer(String RFID, String MASOID, String name, String email, String boMon_To, String khoa_Phong) {
        super(RFID, MASOID, name);
        this.email = email;
        this.boMon_To = boMon_To;
        this.khoa_Phong = khoa_Phong;
    }
    
    // them tai khoan vao csdl, neu them thanh cong tra ve true
    public boolean themTaiKhoan() {
        if (!(model.Regex.check_Number(this.RFID)&&model.Regex.check_Maso(this.MASOID)&&model.Regex.check_txtNotNULL(this.name)&&model.Regex.check_txtNotNULL(this.boMon_To)&&model.Regex.check_Email(this.email)&&model.Regex.check_txtNotNULL(this.khoa_Phong))) {
            String str = "Bạn cần điền đầy đủ tất cả các thông tin";
            if (!model.Regex.check_Email(this.email)) {
                str = "Định dạng email chưa đúng";
            }
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
        ConnectToSql sql = new ConnectToSql();
        String insert = "INSERT INTO EMPLOYER VALUES('" + this.RFID + "','" + this.MASOID + "','" + this.name + "','"
                + this.email + "','" + this.boMon_To + "','" + this.khoa_Phong + "')";
        
        return ConnectToSql.update(insert);
    }

    // sua co so du lieu trong csdl, neu thanh cong tra ve true
    public boolean suaTaiKhoan() {
        super.suaTaiKhoan();
        String update = "UPDATE EMPLOYER set masoID='" + this.MASOID + "',name='" + this.name + "',email='"
                + this.email + "',boMon_To='" + this.boMon_To + "',khoa_Phong='" + this.khoa_Phong + "' WHERE RFID='"
                + this.RFID + "'";
        return ConnectToSql.update(update);
    }

    // ham xoa tai khoan khoi csdl, neu xoa thanh cong tra ve true
    public boolean xoaTaiKhoan() {
        super.xoaTaiKhoan();
        String delete = "DELETE FROM EMPLOYER WHERE RFID='" + this.RFID + "'";
        return ConnectToSql.update(delete);
    }

    public static void deleteEmployer(JTable tbl) {
        try {
            int r = tbl.getSelectedRow();
            Object id = form.frmMain.TableModel.getValueAt(r, 0);
            String sql = "DELETE FROM CHECKIN.dbo.ACCOUNT WHERE RFID='" + id + "'";
            ConnectToSql.update(sql);
            sql = "DELETE FROM CHECKIN.dbo.EMPLOYER WHERE RFID='" + id + "'";
            ConnectToSql.update(sql);
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
    }
    
    public static void edit2SaveEmployer(JTable tbl) {
        try {
            for (int i = 0; i < tbl.getRowCount(); i++) {
                Object RFID = form.frmMain.TableModel.getValueAt(i, 0);
                Object codeID = form.frmMain.TableModel.getValueAt(i, 1);
                Object fullName = form.frmMain.TableModel.getValueAt(i, 2);
                Object email = form.frmMain.TableModel.getValueAt(i, 3);
                Object gender = form.frmMain.TableModel.getValueAt(i, 4);
                Object department = form.frmMain.TableModel.getValueAt(i, 5);
                String sql = "UPDATE  CHECKIN.dbo.EMPLOYER SET RFID = '" + RFID.toString() +"',codeID = '" + codeID.toString() + 
                        "', fullName = N'" + fullName + "', email = '" + email+ "', gender = N'" + gender+ "', department = N'" + department+
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
            String[] colsName = {"RFID","MÃ SỐ", "HỌ VÀ TÊN", "EMAIL", "BỘ MÔN/ TỔ", "KHOA/ PHÒNG"};
            form.frmMain.TableModel.setColumnIdentifiers(colsName);
            tbl.setModel(form.frmMain.TableModel);
            String sql = "SELECT * FROM EMPLOYER" + where;
            
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
        //    e.printStackTrace();
        }
    }
    
    // ham refresh tu csdl theo RFID de load lay cac gia tri
    public boolean refresh_RFID() {
        String select = "SELECT * FROM EMPLOYER WHERE RFID='" + this.RFID + "'";
        ResultSet rs = ConnectToSql.select(select);
        try {
            this.RFID = rs.getString(0);
            this.MASOID = rs.getString(1);
            this.name = rs.getString(2);
            this.email = rs.getString(3);
            this.boMon_To = rs.getString(4);
            this.khoa_Phong = rs.getString(5);
            return true;
        } catch (SQLException e) {
            // e.printStackTrace();
            return false;
        }
    }

    // ham refresh tu csdl theo MASOID de load lay cac gia tri
    public boolean refresh_MASOID() {
        String select = "SELECT * FROM EMPLOYER WHERE RFID='" + this.MASOID + "'";
        ResultSet rs = ConnectToSql.select(select);
        try {
            this.RFID = rs.getString(0);
            this.MASOID = rs.getString(1);
            this.name = rs.getString(2);
            this.email = rs.getString(3);
            this.boMon_To = rs.getString(4);
            this.khoa_Phong = rs.getString(5);
            return true;
        } catch (SQLException e) {
            // e.printStackTrace();
            return false;
        }
    }
}
