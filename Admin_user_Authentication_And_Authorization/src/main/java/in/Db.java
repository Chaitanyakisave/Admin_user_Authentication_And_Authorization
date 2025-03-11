package in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Db {
	
	  public static boolean authenticateUser(String username, String password) throws ClassNotFoundException {
	        boolean isAuthenticated = false;
	        String url = "jdbc:mysql://localhost:3306/mydb";
	        String dbUser = "root";
	        String dbPassword = "root";
          Class.forName("com.mysql.cj.jdbc.Driver");
	        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
	             PreparedStatement pst = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {

	            pst.setString(1, username);
	            pst.setString(2, password);

	            ResultSet rs = pst.executeQuery();
	            isAuthenticated = rs.next(); // If a record is found, user is authenticated

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return isAuthenticated;
	    }
	  
	  public static String authenticateUser1(String username) throws ClassNotFoundException {
	        boolean isAuthenticated = false;
	        String role= null;
	        String url = "jdbc:mysql://localhost:3306/mydb";
	        String dbUser = "root";
	        String dbPassword = "root";
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String sql ="select r.role from users u join user_roles ur on u.user_id = ur.user_ref_id join role r ON ur.role_ref_id = r.role_id where u.username = ?"; ;
	        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
	             PreparedStatement pst = conn.prepareStatement(sql)) {

	            pst.setString(1, username);
	           
	            ResultSet rs = pst.executeQuery();
	            while( rs.next()) {
	            	 role = rs.getString(1);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return role;
	    }

	  public static ArrayList<String> authenticateUser2() throws ClassNotFoundException {
	        ArrayList<String> al =new ArrayList<>();
	        String role= null;
	        String url = "jdbc:mysql://localhost:3306/mydb";
	        String dbUser = "root";
	        String dbPassword = "root";
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String sql ="select name from users;" ;
	        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
	             PreparedStatement pst = conn.prepareStatement(sql)) {

	           // pst.setString(1, username);
	           
	            ResultSet rs = pst.executeQuery();
	            while( rs.next()) {
	            	 al.add( rs.getString(1));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return al;
	    }
	   
}
