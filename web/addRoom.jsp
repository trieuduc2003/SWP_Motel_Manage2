<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.RoomType" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="header.jsp" %>

<div class="site-blocks-cover inner-page-cover overlay" style="background-image: url('images/hero_bg_1.jpg');"
     data-aos="fade" data-stellar-background-ratio="0.5" data-aos="fade">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade-up" data-aos-delay="400">
                <h1 class="text-white">Add Room</h1>
                <p>Admin can add a new room</p>
            </div>
        </div>
    </div>
</div>

<div class="site-section">
    <div class="container">
        <h2>Add New Room</h2>

        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>

        <form action="room" method="post">
            <input type="hidden" name="action" value="insert">
            <input type="hidden" name="motelId" value="${param.motelId}">

            <div class="form-group">
                <label for="roomType">Room Type</label>
                <select class="form-control" id="roomType" name="roomType" required>
                    <c:forEach var="roomType" items="${roomTypes}">
                        <option value="${roomType.typeId}">${roomType.name}- $ ${roomType.price} 
                        </option>
                    </c:forEach>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Add Room</button>
            <a href="room?action=list&motelId=${param.motelId}" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</div>

<%@ include file="footer.jsp" %>
