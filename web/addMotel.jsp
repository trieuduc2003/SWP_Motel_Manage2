<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Motel" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<div class="site-blocks-cover inner-page-cover overlay" style="background-image: url('images/hero_bg_1.jpg');"
     data-aos="fade" data-stellar-background-ratio="0.5" data-aos="fade">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade-up" data-aos-delay="400">
                <h1 class="text-white">Motel</h1>
                <p>Admin can edit motel</p>
            </div>
        </div>
    </div>
</div>
<div class="site-section">
    <div class="container">
        <h2>Add New Motel</h2>

        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>

        <form action="motel" method="post">
            <input type="hidden" name="action" value="insert">

            <div class="form-group">
                <label for="motelName">Motel Name</label>
                <input type="text" class="form-control" id="motelName" name="motelName" 
                       required pattern=".*\S+.*" title="Motel name cannot be empty or whitespace only.">
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <textarea class="form-control" id="description" name="description" 
                          required pattern=".*\S+.*" title="Description cannot be empty or whitespace only."></textarea>
            </div>

            <div class="form-group">
                <label for="address">Address</label>
                <input type="text" class="form-control" id="address" name="address" 
                       required pattern=".*\S+.*" title="Address cannot be empty or whitespace only.">
            </div>

            <div class="form-group">
                <label for="city">City</label>
                <input type="text" class="form-control" id="city" name="city" 
                       required pattern=".*\S+.*" title="City cannot be empty or whitespace only.">
            </div>

            <div class="form-group">
                <label for="numberOfRoom">Number of Rooms</label>
                <input type="number" class="form-control" id="numberOfRoom" name="numberOfRoom" required>
            </div>

            <button type="submit" class="btn btn-primary">Add Motel</button>
            <a href="motels.jsp" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</div>

<%@ include file="footer.jsp" %>
