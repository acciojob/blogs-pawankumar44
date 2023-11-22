package com.driver.models;

import com.driver.models.Blog;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String userName;
    private String first_name;
    private String last_name;
    private String password;

    //relationship
    @OneToMany(mappedBy = "user") //because one user can write many blogs,
            //we have mapped by user, to store user id in each blog rather than creating separate table of user_id and blog_id
    List<Blog> blogs;

    public User() {
    }



    public User(int id, String userName, String first_name, String last_name, String password) {
        this.id = id;
        this.userName = userName;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}