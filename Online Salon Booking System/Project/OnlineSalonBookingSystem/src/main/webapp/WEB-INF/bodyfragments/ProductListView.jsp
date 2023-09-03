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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <c:url var="delete" value="/deleteproduct" />
	<c:url var="update" value="/Updateproduct"/>
	<c:url var="book" value="/bookProduct"/>
<div class="container mt-4" style="position: relative; min-height: 72vh">

	<h2 align="center">All Product</h2>

	
		<sf:form method="post"
			action="${pageContext.request.contextPath}/productsList"
			modelAttribute="form">
			
			<b class="text-center"><%@ include file="businessMessage.jsp"%></b>
			
<div class="row mt-2 mx-2 mb-4">

			<c:forEach items="${list}" var="productlist">
					
						<div class="col-md-4 mt-4" style="margin-right: 180px;">
						<div class="text-center">
							<div class="card" style="width: 23rem; background-color: #e3e5e7;">
							
							<img 
							src="https://img.fruugo.com/product/2/02/390531022_max.jpg"
							style="max-height: 200px; max-width: 100%; width: auto;"
								src='<c:url value="/productImage/${productlist.id}" />'>
								<div class="card-body">
								
								    <h5 class="card-title text-primary">
								    ${productlist.productName}
								    </h5>
								    <a class="card-text">Service Name:  ${productlist.serviceName}</a>
								    <p class="card-text text-uppercase font-weight-bold">Price :  &#8377; ${productlist.price}</p>
                                      </div>
                                      
                                     
							<c:if test="${sessionScope.user.roleid == 1}">
						<td><a	class="btn btn-info" href="${update}?id=${productlist.id}"><i
								class='	far fa-edit' style='font-size: 15px;'></i></a>
						<a	class="btn btn-danger" href="${delete}?id=${productlist.id}"><i
								class='	far fa-trash-alt' style='font-size: 15px;'></i></a>
								</td>
								</c:if>
								<c:if test="${sessionScope.user.roleid == 2}">
						<td><a	class="btn btn-info" href="${book}?id=${productlist.serviceid}&productName=${productlist.productName}&price=${productlist.price}">Booked Product</a>
								</td>
								</c:if>
								</div>
							</div>
						</div>
						
			</c:forEach>		
						</div>
	</sf:form>
	</div>
</body>
</html>