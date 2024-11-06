<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Payment Record</title>
</head>
<body>
    <h1>Update Payment Record</h1>
    
    <form action="updatePaymentRecord" method="POST">
        <input type="hidden" name="record_id" value="${paymentRecord.record_id}" />
        
        <label for="date">Date:</label>
        <input type="date" name="date" value="${paymentRecord.date}" required /><br/>

        <label for="room_id">Room ID:</label>
        <input type="number" name="room_id" value="${paymentRecord.room_id}" required /><br/>

        <label for="total_discount">Total Discount:</label>
        <input type="number" step="0.01" name="total_discount" value="${paymentRecord.total_discount}" required /><br/>

        <label for="motel_id">Motel ID:</label>
        <input type="number" name="motel_id" value="${paymentRecord.motel_id}" required /><br/>

        <label for="guest_id">Guest ID:</label>
        <input type="number" name="guest_id" value="${paymentRecord.guest_id}" required /><br/>

        <label for="contract_id">Contract ID:</label>
        <input type="number" name="contract_id" value="${paymentRecord.contract_id}" required /><br/>

        <input type="submit" value="Update" />
    </form>
    
    <a href="listPaymentRecord">Back to Payment Records</a>
</body>
</html>