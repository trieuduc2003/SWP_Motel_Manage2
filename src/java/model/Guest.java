<<<<<<< HEAD
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

=======
package model;

public class Guest {

    private int guestId;          // ID của khách
    private String name;          // Tên của khách
    private String email;         // Email của khách
    private String phoneNum;      // Số điện thoại của khách
    private String identityId;    // ID định danh của khách

    // Constructor với các tham số
    public Guest(int guestId, String name, String email, String phoneNum, String identityId) {
        this.guestId = guestId;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.identityId = identityId;
    }

    // Constructor mặc định
    public Guest() {
    }

    // Getter và setter cho guestId
    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    // Getter và setter cho name
>>>>>>> origin/QuangAnh267
    public String getName() {
        return name;
    }

<<<<<<< HEAD
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

=======
>>>>>>> origin/QuangAnh267
    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD
=======
    // Getter và setter cho email
    public String getEmail() {
        return email;
    }

>>>>>>> origin/QuangAnh267
    public void setEmail(String email) {
        this.email = email;
    }

<<<<<<< HEAD
    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setIdentity_Id(int identity_Id) {
        this.identity_Id = identity_Id;
    }
    
}
=======
    // Getter và setter cho phoneNum
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    // Getter và setter cho identityId
    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }
} 
>>>>>>> origin/QuangAnh267
