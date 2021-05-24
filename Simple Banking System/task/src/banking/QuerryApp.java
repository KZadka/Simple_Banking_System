package banking;

import java.sql.*;

public class QuerryApp {

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

    public void showBalance (String cardNumber) {
        String sql = "SELECT balance FROM card "
                + "WHERE number = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, cardNumber);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("balance"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isCardNumber (String cardNumber) {
        String sql = "SELECT EXISTS (SELECT  1 FROM card "
                + "WHERE number = ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, cardNumber);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
