package com.example.reflowoct;


public class Room {
    String id;
    String name;
    int photo;

    public Room(String id, String name,int photo) {
        this.id = id;
        this.name = name;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getphoto() {
        return photo;
    }

    public void setphoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}