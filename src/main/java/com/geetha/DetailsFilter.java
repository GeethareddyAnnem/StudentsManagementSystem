package com.geetha;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebFilter;


@WebFilter("/addStud")
public class DetailsFilter implements Filter {

	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		int age = Integer.parseInt(req.getParameter("age"));
		int year = Integer.parseInt(req.getParameter("year"));
		String email = req.getParameter("email");
		
		if((age > 0 && age < 100) && (year > 0 && year < 10) && (email.contains("@")) && (email.contains(".")))
			chain.doFilter(request, response);
		else {
			HttpServletResponse res = (HttpServletResponse) response;
			PrintWriter out = res.getWriter();
			out.println("Invalid Data");
		}
	}
	
	public void init(FilterConfig fconfig) throws ServletException {
		
	}
	
}
