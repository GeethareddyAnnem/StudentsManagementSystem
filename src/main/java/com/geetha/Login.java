package com.geetha;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res ) throws IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		
		
		try {
			String dburl = "jdbc:mysql://localhost:3306/studentsDB?useSSL=false";
			String uname = "root";
			String passw = "Geetha2000@";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dburl,uname,passw);
			
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE name=?;");
			pstmt.setString(1,name);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next() && rs.getString("password").equals(password)) {
				
				
				HttpSession session = req.getSession();
				session.setAttribute("user", name);
				
				
				res.sendRedirect("index.jsp");
			} else {
				res.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			
		} 
	}
}
