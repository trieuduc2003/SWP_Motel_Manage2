<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Payment Line</title>
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
    <h2>Update Payment Line for ID: ${paymentLine.paymentLine_id}</h2>
    <form action="updatePaymentLine" method="post">
        <input type="hidden" name="paymentLineId" value="${paymentLine.paymentLine_id}">
        <input type="hidden" name="paymentLineRecordId" value="${paymentLine.record_id}">

        <label for="status">Status:</label>
        <input type="text" name="status" value="${paymentLine.status}"><br>

        <label for="price_per_month">Price Per Month:</label>
        <input type="text" name="price_per_month" value="${paymentLine.price_per_month}"><br>

        <label for="available_guest">Available Guests:</label>
        <input type="number" name="available_guest" value="${paymentLine.available_guest}"><br>

        <label for="description">Description:</label>
        <input type="text" name="description" value="${paymentLine.description}"><br>

        <label for="billing_period">Billing Period:</label>
        <input type="text" name="billing_period" value="${paymentLine.billing_period}"><br>

        <label for="total_payment">Total Payment:</label>
        <input type="text" name="total_payment" value="${paymentLine.total_payment}"><br>

        <input type="submit" value="Update Payment Line">
    </form>

    <a href="seePaymentLine?PaymentRecord_Id=${paymentLine.record_id}">Back to Payment Lines</a>
</body>
</html>