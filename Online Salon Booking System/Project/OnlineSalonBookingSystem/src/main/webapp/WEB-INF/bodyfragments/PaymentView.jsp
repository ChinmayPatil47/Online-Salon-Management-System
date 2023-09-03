<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.user == null }"></c:if>
	<div class="container mt-4 mb-4"
		style="position: relative; min-height: 68vh">
		<div class="container pt-5 align-items-cente">
			<div class="card bg-light">
				<div class="cardbody mx-auto">
					<h4 class="text-center">Payment Details For Order</h4>
					<b class="text-center"><%@include file="businessMessage.jsp"%></b>
					 <%
						String uri = (String) request.getAttribute("uri");
						%>
					
<sf:form method="post" action="${pageContext.request.contextPath}/submitpayment" modelAttribute="form">


					<div class="form-group">
						<label for="inputEmail4" class="form-label">User Name</label> <input
							type="text" class="form-control" id="inputEmail4" name="username"
							readonly="readonly" value="${sessionScope.user.userName}">
					</div>

					<div class="form-group">
						<s:bind path="payment">
				<label for="inputPassword4" class="form-label">Amount</label>
				<sf:input path="${status.expression}"  readonly="true"
							placeholder="Enter Amount" class="form-control"/>
						<font color="red" style="font-size: 15px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
					</div>

					<div class="form-group">
						<s:bind path="cardnumber">
				<label for="inputPassword4" class="form-label">Card Number</label>
				<sf:input path="${status.expression}"
							placeholder="Enter Card Number" class="form-control"/>
						<font color="red" style="font-size: 15px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
					</div>

					<div class="form-group">
						<s:bind path="expairydate">
				<label for="inputPassword4" class="form-label">Expairy Date</label>
				<sf:input path="${status.expression}"
							placeholder="Enter Expairy Date" class="form-control"/>
						<font color="red" style="font-size: 15px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
					</div>
					
					<div class="form-group">
						<s:bind path="cvv">
				<label for="inputPassword4" class="form-label">CVV Number</label>
				<sf:input path="${status.expression}"
							placeholder="Enter Cvv Number" class="form-control"/>
						<font color="red" style="font-size: 15px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
					</div>


					<div class="container text-center mt-2">
						<input type="submit" class="btn btn-outline-success border-0"
							name="operation" value="Payment"> <a href="${pageContext.request.contextPath}/paymentlist"
							class="btn btn-outline-primary border-0">View Payment List</a>
					</div>



</sf:form>
				</div>

			</div>

		</div>

	</div>
</body>
</html>