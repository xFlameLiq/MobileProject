package com.example.mobileproject;

import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;

public class UserList implements Serializable {

    public User[] user;
    private final int REGISTERS = 5;
    int count;

    public UserList() {
        this.user = new User[REGISTERS];
        this.count = 0;
    }

    public int addUser(User user) {
        if(this.count < this.user.length) {
            this.user[this.count] = user;
            this.user[this.count].setId(count);
            this.count++;
            return 1;
        } else {
            System.out.println("Usuarios alcanzados");
            return -1;
        }
    }

    public int validateUser(String email, String pass) {
        for (int i = 0; i < this.count; i++) {
            if( email.equals(this.user[i].getEmail()) && pass.equals(this.user[i].getPass()) ) {
                System.out.println("Encontrado");
                return 1;
            }
        }
        return -1;
    }

    public String  getUsers() {
        String mostrar = "";
        for (int i = 0; i < this.count; i++) {
            mostrar += "Email: " + this.user[i].getEmail() + "\n" +
                    "Contraseña: " + this.user[i].getPass() + "\n" +
                    "Id: " + this.user[i].getId() + "\n\n";
        }
        return mostrar;
    }

}
