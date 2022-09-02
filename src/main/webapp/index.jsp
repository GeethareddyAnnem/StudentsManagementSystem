<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student DB</title>
</head>
<body>
	
	<%
		if(session.getAttribute("user") == null){
			response.sendRedirect("login.jsp");
		}
	
	%>


	<h1>Welcome to Student Database Management System <%=session.getAttribute("user") %></h1>
	<form action="addStud" method="post">
		<input type="text" name="name" placeholder="Enter Name"  >
		<input type="number" name="age" placeholder="Enter Age"  >
		<input type="number" name="year" placeholder="Enter Year"  >
		<input type="email" name="email" placeholder="Enter Mail"  >
		<input type="submit" value="add" />
	</form>
	
	<h2>List of Students</h2>
	<%@ page import="java.sql.*" %>
	<% 
		String dburl = "jdbc:mysql://localhost:3306/studentsDB?useSSL=false";
		String uname = "root";
		String passw = "Geetha2000@";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(dburl,uname,passw);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM stud_info");
		//st.close();
		//con.close();
		
	%>
	<%
	while(rs.next()){
		out.println("Id: "+rs.getString("id")+" - "+rs.getString("name")+" - "+rs.getString("year")+" Year <a href='del?id="+rs.getString("id")+"'>Delete</a> <br>");	
	}
	st.close();
	con.close();
	%>
	
	<h3>Want to <a href="logout" >Logout</a>?</h3>
</body>
</html>