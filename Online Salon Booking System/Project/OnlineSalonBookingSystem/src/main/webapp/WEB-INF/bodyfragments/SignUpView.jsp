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
<title>Sign Up</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css"> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript"> $('.datepicker').datepicker();</script>
</head>
<body>
<div class="container mt-5">
<div class="card bg-light">
<div class="cardbody mx-auto">
    <h4 class="card-title mt-3 text-center">Sign Up Form</h4>
     <p class="text-center">Fill The Form and Complete Your Registration !!</p>  
    

<!-- Form Start -->
<sf:form method="post" action="${pageContext.request.contextPath}/userRegistration" modelAttribute="form">
<%
						String uri = (String) request.getAttribute("uri");
						%>
						 <b class="text-center"><%@ include file="businessMessage.jsp"%></b>

    <!-- UserName -->
     <s:bind path="userName">
     	<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
<div class="form-group input-group">
    <div class="input-group-prepend">
        <span class="input-group-text">
            <i class="fa fa-user"></i>
        </span>
    </div>
    
    <sf:input path="${status.expression}"
							placeholder="Enter User Name" class="form-control" />

    </div>
    </s:bind>
 
  <!-- UserName End-->

  <!-- Email -->
     <s:bind path="email">
     <font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
  <div class="form-group input-group">
    <div class="input-group-prepend">
        <span class="input-group-text">
            <i class="fa fa-envelope"></i>
        </span>
    </div>
 
    <sf:input path="${status.expression}" type = "email"
							placeholder="Enter Email" class="form-control" />
						
    </div>
    </s:bind>
  
  <!-- Email End -->

  <!-- Phone -->
     <s:bind path="phoneNo">
     	<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
  <div class="form-group input-group">
    <div class="input-group-prepend">
        <span class="input-group-text">
            <i class="fa fa-phone"></i>
        </span>
    </div>
    <select class="custom-select" style="max-width: 80px;">
        <option>+91</option>
        <option>+92</option>
        <option>+93</option>
    </select>
  
    <sf:input path="${status.expression}"
							placeholder="Enter PhoneNo" class="form-control" />
					
     </div>
    </s:bind>

  <!-- Phone End -->

<!-- User Type Feild -->
   <s:bind path="gender">
   <font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
<div class="form-group input-group">
    <div class="input-group-prepend">
        <span class="input-group-text">
            <i class="fa fa-building"></i>
        </span>
    </div>
 
						<sf:select class="form-control" path="${status.expression}">
					             	<option selected disabled>--------Select Gender Type-------</option>
									<sf:option value="Male"/>
									<sf:option value="Female" />
								</sf:select>
						</div>
					</s:bind>
  
<!-- User Type Feild End -->

<!-- Password -->
  <s:bind path="password">
  <font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
<div class="form-group input-group">
    <div class="input-group-prepend">
        <span class="input-group-text">
            <i class="fa fa-lock"></i>
        </span>
    </div>
    
    <sf:input path="${status.expression}" type="password"
							placeholder="Enter Password" class="form-control" />
				</div>		
    </s:bind>
  
  <!-- Password End -->
  
   <!-- Date -->
        <s:bind path="dob">
  
<div class="form-group input-group">
    <div class="input-group-prepend">
        <span class="input-group-text">
            <i class="fa fa-calendar"></i>
        </span>
    </div>
   
    <sf:input path="${status.expression}" 
							placeholder="Enter DOB" id="datepicker" class="form-control" />
    
  </div>
  </s:bind>
  <!-- Date End -->
  
  
    <!-- Address -->
     <s:bind path="address">
     	<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
<div class="form-group input-group">
    <div class="input-group-prepend">
        <span class="input-group-text">
            <i class="fa fa-location-arrow"></i>
        </span>
    </div>
     
    <sf:textarea  path="${status.expression}" type="text" rows = "5" cols = "30"
							placeholder="Enter Address" class="form-control" />
					
   
  </div>
   </s:bind>
  <!-- Address End -->
  

<input type="submit" name="operation" class="btn btn-block btn-success" value="Save">
<input type="submit" name="operation" class="btn btn-block btn-secondary" value="Reset">

</sf:form>
  <!-- Form End -->
</div>
</div>
</div>
<div class="mt-5">
</div>
</body>
<script type="text/javascript">
    $('.datepicker').datepicker({ 
        startDate: new Date()
    });
  
</script>
</html>