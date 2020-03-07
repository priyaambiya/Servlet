package com.registrationservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/updatee")
public class UpdateController  extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		try
		{
			HttpSession ses=req.getSession(false);
			if(ses!=null)
			{
				String uname= req.getParameter("username");
				String uemail= req.getParameter("email");
				String umob= req.getParameter("mobileno");
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/piya","root","root");
				PreparedStatement ps=con.prepareStatement("update registration set username='"+uname+"',mobileno='"+umob+"' where email='"+uemail+"'");
				int row=ps.executeUpdate();
				if(row>0)
				{
					ses.invalidate();
					res.sendRedirect("login.html");
				}
			}
			else
			{
				res.sendRedirect("login.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();


		}

	}

}
