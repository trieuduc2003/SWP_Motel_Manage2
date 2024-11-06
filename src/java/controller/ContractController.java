package controller;

import dal.ContractDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Contract;
import model.User;

/**
 * ContractController handles the creation, update, deletion, and display of
 * contracts.
 */
@WebServlet(name = "ContractController", urlPatterns = {"/contract"})

public class ContractController extends HttpServlet {

    private final ContractDAO contractDAO = new ContractDAO();

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("list".equals(action)) {
            List<Contract> contracts = contractDAO.getAllContracts();
            request.setAttribute("contracts", contracts);
            request.getRequestDispatcher("contracts.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int contractId = Integer.parseInt(request.getParameter("contractId"));
            Contract contract = contractDAO.getContractById(contractId);
            request.setAttribute("contract", contract);
            request.getRequestDispatcher("editContract.jsp").forward(request, response);
        } else if ("view".equals(action)) {
            int contractId = Integer.parseInt(request.getParameter("contractId"));
            Contract contract = contractDAO.getContractById(contractId);
            request.setAttribute("contract", contract);
            request.getRequestDispatcher("viewContract.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        // Retrieve userId from session
        System.out.println("actionsds" + action);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return; // Stop processing if user is not logged in
        }

        if ("insert".equals(action)) {
            String motelIdStr = request.getParameter("motelId");
            String roomIdStr = request.getParameter("roomId");
            String totalPriceStr = request.getParameter("totalPrice");
            String paymentMethod = request.getParameter("paymentMethod");

            // Ghi nhật ký các tham số
            System.out.println("Motel ID: " + motelIdStr);
            System.out.println("Room ID: " + roomIdStr);
            System.out.println("Total Price: " + totalPriceStr);
            System.out.println("Payment Method: " + paymentMethod);
            System.out.println("User ID: " + user.getId());

            Contract contract = new Contract();
            contract.setRoomId(Integer.parseInt(roomIdStr));
            contract.setUserId(user.getId());
            contract.setTotalPrice(Double.parseDouble(totalPriceStr));
            contract.setPaymentMethod(paymentMethod);
            contract.setPaymentStatus("Not Paid"); // Default payment status
            contract.setPaymentDate(null); // Initially null
            contract.setTypeOfContract("Standard"); // Default type
            contract.setCreateAt(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            contract.setMotelId(Integer.parseInt(motelIdStr));

            // Sau khi đã thiết lập contract, bạn có thể ghi nhật ký
            System.out.println("Contract created: " + contract);

            response.sendRedirect("/home");
        } else if ("update".equals(action)) {
            Contract contract = new Contract();
            contract.setContractId(Integer.parseInt(request.getParameter("contractId")));
            contract.setRoomId(Integer.parseInt(request.getParameter("roomId")));
            contract.setUserId(user.getId());
            contract.setTotalPrice(Double.parseDouble(request.getParameter("totalPrice")));
            contract.setPaymentMethod(request.getParameter("paymentMethod"));
            contract.setPaymentStatus(request.getParameter("paymentStatus"));
            contract.setTypeOfContract(request.getParameter("typeOfContract"));

            String paymentDate = request.getParameter("paymentDate");
            contract.setPaymentDate((paymentDate != null && !paymentDate.isEmpty()) ? paymentDate : null);
            response.sendRedirect("contract?action=list");
        }

    }

    /**
     * Handles error messages by forwarding to an error page.
     */
    private void handleError(HttpServletRequest request, HttpServletResponse response, String errorMessage) throws ServletException, IOException {
        request.setAttribute("errorMessage", errorMessage);
        request.getRequestDispatcher("error.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     */
    @Override
    public String getServletInfo() {
        return "ContractController handles contract operations such as creating, updating, and deleting contracts.";
    }
}
