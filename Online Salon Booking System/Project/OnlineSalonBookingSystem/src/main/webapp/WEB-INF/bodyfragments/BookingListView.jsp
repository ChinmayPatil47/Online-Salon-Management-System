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
<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<body>
	<br>
	<c:url var="delete" value="/order/Delete"/>
	<c:url var="confirm" value="/order/confirm"/>
	<c:url var="cancle" value="/order/cancle"/>
	<c:url var="pay" value="/pay"/>
	
	
	<h2 align="center">Booking List</h2>
	<br>
	<div class="ml-4 mr-4 mt-4"
		style="position: relative; min-height: 72vh">

		<sf:form method="post"
			action="${pageContext.request.contextPath}/bookinglist"
			modelAttribute="form">
			
			
<b class="text-center"><%@ include file="businessMessage.jsp"%></b>
			<table class="table table-striped table table-dark">
				<tr>

					<th scope="col">User Name</th>
					<th scope="col">Product Name</th>
					<th scope="col">Price</th>
					<c:if test="${sessionScope.user.roleid == 1}">
					<th scope="col">Action</th>
					</c:if>
					<c:if test="${sessionScope.user.roleid == 2}">
					<th scope="col">remove</th>
					</c:if>
				</tr>
<c:set var="totalp" value="${0}" />
				<c:forEach items="${list}" var="orderlist">

					<tr>

						<td>${orderlist.userName}</td>
						<td>${orderlist.productname}</td>
						<td>&#8377; ${orderlist.servicecharge}</td>
					
					<c:if test="${sessionScope.user.roleid == 1}">
						<td><%-- <a	class="btn btn-warning" href="${cancle}?id=${orderlist.id}&status=${orderlist.status}"><i
								class='fa fa-times' style='font-size: 15px;'></i></a>
								<a class="btn btn-success" href="${confirm}?id=${orderlist.id}&status=${orderlist.status}"><i
										class='fa fa-check' style='font-size: 15px;'></i></a> --%>
											<a class="btn btn-danger" href="${delete}?id=${orderlist.id}"><i
										class='fa fa-trash' style='font-size: 15px;'></i></a>
								</td>
								</c:if>
									<c:if test="${sessionScope.user.roleid == 2}">
									<td>
									<a class="btn btn-danger" href="${delete}?id=${orderlist.id}"><i
								class='fa fa-times' style='font-size: 15px;'></i></a>
									</td>
									<c:if test="${orderlist.status == 'confirm'}">
									<td><a class="btn btn-info" href="${pay}?id=${orderlist.id}&status=${orderlist.status}"><i class="fa fa-paypal" aria-hidden="true"></i></a></td>
									</c:if>
									
									<c:if test="${orderlist.status == 'paid'}">
									<td><a class="btn btn-secondary" href="">Paid</a></td>
									</c:if>
									
									</c:if>
						</tr>
						<c:set var="totalp" value="${totalp +orderlist.servicecharge}" />
				</c:forEach>
				<c:if test="${sessionScope.user.roleid == 2}">
				<tr><td></td>
							<td  class="text-uppercase font-weight-bold">Total Charges</td>
							<td class="text-uppercase font-weight-bold">&#8377;  ${totalp}</td>
							<td><a class="btn btn-info" href="${pay}?totalcharge=${totalp}">checkout</a></td>
						</tr>
						</c:if>
				</tbody>
			</table>


		</sf:form>


	</div>
</body>
</html>