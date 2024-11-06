<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Room" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<c:set var="motel" value="${motelDao.getMotelById(param.motelId)}"/>

<div class="site-blocks-cover inner-page-cover overlay" style="background-image: url('images/hero_bg_1.jpg');"
     data-aos="fade" data-stellar-background-ratio="0.5" data-aos="fade">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-7 text-center" data-aos="fade-up" data-aos-delay="400">
                <h1 class="text-white">Available Rooms</h1>
                <p>Choose a room to book</p>
            </div>
        </div>
    </div>
</div>

<div class="site-section">
    <div class="container">
        <h2>Rooms of ${motel.motelName}</h2>

        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>

        <div class="row">
            <c:forEach var="room" items="${rooms}">
                <c:set var="roomType" value="${roomDao.getRoomTypeById(room.typeId)}" />
                <div class="col-md-4 mb-4">
                    <div class="card position-relative">
                        <img src='images/img_1.jpg' class="card-img-top" alt="${roomType.name}">
                        <div class="card-body">
                            <h5 class="card-title">${roomType.name}</h5>
                            <p class="card-text">
                                Max Guests: ${roomType.maxGuest}<br>
                                Price: 
                                <c:if test="${roomType.discount > 0}">
                                    <span style="text-decoration: line-through;">${roomType.price}</span>
                                    (<span>${roomType.price - (roomType.price * roomType.discount / 100)}</span>)
                                </c:if>
                                <c:if test="${roomType.discount == 0}">
                                    ${roomType.price}
                                </c:if>
                            </p>

                            <!-- Button to open booking modal -->
                            <button class="btn btn-primary" onclick="openBookingModal(${room.roomId})">
                                Book Now
                            </button>
                        </div>
                        <c:if test="${roomType.discount > 0}">
                            <span class="badge bg-info position-absolute" style="top: 10px; right: 10px;">-${roomType.discount}%</span>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<!-- Booking Modal -->
<div id="bookingModal" class="modal" tabindex="-1" role="dialog" style="display:none;">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Booking Information</h5>
                <button type="button" class="close" onclick="closeBookingModal()">
                    <span>&times;</span>
                </button>
            </div>
            <div class="modal-body" id="modalBody">
                <!-- Booking form will be injected here -->
            </div>
        </div>
    </div>
</div>

<div id="modalBackdrop" style="display:none;" onclick="handleBackdropClick()"></div>

<script>
function openBookingModal(room) {
    var modalBody = document.getElementById('modalBody');
    modalBody.innerHTML = `
        <form action="contract?action=insert" method="post">
            <input type="text" name="roomId" value="${room}">
            <input type="hidden" name="motelId" value="${param.motelId}">
            <input type="text" name="totalPrice" value="${roomDao.getRoomTypeById(room.typeId).price}">
            
            <div class="form-group">
                <label for="checkInDate">Check-in Date:</label>
                <input type="date" name="checkInDate" required class="form-control">
            </div>
            
            <div class="form-group">
                <label for="checkOutDate">Check-out Date:</label>
                <input type="date" name="checkOutDate" required class="form-control">
            </div>
            
            <div class="form-group">
                <label for="specialRequests">Special Requests:</label>
                <textarea name="specialRequests" class="form-control" rows="4" placeholder="Any special requests?"></textarea>
            </div>
            
            <div class="form-group">
                <label for="contactInfo">Contact Information:</label>
                <input type="text" name="contactInfo" required class="form-control" placeholder="Your contact number or email">
            </div>
            
            <div class="form-group">
                <label for="paymentMethod">Payment Method:</label>
                <select name="paymentMethod" required class="form-control">
                    <option value="Credit Card">Credit Card</option>
                    <option value="Debit Card">Debit Card</option>
                    <option value="Cash">Cash</option>
                    <option value="Bank Transfer">Bank Transfer</option>
                </select>
            </div>
            
            <button type="submit" class="btn btn-success" 
                    onclick="return confirm('Are you sure you want to book this room?');">
                Confirm Booking
            </button>
        </form>
    `;
    document.getElementById('bookingModal').style.display = 'block';
    document.getElementById('modalBackdrop').style.display = 'block';
}


    function closeBookingModal() {
        document.getElementById('bookingModal').style.display = 'none';
        document.getElementById('modalBackdrop').style.display = 'none';
    }

    function handleBackdropClick() {
        if (confirm('Are you sure you want to close the booking form?')) {
            closeBookingModal();
        }
    }
</script>

<%@ include file="footer.jsp" %>
