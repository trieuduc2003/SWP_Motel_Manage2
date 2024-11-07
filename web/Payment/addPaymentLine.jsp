<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Add New Payment Line</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f8f9fa;
                margin: 0;
                padding: 20px;
            }

            .container {
                max-width: 600px;
                margin: auto;
                background: #ffffff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h2 {
                text-align: center;
                color: #343a40;
            }

            label {
                display: block;
                margin-bottom: 5px;
                color: #495057;
            }

            input, select {
                width: 100%;
                padding: 8px;
                margin-bottom: 15px;
                border: 1px solid #ced4da;
                border-radius: 4px;
            }

            input[type="submit"] {
                background-color: #007bff;
                color: white;
                border: none;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #0056b3;
            }
        </style>
    </head> 
    <body>
        <div class="container">
            <h2>Add New Payment Line into record: ${recordIdForLine}</h2>
            <form action="addPaymentLine" method="post">
                <c:if test="${empty recordIdForLine}">
                    <p>Error: Record ID is not available.</p>
                </c:if>
                <label for="status">Status:</label>
                <input type="text" id="Linestatus" name="Linestatus" required>

                <label for="price_per_month">Price per Month:</label>
                <input type="number" step="0.01" id="Lineprice_per_month" name="Lineprice_per_month" required>

                <label for="available_guest">Available Guests:</label>
                <input type="number" id="Lineavailable_guest" name="Lineavailable_guest" required>

                <label for="description">Description:</label>
                <textarea id="Linedescription" name="Linedescription" required></textarea>

                <!--                <label for="record_id">Record ID:</label>-->
                <input type="hidden" id="record_id" name="record_id" value="${recordIdForLine}">

                <label for="billing_period">Billing Period:</label>
                <input type="text" id="Linebilling_period" name="Linebilling_period" required>

                <label for="total_payment">Total Payment:</label>
                <input type="number" step="0.01" id="Linetotal_payment" name="Linetotal_payment" required>

                <input type="submit" value="Add Payment Line">
            </form>
            <a href=""seePaymentLine?PaymentRecord_Id=" + recordIdForLine">Back to PaymentLine List</a> <!-- Change path as needed -->
        </div>
    </body>
</html>