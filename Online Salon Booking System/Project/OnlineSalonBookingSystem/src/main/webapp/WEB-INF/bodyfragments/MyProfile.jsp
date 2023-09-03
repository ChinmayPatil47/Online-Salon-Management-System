<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<br>
<div class="container"> 
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item linkSize"><i class="fas fa-tachometer-alt"></i> <a class="link-dark" href="<c:url value="/welcome"/>">Home</a></li>
    <li class="breadcrumb-item linkSize active" aria-current="page"> <i class="fa fa-arrow-right" aria-hidden="true"></i> My Profile</li>
  </ol>
</nav>
</div>
<hr>
<div class="container"> 
	<sf:form method="post"
		action="${pageContext.request.contextPath}/profilee"
		modelAttribute="form">
		<div class="card">
			<h5 class="card-header"
				style="background-color: #00061df7; color: white;">My Profile</h5>
			<div class="card-body">
				<b><%@ include file="businessMessage.jsp"%></b>



				<div class="col-md-6">
					<s:bind path="userName">
						<label for="inputEmail4" class="form-label">User Name</label>
						<sf:input path="${status.expression}"
							placeholder="Enter User Name" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
			
				<div class="col-md-6">
					<s:bind path="email">
						<label for="inputEmail4" class="form-label">Email</label>
						<sf:input path="${status.expression}" placeholder="Enter Email"
							class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				
				<div class="col-md-6">
					<s:bind path="password">
						<label for="inputEmail4" class="form-label">Password</label>
						<sf:input path="${status.expression}" type = "password"
							placeholder="Enter Password" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>

				<div class="col-md-6">
					<s:bind path="phoneNo">
						<label for="inputEmail4" class="form-label">Phone No</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Phone No" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				
				
				<div class="col-md-6">
					<s:bind path="gender">
						<label for="inputEmail4" class="form-label">Gender</label>
							<sf:select class="form-control" path="${status.expression}">
					             	<option selected disabled>--------Select Gender Type-------</option>
									<sf:option value="Male"/>
									<sf:option value="Female" />
								</sf:select>
								<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>

				

				<br>
				<div class="text-center ml-2 col-3">
					<input type="submit" name="operation"
						class="btn btn-primary" value="Save">  <input
						type="submit" name="operation" class="btn btn-primary"
						value="Reset">
				</div>
			</div>
		</div>
	</sf:form>
</div>