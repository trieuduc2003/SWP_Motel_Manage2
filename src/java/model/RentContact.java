/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
        this.guestName = guestName;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.totalPrice = totalPrice;
    }

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
        this.endDate = endDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

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
    
    

}
