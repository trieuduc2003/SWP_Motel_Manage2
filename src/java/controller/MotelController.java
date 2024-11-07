/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.MotelDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Motel;

/**
 *
 * @author DLCT
 */
@WebServlet(name = "MotelController", urlPatterns = {"/motel"})
public class MotelController extends HttpServlet {

    private final MotelDAO motelDAO = new MotelDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MotelController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MotelController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String searchTerm = request.getParameter("searchTerm"); // Get search term if provided
        String discountParam = request.getParameter("haveDiscount"); // Get discount parameter

        System.out.println("Action: " + action);

        if ("list".equals(action) || "search".equals(action)) {
            boolean hasDiscount = "true".equals(discountParam); // Check if 'Have Discount' is selected
            List<Motel> motels = motelDAO.getAllMotelHaveDiscount(hasDiscount, searchTerm); // Pass search term and discount to method
            request.setAttribute("motels", motels);
            request.setAttribute("searchTerm", searchTerm); // Pass search term to the JSP
            request.setAttribute("haveDiscount", discountParam); // Pass the discount parameter to the JSP
            request.getRequestDispatcher("motels.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int motelId = Integer.parseInt(request.getParameter("motelId"));
            Motel motel = motelDAO.getMotelById(motelId);
            request.setAttribute("motel", motel);
            request.getRequestDispatcher("editMotel.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("action" + action);
        if ("insert".equals(action)) {
            Motel motel = new Motel();
            motel.setMotelName(request.getParameter("motelName"));
            motel.setDescription(request.getParameter("description"));
            motel.setAddress(request.getParameter("address"));
            motel.setCity(request.getParameter("city"));
            motel.setNumberOfRoom(Integer.parseInt(request.getParameter("numberOfRoom")));
            boolean test = motelDAO.insertMotel(motel);
            System.out.println("sdsdsd" + test);
            response.sendRedirect("motel?action=list");
        } else if ("update".equals(action)) {
            Motel motel = new Motel();
            motel.setMotelId(Integer.parseInt(request.getParameter("motelId")));
            motel.setMotelName(request.getParameter("motelName"));
            motel.setDescription(request.getParameter("description"));
            motel.setAddress(request.getParameter("address"));
            motel.setCity(request.getParameter("city"));
            motel.setNumberOfRoom(Integer.parseInt(request.getParameter("numberOfRoom")));
            motelDAO.updateMotel(motel);
            response.sendRedirect("motel?action=list");
        } else if ("delete".equals(action)) {
            int motelId = Integer.parseInt(request.getParameter("motelId"));
            motelDAO.deleteMotel(motelId);
            response.sendRedirect("motel?action=list");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
