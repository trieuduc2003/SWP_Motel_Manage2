package model;

<<<<<<< HEAD
public class Room {
    private int id;
    private Motel motel;
    private RoomType roomType;

    // Getters and Setters
    public int getId() {
        return id;
=======
import java.util.List;

public class Room {

    private int roomId;          // ID của phòng
    private int motelId;         // ID của khách sạn
    private int typeId;      // ID của loại phòng
    private String imageUrl;     // URL hình ảnh phòng
    private String motelName;    // Tên khách sạn (liên kết từ bảng Motels)
    private String typeName;
    private String status;
    private double Price; // Thêm thuộc tính Price
    private List<Categories> categories; // Add this field

    // Constructor với các tham số
    public Room(int roomId, int motelId, int typeId, String imageUrl, String motelName, String typeName, String status, double Price) {
        this.roomId = roomId;
        this.motelId = motelId;
        this.typeId = typeId;
        this.imageUrl = imageUrl;
        this.motelName = motelName;
        this.typeName = typeName;
        this.status = status;
        this.Price = Price;
    }

    // Constructor mặc định
    public Room() {
    }

    // Getter và setter cho roomId
    public int getRoomId() {
        return roomId;
>>>>>>> origin/QuangAnh267
    }

    public void setId(int id) {
        this.id = id;
    }

<<<<<<< HEAD
    public Room(int id, Motel motel, RoomType roomType) {
        this.id = id;
        this.motel = motel;
        this.roomType = roomType;
=======
    // Getter và setter cho motelId
    public int getMotelId() {
        return motelId;
>>>>>>> origin/QuangAnh267
    }

    public Room() {
    }

<<<<<<< HEAD
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

  
=======
    // Getter và setter cho typeId
    public int gettypeId() {
        return typeId;
    }

    public void setRoomtypeId(int typeId) {
        this.typeId = typeId;
    }

    // Getter và setter cho imageUrl
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Getter và setter cho motelName
    public String getMotelName() {
        return motelName;
    }

    public void setMotelName(String motelName) {
        this.motelName = motelName;
    }

    // Getter và setter cho roomTypeName
    public String gettypeName() {
        return typeName;
    }

    public void settypeName(String roomTypeName) {
        this.typeName = typeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "Room{"
                + "roomId=" + roomId
                + ", motelId=" + motelId
                + ", typeId=" + typeId
                + ", imageUrl='" + imageUrl + '\''
                + ", status='" + status + '\''
                + ", motelName='" + motelName + '\''
                + ", TypeName='" + typeName + '\''
                + ", Price=" + Price
                + '}';
    }
>>>>>>> origin/QuangAnh267
}
