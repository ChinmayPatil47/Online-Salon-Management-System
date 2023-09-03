<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<meta charset="utf-8">

<!-- calender -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.10.2/fullcalendar.min.css" integrity="sha512-KXkS7cFeWpYwcoXxyfOumLyRGXMp7BTMTjwrgjMg0+hls4thG2JGzRgQtRfnAuKTn2KWTDZX4UdPg+xTs8k80Q==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.10.2/fullcalendar.min.js" integrity="sha512-o0rWIsZigOfRAgBxl4puyd0t6YKzeAw9em/29Ag7lhCQfaaua/mDwnpE2PVzwqJ08N7/wqrgdjc2E0mwdSY2Tg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.10.2/fullcalendar.print.min.css" integrity="sha512-5tgjCXQWNEEUuHZYYhokrbmmcQe6v4cbsb5dhyFwuUOOKtJglWo8046a4nDoxJlazTma4qNAM6+ZYZA7yjgZKw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<!-- calender end -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	>
	<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">
<link rel="stylesheet" href="/OnlineMedicineDonationSystem/resources/css/style.css">
<!-- google fonts start -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Bree+Serif&display=swap" rel="stylesheet">
<!-- google fonts end -->
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- Extra -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
<script type="text/javascript">
  $( function() {
    $( "#datepicker" ).datepicker({
    	dateFormat : 'mm/dd/yy',
		defaultDate : "01/01/1983",
      changeMonth: true,
      changeYear: true,
      yearRange : '-45:+10'
    });
  } );
  $( function() {
	    $( "#datepicker1" ).datepicker({
	    	dateFormat : 'mm/dd/yy',
	      changeMonth: true,
	      changeYear: true,
	      
	    });
	  } );
  
	
  </script>
<style type="text/css">
.blockquote {
	padding: 20px;
	box-shadow: inset 0 -3em 3em rgba(0, 0, 0, 0.1), 0 0 0 2px
		rgb(255, 255, 255), 0.3em 0.3em 1em rgba(0, 0, 0, 0.3);
}

.imageHeight {
	height: 380px;
}

.linkSize {
	font-size: 20px;
}
.bgcolor{
	background-color: #009688;
}

body{
	font-family: 'Bree Serif', serif;
}

.bg-footer{
	background: linear-gradient(to bottom, #EC6F66, #F3A183);
}
.bg-header{
	background-color: #F7F7FF;
}
.navbar-nav{
min-height: 33px !important;
margin-bottom: 0;
border-radius: 0;
}
.navbar-nav > li > a, .navbar-brand{
    padding-top: 5px !important;
    padding-bottom: 0 !important;
    
    height: 33px;
}
.main{
	color: maroon;
	font-family: serif;
	font-size: large;
} 

.myclass{
height:100vh;

display: flex;
justify-content: center;
align-items: center;
}
/* MARKETING CONTENT
-------------------------------------------------- */

/* Center align the text within the three columns below the carousel */
.marketing .col-lg-4 {
  margin-bottom: 1.5rem;
  text-align: center;
}
.marketing h2 {
  font-weight: 400;
}
.marketing .col-lg-4 p {
  margin-right: .75rem;
  margin-left: .75rem;
}

</style>



</head>
<body>

	<tiles:insertAttribute name="header" />
	
			<tiles:insertAttribute name="body" />
		

			<tiles:insertAttribute name="footer" />
</body>
</html>