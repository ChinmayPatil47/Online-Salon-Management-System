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
	<br>
	<c:url var="delete" value="/payment/Delete" />
	<c:url var="update" value="/home/update"/>
	
	<h2 align="center">Payment List</h2>
	<br>
	<div class="container mt-4"
		style="position: relative; min-height: 72vh">

		<sf:form method="post"
			action="${pageContext.request.contextPath}/paymentList"
			modelAttribute="form">
			
<b class="text-center"><%@ include file="businessMessage.jsp"%></b>
			<table class="table table-striped table table-dark">
				<tr>

					<th scope="col">User Name</th>
					<th scope="col">Amount</th>
					<th scope="col">Card Number</th>
					<th scope="col">Expairy Date</th>
					<th scope="col">CVV</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>

				<c:forEach items="${list}" var="paymentlist">

					<tr>

						<td>${paymentlist.username}</td>
						<td>&#8377; ${paymentlist.payment}</td>
						<td>${paymentlist.cardnumber}</td>
						<td>${paymentlist.expairydate}</td>
						<td>${paymentlist.cvv}</td>
						<td class="text-info font-weight-bold">${paymentlist.status}</td>
						<c:if test="${sessionScope.user.roleid == 1}">
						<td><a	class="btn btn-danger" href="${delete}?id=${paymentlist.id}"><i
								class='	far fa-trash-alt' style='font-size: 15px;'></i></a>
								</td>
								</c:if>
					</tr>
				</c:forEach>
				</tbody>
			</table>


		</sf:form>


	</div>
</body>
</html>