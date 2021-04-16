package com.example.swagers;

public class UserHelperClass {

    String Email,UserName,TeamName,PassWord;

    public UserHelperClass() {
    }

    public UserHelperClass(String email, String userName, String teamName, String password) {
        Email = email;
        UserName = userName;
        TeamName = teamName;
        PassWord = password;
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public String getPassword() {
        return PassWord;
    }

    public void setPassword(String password) {
        PassWord = password;
    }
}