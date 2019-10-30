package DBConnection;

import java.sql.*;

public class Database {
    private Connection con;


    public Database() {
    }



    public Connection getConnection(){
        if(con != null){
            return con;
        }
        System.out.println("Could not return a connection");
        return null;
    }

    public void connectToDatabase(String url, String user, String password){
        try{
            this.con = DriverManager.getConnection(
                    url, user, password
            );
            System.out.println("Connected to database");
        }catch(Exception e){
            System.out.println("Could not connect to database");
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ResultSet select(PreparedStatement statement){
        ResultSet rs = null;
        try {
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return rs;
        }
    }


    public boolean insert(PreparedStatement statement){
        try {
            int inserted = statement.executeUpdate();
            if(inserted>0){
                System.out.println("Inserted Succesfully");
                return true;
            }
            else{
                System.out.println("Could not insert item");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(PreparedStatement statement){
        try {
            int deleted = statement.executeUpdate();
            if(deleted>0){
                System.out.println("Removed Succesfully");
                return true;
            }
            else{
                System.out.println("Could not remove item");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

