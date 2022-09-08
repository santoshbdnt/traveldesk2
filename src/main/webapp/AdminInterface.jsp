<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
<style>
form{
display: inline-flex;
}

body {
background-image: url("images/index.jpg");
}

.travel{
	color:white;
}
</style>
	<script src="js/newrecord.js"></script>

 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
   <link rel="stylesheet" href="css/AdminInterface.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<link rel="stylesheet"  href="create.css">
<link rel="stylesheet" href="js.js" type="text/Javascript">
<script src="/create.js"></script>
</head>
  <body>
    <div>
        <div class="main-container">
            <div>
                <div class="container-fluid row ">
                    <div class="col-3 float-left">
                        <a href="#">
                            
                        </a>
                    </div>

                    <div class="col-7 float-left" style="align-self: center;">
                        <h1 class="text-white">ABC Private Travels Limited</h1>
                    </div>

                    <div class="col-2 float-end" style="align-self: center;">
                        <a href="index.html"><button type="button" class="btn btn-danger">Logout</button></a>
                    </div>

                </div>

                <div class="mt-3 text-center">
                    <h1 class="travel">Employee Interefernce</h1>
                </div>

                <div class="mt-5 text-center">
                    <a href="createEmployee.html"><button type="button" class="btn btn-danger">Create Employess</button></a>

                    <a href="search.html"><button type="button" class="btn btn-danger ">Search Traveler</button></a>
                    <form action="ViewEmployee" method="post">
                    <input type="submit" class="btn btn-danger " Value="View Employees">
					</form>
                </div>
                
                
    </div>
            </div>

        </div>
    </div>
<script src="index.js"></script>
	
	<%
	
	
	if(session.getAttribute("fname") == null){
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.forward(request, response);
	}
	%>
	
	
</body>
</html>