package com.sendredirect;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/second22")
public class MySendReDirect2con extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
     //  String uemail=req.getParameter("uemail");
		//String upassword=req.getParameter("upass");
	//	 String name=req.getParameter("name"); 
		res.sendRedirect("http://www.google.com");
		
	}
	}


