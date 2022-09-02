package com.geetha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/del")
public class DelStud extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			String dburl = "jdbc:mysql://localhost:3306/studentsDB?useSSL=false";
			String uname = "root";
			String passw = "Geetha2000@";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dburl,uname,passw);
			
			PreparedStatement pstmt = con.prepareStatement("DELETE from stud_info WHERE id=?;");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
			res.sendRedirect("index.jsp");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
