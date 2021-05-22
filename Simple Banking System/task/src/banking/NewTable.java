package banking;

import java.sql.*;

public class NewTable {

    public static void createNewTable() {
        String url = "jdbc:sqlite:C:/Users/Krzysiek/IdeaProjects/Simple Banking System/Simple Banking System/task/card.s3db";

        String sql = "CREATE TABLE IF NOT EXISTS card ("
                    + "id INTEGER PRIMARY KEY,"
                    + "number TEXT,"
                    + "pin TEXT,"
                    + "balance INTEGER DEFAULT 0"
                    + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:C:/Users/Krzysiek/IdeaProjects/Simple Banking System/Simple Banking System/task" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                //System.out.println("The driver name is " + meta.getDriverName());
                //System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
