package com.geetha;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addStud")
public class AddStud extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		try {
			String dburl = "jdbc:mysql://localhost:3306/studentsDB?useSSL=false";
			String uname = "root";
			String passw = "Geetha2000@";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dburl,uname,passw);
			Statement st = con.createStatement();
			
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			int year = Integer.parseInt(req.getParameter("year"));
			int age = Integer.parseInt(req.getParameter("age"));
			
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO stud_info (name,age,year,email) VALUES(?,?,?,?);");
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setInt(3, year);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			
			/*
			PrintWriter out = res.getWriter();
			out.println(name+email+year+age);
			*/
			
			pstmt.close();
			st.close();
			con.close();
			
			res.sendRedirect("index.jsp");
			
		} catch(Exception e) {
			System.out.println(e);
		}

	}
}
