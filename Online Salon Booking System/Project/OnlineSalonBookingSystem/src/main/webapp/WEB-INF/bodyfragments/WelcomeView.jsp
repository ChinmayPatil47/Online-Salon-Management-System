<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	   <%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
 <style>
        .cont{
            width: 400px;
            position: relative;
            overflow: hidden;
        }
        .cont img{
            width: 100%;
            height: auto;
        }
        .cont:hover .t{
            top: 0;
        }
        .t{
            color: white;
            background-color: rgba(0,0,0,0.8);
            position: absolute;
            top: -100%;
            height: 100%;
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            transition: all 0.4s;
        }
    </style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:url var="service" value="/gender"/>
	<!--  testimonals container  -->
	<div class="testimonals-container mt-4 mb-4 ml-3 mr-3" id="testi">
		<div class="container-fluid">
			<div class="row center mx-4 my-4 text-center">
				<h2>Welcome To our Salon</h2>
				<p>Choose the section and take services</p>
			</div>

			<div class="card-group mx-2 mb-4" >
				<div class="card mx-2 mb-4 cont">
					<img
						src="https://images.unsplash.com/photo-1599351431202-1e0f0137899a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Njh8fHNhbG9ufGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60"
						 alt="...">
					<div class="t">
            <a href="${service}?gender=Men" style="text-decoration: none;"><h2>For Men</h2></a>
            <p>Discover a world of grooming, style, and relaxation tailored specifically for men!</p>
        </div>
					
					<div class="card-footer">
						<small class="text-muted">we believe that grooming is not
							just a routine it's a statement of self-care and confidence. Our
							salon is a haven where men can escape the hustle and bustle of
							everyday life and indulge in a moment of personal pampering.</small>
					</div>
				</div>

				<div class="card mx-2 mb-4 cont">
					<img 
						src="https://images.unsplash.com/photo-1614838280617-8a8f8e4cd04a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTIyfHxzYWxvbnxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=500&q=60"
						 alt="...">
						<div class="t">
            <a href="${service}?gender=Women" style="text-decoration: none;"><h2>For Women</h2></a>
            <p>Step into a world of beauty, pampering, and rejuvenation tailored exclusively for women!</p>
    </div>
					<div class="card-footer">
						<small class="text-muted">we believe that every women
							deserves to feel confident and radiant. Our salon is more than
							just a place for beauty treatments; it's a sanctuary where you
							can take a break from the demands of daily life and indulge in
							self-care.</small>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>