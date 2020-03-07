package com.registrationservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/viewuser")
public class ViewUserData extends HttpServlet
{
 @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
 {
	 try
	 {
		 
		 PrintWriter out=res.getWriter();
	 HttpSession ses=req.getSession(false);
	 if(ses!=null)
	 {
	String user=(String) ses.getAttribute("user");
	String pass=(String) ses.getAttribute("pass");
out.print("<center><h4>Welcome "+user+"</h4></center>");
	 
	 Class.forName("com.mysql.jdbc.Driver");
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/piya","root","root");
	 PreparedStatement ps=con.prepareStatement("Select * from registration where username=? and password=?");
	 ps.setString(1,user);
	 ps.setString(2,pass);
	 ResultSet rs=ps.executeQuery();
	if(rs.next())
	{
		out.println("<center><table><form action='updatee' method='post'>");
		out.println("<tr><td>Username</td><td><input type='text' name='username' value='"+rs.getString("username")+"'></td></tr>"
				+ "<tr><td>Email</td><td><input type='text' name='email' value='"+rs.getString("email")+"' readonly></td></tr>"
				+ "<tr><td>Mobileno</td><td><input type='text' name='mobileno' value='"+rs.getString("mobileno")+"'></td></tr>"
						+ "<td><input type='submit' value='update'</table></center>");

	}}
	 else
	 {
		 res.sendRedirect("login.html");
	 }
	 }
	 catch(Exception e) {
		 e.printStackTrace();
		 }
}
}
