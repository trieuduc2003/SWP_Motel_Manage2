/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class RoomType {
    private int id;
    private String name;
    private String description;
    private int max_user;

    public RoomType() {
    }

    public RoomType(int id, String name, String description, int max_user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.max_user = max_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMax_user() {
        return max_user;
    }

    public void setMax_user(int max_user) {
        this.max_user = max_user;
    }
    
}
