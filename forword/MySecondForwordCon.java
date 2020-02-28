package com.forword;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/demokk")
public class MySecondForwordCon extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		
		  String uemail=req.getParameter("uemail");
		  String upassword=req.getParameter("upass");
		  System.out.println(uemail+"  "+upassword);
		RequestDispatcher rd=req.getRequestDispatcher("logindemo.html");
		rd.forward(req,res);
	
	}
	

}
