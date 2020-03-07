package com.sevlet2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nexttt")
public class HiddenFormCon extends HttpServlet
{
   @Override
 public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
   {
	   try
	   {

		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
	    String uname=req.getParameter("uname");
	    String password=req.getParameter("upass");
	    String uemail =req.getParameter("uemail");
	    String umob=req.getParameter("umob");
	    System.out.println(uname+" "+password+" "+uemail+" "+umob);
	    
	    
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet1","root","root");
	    PreparedStatement ps=con.prepareStatement("insert into servlet1 (username,password,email,mobile) value (?,?,?,?)");
	  
	    ps.setString(1, uname);
	    ps.setString(2, password);
	    ps.setString(3, uemail);
	    ps.setString(4, umob);
	    int row=ps.executeUpdate();
	    if(row>0)
	    {
	    	pw=res.getWriter();
	    	pw.print("successfully run.....");
	    	
	    }
	    else
	    {
	    	pw.print("try again");
	    }
	    
	   }
	   catch(Exception e)
	   {
	     e.printStackTrace();
	    }
  }
}
