import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class login implements Servlet
{
	public void init(ServletConfig h)
	{
	
	}
	public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException	
		{
		res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	String name=req.getParameter("usrname");
	String pass=req.getParameter("usrpass");
	String select2=req.getParameter("isTitles");
	int select=Integer.parseInt(select2);
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection	("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	switch(select){
	case 1:{
	PreparedStatement ps1=con.prepareStatement("select USERNAME,PASSWORD from admin where USERNAME=? and PASSWORD=?");
	ps1.setString(1,name);	
	ps1.setString(2,pass);
	ResultSet rs1=ps1.executeQuery();
	if(rs1.next()){
	RequestDispatcher rd1=req.getRequestDispatcher("home1.html");
	rd1.include(req,res);}
	else{
	pw.println("Invalid User/Pass");
	RequestDispatcher rd1=req.getRequestDispatcher("index.html");
	rd1.include(req,res);
	
}
break;
}
    case 2:{
	PreparedStatement ps2=con.prepareStatement("select Name,Password from employee where Name=? and Password=?");
	ps2.setString(1,name);	
	ps2.setString(2,pass);
	ResultSet rs2=ps2.executeQuery();
	if(rs2.next()){
	RequestDispatcher rd2=req.getRequestDispatcher("home2.html");
	rd2.include(req,res);}
	else{
	pw.println("Invalid User/Pass");
	RequestDispatcher rd2=req.getRequestDispatcher("index.html");
	rd2.include(req,res);
	
}
break;
}   
   case 0:{
	   pw.println("Invalid selection");
   }


	}
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