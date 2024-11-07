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
    
    <form action="updateFeeInclude" method="post">
        <input type="hidden" name="PaymentLine_Id" value="${FeeIncludepaymentLineId}" />
        <table border="1">
            <thead>
                <tr>
                    <th>Fee Include ID</th>
                    <th>Note</th>
                    <th>Count</th>
                    <th>Price</th>
                    <th>Unit</th>
                    <th>Selected</th>
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
                        <td>
                            <input type="checkbox" name="selectedFeeIncludeIds" value="${fee.feeinclude_id}" checked="checked" />
                        </td>
                    </tr>
                </c:forEach>
                <c:forEach var="fee" items="${FeeIncludeAll}">
                    <c:if test="${!FeeIncludefeeIncludes.contains(fee)}">
                        <tr>
                            <td>${fee.feeinclude_id}</td>
                            <td>${fee.note}</td>
                            <td>${fee.count}</td>
                            <td>${fee.price}</td>
                            <td>${fee.unit}</td>
                            <td>
                                <input type="checkbox" name="selectedFeeIncludeIds" value="${fee.feeinclude_id}" />
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>
        <input type="submit" value="Update" />
    </form>

    <a href="listFeeInclude?FeeIncludepaymentLineId=${FeeIncludepaymentLineId}">Back</a>
</body>
</html>