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
                <h1 class="text-white">Add Room Type</h1>
                <p>Admin can add a new room type</p>
            </div>
        </div>
    </div>
</div>

<div class="site-section">
    <div class="container">
        <h2>Add New Room Type</h2>

        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>

        <form action="roomType" method="post" onsubmit="return validateForm()">
            <input type="hidden" name="action" value="insert">

            <div class="form-group">
                <label for="name">Room Type Name</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <textarea class="form-control" id="description" name="description" required></textarea>
            </div>

            <div class="form-group">
                <label for="maxGuest">Max Guests</label>
                <input type="number" class="form-control" id="maxGuest" name="maxGuest" required>
            </div>

            <div class="form-group">
                <label for="price">Price</label>
                <input type="number" class="form-control" id="price" name="price" step="0.01" required>
            </div>

            <div class="form-group">
                <label for="discount">Discount (%)</label>
                <input type="number" class="form-control" id="discount" name="discount" step="0.01" value="0">
            </div>

            <button type="submit" class="btn btn-primary">Add Room Type</button>
            <a href="motelRoom.jsp" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</div>

<script>
    function validateForm() {
        var name = document.getElementById("name").value.trim();
        var description = document.getElementById("description").value.trim();
        var maxGuest = document.getElementById("maxGuest").value.trim();
        var price = document.getElementById("price").value.trim();
        var discount = document.getElementById("discount").value.trim();

        if (name === "" || description === "" || maxGuest === "" || price === "") {
            alert("Fields cannot be empty or contain only spaces.");
            return false; // Prevent form submission
        }

        return true; // Allow form submission
    }
</script>

<%@ include file="footer.jsp" %>
