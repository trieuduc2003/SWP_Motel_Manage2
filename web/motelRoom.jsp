<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Room" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<div class="site-blocks-cover inner-page-cover overlay" style="background-image: url('images/hero_bg_1.jpg');"
     data-aos="fade" data-stellar-background-ratio="0.5" data-aos="fade">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade-up" data-aos-delay="400">
                <h1 class="text-white">Room</h1>
                <p>Admin can list Room</p>
            </div>
        </div>
    </div>
</div>
<div class="site-section">
    <div class="container">
        <h2>Manage Rooms for Motel ID: ${param.motelId}</h2>

        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>

        <div class="mb-3">
            <a href="room?action=add&motelId=${param.motelId}" class="btn btn-primary ">Add New Room</a>
            <a href="roomType?action=list" class="btn btn-info">Room Type List</a>

        </div>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Room ID</th>
                    <th>Room Type</th>
                    <th>Max Guest</th>
                    <th>Price</th>
                    <th>Discount</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="room" items="${rooms}">
                    <c:set var="roomType" value="${roomDao.getRoomTypeById(room.typeId)}"/>
                    <tr>
                        <td>${room.roomId}</td>
                        <td>${roomType.name}</td>
                        <td>${roomType.maxGuest}</td>
                        <td>

                            <c:if test="${roomType.discount > 0}">
                                <span style="text-decoration: line-through;">${roomType.price}</span>

                                (<span>${roomType.price - (roomType.price * roomType.discount / 100)}</span>
                            </c:if>
                            <c:if test="${roomType.discount == 0}">
                                ${roomType.price}
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${roomType.discount > 0}">
                                ${roomType.discount} %
                            </c:if>
                        </td>
                        <td>
                            <a href="room?action=edit&roomId=${room.roomId}&motelId=${param.motelId}" class="btn btn-info">Edit</a>



                            <form action="room?action=delete" method="post" style="display: inline;">
                                <input type="hidden" name="roomId" value="${room.roomId}">
                                <input type="hidden" name="motelId" value="${param.motelId}"> <!-- Include motelId if needed -->
                                <button type="submit" class="btn btn-danger" 
                                        onclick="return confirm('Are you sure you want to delete this room?');">
                                    Delete
                                </button>
                            </form>
                        </td>

                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>
</div>

<%@ include file="footer.jsp" %>
