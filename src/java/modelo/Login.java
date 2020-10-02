/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author XPC
 */
public class Login {
    private String user;
    private String password;
    private int user_id;
    
    public Login(String user, String password, int user_id){
        this.user = user;
        this.password = password;
        this.user_id = user_id;
    }

    public Login(String user) {
        this.user = user;
    }
    
    public Login(){
        
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    
    
}