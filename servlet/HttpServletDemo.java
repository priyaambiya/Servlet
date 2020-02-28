package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/priya")
public class HttpServletDemo extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	pw.print("<html><body><form action='#' method='get'>"
	+"Username<input type='text' name=uname>"+"Password<input type='text' name='pass'>"
	+"<input type='submit' value='login'></body>"
	+"</html>"
	);
	
	
	
}

}
