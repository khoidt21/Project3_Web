/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 * @author vuvan
 */
public class UsersData {

    private static UsersData instance;
    private final String spChar = "--@--";
    private String message;
    private final String pathData = "data.txt";
    private static HashMap<String, String> users;
    private static ArrayList<String> usersOnline;

    private UsersData() {
    }

    public static UsersData getInstance() {
        if (instance == null) {
            instance = new UsersData();
        }
        return instance;
    }
    
    public String getPathData() {
        return pathData;
    }

    public String getSpChar() {
        return spChar;
    }

    public HashMap<String, String> getData() {
        return users;
    }

    public void scanData() {
        if (users != null) {
            return;
        }
        users = new HashMap<>();
        usersOnline = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        
        try {
            fileReader = new FileReader(pathData);
            bufferedReader = new BufferedReader(fileReader);
            String str;
            
            while ((str = bufferedReader.readLine()) != null) {
                String[] b = str.split(Pattern.quote(spChar));

                if (b.length >= 2) {
                    User u = new User(b[0], b[1]);
                    if (u.validUser() && !hasUser(b[0])) {
                        users.put(u.getUsername(), u.getPassword());
                        
                    }
                }
            }
            bufferedReader.close();
            
        } catch (IOException ignored) {
        }
    }

    //Kiem tra va lay thong tin User
    public boolean checkUser(String username, String password) {
        return checkUser(new User(username, password));
    }
    
    //Kiem tra du lieu trong Hash Map User
    public boolean checkUser(User u) {
        if (users.isEmpty()) {
            u.addError("No user in hash map");
            return false;
        }
        if (users.containsKey(u.getUsername())) {
            if (users.get(u.getUsername()).equals(u.getPassword())) {
                return true;
            }
            u.addError("Wrong password");
            return false;
        }
        u.addError("User not exists");
        return false;
    }
    
    //Kiem tra neu User co trong HashMap
    public boolean hasUser(String username) {
        return users.containsKey(username);
    }

    //Them moi User vao HashMap
    public void addUser(String u, String p) {
    	//users.put("admin","12345");
        users.put(u, p);
    }

    public String getMessage() {
        return message;
    }

    //Luu user vao FilePath
    public void saveUsers() {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        try {
            fileWriter = new FileWriter(pathData);
            printWriter = new PrintWriter(fileWriter);
            if (users != null) {
                
                for (Map.Entry m : users.entrySet()) {
                    printWriter.println(m.getKey() + spChar + m.getValue() + "\n");
                }
            }
            printWriter.close();
        } catch (IOException e) {
        }
    }

    public String usernamesToString() {
        ArrayList<String> m = new ArrayList<>();
        for (Map.Entry mm : users.entrySet()) {
            m.add((String) mm.getKey());
        }
        return String.join(", ", m);
    }
    
    public void addUsersOnline(String username){
        if(!usersOnline.contains(username)){
            usersOnline.add(username);
        }
    }
    
    //.size de lay ra tong so User online
    public ArrayList<String> getUsersOnline(){
        if(usersOnline != null)
        return usersOnline;
        return new ArrayList<>();
    }
}
