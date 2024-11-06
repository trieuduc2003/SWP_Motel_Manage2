<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.RoomType" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>

<div class="site-blocks-cover inner-page-cover overlay" style="background-image: url('images/hero_bg_1.jpg');"
     data-aos="fade" data-stellar-background-ratio="0.5" data-aos="fade">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade-up" data-aos-delay="400">
                <h1 class="text-white">Edit Room Type</h1>
                <p>Admin can update room type details</p>
            </div>
        </div>
    </div>
</div>

<div class="site-section">
    <div class="container">
        <h2>Edit Room Type</h2>

        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>

        <form action="roomType" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="typeId" value="${roomType.typeId}">

            <div class="form-group">
                <label for="name">Room Type Name</label>
                <input type="text" class="form-control" id="name" name="name" value="${roomType.name}" required>
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <textarea class="form-control" id="description" name="description" required>${roomType.description}</textarea>
            </div>

            <div class="form-group">
                <label for="maxGuest">Max Guests</label>
                <input type="number" class="form-control" id="maxGuest" name="maxGuest" value="${roomType.maxGuest}" required>
            </div>

            <div class="form-group">
                <label for="price">Price</label>
                <input type="number" class="form-control" id="price" name="price" value="${roomType.price}" step="0.01" required>
            </div>

            <div class="form-group">
                <label for="discount">Discount (%)</label>
                <input type="number" class="form-control" id="discount" name="discount" value="${roomType.discount}" step="0.01">
            </div>

            <button type="submit" class="btn btn-primary">Update Room Type</button>
            <a href="roomType?action=list" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</div>

<%@ include file="footer.jsp" %>
