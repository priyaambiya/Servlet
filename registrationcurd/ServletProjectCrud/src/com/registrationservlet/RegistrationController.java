package com.registrationservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/controllerr")
public class RegistrationController extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		try
		{
			String uname=req.getParameter("uname");
			String upassword=req.getParameter("upass");
			String umobileno=req.getParameter("umob");
			String uemail=req.getParameter("uemail");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/piya","root","root");
		//Statement st=con.createStatement();
	//	st.execute("create table registration(username varchar(20),password varchar(20),mobileno varchar(10),email varchar(20))");
		PreparedStatement ps=con.prepareStatement("insert into registration (username,password,mobileno,email) values(?,?,?,?);");
		ps.setString(1,uname);
		ps.setString(2,upassword);
		ps.setString(3,umobileno);
		ps.setString(4,uemail);
		 int row=ps.executeUpdate();
		 if(row>0)
		 {
			 RequestDispatcher rd1= req.getRequestDispatcher("login.html");
	    	  rd1.include(req, res);
	    	  out.print("<center>you have successfully registration ......please login</center>");
	    	  
		 }
		 
		//out.print("done");
		//st.close();
		 ps.close();
		con.close();

		out.print("done");
		}
		
		catch(Exception e)
		{
		   RequestDispatcher rd=req.getRequestDispatcher("contact.html");
		   rd.forward(req,res);
		   
		}
	}
	}



