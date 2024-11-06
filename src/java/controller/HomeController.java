package controller;

import dal.MotelDAO; // Thêm import cho MotelDAO
import model.Motel; // Thêm import cho model Motel
import java.io.IOException;
import java.util.List; // Thêm import cho List
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HomeController extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        
        
        throws ServletException, IOException {
    MotelDAO dao = new MotelDAO();

    // Lấy tham số tìm kiếm và trạng thái giảm giá từ request
    String searchKeyword = request.getParameter("search");
    String discountParam = request.getParameter("haveDiscount");

    // Xử lý giá trị haveDiscount
    boolean isDiscount = "true".equals(discountParam); // Nếu chọn "Have Discount"
    // Gọi phương thức getAllMotelHaveDiscount với search và isDiscount
    List<Motel> motels = dao.getAllMotelHaveDiscount(isDiscount, searchKeyword);

    request.setAttribute("motels", motels);
    request.setAttribute("searchKeyword", searchKeyword); // Để hiển thị lại từ khóa tìm kiếm
    request.setAttribute("haveDiscount", discountParam); // Để sử dụng trong JSP nếu cần
    request.getRequestDispatcher("home.jsp").forward(request, response);
}





    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý cho phương thức POST nếu cần
    }
}
