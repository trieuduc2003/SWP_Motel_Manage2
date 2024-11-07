package controller.staff;

import dal.ContractDAO;
import dal.RentContactDAO;
import dal.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contract;
import model.RentContact;
import model.User;
import model.enums.Role;
import model.enums.Status;
import utility.EmailUtility;

@WebServlet(name = "RenContactManagementController", urlPatterns = {"/staff/rent-contact-management"})
public class RenContactManagementController extends HttpServlet {

    private final RentContactDAO rentContactDAO = new RentContactDAO();
    private final ContractDAO contractDAO = new ContractDAO();
    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");

        if (user != null && user.getRole().equals(Role.STAFF)) {
            try {
                String pageParam = request.getParameter("page");

                int page = 1;
                int pageSize = 6;
                if (pageParam != null && !pageParam.isEmpty()) {
                    page = Integer.parseInt(pageParam);
                }
                String searchParam = request.getParameter("search");
                String statusParam = request.getParameter("status");

                String status = null;
                if (statusParam != null && !statusParam.isEmpty()) {
                    status = statusParam;
                }
                List<RentContact> contracts = rentContactDAO.getRenContacts(searchParam, status);
                List<RentContact> pagingContract = rentContactDAO.Paging(contracts, page, pageSize);
                request.setAttribute("totalPages", contracts.size() % pageSize == 0 ? (contracts.size() / pageSize) : (contracts.size() / pageSize + 1));
                request.setAttribute("currentPage", page);
                request.setAttribute("contracts", pagingContract);
                request.getRequestDispatcher("rent-contact-management.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(RenContactManagementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            session.setAttribute("notificationErr", "Access Denied!");
            response.sendRedirect("../login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("account");
        if (currentUser != null && currentUser.getRole().equals(Role.STAFF)) {
            String action = request.getParameter("action");
            int rencontactID = Integer.parseInt(request.getParameter("rencontactID"));

            if ("reject".equals(action)) {
                try {
                    // Update status to REJECTED
                    rentContactDAO.updateStatus(rencontactID, Status.REJECTED);
                    session.setAttribute("notification", "Contract rejected successfully.");
                } catch (SQLException ex) {
                    Logger.getLogger(RenContactManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if ("approve".equals(action)) {
                try {
                    // Retrieve inputs
                    String cccd = request.getParameter("cccd");
                    BigDecimal price = new BigDecimal(request.getParameter("price"));

                    // Create new User based on Email
                    RentContact rentContact = rentContactDAO.getRentContactById(rencontactID);
                    if (contractDAO.isRoomAlreadyRented(rentContact.getRoom().getId())) {
                        session.setAttribute("notificationErr", "This room is already rented.");
                        response.sendRedirect("rent-contact-management");
                        return;
                    }
                    String email = rentContact.getEmail();
                    String username = email.substring(0, email.indexOf("@"));
                    String password = generateRandomPassword(6);

                    User user = new User();
                    user.setName(username);
                    user.setEmail(email);
                    user.setPhone(rentContact.getPhoneNumber());
                    user.setPassword(password);
                    user.setCccd(cccd);
                    user.setRole(Role.USER);
                    user.setStatus(Status.ACTIVE);

                    userDAO.insertUser2(user);

                    User newUser = userDAO.getUserIdByEmail(email);

                    System.out.println(newUser);
                    System.out.println(user);
                    // Create Contract
                    Contract contract = new Contract();
                    contract.setRoom(rentContact.getRoom());
                    contract.setUser(newUser);
                    contract.setMotel(rentContact.getRoom().getMotel());
                    contract.setTotalPrice(price.doubleValue());
                    contract.setCreateAt(new Date(System.currentTimeMillis())); // Set current date as creation date
                    contract.setPaymentStatus("Pending");
                    contract.setPaymentDate(new Date(System.currentTimeMillis())); // Set current date as creation date
                    contract.setTypeOfContract("Long-Term");

                    contractDAO.insertContract(contract);

                    // Send Email
                    String message = "Your account has been created with username: " + username + " and password: " + password;
                    EmailUtility.sendEmail(email, "Account Created", message);

                    rentContactDAO.updateStatus(rencontactID, Status.ACTIVE);
                    session.setAttribute("notification", "Contract approved successfully.");
                } catch (SQLException ex) {
                    Logger.getLogger(RenContactManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            response.sendRedirect("rent-contact-management");
        } else {
            session.setAttribute("notificationErr", "Please login first!");
            response.sendRedirect("../login");
        }
    }

    private String generateRandomPassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * chars.length());
            password.append(chars.charAt(randomIndex));
        }
        return password.toString();
    }

}
