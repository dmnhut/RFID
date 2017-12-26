/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dev
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Account {
    protected String RFID;
    protected String MASOID;
    protected String name;

    // ham khoi tao voi 3 tham so ma the(RFID) ma so sv/cb(MASOID) va hoten
    // (name)
    public Account(String RFID, String MASOID, String name) {
        this.RFID = RFID;
        this.MASOID = MASOID;
        this.name = name;
    }

    // cac ham get de lay thong tin
    public String getRFID() {
        return RFID;
    }

    public String getMASOID() {
        return MASOID;
    }

    public String getName() {
        return name;
    }

    public boolean themTaiKhoan() {
        String insert = "INSERT INTO ACCOUNT VALUES('" + this.RFID + "','" + this.MASOID + "',N'" + this.name + "')";
        return ConnectToSql.update(insert);
    }

    // sua co so du lieu trong csdl, neu thanh cong tra ve true
    public boolean suaTaiKhoan() {
        String update = "UPDATE ACCOUNT set MASOID='" + this.MASOID + "N',name='" + this.name + "' WHERE RFID='"
                + this.RFID + "'";
        return ConnectToSql.update(update);
    }

    // ham xoa tai khoan khoi csdl, neu xoa thanh cong tra ve true
    public boolean xoaTaiKhoan() {
        String delete = "DELETE FROM ACCOUNT WHERE RFID='" + this.RFID + "'";
        return ConnectToSql.update(delete);
    }

    /**
     *
     * @return
     */
    public boolean refresh() {
        String select = "SELECT * FROM CHECKIN.dbo.ACCOUNT WHERE RFID='" + this.RFID + "' or codeID='" + this.RFID + "' or RFID='" + this.MASOID + "' or codeID='" + this.MASOID + "'";
        System.out.println(select);
        ResultSet rs = model.ConnectToSql.select(select);
        try {
            while (rs.next()) {
                this.RFID = rs.getString(1);
                this.MASOID = rs.getString(2);
                this.name = rs.getString(3);
                return true;
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Eror:73 from class Account");
        }
        return false;
    }

    // ham refresh tu csdl theo RFID de load lay cac gia tri
    public boolean refresh_RFID() {
        String select = "SELECT * FROM CHECKIN.dbo.ACCOUNT WHERE RFID='" + this.RFID + "'";
        ResultSet rs = model.ConnectToSql.select(select);
        try {
            while (rs.next()) {
                this.RFID = rs.getString(1);
                this.MASOID = rs.getString(2);
                this.name = rs.getString(3);
                return true;
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Eror:73 from class Account");
        }
        return false;
    }

    // ham refresh tu csdl theo MASOID de load lay cac gia tri
    public boolean refresh_MASOID() {
        String select = "SELECT * FROM CHECKIN.dbo.ACCOUNT WHERE RFID='" + this.MASOID + "'";
        ResultSet rs = ConnectToSql.select(select);
        try {
            this.RFID = rs.getString(0);
            this.MASOID = rs.getString(1);
            this.name = rs.getString(2);
            return true;
        } catch (SQLException e) {
            // e.printStackTrace();
            return false;
        }
    }
}
