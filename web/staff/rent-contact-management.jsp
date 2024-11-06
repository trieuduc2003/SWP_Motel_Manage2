<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<title>Contract Management</title>
<jsp:include page="header.jsp" />

<div class="container-fluid">
    <h1 class="h3 mb-2 text-gray-800">Rent Contact Management</h1>

    <!-- Notification for success/error -->
    <c:if test="${not empty sessionScope.notification}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            ${sessionScope.notification}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <%
            session.removeAttribute("notification");
        %>
    </c:if>
    <c:if test="${not empty sessionScope.notificationErr}">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            ${sessionScope.notificationErr}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <%
            session.removeAttribute("notificationErr");
        %>
    </c:if>

    <!-- Add New Contract Button -->
    <!--<button type="button" class="btn btn-primary mb-4" data-toggle="modal" data-target="#addContractModal">Add New Contract</button>-->
    <div class="card shadow mb-4 ">
        <div class="card-header py-3 row">
            <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search col-md-6" action="rent-contact-management" method="GET">
                <div class="input-group">
                    <input type="text" class="form-control bg-light border-0 small" placeholder="Enter name to search..."
                           aria-label="Search" aria-describedby="basic-addon2" name="search" value="${param.search}">
                    <input type="hidden" name="status" value="${param.status}">
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="button">
                            <i class="fas fa-search fa-sm"></i>
                        </button>
                    </div>
                </div>
            </form>
            <ul class="nav nav-pills">
                <li class="nav-item">
                    <a class="nav-link ${param.status == null || param.status == '' ? 'active' : ''}" href="?search=${param.search}">ALL</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${param.status == 'ACTIVE' ? 'active' : ''}" href="?status=ACTIVE&search=${param.search}">ACTIVE</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${param.status == 'INACTIVE' ? 'active' : ''}" href="?status=INACTIVE&search=${param.search}">INACTIVE</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${param.status == 'REJECTED' ? 'active' : ''}" href="?status=REJECTED&search=${param.search}">REJECTED</a>
                </li>
            </ul>

        </div>
        <!-- Contract List Table -->
        <div class="table-responsive">
            <table class="table table-bordered" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Motel</th>
                        <th>Room</th>
                        <th>Name</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="contract" items="${contracts}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${contract.room.motel.name}</td>
                            <td>${contract.room.id}</td>
                            <td>${contract.guestName}</td>
                            <td>${contract.getFormattedStartDate()}</td>
                            <td>${contract.getFormattedEndDate()}</td>
                            <td>${contract.phoneNumber}</td>
                            <td>${contract.email}</td>
                            <td>${contract.address}</td>
                            <td >${contract.status}</td>


                            <td style="width: 170px">
                                <c:if test="${contract.status.name() == 'INACTIVE'}">
                                    <form action="rent-contact-management" method="POST" style="display:inline;" onsubmit="return confirmDelete()">
                                        <input type="hidden" name="rencontactID" value="${contract.rencontactID}"/>
                                        <input type="hidden" name="action" value="reject"/>
                                        <button type="submit" class="btn btn-danger btn-sm"><i class="fas fa-lock"></i></button>
                                    </form>

                                    <script>
                                        function confirmDelete() {
                                            return confirm("Are you sure you want to Reject?");
                                        }
                                    </script>
                                    <button type="button" class="btn btn-success btn-sm" onclick="openApproveModal(${contract.rencontactID})"><i class="fas fa-lock-open"></i></button>
                                </c:if>


                            </td>
                        </tr>



                    </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- Modal for Approval -->
        <!-- Modal for Approval -->
        <div class="modal fade" id="approveModal" tabindex="-1" role="dialog" aria-labelledby="approveModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form id="approveForm" action="rent-contact-management" method="POST" onsubmit="return validateApproveForm()">
                        <div class="modal-header">
                            <h5 class="modal-title" id="approveModalLabel">Approve Contract</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <input type="hidden" name="rencontactID" id="approveRencontactID"/>
                            <input type="hidden" name="action" value="approve"/>

                            <div class="form-group">
                                <label for="cccd">CCCD</label>
                                <input type="text" id="cccd" name="cccd" class="form-control" />
                                <small id="cccdError" class="text-danger"></small> <!-- Error message container -->
                            </div>

                            <div class="form-group">
                                <label for="price">Total Price</label>
                                <input type="number" id="price" name="price" class="form-control" />
                                <small id="priceError" class="text-danger"></small> <!-- Error message container -->
                            </div>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-success">Confirm Approval</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <script>
            function openApproveModal(rencontactID) {
                document.getElementById("approveRencontactID").value = rencontactID;
                $('#approveModal').modal('show');
            }
        </script>
        <!-- Pagination -->
        <nav class="mt-3">
            <ul class="pagination justify-content-center">
                <c:if test="${currentPage > 1}">
                    <li class="page-item">
                        <a class="page-link" href="?page=${currentPage - 1}&status=${param.status}&search=${param.search}">Previous</a>
                    </li>
                </c:if>
                <c:forEach var="pageNum" begin="1" end="${totalPages}">
                    <li class="page-item ${pageNum == currentPage ? 'active' : ''}">
                        <a class="page-link" href="?page=${pageNum}&status=${param.status}&search=${param.search}">${pageNum}</a>
                    </li>
                </c:forEach>
                <c:if test="${currentPage < totalPages}">
                    <li class="page-item">
                        <a class="page-link" href="?page=${currentPage + 1}&status=${param.status}&search=${param.search}">Next</a>
                    </li>
                </c:if>
            </ul>
        </nav>

    </div>
</div>

<script>
    function validateApproveForm() {
        let isValid = true;

// Clear previous error messages
        document.getElementById("cccdError").textContent = "";
        document.getElementById("priceError").textContent = "";

// Validate CCCD
        const cccd = document.getElementById("cccd").value;
        const cccdError = document.getElementById("cccdError");
        const cccdPattern = /^\d{12}$/; // Assuming CCCD should be exactly 12 digits
        if (!cccdPattern.test(cccd)) {
            cccdError.textContent = "CCCD must be a 12-digit number.";
            isValid = false;
        }

// Validate Price
        const price = document.getElementById("price").value;
        const priceError = document.getElementById("priceError");
        if (price <= 0 || isNaN(price)) {
            priceError.textContent = "Price must be a positive number.";
            isValid = false;
        }

        return isValid;
    }

    function openApproveModal(rencontactID) {
        document.getElementById("approveRencontactID").value = rencontactID;
        $('#approveModal').modal('show');
    }
</script>



<jsp:include page="footer.jsp"/>


