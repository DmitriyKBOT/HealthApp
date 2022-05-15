package com.example.dmitriyk_project1;

public class User {
    //занесение данных в базу данных
    public String id ,Name, SecName,AGE, VES, Email;

    public User(String id, String name, String secName, String AGE, String VES, String Email) {
        this.id = id;
        this.Name = name;
        this.SecName = secName;
        this.AGE = AGE;
        this.VES = VES;
        this.Email = Email;
    }
}

