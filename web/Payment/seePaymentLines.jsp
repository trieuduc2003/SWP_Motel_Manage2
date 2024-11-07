<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Dòng Thanh Toán</title>
    <link rel="stylesheet" type="text/css" href="styles.css"> <!-- Thêm CSS nếu cần -->
    
    <script type="text/javascript">
        function doDelete(paymentLineId, recordId) {
            if (confirm("Are you sure you want to delete Payment Line with ID = " + paymentLineId + "?")) {
                // Redirect to the delete servlet with the appropriate parameters
                window.location = "deletePaymentLine?deletePaymentLineId=" + paymentLineId + "&PaymentRecord_Id=" + recordId;
            }
        }
    </script>
</head>
<body>
    <!-- Link to add a new payment line -->
    <div>
        <a href="addPaymentLine?PaymentRecord_Id=${recordIdForLine}" class="btn btn-primary">Add Payment Line</a>
</div>
    
    <h2>Danh sách Dòng Thanh Toán cho Record ID: ${recordIdForLine}</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Payment Line ID</th>
                <th>Status</th>
                <th>Price Per Month</th>
                <th>Available Guests</th>
                <th>Description</th>
                <th>Billing Period</th>
                <th>Total Payment</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="line" items="${paymentLines}">
                <tr>
                    <td>${line.paymentLine_id}</td>
                    <td>${line.status}</td>
                    <td>${line.price_per_month}</td>
                    <td>${line.available_guest}</td>
                    <td>${line.description}</td>
                    <td>${line.billing_period}</td>
                    <td>${line.total_payment}</td>
                    <td>
                        <a href="updatePaymentLine?PaymentLineUpdateId=${line.paymentLine_id}&PaymentRecord_Id=${recordIdForLine}">Update</a>
                        <a href="#" onclick="doDelete('${line.paymentLine_id}', '${recordIdForLine}')">Delete</a>
                        <a href="listFeeInclude?FeeIncludepaymentLineId=${line.paymentLine_id}">Details</a>
                    </td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="listPaymentRecord">Back to PaymentRecord List</a> <!-- Change path as needed -->
</body>
</html>