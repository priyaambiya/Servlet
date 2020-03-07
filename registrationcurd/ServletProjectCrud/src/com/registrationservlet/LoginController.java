package com.registrationservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginpk")
public class LoginController  extends HttpServlet
{
 @Override
       public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
 {
	 res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		try
		{
		  String upassword=req.getParameter("upass");
		  String uemail=req.getParameter("uemail");
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/piya","root","root");
       PreparedStatement ps= con.prepareStatement("Select * from registration where email='"+uemail+"' and password='"+upassword+"'");
       ResultSet rs= ps.executeQuery();
       if(rs.next())
       {
    	   String user=rs.getString("username");
    	   String pass=rs.getString("password");    	   
    	   HttpSession ses=req.getSession(true);
    	   ses.setAttribute("user",user);
    	   ses.setAttribute("pass",pass);
    //	   System.out.println(user+" "+pass);
    	  RequestDispatcher rd= req.getRequestDispatcher("/homek");
    	  rd.include(req, res);
    	 out.print("<center>you have successfully login .......welcome</center>");
    	  
       }
       else
       {
    	   RequestDispatcher rd= req.getRequestDispatcher("login.html");
     	  rd.include(req, res);
     	  out.print("<center> invalid email and password..... try again</center>");
     	  
    	   
    	 //  res.sendRedirect("https://www.google.com/");
      }
        }
		catch(Exception e)
		{
			 RequestDispatcher rd= req.getRequestDispatcher("contact.html");
	     	  rd.include(req, res);
	     	  out.print(" <center>invalid email and password..... try again</center>");
	     
			
			}
		}
	

 
}
