<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Fee Include</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h2>Danh sách Fee Include cho Payment Line ID: ${FeeIncludepaymentLineId}</h2>

    <c:if test="${empty FeeIncludepaymentLineId}">
        <p>Error: Line ID is not available.</p>
    </c:if>
    
    <table border="1">
        <thead>
            <tr>
                <th>Fee Include ID</th>
                <th>Note</th>
                <th>Count</th>
                <th>Price</th>
                <th>Unit</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="fee" items="${FeeIncludefeeIncludes}">
                <tr>
                    <td>${fee.feeinclude_id}</td>
                    <td>${fee.note}</td>
                    <td>${fee.count}</td>
                    <td>${fee.price}</td>
                    <td>${fee.unit}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Tạo URL cho Update với tham số PaymentLine_Id -->
    <c:url var="updateFeeInclude" value="updateFeeInclude">
        <c:param name="PaymentLine_Id" value="${FeeIncludepaymentLineId}" />
    </c:url>

    <!-- Nút Update duy nhất -->
    <button onclick="window.location.href='${updateFeeInclude}'">Update</button>

    <a href="seePaymentLine?PaymentRecord_Id=${FeeIncludepaymentLineId}">Back</a>
</body>
</html>