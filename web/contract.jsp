<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"></jsp:include> <!-- Include Header -->

<div class="site-mobile-menu">
    <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
            <span class="icon-close2 js-menu-toggle"></span>
        </div>
    </div>
    <div class="site-mobile-menu-body"></div>
</div> <!-- .site-mobile-menu -->

<div class="site-blocks-cover overlay" style="background-image: url('images/hero_bg_2.jpg');" data-aos="fade" data-stellar-background-ratio="0.5" data-aos="fade">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-8 text-center" data-aos="fade-up" data-aos-delay="400">
                <h1 class="mb-4">Excellent Space For Your Next Home</h1>
                <p class="mb-5">1105 Madison Plaza Suite 120 Chesapeake, CA, California</p>
                <p><a href="#" class="btn btn-primary px-5 py-3">Take a Tour</a></p>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="featured-property-half d-flex">
        <div class="image" style="background-image: url('images/hero_bg_1.jpg')"></div>
        <div class="text">
            <h2>Property Information</h2>
            <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis quae obcaecati doloribus distinctio, aliquam vero? Molestias, amet, eveniet.</p>
            <ul class="property-list-details mb-5">
                <li class="text-black">Property Name: <strong class="text-black">Marga Luxury Suite</strong></li>
                <li>Room: <strong>2</strong></li>
                <li>Total Area: <strong>482 Square Feets</strong></li>
                <li>Category: <strong>Modern House</strong></li>
                <li>Lunch Date: Jan 20, 2019<strong></strong></li>
            </ul>
            <p><a href="#" class="btn btn-primary px-4 py-3">Get Details</a></p>
        </div>
    </div>
</div>

<!-- Các ph?n còn l?i c?a mã -->

<div class="bg-primary" data-aos="fade">
    <div class="container">
        <div class="row">
            <a href="#" class="col-2 text-center py-4 social-icon d-block"><span class="icon-facebook text-white"></span></a>
            <a href="#" class="col-2 text-center py-4 social-icon d-block"><span class="icon-twitter text-white"></span></a>
            <a href="#" class="col-2 text-center py-4 social-icon d-block"><span class="icon-instagram text-white"></span></a>
            <a href="#" class="col-2 text-center py-4 social-icon d-block"><span class="icon-linkedin text-white"></span></a>
            <a href="#" class="col-2 text-center py-4 social-icon d-block"><span class="icon-pinterest text-white"></span></a>
            <a href="#" class="col-2 text-center py-4 social-icon d-block"><span class="icon-youtube text-white"></span></a>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include> <!-- Include Footer -->
