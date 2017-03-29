import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Sqlite3Connector {
    Connection conn;

    public Sqlite3Connector(){
        Connection conn = null;
    }

    // String url = "jdbc:sqlite:/Users/krishermstad/Data/sqlite/test.db";
    public void connect(String url){
        try {
            // create a connection to the database
            this.conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            this.getAllFromDatabase();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (this.conn != null) {
                    this.conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    // getAllFromDatabase
    public void getAllFromDatabase(){
        Statement stmt = null;
        try {
            this.conn.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM TDB;" );
            while ( rs.next() ) {
                int ID = rs.getInt("ID");
                String  ITEM = rs.getString("ITEM");
                System.out.println( "TID:" + ID );
                System.out.println( "ITEM: " + ITEM );
            }
            rs.close();
            stmt.close();
            this.conn.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    // getFriendsFromDatabase
    public HashMap<Integer, ArrayList<String>> getFriendsFromDatabase(String url){
        HashMap<Integer, ArrayList<String>> friendsMap = new HashMap<>();

        Statement stmt = null;
        try {
            this.conn = DriverManager.getConnection(url);
            this.conn.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM friends;" );
            while ( rs.next() ) {
                int ID = rs.getInt("ID");
                String  FNAME = rs.getString("FNAME");

                if(!friendsMap.containsKey(ID)){
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add(FNAME);
                    friendsMap.put(ID, temp);
                }
                else{
                    ArrayList<String> current = friendsMap.get(ID);
                    current.add(FNAME);
                    friendsMap.put(ID, current);
                }

            }
            rs.close();
            stmt.close();
            this.conn.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");

        return friendsMap;
    }

}
