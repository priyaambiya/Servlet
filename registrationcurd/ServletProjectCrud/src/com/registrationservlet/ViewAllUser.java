package com.registrationservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Executable;
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
@WebServlet("/viewalluser")
public class ViewAllUser extends HttpServlet 
{
	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		try
		{
			PrintWriter out=res.getWriter();
			HttpSession ses=req.getSession(false);
			if(ses!=null)
			{
			String user=(String) ses.getAttribute("user");
			out.println("<center><h3>welcome "+user+"</h3></center>");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/piya","root","root");
			PreparedStatement ps=con.prepareStatement("select * from registration ");
			ResultSet rs= ps.executeQuery();
			out.println("<center><table><tr><th>Username</th>");
			out.println("<th>Email</th>");
			out.println("<th>Mobileno</th></tr>");

			while(rs.next())
			{
				out.println("<tr><td><input type='text' name='username' value='"+rs.getString("username")+"' disabled></td>"
						+ "<td><input type='text' name='email' value='"+rs.getString("email")+"' disabled></td>"
						+ "<td><input type='text' name='mobileno' value='"+rs.getString("mobileno")+"' disabled></td></tr>");
			}
			out.println("</table></center>");

			}
			else
			{
				res.sendRedirect("login.html");
			}
		}catch(Exception e)
		{

		}

	}

}
