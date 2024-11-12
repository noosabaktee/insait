/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author acer
 */
public class Comments {
    String content;
    int date, id, post_id, user_id;
    
    public int getId(){
        return id;
    }
    
    public int getUserId(){
        return user_id;
    }
    
    public int getPostId(){
        return post_id;
    }
    
    public int getDate(){
        return date;
    }
    
    public String getContent(){
        return content;
    }
    
    public void deleteComment(){
        
    }
}
