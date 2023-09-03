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
<div class="p-5  mt-4 mb-4 bg-image"
		style="background-image: url('https://img.freepik.com/free-photo/adult-barber-washing-old-man-hair-backwash_23-2148181935.jpg?w=740&t=st=1692619989~exp=1692620589~hmac=c6052eea9d7e3ce8dfeb81d4bd780ae98d2f7c99987e5d9f7d17659a268c2ebc')"
	class="img-responsive">
		<div class="container mt-4" style="position: relative; min-height: 82vh">
		<div
			class="row d-flex justify-content-center align-items-center h-100">
			<div class="col-lg-12 col-xl-11">
					<div class="card-body p-md-5">
						<div class="row justify-content-center">
							<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

								<div class="card">
									<div class="card-header text-center">Add Product</div>
									<div class="card-body">

										<sf:form method="post"
											action="${pageContext.request.contextPath}/addproduct"
											modelAttribute="form" enctype="multipart/form-data">

											<br style="clear: both">
											<%
												String uri = (String) request.getAttribute("uri");
											%>
											<s:bind path="id">
												<sf:input path="${status.expression}" type="hidden" />
											</s:bind>

											<b class="text-center"><%@include
													file="businessMessage.jsp"%></b>

											<div class="form-outline">
											  <font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
												<label class="form-label" for="form3Example4">Service
													Name</label>
												<s:bind path="serviceid">
                     <sf:select class="form-control" path="${status.expression}" required="true">
						 	<sf:option value="-1" label="----Select----" />
							<sf:options itemLabel="serviceName" itemValue="id" items="${servicelist}"/>
					</sf:select>
					</s:bind>
											</div>


											<div class="form-outline">
												<label class="form-label" for="form3Example4">Product Name</label>
												<s:bind path="productName">
													<sf:input type="text" path="${status.expression}"
														placeholder="Enter Product Name" class="form-control"
														required="true" />
													<font color="red" style="font-size: 13px"><sf:errors
															path="${status.expression}" /></font>
												</s:bind>
											</div>
											
											<div class="form-outline">
												<label class="form-label" for="form3Example4">
													Price</label>
												<s:bind path="price">
													<sf:input path="${status.expression}"
														placeholder="Enter Price"
														class="form-control" />
													<font color="red" style="font-size: 13px"><sf:errors
															path="${status.expression}" /></font>
												</s:bind>
											</div>
											
													<div class="form-outline mb-3">
												<label class="form-label" for="form3Example4">Image</label>
												<s:bind path="image">
													<sf:input type="file" path="${status.expression}"
														placeholder="Enter Image" class="form-control"
														required="true" />
													<font color="red" style="font-size: 13px"><sf:errors
															path="${status.expression}" /></font>
												</s:bind>
											</div>
											



											<div class="text-center">

												<input type="submit" value="Save" name="operation"
													class="btn btn-primary"> <input type="submit"
													value="Reset" name="operation" class="btn btn-success">
											</div>

										</sf:form>
									</div>


								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</div>
	</div>
</body>
</html>