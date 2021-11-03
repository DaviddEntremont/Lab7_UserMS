/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;


public class User implements Serializable {
    
    private String email;
    private boolean active;
    private String firstname;
    private String lastname;
    private String password;
    private Role role;
    
    public User() {
    }
    
    public User(String Email, boolean Active, String Firstname, String Lastname, String Password, Role Role) {
        this.email = Email;
        this.active = Active;
        this.firstname = Firstname;
        this.lastname = Lastname;
        this.password = Password;
        this.role = Role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(Boolean Active) {
       this.active = Active;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role Role) {
        this.role = Role;
    }
    
}

