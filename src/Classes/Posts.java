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
public class Posts {
    String content, title, date;
    int id, user_id;
    char type;
    
    public Posts(int id){
        try (Connection conn = Connect.getConnection(); Statement stmt = conn.createStatement()) {
            String userQuery = "SELECT * FROM posts WHERE id = " + id;
            ResultSet rsUser = stmt.executeQuery(userQuery);
            
            while(rsUser.next()){
                this.id = Integer.valueOf(rsUser.getString("id"));
                this.title = rsUser.getString("title");
                this.content = rsUser.getString("content");
                this.date = rsUser.getString("date");
                this.user_id = Integer.valueOf(rsUser.getString("user_id"));
                this.type = rsUser.getString("type").charAt(0);
            }
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int deletePost(int id){
        int result = 0;
        try (Connection conn = Connect.getConnection(); Statement stmt = conn.createStatement()) {
                String deletePost = "DELETE FROM posts WHERE id = " + id;
                String deleteComment = "DELETE FROM comments WHERE post_id = " + id;
                stmt.addBatch(deletePost);
                stmt.addBatch(deleteComment);
                int[] i = stmt.executeBatch();
                result = i[0];
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public int getId(){
        return id;
    }
    
    public int getUserId(){
        return user_id;
    }
    
    public String getDate(){
        return date;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getContent(){
        return content;
    }
    
    public int totalComment(){
        int total = 0;
        try (Connection conn = Connect.getConnection(); Statement stmt = conn.createStatement()) {
            String query = "SELECT COUNT(*) FROM comments WHERE post_id = " + this.id;
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                total = rs.getInt(1);
            }
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return total;
    }
    
    public char getType(){
        return type;
    }
    
    public int getComment(){
        return 1;
    }
}
