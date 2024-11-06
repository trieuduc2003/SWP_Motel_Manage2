<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.RoomType" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<div class="site-blocks-cover inner-page-cover overlay" style="background-image: url('images/hero_bg_1.jpg');"
     data-aos="fade" data-stellar-background-ratio="0.5" data-aos="fade">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade-up" data-aos-delay="400">
                <h1 class="text-white">Room Type</h1>
                <p>Admin can list Room Type</p>
            </div>
        </div>
    </div>
</div>
<div class="site-section">
    <div class="container">
        <h2>Manage Room Types</h2>

        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>

        <a href="roomType?action=add" class="btn btn-primary mb-3">Add New Room Type</a>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Type ID</th>
                    <th>Room Type Name</th>
                    <th>Description</th>
                    <th>Max Guest</th>
                    <th>Price</th>
                    <th>Discount</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="roomType" items="${roomTypes}">
                    <tr>
                        <td>${roomType.typeId}</td>
                        <td>${roomType.name}</td>
                        <td>${roomType.description}</td>
                        <td>${roomType.maxGuest}</td>
                        <td>
                            <c:if test="${roomType.discount > 0}">
                                <span style="text-decoration: line-through;">${roomType.price}</span>
                                <span>${roomType.price - (roomType.price * roomType.discount / 100)}</span>
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
                            <!-- Edit button -->
                            <a href="roomType?action=edit&typeId=${roomType.typeId}" class="btn btn-info">Edit</a>
                            
                            <!-- Delete button -->
<!--                            <form action="roomType?action=delete" method="post" style="display: inline;">
                                <input type="hidden" name="typeId" value="${roomType.typeId}">
                                <button type="submit" class="btn btn-danger" 
                                        onclick="return confirm('Are you sure you want to delete this room type?');">
                                    Delete
                                </button>
                            </form>-->
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="footer.jsp" %>
