package com.forword;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/firstt")
public class MyFirstForwordCon extends HttpServlet
{

	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
		{
			 
			//String uemail=req.getParameter("uemail");
			//S String upassword=req.getParameter("upass");
			RequestDispatcher rd=req.getRequestDispatcher("/demokk");
			rd.forward(req,res);
		
		}
		

	}



