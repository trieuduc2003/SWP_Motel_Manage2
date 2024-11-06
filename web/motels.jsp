<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Motel" %>
<%@ page import="java.util.List" %>
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
        <h2>List of Motels</h2>
        <form action="motel" method="get" class="form-inline mb-3">
            <!-- Display the search term in the input box if it exists -->
            <input type="text" name="searchTerm" class="form-control mr-2" placeholder="Search by name" 
                   value="${searchTerm != null ? searchTerm : ''}" />
            <select name="haveDiscount" class="form-control mr-2">
                <option value="all" ${haveDiscount == 'all' ? 'selected' : ''}>All</option>
                <option value="true" ${haveDiscount == 'true' ? 'selected' : ''}>Have Discount</option>
                <option value="false" ${haveDiscount == 'false' ? 'selected' : ''}>No Discount</option>
            </select>
            <input type="hidden" name="action" value="search" />
            <button type="submit" class="btn btn-primary">Search</button>
        </form>

        <a href="addMotel.jsp" class="btn btn-primary mb-3">Add New Motel</a>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Motel ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Address</th>
                    <th>City</th>
                    <th>Number of Rooms</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="motel" items="${motels}">
                    <tr>
                        <td>${motel.motelId}</td>
                        <td>${motel.motelName}</td>
                        <td>${motel.description}</td>
                        <td>${motel.address}</td>
                        <td>${motel.city}</td>
                        <td>${motel.numberOfRoom}</td>
                        <td>
                            <a href="motel?action=edit&motelId=${motel.motelId}" class="btn btn-warning">Edit</a>
                            <form action="motel" method="post" style="display:inline;" onsubmit="return confirm('Are you sure you want to delete this motel?');">
                                <input type="hidden" name="motelId" value="${motel.motelId}" />
                                <input type="hidden" name="action" value="delete" />
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="footer.jsp" %>
