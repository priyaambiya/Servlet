package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/second")
public class GenericSevletDemo extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
	 res.setContentType("text/html");
	 PrintWriter out=res.getWriter();
	 out.print("<html><body><form action='#' method='get'>"
	 		+ "Usrname<input type='text' name='uname'>password<input type='password' name='upass'>"
	 		+"<input type='submit' value='login'></body>"
	 		+"</html>");
	}
	

}
