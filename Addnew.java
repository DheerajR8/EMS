import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.Random;
public class Addnew implements Servlet
{
	private int c;
 public void init(ServletConfig h)
	{
	c=1000;	}
 public void service(ServletRequest req,ServletResponse res)throws  ServletException,IOException
	{
 	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	String ename=req.getParameter("empname");
	String pass=req.getParameter("password");
	String edpt=req.getParameter("dept");
	String epost=req.getParameter("post");
	String esal=req.getParameter("salary");
	String loc=req.getParameter("location");
	String email=req.getParameter("email");
	String contact=req.getParameter("contact");
	
	
	//Random rand=new Random();
	//int r=rand.nextInt(1000);	
	
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?)");c++;
ps.setInt(1,c);
ps.setString(2,ename);
ps.setString(3,pass);
ps.setString(4,epost);
ps.setString(5,edpt);
ps.setString(6,esal);
ps.setString(7,loc);
ps.setString(8,email);
ps.setString(9,contact);
ps.executeUpdate();
pw.println("You have suceessfully added new Employee");
pw.println("Newly Added Employee Id :"+c);
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