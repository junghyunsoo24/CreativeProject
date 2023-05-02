package DB;

import java.sql.*;

public class DBConnectionTest {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/creative_project";
            String id = "root";
            String password = "1234";
            conn = DriverManager.getConnection(url, id, password);

            String sql = "SELECT * FROM consumption_amount";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int pk = rs.getInt("id");
                int year = rs.getInt("year");
                String dong_code = rs.getString("dong_code");
                String dong_name = rs.getString("dong_name");
                String industry_code = rs.getString("industry_code");
                String industry_name = rs.getString("industry_name");
                int amount = rs.getInt("amount");
                System.out.printf("%d | %d | %s | %s | %s | %s | %d\n", pk, year, dong_code, dong_name, industry_code, industry_name, amount);
            }

        } catch (SQLException e) {
            System.out.println("오류 : " + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
