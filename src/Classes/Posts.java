/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author acer
 */
public class Posts {
    String content, title;
    int id, user_id, date;
    char type;
    
    public void deletePost(){
        
    }
    
    public int getId(){
        return id;
    }
    
    public int getUserId(){
        return user_id;
    }
    
    public int getDate(){
        return date;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getContent(){
        return content;
    }
    
    public char getType(){
        return type;
    }
}
