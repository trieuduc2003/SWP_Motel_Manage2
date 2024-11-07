/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
<<<<<<< HEAD

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.enums.Status;

public class RentContact {

    private String guestName;
    private int roomId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String phoneNumber;
    private String address;
    private BigDecimal totalPrice;
//new
    private int rencontactID;
    private Room room;
    private String email;
    private Status status;
    public RentContact() {

    }

    public RentContact(String guestName, int roomId, LocalDate startDate, LocalDate endDate, String phoneNumber, String address, BigDecimal totalPrice) {
=======
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class RentContact {
    private int rentContractId;
    private String guestName;
    private int roomId;
    private Date startDate;
    private Date endDate;
    private String phoneNumber;
    private String email;
    private String address;
    private String status;
    private BigDecimal totalPrice;

    public RentContact() {
    }

    public RentContact(int rentContractId, String guestName, int roomId, Date startDate, Date endDate, String phoneNumber, String email, String address, String status, BigDecimal totalPrice) {
        this.rentContractId = rentContractId;
>>>>>>> origin/QuangAnh267
        this.guestName = guestName;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.phoneNumber = phoneNumber;
<<<<<<< HEAD
        this.address = address;
        this.totalPrice = totalPrice;
    }

=======
        this.email = email;
        this.address = address;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public int getRentContractId() {
        return rentContractId;
    }

    public void setRentContractId(int rentContractId) {
        this.rentContractId = rentContractId;
    }

>>>>>>> origin/QuangAnh267
    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

<<<<<<< HEAD
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
=======
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
>>>>>>> origin/QuangAnh267
        this.endDate = endDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

<<<<<<< HEAD
=======
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

>>>>>>> origin/QuangAnh267
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

<<<<<<< HEAD
=======
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

>>>>>>> origin/QuangAnh267
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
<<<<<<< HEAD

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getRencontactID() {
        return rencontactID;
    }

    public void setRencontactID(int rencontactID) {
        this.rencontactID = rencontactID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getFormattedStartDate() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return startDate != null ? startDate.format(formatter) : "";
}

public String getFormattedEndDate() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return endDate != null ? endDate.format(formatter) : "";
}
    @Override
    public String toString() {
        return "RentContact{" + "guestName=" + guestName + ", roomId=" + roomId + ", startDate=" + startDate + ", endDate=" + endDate + ", phoneNumber=" + phoneNumber + ", address=" + address + ", totalPrice=" + totalPrice + ", rencontactID=" + rencontactID + ", room=" + room + ", email=" + email + ", status=" + status + '}';
    }
    
    

=======
>>>>>>> origin/QuangAnh267
}
