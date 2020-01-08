package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    private int id;

    private static int nextId = 1;
    @NotBlank(message = "Username is required")
    @NotNull
    @Size(min = 5,max = 15,message = "User name must be between 5 and 15 characters")
    private String username;
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message = "password is required")
    @Size(min = 6,message = "Password should be atleast 6 characters")
    @NotNull
    private String password;


    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;

        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}