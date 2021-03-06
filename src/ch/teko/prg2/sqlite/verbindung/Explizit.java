package ch.teko.prg2.sqlite.verbindung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Explizit {
    public static void main(String[] args) {

        // Treiber explizit registrieren
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Pfad zur Datenbank
        String url = "jdbc:sqlite:/Users/glausm/Desktop/JDBCTutorial/chinook.db";

        // Connection Objekt zur Datenbank
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);

            boolean isValid = conn.isValid(0);
            System.out.println("Do we have a db connection? " + isValid);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
