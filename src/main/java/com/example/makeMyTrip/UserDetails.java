package com.example.makeMyTrip;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDetails {
    private String name;
    private String email;
    private String ph_number;
    private String card_number;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPh_number() {
        return ph_number;
    }

    public void setPh_number(String ph_number) {
        this.ph_number = ph_number;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }


}
