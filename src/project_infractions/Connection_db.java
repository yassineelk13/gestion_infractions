package project_infractions;

import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Connection_db {
            
        
        public static void connect(){
            String username = "root";
            String password = "";
            String conn_str = "jdbc:mysql://localhost/project_infractions";
            Connection conn;
            Statement stmt;
            try {
            conn = DriverManager.getConnection(conn_str, username, password);
            System.out.println("Connected!");
            
            
            // Do something with the connection if needed
        } catch (SQLException e) {
            e.printStackTrace(); // Print the stack trace for debugging
        } 
        }
        
        
        
        /*
        public void get(){
            try {
            connect();
            stmt = conn.createStatement();
            String sql = "select * from classe";

            // Step 4: Execute the query
            ResultSet result = stmt.executeQuery(sql);
            
             while (result.next()) {

                // Print name an age
                System.out.println(
                    "id: " + result.getString("id_class"));
                System.out.println(
                    "classe:" + result.getString("nom_class"));
            }
        }catch (SQLException e) {
            e.printStackTrace(); // Print the stack trace for debugging
        } 
}*/
}