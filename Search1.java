import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class Search1 implements Servlet
{
	public void init(ServletConfig h)
	{
	
	}
	public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException	
		{
		res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	String id=req.getParameter("empid");
	out.print("<div class='container'><table><tr><th>NAME</th><th>DEPARTMENT</th><th>POST</th><th>SALARY</th><th>EMAIL-Id</th><th>CONTACT</th></tr>");
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection	("jdbc:oracle:thin:@localhost:1521:xe","system","system");
    Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("select Name,Department,Post,Salary,Email,Contact from employee where ID="+id+"");
	while(rs.next()){
		out.print("<tr><td>");
		out.println(rs.getString(1));
		out.print("</td>");
		out.print("<td>");
		out.println(rs.getString(2));
		out.print("</td>");
		out.print("<td>");
		out.println(rs.getString(3));
		out.print("</td>");
		out.print("<td>");
		out.println(rs.getLong(4));
		out.print("</td>");
		out.print("<td>");
		out.println(rs.getString(5));
		out.print("</td>");
		out.print("<td>");
		out.println(rs.getLong(6));
		out.print("</td>");
		out.print("</tr></table></div>");
	}
	
}
	catch(Exception e2){
out.println(e2);
}

	out.close();
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