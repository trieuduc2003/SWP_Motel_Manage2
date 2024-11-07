package PaymentController;

import dal.PaymentRecordDAO;
import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.PaymentRecord;

public class listPaymentRecord extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PaymentRecordDAO paymentRecordDAO = new PaymentRecordDAO();
        
        int pageNumber = Integer.parseInt(request.getParameter("paymentRecordPage") != null ? request.getParameter("paymentRecordPage") : "1");
        int pageSize = 10;

        String searchBy = request.getParameter("searchByPaymentRecord");
        String searchValue = request.getParameter("searchValuePaymentRecord");
        if (searchValue != null) {
            searchValue = searchValue.replaceAll("\\s+", ""); // Remove all spaces
        }

        String sortBy = request.getParameter("sortByPaymentRecord");
        String order = request.getParameter("orderPaymentRecord");

        ArrayList<PaymentRecord> paymentRecordList;
        int totalRecords;

        if (searchBy == null || searchValue == null || searchValue.trim().isEmpty()) {
            paymentRecordList = (ArrayList<PaymentRecord>) paymentRecordDAO.getPaymentRecords(pageNumber, pageSize, sortBy, order);
            totalRecords = paymentRecordDAO.getTotalPaymentRecords();
        } else {
            paymentRecordList = (ArrayList<PaymentRecord>) paymentRecordDAO.searchPaymentRecords(searchBy, searchValue, pageNumber, pageSize, sortBy, order);
            totalRecords = paymentRecordDAO.getTotalSearchResults(searchBy, searchValue);
        }

        int totalPages = (int) Math.ceil((double) totalRecords / pageSize);

        request.setAttribute("paymentRecordListOfRecords", paymentRecordList);
        request.setAttribute("paymentRecordTotalPages", totalPages);
        request.setAttribute("paymentRecordCurrentPage", pageNumber);

        request.setAttribute("searchByPaymentRecord", searchBy);
        request.setAttribute("searchValuePaymentRecord", searchValue);
        request.setAttribute("sortByPaymentRecord", sortBy);
        request.setAttribute("orderPaymentRecord", order);

        request.getRequestDispatcher("Payment/listPaymentRecord.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
