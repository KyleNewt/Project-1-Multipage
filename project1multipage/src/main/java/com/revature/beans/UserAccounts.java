package com.revature.beans;

public class UserAccounts{
    private int userId;
    private String email;
    private String password;
    private boolean isManager;

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        //should never be called
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public boolean getIsManager(){
        return isManager;
    }

    public void setIsManager(boolean isManager){
        this.isManager = isManager;
    }

    public UserAccounts(String email, String password, boolean isManager){
        super();
        this.email = email;
        this.password = password;
        this.isManager = isManager;
    }

    public UserAccounts(){
        super();
    }

    public String toString(){
        return "[email = " + email + ", password = " + password + 
        ", isManager = " + isManager + "]";
    }
}