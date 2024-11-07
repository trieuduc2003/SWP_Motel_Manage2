<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Record List</title>
    <script type="text/javascript">
        function doDelete(record_id) {
            if (confirm("Are you sure you want to delete Record with ID = " + record_id + "?")) {
                window.location = "deletePaymentRecord?deletePaymentRecordid=" + record_id;
            }
        }
    </script>
</head>
<body>
    <h1>List of Payment Records</h1>
    <div>
        <a href="addPaymentRecord">Add Payment Record</a>
    </div>

    <!-- Search Form -->
    <form action="listPaymentRecord" method="GET">
        <label for="searchByPaymentRecord">Search By:</label>
        <select name="searchByPaymentRecord" id="searchByPaymentRecord">
            <option value="record_id" ${param.searchByPaymentRecord == 'record_id' ? 'selected' : ''}>Record ID</option>
            <option value="date" ${param.searchByPaymentRecord == 'date' ? 'selected' : ''}>Date</option>
            <option value="room_id" ${param.searchByPaymentRecord == 'room_id' ? 'selected' : ''}>Room ID</option>
            <option value="total_discount" ${param.searchByPaymentRecord == 'total_discount' ? 'selected' : ''}>Total Discount</option>
            <option value="motel_id" ${param.searchByPaymentRecord == 'motel_id' ? 'selected' : ''}>Motel ID</option>
            <option value="guest_id" ${param.searchByPaymentRecord == 'guest_id' ? 'selected' : ''}>Guest ID</option>
            <option value="contract_id" ${param.searchByPaymentRecord == 'contract_id' ? 'selected' : ''}>Contract ID</option>
        </select>
        <input type="text" name="searchValuePaymentRecord" placeholder="Enter search value" value="${param.searchValuePaymentRecord}" />
        <input type="submit" value="Search" />
    </form>

    <!-- Table for Displaying Payment Records -->
    <table>
        <thead>
            <tr>
                <th><a href="?sortByPaymentRecord=record_id&orderPaymentRecord=${param.orderPaymentRecord == 'ASC' ? 'DESC' : 'ASC'}">ID</a></th>
                <th><a href="?sortByPaymentRecord=date&orderPaymentRecord=${param.orderPaymentRecord == 'ASC' ? 'DESC' : 'ASC'}">Date</a></th>
                <th><a href="?sortByPaymentRecord=room_id&orderPaymentRecord=${param.orderPaymentRecord == 'ASC' ? 'DESC' : 'ASC'}">Room ID</a></th>
                <th><a href="?sortByPaymentRecord=total_discount&orderPaymentRecord=${param.orderPaymentRecord == 'ASC' ? 'DESC' : 'ASC'}">Total Discount</a></th>
                <th><a href="?sortByPaymentRecord=motel_id&orderPaymentRecord=${param.orderPaymentRecord == 'ASC' ? 'DESC' : 'ASC'}">Motel ID</a></th>
                <th><a href="?sortByPaymentRecord=guest_id&orderPaymentRecord=${param.orderPaymentRecord == 'ASC' ? 'DESC' : 'ASC'}">Guest ID</a></th>
                <th><a href="?sortByPaymentRecord=contract_id&orderPaymentRecord=${param.orderPaymentRecord == 'ASC' ? 'DESC' : 'ASC'}">Contract ID</a></th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${paymentRecordListOfRecords}" var="pr">
                <tr>
                    <td>${pr.record_id}</td>
                    <td>${pr.date}</td>
                    <td>${pr.room_id}</td>
                    <td>${pr.total_discount}</td>
                    <td>${pr.motel_id}</td>
                    <td>${pr.guest_id}</td>
                    <td>${pr.contract_id}</td>
                    <td class="actions">
                        <a href="updatePaymentRecord?updatePaymentRecordId=${pr.record_id}">Update</a>
                        <a href="#" onclick="doDelete('${pr.record_id}')">Delete</a>
                        <a href="seePaymentLine?PaymentRecord_Id=${pr.record_id}">See-Line</a>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty paymentRecordListOfRecords}">
                <tr>
                    <td colspan="8">No payment records found.</td>
                </tr>
            </c:if>
        </tbody>
    </table>

    <!-- Pagination -->
    <div class="pagination">
        <c:if test="${paymentRecordCurrentPage > 1}">
            <a href="?paymentRecordPage=${paymentRecordCurrentPage - 1}&searchByPaymentRecord=${param.searchByPaymentRecord}&searchValuePaymentRecord=${param.searchValuePaymentRecord}&sortByPaymentRecord=${param.sortByPaymentRecord}&orderPaymentRecord=${param.orderPaymentRecord}">Previous</a>
        </c:if>
        <c:forEach begin="1" end="${paymentRecordTotalPages}" var="i">
            <c:if test="${i == paymentRecordCurrentPage}">
                <strong>${i}</strong>
            </c:if>
            <c:if test="${i != paymentRecordCurrentPage}">
                <a href="?paymentRecordPage=${i}&searchByPaymentRecord=${param.searchByPaymentRecord}&searchValuePaymentRecord=${param.searchValuePaymentRecord}&sortByPaymentRecord=${param.sortByPaymentRecord}&orderPaymentRecord=${param.orderPaymentRecord}">${i}</a>
            </c:if>
        </c:forEach>
        <c:if test="${paymentRecordCurrentPage < paymentRecordTotalPages}">
            <a href="?paymentRecordPage=${paymentRecordCurrentPage + 1}&searchByPaymentRecord=${param.searchByPaymentRecord}&searchValuePaymentRecord=${param.searchValuePaymentRecord}&sortByPaymentRecord=${param.sortByPaymentRecord}&orderPaymentRecord=${param.orderPaymentRecord}">Next</a>
        </c:if>
    </div>
</body>
</html>
