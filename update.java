import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.Random;
public class update implements Servlet
{
 public void init(ServletConfig h)
	{
	}
 public void service(ServletRequest req,ServletResponse res)throws  ServletException,IOException
	{
 	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	String ename=req.getParameter("empname");
	String edpt=req.getParameter("dept");
	String epost=req.getParameter("post");
	String esal=req.getParameter("salary");
	String email=req.getParameter("email");
	String contact=req.getParameter("contact");	
	
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
PreparedStatement ps=con.prepareStatement("update employee set NAME=""");
ps.executeUpdate();
pw.println("You have suceessfuly update details of Employee");
	}
catch(Exception e2){
pw.println(e2);
}

	pw.close();
	}
        public void destroy()
	{ 
	}
	public ServletConfig getServletConfig()	
	{
	return null;	  
	}
	public String getServletInfo(){return null;}
	}