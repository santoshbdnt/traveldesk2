<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<link rel="stylesheet" href="css/employee.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>


</head>


<body >
    <nav class="navbar navbar-expand-lg navbar-light  anmol mb-3">
        <a class="navbar-brand" href="#">
            <img src="https://res.cloudinary.com/dawponnlp/image/upload/v1656400319/detailed-travel-logo_23-2148627268_n58z6l.webp" class="image"  width="150px" height="150px"/>
        </a>
        <div class="center">
            <h1 class=" head ">ABC Travels Limited</h1>
        </div>




    </nav>

    <div class="center">
        <h1>Employee Interface</h1>
        <hr>
        <div class="mt-5">
           <a href="newRecord.jsp"> <button class="btn btn-primary" >New Record</button></a>
            <a href="search.html"><button class="btn btn-primary">Search Traveler</button></a>
        </div>
    </div>


<%
	if(session.getAttribute("spokeName") == null){
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.forward(request, response);
	}
	%>

</body>
</html>