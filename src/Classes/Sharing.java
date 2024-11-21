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
    
    public int updatePost(String title, String content, int comment){
        int i = 0;
        try (Connection conn = Connect.getConnection(); Statement stmt = conn.createStatement()) {
            String updatePost = "UPDATE posts SET title = '" +title+ "', content = '" + content
                + "', comment = " + comment + " WHERE id = "+ id;
            i = stmt.executeUpdate(updatePost);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return i;
    }
}
