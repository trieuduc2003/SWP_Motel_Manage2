package controller;

import dal.RoomDAO; // Assuming this DAO class has methods for RoomType
import model.RoomType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "RoomTypeController", urlPatterns = {"/roomType"})
public class RoomTypeController extends HttpServlet {

    private final RoomDAO roomDAO = new RoomDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("list".equals(action)) {
            // Fetch all room types to display
            List<RoomType> roomTypes = roomDAO.getAllRoomTypes();
            request.setAttribute("roomTypes", roomTypes);
            request.getRequestDispatcher("roomType.jsp").forward(request, response); // Change to your JSP for listing room types
        } else if ("add".equals(action)) {
            request.getRequestDispatcher("addRoomType.jsp").forward(request, response); // Forward to add room type page
        } else if ("edit".equals(action)) {
            int typeId = Integer.parseInt(request.getParameter("typeId"));
            RoomType roomType = roomDAO.getRoomTypeById(typeId);
            request.setAttribute("roomType", roomType);
            request.getRequestDispatcher("editRoomType.jsp").forward(request, response); // Change to your JSP for editing room types
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("insert".equals(action)) {
            RoomType roomType = new RoomType();
            roomType.setName(request.getParameter("name"));
            roomType.setDescription(request.getParameter("description"));
            roomType.setMaxGuest(Integer.parseInt(request.getParameter("maxGuest")));
            roomType.setPrice(Double.parseDouble(request.getParameter("price")));
            roomType.setDiscount( Double.parseDouble(request.getParameter("discount")));

            roomDAO.addRoomType(roomType); // Call the method to add the room type
            response.sendRedirect("roomType?action=list"); // Redirect to the list of room types
        } else if ("update".equals(action)) {
            RoomType roomType = new RoomType();
            roomType.setTypeId(Integer.parseInt(request.getParameter("typeId")));
            roomType.setName(request.getParameter("name"));
            roomType.setDescription(request.getParameter("description"));
            roomType.setMaxGuest(Integer.parseInt(request.getParameter("maxGuest")));
            roomType.setPrice(Double.parseDouble(request.getParameter("price")));
            roomType.setDiscount(Double.parseDouble(request.getParameter("discount")));
            roomDAO.updateRoomType(roomType); // Call the method to update the room type
            response.sendRedirect("roomType?action=list"); // Redirect to the list of room types
        }
    }

    @Override
    public String getServletInfo() {
        return "Room Type Controller Servlet";
    }
}
