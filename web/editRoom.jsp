<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Room" %>
<%@ page import="model.RoomType" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>

<div class="site-blocks-cover inner-page-cover overlay" style="background-image: url('images/hero_bg_1.jpg');"
     data-aos="fade" data-stellar-background-ratio="0.5" data-aos="fade">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade-up" data-aos-delay="400">
                <h1 class="text-white">Edit Room</h1>
                <p>Admin can update room details</p>
            </div>
        </div>
    </div>
</div>

<div class="site-section">
    <div class="container">
        <h2>Edit Room</h2>

        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>

        <form action="room" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="roomId" value="${room.roomId}">
            <input type="hidden" name="motelId" value="${room.motelId}">

            <div class="form-group">
                <label for="roomType">Room Type</label>
                <select class="form-control" id="roomType" name="roomType" required>
                    <c:forEach var="roomType" items="${roomTypes}">
                        <option value="${roomType.typeId}" <c:if test="${roomType.typeId == room.typeId}">selected</c:if>>
                            ${roomType.name}- $ ${roomType.price} 
                        </option>
                    </c:forEach>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Update Room</button>
            <a href="room?action=list&motelId=${room.motelId}" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</div>

<%@ include file="footer.jsp" %>
