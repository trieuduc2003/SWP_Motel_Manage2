/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import com.mysql.cj.xdevapi.Statement;
import com.sun.jdi.connect.spi.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Fee_Include;
import model.Fee_Include_Line;

/**
 *
 * @author djxjs
 */
public class FeeIncludeDAO extends DBContext {
    public ArrayList<Fee_Include> getFeeIncludesByPaymentLineId(int paymentLineId) {
        ArrayList<Fee_Include> feeIncludes = new ArrayList<>();
        String sql = "SELECT fi.* FROM Fee_Include fi "
                   + "JOIN Fee_Include_Line fil ON fi.feeinclude_id = fil.FeeInclude_id "
                   + "WHERE fil.PaymentLine_id = ?";

        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(sql); // Sử dụng PreparedStatement
        ResultSet rs = pstmt.executeQuery(); // Thực hiện truy vấn
            while (rs.next()) {
                Fee_Include feeInclude = new Fee_Include();
                feeInclude.setFeeinclude_id(rs.getInt("feeinclude_id"));
                feeInclude.setNote(rs.getString("note"));
                feeInclude.setCount(rs.getInt("count"));
                feeInclude.setPrice(rs.getDouble("price"));
                feeInclude.setUnit(rs.getString("Unit"));
                feeIncludes.add(feeInclude);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Xử lý ngoại lệ một cách thích hợp trong sản phẩm
        }
        return feeIncludes;
    }
    
    public ArrayList<Fee_Include> getAllFeeIncludes() {
    ArrayList<Fee_Include> feeIncludes = new ArrayList<>();
    String sql = "SELECT fi.* FROM Fee_Include fi";

    try{PreparedStatement pstmt = connection.prepareStatement(sql); // Sử dụng PreparedStatement
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
            Fee_Include feeInclude = new Fee_Include();
            feeInclude.setFeeinclude_id(rs.getInt("feeinclude_id"));
            feeInclude.setNote(rs.getString("note"));
            feeInclude.setCount(rs.getInt("count"));
            feeInclude.setPrice(rs.getDouble("price"));
            feeInclude.setUnit(rs.getString("unit"));
            feeIncludes.add(feeInclude);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Xử lý ngoại lệ
    }
    return feeIncludes;
}
}
