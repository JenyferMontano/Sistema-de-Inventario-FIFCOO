package models;

import java.sql.*;

public class DBConnection {
    private String url;
    private String user;
    private String pass;
    private static Connection con;
    public DBConnection(String server,String db, String user, String pass) {
        this.url = "jdbc:mysql://" +server+":3306/"+db;
        this.user = user;
        this.pass = pass;
    }
    public  Connection getConnection() throws Exception {
        if(con == null) {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            con = DriverManager.getConnection(this.url, this.user, this.pass);
        }
        return con;

    }

    public void close(Statement stmt) throws Exception {
        close(null,stmt);
    }

    public void close(ResultSet rs, Statement stmt) throws Exception {
        try{
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();

        }catch(Exception e){
        }
    }
}
