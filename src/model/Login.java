package model;

/**
 *
 * @author Dev
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {

    private String username;
    private String password;
    private String codeID;
    private String fullname;

    public String getFullname() {
        return fullname;
    }

    public String getCodeID() {
        return codeID;
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setCodeID(String codeID) {
        this.codeID = codeID;
    }

    // ham kiem tra mat vs mat khau trong csdl co khop hay khong, neu khop thi
    // tra ve true
    public boolean checkLogin() {
        try {
            String select = "SELECT * FROM LOGIN";
            ResultSet rs = model.ConnectToSql.select(select);
            while (rs.next()) {
                if (this.username.equals(rs.getString(1)) && new MD5().md5(this.password).equals(rs.getString(2))) {
                    this.fullname = rs.getString(4);
                    this.codeID = rs.getString(3);
                    model.ConnectToSql.con.close();
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    // them tai khoan moi de dang nhap phan mem
    public boolean addAccount() {
        String update = "INSERT INTO LOGIN VALUES('" + this.username + "', '" + new MD5().md5(this.password) + "', '" + this.codeID + "', N'" + this.fullname + "')";
        return model.ConnectToSql.update(update);
    }

    // doi mat khau nguoi dung
    public boolean changePassword(String newPassword) {
        if (checkLogin()) {
            String update = "UPDATE LOGIN SET password='" + new MD5().md5(newPassword) + "' WHERE username='" + this.username + "'";
            return ConnectToSql.update(update);
        } else {
            return false;
        }
    }

    // xoa tai khoang nguoi dung
    public boolean deleteAccount() {
        String delete = "DELETE FROM LOG WHERE username='" + this.username + "'";
        return model.ConnectToSql.update(delete);
    }

    // ham luu lai thoi gian dang nhap va dang xuat cua nguoi dung,
    // logFile(true) luu login, logFile(false) luu logout neu thanh cong, ket
    // qua tra ve true
    public boolean logFile(boolean checkLogin) {
        // duong dan de luu file logFile
        String pathName = "C:\\CHECKIN-demo\\Login";
        File file = new File(pathName);
        // kiem tra thu muc co ton tai chua,neu chua thi tao thu muc
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        // kiem tra tao tin co ton tai chua, neu chua thi tao tap tin
        pathName = "C:\\CHECKIN-demo\\Login\\logFile";
        file = new File(pathName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        // ghi du lieu vao file
        try {
            FileWriter fr = new FileWriter(file, true);
            Date date = new Date();
            String str = date.getDate() + " " + date.getTime() + " " + this.username;
            if (checkLogin) {
                str += " Login\r\n";
            } else {
                str += " Logout\r\n";
            }
            fr.write(str);
            fr.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        Login login = new Login("", "");
        login.setCodeID("000");
        login.setFullname("root");
        login.setPassword("root");
        login.setUsername("root");
        login.addAccount();
        login.setCodeID("001");
        login.setFullname("Doan Minh Nhut");
        login.setPassword("admin");
        login.setUsername("admin");
        login.addAccount();
    }
}
