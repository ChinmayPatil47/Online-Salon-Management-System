<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<style>
.material-symbols-outlined {
  font-variation-settings:
  'FILL' 0,
  'wght' 400,
  'GRAD' 0,
  'opsz' 48
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Barlow:wght@200&family=Old+Standard+TT:ital@1&family=Orbitron:wght@700&family=Palanquin:wght@300&family=Roboto:ital,wght@0,400;1,100&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
	integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>


<script>
	$(document).ready(function() {
		$(".owl-carousel").owlCarousel({
			loop : true,
			margin : 10,
			responsive : {
				0 : {
					items : 1,
					nav : true
				},
				600 : {
					items : 3,
					nav : false
				},
				1000 : {
					items : 3,
					nav : true,
					loop : false
				}
			}
		});
	});
	new WOW().init();
</script>
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script>
	AOS.init();
</script>

</head>
<body>
	<!-- header start -->
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<div class="container">
			<c:if test="${sessionScope.user == null }">
				<a class="navbar-brand text-white" href="<c:url value = "/" />"><b><span
						class="">Online </span>Salon Booking System</b></a>
			</c:if>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">
					<c:if test="${sessionScope.user == null }">
						<li class="nav-item active"><a class="nav-link text-white"
							href="<c:url value = "/" />">Home <span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item"><a class="nav-link text-white"
							href="<c:url value = "/about" />">About</a></li>

						<li class="nav-item"><a class="nav-link text-white"
							href="<c:url value = "/contactUs" />">Contact Us</a></li>
					</c:if>

					<c:if test="${sessionScope.user != null}">
						<c:if test="${sessionScope.user.roleid == 1}">


							<li class="nav-item"><a class="nav-link text-white"
								href="<c:url value = "/userList" />">User List</a></li>

							<li class="nav-item"><a class="nav-link text-white"
								href="<c:url value = "/services" />">Service</a></li>

							<li class="nav-item"><a class="nav-link text-white"
								href="<c:url value = "/serviceList" />">Service List</a></li>
								
								
							<li class="nav-item"><a class="nav-link text-white"
								href="<c:url value = "/products" />">Product</a></li>

							<li class="nav-item"><a class="nav-link text-white"
								href="<c:url value = "/productsList" />">Product List</a></li>


							<li class="nav-item"><a class="nav-link text-white"
								href="<c:url value = "/cartlist" />">Cart List</a></li>

							<li class="nav-item"><a class="nav-link text-white"
								href="<c:url value = "/paymentlist" />">Payment List</a></li>

							<li class="nav-item "><a class="nav-link"
								style="padding: 6px; color: black;"
								href="<c:url value="/loginView"/>"><b class="text-white">Logout</b></a></li>


						</c:if>

						<c:if test="${sessionScope.user.roleid == 2}">

							<li class="nav-item"><a class="nav-link text-white"
								href="<c:url value = "/serviceList" />">Service List</a></li>

							<%-- <li class="nav-item"><a class="nav-link text-white"
								href="<c:url value = "/bookinglist" />">Booking List</a></li>
 --%>
							<li class="nav-item"><a class="nav-link text-white"
								href="<c:url value = "/paymentlist" />">Payment List</a></li>

							<li class="nav-item "><a class="nav-link"
								style="padding: 6px; color: black;"
								href="<c:url value="/loginView"/>"><b class="text-white">Logout</b></a></li>
						</c:if>

					</c:if>

					<c:if test="${sessionScope.user != null}">

						<li class="nav-item"><a class="nav-link text-white"
							href="<c:url value = "/profile" />">My Profile</a></li>

						<li class="nav-item"><a class="nav-link text-white"
							href="<c:url value = "/changepassword" />">Change Password</a></li>

						<li class="nav-item "><a class="nav-link"><b
								class="text-white"> Hello,${sessionScope.user.userName}
									(${sessionScope.user.rolename }) </b></a></li>

						<li class="nav-item">
						<a href="<c:url value = "/cartlist" />"><span class="text-primary site-cart material-symbols-outlined">add_shopping_cart</span></a>
						</li>


					</c:if>

					<c:if test="${sessionScope.user == null}">


						<li class="nav-item"><a class="nav-link text-white"
							href="<c:url value = "/loginView" />">Login</a></li>

						<li class="nav-item"><a class="nav-link text-white"
							href="<c:url value = "/userRegistration" />">SignUp</a></li>

					</c:if>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Header End -->

	<!-- Header Section -->

</body>
</html>