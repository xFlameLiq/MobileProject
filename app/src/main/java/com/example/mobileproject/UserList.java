package com.example.mobileproject;

import android.widget.Toast;

import java.io.Serializable;

public class UserList implements Serializable {

    public User[] users;
    private final int REGISTERS = 5;
    int count;

    public UserList() {
        this.users = new User[REGISTERS];
        this.count = 0;
    }

    public int addUser(User user) {
        if(this.count < this.users.length) {
            this.users[this.count] = user;
            this.count++;
            return 1;
        } else {
            System.out.println("Usuarios alcanzados");
            return -1;
        }
    }

    public int validateUser(String email, String pass) {
        for (int i = 0; i < this.count; i++) {
            if( email.equals(this.users[i].getEmail()) && pass.equals(this.users[i].getPass()) ) {
                System.out.println("Encontrado");
                return 1;
            }
        }
        return -1;
    }

}
