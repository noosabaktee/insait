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
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class Comments {
    String content, date;
    int id, post_id, user_id;
    
    public Comments(int id){
        try (Connection conn = Connect.getConnection(); Statement stmt = conn.createStatement()) {
            String userQuery = "SELECT * FROM comments WHERE id = " + id;
            ResultSet rsUser = stmt.executeQuery(userQuery);
            
            while(rsUser.next()){
                this.id = Integer.valueOf(rsUser.getString("id"));
                this.user_id = Integer.valueOf(rsUser.getString("user_id"));
                this.post_id = Integer.valueOf(rsUser.getString("post_id"));
                this.content = rsUser.getString("content");
                this.date = rsUser.getString("date");
            }
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int getId(){
        return id;
    }
    
    public int getUserId(){
        return user_id;
    }
    
    public int getPostId(){
        return post_id;
    }
    
    public String getDate(){
        return date;
    }
    
    public String getContent(){
        return content;
    }
    
    public int deleteComment(int id){
        int i = 0;
        try (Connection conn = Connect.getConnection(); Statement stmt = conn.createStatement()) {
            String deleteComment = "DELETE FROM comments WHERE id = " + id;             
            i = stmt.executeUpdate(deleteComment);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return i;
    }
}
