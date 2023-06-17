package com.example.mobileproject;

import java.io.Serializable;
import java.util.ArrayList;

public class SesionUser implements Serializable {

    public UserList users;
    ArrayList<Subjects> subjects = new ArrayList();
    private Subjects subjectsObj = new Subjects("pruebitaxd", "");


    public SesionUser() {
        this.users = new UserList();
        init();
    }

    public void init() {
        subjects.add(subjectsObj);
        User admin = new User(0, "David", "Loera", "admin", "admin", "21110121", 5, subjects);
        users.addUser(admin);
    }


}
