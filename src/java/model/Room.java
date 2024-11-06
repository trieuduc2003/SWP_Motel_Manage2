package model;

public class Room {
    private int id;
    private Motel motel;
    private RoomType roomType;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room(int id, Motel motel, RoomType roomType) {
        this.id = id;
        this.motel = motel;
        this.roomType = roomType;
    }

    public Room() {
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Motel getMotel() {
        return motel;
    }

    public void setMotel(Motel motel) {
        this.motel = motel;
    }

  

  

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", motelId=" + motel + ", roomType=" + roomType + '}';
    }

  
}
