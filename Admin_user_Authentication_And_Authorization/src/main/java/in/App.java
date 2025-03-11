package in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/index")
public class App extends HttpServlet{
   public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
	  String username = req.getParameter("userId"); 
	  String password = req.getParameter("password");
	  PrintWriter out =res.getWriter();
	 // out.print("hihi");
	  String role =null;
	try {
		if(  Db.authenticateUser(username, password)) {
			  role = Db.authenticateUser1(username);
		}else {
			res.setContentType("text/html");
			res.getWriter().println("<h2 style ='color: red'>Passowrd is wrong<h2>");
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp") ;	
			rd.include(req, res);
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
//		 RequestDispatcher rd = req.getRequestDispatcher("/admin.jsp") ;		
//		rd.forward(req, res);
	}
	   HttpSession session = req.getSession();
	  // String sql ="select r.role from user u join user_role ur on u.user_id = ur.ur.user_ref_id join roles r ON ur.role_ref_id = r.role_id where u.username = ?";
     
	   session.setAttribute("role",role);
	    
	   
      if("ADMIN".equals(role)) {
    	  RequestDispatcher rd = req.getRequestDispatcher("/admin.jsp") ; 
    	  rd.forward(req, res);
    	  res.getWriter().print(role);
      }  else if("USER".equals(role))  {
    	  
    	  RequestDispatcher rd = req.getRequestDispatcher("/user.jsp") ;	
    	  rd.forward(req, res);
    	  res.getWriter().print( " hi" + role);
   }
   }}
