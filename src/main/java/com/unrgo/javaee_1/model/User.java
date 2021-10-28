package com.unrgo.javaee_1.model;

import javax.inject.Inject;

public class User {
    private int id;
    private String name;
    private String password;
    @Inject
    private ROLE role;

    public User(){

    }

    public User(int id,String name,String password,ROLE role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public enum ROLE {
        USER,
        ADMIN,
        UNKNOWN
    }
}


