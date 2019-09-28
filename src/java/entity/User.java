/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author vuvan
 */

public class User {
    private String username;
    private String password;
    private ArrayList<String> errors;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        errors = new ArrayList();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getErrors() {
        return errors;
    }
    
    //Cac loi duoc them vao ArrayList
    public void addError(String e){
        errors.add(e);
    }

    public boolean validUser(){
        if(Pattern.compile(".*[$#@%^&*]+.*").matcher(username).matches()) {
            errors.add("Username must not contain one of $#@%^&*");
        }
        
        //Kiem tra Validate Password
        Pattern[] passReg = new Pattern[3];
        passReg[0] = Pattern.compile(".*[A-Z]+.*");
        passReg[1] = Pattern.compile(".*[0-9]+.*");
        passReg[2] = Pattern.compile(".*[$#@%^&*]+.*");
        for (Pattern pr : passReg) {
            if (!pr.matcher(password).matches()) {
                errors.add("Password must contain at least One Uppercase Letter,One Digit "
                        + "and One Speciel Syntax($#@%^&*)");  
                break;
            }
        }
        return errors.isEmpty();
    }
    
    //Tong hop cac loi co trong Validate
    public String errorToString(){
        return String.join("<br/>", errors);
    }
}
