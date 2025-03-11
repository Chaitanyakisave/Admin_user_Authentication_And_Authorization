package in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  @WebServlet("/register")
public class Register extends HttpServlet{
  public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
	  String name =req.getParameter("name");
	  String username = req.getParameter("userId"); 
	  String password = req.getParameter("password");
	  int role_id =Integer.parseInt(req.getParameter("id"));
	  String url = "jdbc:mysql://localhost:3306/mydb";
      String dbUser = "root";
      String dbPassword = "root";
      PrintWriter out =res.getWriter();
      try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		//out.print("hihi wrong2");
	}
     // String sql ="select r.role from users u join user_roles ur on u.user_id = ur.user_ref_id join role r ON ur.role_ref_id = r.role_id where u.username = ?"; ;
      String sql ="insert into users (username,password,name) values (?,?,?)";
      String sql1 ="insert into user_roles values(?,?)";
      String sql3 ="select user_id from users where username =?";
      try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
           PreparedStatement pst = conn.prepareStatement(sql);
    		  PreparedStatement pst3 = conn.prepareStatement(sql3);
        		   PreparedStatement pst1 = conn.prepareStatement(sql1)) {

          pst.setString(1, username);
          pst.setString(2,password);
          pst.setString(3, name);
         pst3.setString(1,username);
        int a =   pst.executeUpdate();
        ResultSet rs = pst3.executeQuery();
        int id=0 ;
       while(rs.next()) {
    	    id=   rs.getInt(1);
       }
       pst1.setInt(1, id);
       pst1.setInt(2, role_id);
        pst1.executeUpdate();
        if(a>0) {
        	res.setContentType("text/html");
        	out.print("<h1 style ='color:green'>Register succesfully please login....</h1>");
          RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
          rd.include(req,res);
        }else {
        	out.print("hihi wrong");
        }
      } catch (SQLException e) {
          e.printStackTrace();
          out.print("hihi wrong1");
      }

  }


}
