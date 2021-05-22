package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertApp {

    private Connection connect() {
        String url = "jdbc:sqlite:C:/Users/Krzysiek/IdeaProjects/Simple Banking System/Simple Banking System/task/card.s3db";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public void insert (String number, String pin, int balance) {
        String sql = "INSERT INTO card (number, pin, balance) VALUES (?, ?, ?)";

        try (Connection con = this.connect();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, number);
            pstmt.setString(2, pin);
            pstmt.setInt(3, balance);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
