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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css"> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript"> $('.datepicker').datepicker();</script>
</head>
<body>

	<c:if test="${sessionScope.user == null }"></c:if>
	<div class="container mt-2">
	<h3 class="text-center my-3">Quote Booking Service</h3>
	<b class="text-center"><%@include file="businessMessage.jsp"%></b>
					 <%
						String uri = (String) request.getAttribute("uri");
						%>
						
	<sf:form method="post" action="${pageContext.request.contextPath}/submitbooking" modelAttribute="form">

		<div class="row g-3">

            <div class="col-md-6">
            <s:bind path="servicename">
				<label for="inputPassword4" class="form-label">Service</label>
				<sf:input path="${status.expression}"  readonly="true"
							placeholder="Enter Service" class="form-control"/>
						<font color="red" style="font-size: 15px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
			</div>


             <div class="col-md-6">
            <s:bind path="totalcharge">
				<label for="inputPassword4" class="form-label">Service Charge</label>
				<sf:input path="${status.expression}"  readonly="true"
							placeholder="Enter Service" class="form-control"/>
						<font color="red" style="font-size: 15px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
			</div>

			<div class="col-md-6">
				<label for="inputEmail4" class="form-label">Email</label> <input
					type="email" class="form-control" id="inputEmail4" name="email" readonly="readonly"
					value="${sessionScope.user.email}">
			</div>

			
			<div class="col-md-6">
				<label for="inputEmail4" class="form-label">Phone No</label> <input name="phoneNo"  readonly="readonly"
					 class="form-control" value="${sessionScope.user.phoneno}">
			</div>
			
			
			<div class="col-md-6">
			<s:bind path="scheduledate">
				<label for="inputPassword4" class="form-label">Schedule Date</label>
					<sf:input path="${status.expression}" placeholder="Enter Schedule date" class="form-control mb-4" id="datepicker1"  required="true" />
					</s:bind>
			</div>

			<div class="col-md-6">
			<s:bind path="orderid">
				<label for="inputPassword4" class="form-label">Order Id</label>
				<sf:input path="${status.expression}"
							placeholder="Enter Order Id" class="form-control"/>
						<font color="red" style="font-size: 15px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
			</div>
			
			<div class="col-md-6">
			<s:bind path="originadd">
				<label for="name">Origin Address</label>
				<sf:textarea path="${status.expression}" style="height: 100px;" class="form-control"
					placeholder="Enter Origin Address" name = "originadd" />
					<font color="red" style="font-size: 13px"><sf:errors
								               path="${status.expression}" /> </font>
					</s:bind>
			</div>

			<div class="col-md-6">
			<s:bind path="destinationadd">
				<label for="name">Destination Address</label>
				<sf:textarea path="${status.expression}" style="height: 100px;" class="form-control"
					placeholder="Enter Destination Address" name = "destinationadd" />
					<font color="red" style="font-size: 13px"><sf:errors
								               path="${status.expression}" /> </font>
								               </s:bind>
			</div>

<div class="col-md-12 mt-4">
<h6><b>Declaration</b></h6>
</div>

            <div class="col-md-12">
            <s:bind path="declaration">
            <sf:textarea path="${status.expression}" style="height: 80px;" class="form-control"
					placeholder="Enter Declaration" name = "declaration" />
					<font color="red" style="font-size: 13px"><sf:errors
								               path="${status.expression}" /> </font>
								               </s:bind>
			</div>
			
			
<div class="container mt-4 mb-4 text-center">
				<input type= "submit" class="btn btn-outline-success" name="operation" value="Submit">
			</div>
			
			
			
		</div>
		</sf:form>
	</div>
	
	
	

<script type="text/javascript">
	$('.datepicker').datepicker({
		startDate : new Date()
	});
	
</script>
</body>
</html>