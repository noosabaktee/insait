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
public class Users {
    String email, name, password, bio, gender, date;
    int id;
    
    public Users(int id){
        try (Connection conn = Connect.getConnection(); Statement stmt = conn.createStatement()) {
            String userQuery = "SELECT * FROM users WHERE id = " + id;
            ResultSet rsUser = stmt.executeQuery(userQuery);
            
            while(rsUser.next()){
                this.id = Integer.valueOf(rsUser.getString("id"));
                this.name = rsUser.getString("name");
                this.email = rsUser.getString("email");
                this.password = rsUser.getString("password");
                this.gender = rsUser.getString("gender");
                this.bio = rsUser.getString("bio");
                this.date = rsUser.getString("date");
            }
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getName(){
        return name;
    }
    
    public String getGender(){
        return gender;
    }
    
    public String getBio(){
        return bio;
    }
    
    public String getPassword(){
        return password;
    }
    
    public int getId(){
        return id;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setName(){
        
    }
    
     public void setBio(){
        
    }
    
    public void setPassword(){
        
    }
}
