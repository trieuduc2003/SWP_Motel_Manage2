package controller;

import dal.MotelDAO;
import dal.RoomDAO;
import model.Room;
import model.RoomType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "RoomController", urlPatterns = {"/room"})
public class RoomController extends HttpServlet {

    private final RoomDAO roomDAO = new RoomDAO();
    private final MotelDAO motelDAO = new MotelDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int motelId = Integer.parseInt(request.getParameter("motelId")); // Get the motelId from request
        System.out.println("action " + action);
        if ("list".equals(action)) {
            List<Room> rooms = roomDAO.getAllRoomsByMotelId(motelId);
            request.setAttribute("rooms", rooms);
            request.setAttribute("motelId", motelId);
            request.setAttribute("roomDao", roomDAO);
            request.getRequestDispatcher("motelRoom.jsp").forward(request, response);
        } else if ("list-user".equals(action)) {
            List<Room> rooms = roomDAO.getAllRoomsByMotelId(motelId);
            request.setAttribute("rooms", rooms);
            request.setAttribute("roomDao", roomDAO);

            request.setAttribute("motelDao", motelDAO);

            request.setAttribute("motelId", motelId);
            request.getRequestDispatcher("listRooms.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int roomId = Integer.parseInt(request.getParameter("roomId"));
            System.out.println("idddd" + roomId);
            Room room = roomDAO.getRoomById(roomId);
            List<RoomType> roomTypes = roomDAO.getAllRoomTypes();
            request.setAttribute("roomTypes", roomTypes);

            request.setAttribute("room", room);
            request.setAttribute("motelId", motelId);
            request.getRequestDispatcher("editRoom.jsp").forward(request, response);
        } else if ("add".equals(action)) {
            // Fetch all room types to populate the dropdown
            List<RoomType> roomTypes = roomDAO.getAllRoomTypes();
            request.setAttribute("roomTypes", roomTypes);
            request.setAttribute("motelId", motelId);
            request.getRequestDispatcher("addRoom.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int motelId = Integer.parseInt(request.getParameter("motelId")); // Get the motelId from request

        if ("insert".equals(action)) {
            Room room = new Room();
            int typeId = Integer.parseInt(request.getParameter("roomType")); // Room type selected by the user
            room.setTypeId(typeId);
            room.setMotelId(motelId); // Set the Motel ID
            boolean test = roomDAO.addRoom(room); // Call the method to add the room
            response.sendRedirect("room?action=list&motelId=" + motelId); // Redirect to the list of rooms
        } else if ("update".equals(action)) {
            Room room = new Room();
            room.setRoomId(Integer.parseInt(request.getParameter("roomId")));
            int typeId = Integer.parseInt(request.getParameter("roomType")); // Assuming roomType is passed as parameter
            room.setTypeId(typeId);
            room.setMotelId(motelId);
            roomDAO.updateRoom(room);
            response.sendRedirect("room?action=list&motelId=" + motelId); // Redirect to list of rooms

        } else if ("delete".equals(action)) {
            int roomId = Integer.parseInt(request.getParameter("roomId"));
            roomDAO.deleteRoom(roomId);
            response.sendRedirect("room?action=list&motelId=" + motelId); // Redirect to list of rooms
        }
    }

    @Override
    public String getServletInfo() {
        return "Room Controller Servlet";
    }
}
