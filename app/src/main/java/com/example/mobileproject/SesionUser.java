package com.example.mobileproject;

import java.io.Serializable;

public class SesionUser implements Serializable {

    public UserList users;

    public SesionUser() {
        this.users = new UserList();
        init();
    }

    public void init() {
        User admin = new User(0, "David", "Loera", "Admin", "Admin", "21110121", 5);
        users.addUser(admin);
    }


}
