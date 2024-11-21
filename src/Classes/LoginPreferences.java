/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.util.prefs.Preferences;

public class LoginPreferences {

    private static final String PREFS_NODE = "com.example.login";

    // Menyimpan data login
    public static void saveLogin(int user_id) {
        Preferences prefs = Preferences.userRoot().node(PREFS_NODE);
        prefs.put("user_id", String.valueOf(user_id));
        System.out.println("Login data saved in preferences!");
    }
    
    public static void logout() {
        Preferences prefs = Preferences.userRoot().node(PREFS_NODE);
        prefs.put("user_id", "0");
    }

    // Membaca data login
    public static int loadId() {
        Preferences prefs = Preferences.userRoot().node(PREFS_NODE);
        String user_id = prefs.get("user_id","0");
        return Integer.valueOf(user_id);
    }
}
