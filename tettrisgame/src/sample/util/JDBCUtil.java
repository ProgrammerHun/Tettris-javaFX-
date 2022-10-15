package sample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("드라이버 파일을 찾을 수 없습니다.");
            return null;
        }

        String connectionString = "jdbc:mysql://";
        String userId = "yy_10125";
        String password = "1234";

        Connection con = null;

        try{
            con = DriverManager.getConnection(connectionString, userId, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 연결중 오류 발생");
        }
        return con;
    }

    public static void close(Connection value) {
        if(value != null) try { value.close(); } catch (Exception e) {}
    }

    public static void close(PreparedStatement value) {
        if(value != null) try { value.close(); } catch (Exception e) {}
    }

    public static void close(ResultSet value) {
        if(value != null) try { value.close(); } catch (Exception e) {}
    }

}