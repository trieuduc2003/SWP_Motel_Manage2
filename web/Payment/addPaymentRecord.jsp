<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Payment Record</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        form {
            max-width: 400px;
            margin: auto;
        }
        label {
            display: block;
            margin-bottom: 8px;
        }
        input[type="text"],
        input[type="number"],
        input[type="date"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            padding: 10px 15px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #218838;
        }
        .error {
            color: red;
        }
        .success {
            color: green;
        }
    </style>
</head>
<body>

<h2>Add Payment Record</h2>

<c:if test="${not empty error}">
    <div class="error">${error}</div>
</c:if>
<c:if test="${not empty success}">
    <div class="success">${success}</div>
</c:if>

<form action="addPaymentRecord" method="post">
    <label for="date">Date (yyyy-mm-dd):</label>
    <input type="text" id="Recorddate" name="Recorddate" required placeholder="2024-11-05">

    <label for="room_id">Room ID:</label>
    <input type="number" id="Recordroom_id" name="Recordroom_id" required>

    <label for="total_discount">Total Discount:</label>
    <input type="number" id="Recordtotal_discount" name="Recordtotal_discount" step="0.01" required>

    <label for="motel_id">Motel ID:</label>
    <input type="number" id="Recordmotel_id" name="Recordmotel_id" required>

    <label for="guest_id">Guest ID:</label>
    <input type="number" id="Recordguest_id" name="Recordguest_id" required>

    <label for="contract_id">Contract ID:</label>
    <input type="number" id="Recordcontract_id" name="Recordcontract_id" required>

    <input type="submit" value="Add Payment Record">
    <button onclick="window.history.back();">Go Back</button>
</form>

</body>
</html>