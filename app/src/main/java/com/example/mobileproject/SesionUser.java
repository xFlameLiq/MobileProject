package com.example.mobileproject;

import java.io.Serializable;

public class SesionUser implements Serializable {

    public UserList users;

    public SesionUser() {
        this.users = new UserList();
        init();
    }

    public void init() {
        User admin = new User("admin", "admin");
        users.addUser(admin);
    }


}
