package com.hp.Dao;

public class User {
    private String admin;
    private  String pwd;

    @Override
    public String toString() {
        return "User{" +
                "admin='" + admin + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User() {
    }

    public User(String admin, String pwd) {
        this.admin = admin;
        this.pwd = pwd;
    }
}
