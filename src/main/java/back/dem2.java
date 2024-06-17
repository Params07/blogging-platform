package back;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.google.gson.Gson;


public class dem2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connect = null;
		 
		try {
            Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/blogdata";
            String username = "postgres";
            String password = "1507";
            connect = DriverManager.getConnection(url, username, password);
            Integer user = Integer.parseInt(request.getParameter("id"));
            String sql = "SELECT * FROM comments WHERE post_id = ?";
            
           try(PreparedStatement p1 = connect.prepareStatement(sql)){
        	   p1.setInt(1,user);
        	   ResultSet resultSet = p1.executeQuery();
               ArrayList <HashMap> list = new ArrayList();
   	        while (resultSet.next()) {
   	            HashMap<String,String> map = new HashMap();
   	            
   	            map.put("username", resultSet.getString("username"));
   	            map.put("comment", resultSet.getString("comment"));
   	            map.put("date", resultSet.getString("date"));  
   	         list.add(map);
   	           
   	        }
               
 	         String jsonString = new Gson().toJson(list);

  	        
  	        response.setContentType("application/json");

  	       
  	        response.getWriter().write(jsonString);
           }
   	        
   	        
			 
		} catch (SQLException |ClassNotFoundException e) {
			
			e.printStackTrace();
			 response.getWriter().write("Error: " + e.getMessage());
		}
		finally {
			if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
		}
		
	}
		
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connect = null;
		 
		try {
            Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/blogdata";
            String username = "postgres";
            String password = "1507";
            connect = DriverManager.getConnection(url, username, password);
            Integer id = Integer.parseInt(request.getParameter("id"));
            String user = request.getParameter("user");
            String comment = request.getParameter("comment");
            String sql = "INSERT INTO comments (post_id,username,comment) VALUES (?,?,?)";
            response.getWriter().write("data inserted");
           try(PreparedStatement p1 = connect.prepareStatement(sql)){
        	   p1.setInt(1,id);
        	   p1.setString(2,user);
        	   p1.setString(3,comment);
        	   p1.executeUpdate();
           }
          
			 
		} catch (SQLException |ClassNotFoundException e) {
			
			e.printStackTrace();
			 response.getWriter().write("Error: " + e.getMessage());
		}
		finally {
			if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
		}
		
	}

}
