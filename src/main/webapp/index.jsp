<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"  >
<head>
<meta charset="UTF-8">
<title>Student DB</title>
<style>
body {
  background-color: linen;
}

h1{
  color: maroon;
  margin-left: 40px;
} 
h2{color: blue;
 margin-left: 40px;}
table, th, td {

  border: 1px solid green;
  border-collapse: collapse;
 margin-left: auto;
  margin-right: auto;
}
 td,th{
 
  background-color: #96D4D4;
}
th{ color: red;
}
h1,h2,#form{
 text-align: center;
}
#logout{

 

 text-align:right;
}

</style>
</head>
<body>

	
	<%
		if(session.getAttribute("user") == null){
			response.sendRedirect("login.jsp");
		}
	
	%>
   <h4 id="logout"><button  style="background-color: pink;"><a  href="logout"style= "color: green;" >Logout</a></button></h4>

	<h1>Welcome to Student Database Management System  </h1>
	<h2 id="name"> Hello  <%=session.getAttribute("user") %> </h2>
	
	<form action="addStud" method="post" id="form">
		<input type="text" name="name" placeholder="Enter Name"  >
		<input type="number" name="age" placeholder="Enter Age"  >
		<input type="number" name="year" placeholder="Enter Year"  >
		<input type="email" name="email" placeholder="Enter Mail"  >
		<input type="submit" value="add" />
	</form>


	<%@ page import="java.sql.*" %>
	<% 
		String dburl = "jdbc:mysql://localhost:3306/studentsDB?allowPublicKeyRetrieval=true&useSSL=false";
		String uname = "root";
		String passw = "Geetha2000@";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(dburl,uname,passw);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM stud_info");
		//st.close();
		//con.close();
		
	%>
	
	<table cellpadding="30" cellspacing="35">
		  <caption><h3 style= "color:green;">Students Details</caption>
		  
		  <tr>
		  <th> Id</th>
		  <th> Name</th>
		  <th> Email</th>
		  <th> Year</th>
		  <th> Operation</th>
		  </tr>
		  <tr>
	<%
	while(rs.next()){
		
		
		  
		
		
		out.println("<td>"+rs.getString("id")+"</td><td> "+rs.getString("name")+"</td><td>"+rs.getString("email")+"</td><td>"+rs.getString("year")+"</td><td> <a href='del?id="+rs.getString("id")+"'>Delete</a> </td> <tr>");	
	}
	st.close();
	con.close();
	%>
	</h3>
	<br>
	
</body>
</html>

