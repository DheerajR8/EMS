import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.Random;
public class action implements Servlet
{
	private int c;
 public void init(ServletConfig h)
	{
	c=1000;	}
 public void service(ServletRequest req,ServletResponse res)throws  ServletException,IOException
	{
 	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	String name=req.getParameter("username");
	String fname=req.getParameter("fname");
	String mname=req.getParameter("mname");
	String address=req.getParameter("address");
	String city=req.getParameter("City");
	String email=req.getParameter("useremail");
	String contact=req.getParameter("usercontact");
	String balance=req.getParameter("balance");
	//Random rand=new Random();
	//int r=rand.nextInt(1000);	
	
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
PreparedStatement ps=con.prepareStatement("insert into account values(?,?,?,?,?,?,?,?,?)");c++;
ps.setInt(1,c);
ps.setString(2,name);
ps.setString(3,fname);
ps.setString(4,mname);
ps.setString(5,address);
ps.setString(6,city);
ps.setString(7,email);
ps.setString(8,contact);
ps.setString(9,balance);
ps.executeUpdate();
pw.println("Your Account Number"+c);
	RequestDispatcher rd=req.getRequestDispatcher("account-open.html");
	rd.include(req,res);
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