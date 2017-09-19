package model;

/**
 *
 * @author Dev
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ConnectToSql {

    public static Connection con;

    public static ResultSet select(String sql) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://WORKSPACE\\Dev:1433;databaseName=CHECKIN" + ";integratedSecurity=true");
            java.sql.Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            System.out.println(sql);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean update(String sql) {
        boolean flag = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://WORKSPACE\\Dev:1433;databaseName=CHECKIN" + ";integratedSecurity=true");
            java.sql.Statement s = con.createStatement();
            s.executeUpdate(sql);
            System.out.println(sql);
            flag = !flag;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
