package com.example.lab3_1;

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;

    public Contact(int id, String name, String phoneNumber) {
        this.id =id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
