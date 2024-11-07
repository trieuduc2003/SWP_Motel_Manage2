/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author djxjs
 */
public class Guest {
    private int guest_id;
    private String name;
    private String email;
    private int phoneNum;
    private int identity_Id;
    
     public Guest() {
   }

    public Guest(int guest_id, String name, String email, int phoneNum, int identity_Id) {
        this.guest_id = guest_id;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.identity_Id = identity_Id;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public int getIdentity_Id() {
        return identity_Id;
    }
     
     
    ////////////////////////////////////

    public void setGuest_id(int guest_id) {
        this.guest_id = guest_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setIdentity_Id(int identity_Id) {
        this.identity_Id = identity_Id;
    }
    
}
