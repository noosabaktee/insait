/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Config.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author acer
 */
public class Sharing extends Posts{
    int comment;

    public Sharing(int id){
        super(id);
        try (Connection conn = Connect.getConnection(); Statement stmt = conn.createStatement()) {
            String userQuery = "SELECT * FROM posts WHERE id = " + id;
            ResultSet rsUser = stmt.executeQuery(userQuery);
            
            while(rsUser.next()){
                this.comment = Integer.valueOf(rsUser.getString("comment"));
            }
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int getComment(){
        return comment;
    }
    
    public void updatePost(String title, String content, boolean comment){
        
    }
}
