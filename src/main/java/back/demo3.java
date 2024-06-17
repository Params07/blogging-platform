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


public class demo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		   Connection connection = null;
	        try {
	        	Class.forName("org.postgresql.Driver");
	            String url = "jdbc:postgresql://localhost:5432/blogdata";
	            String username = "postgres";
	            String password = "1507";
	            
	            connection = DriverManager.getConnection(url, username, password);
	            String u1 = request.getParameter("user");
	            
	            String sql = "SELECT * FROM data WHERE username = ?";
	            	 try(PreparedStatement p1 = connection.prepareStatement(sql))
	                 {p1.setString(1, u1);
	                 	 ResultSet resultSet = p1.executeQuery();
	                             ArrayList <HashMap> list = new ArrayList();
	                 	        while (resultSet.next()) {
	                 	            HashMap<String,String> map = new HashMap();
	                 	            map.put("title", resultSet.getString("title"));
	                 	            map.put("username", resultSet.getString("username"));
	                 	            map.put("content", resultSet.getString("content"));
	                 	            map.put("date", resultSet.getString("date"));  
	                 	            map.put("id", resultSet.getString("id"));
	                 	            list.add(map);
	                 	        }
	                 	        Collections.reverse(list);
	                 	        String jsonString = new Gson().toJson(list);

	                 	        
	                 	        response.setContentType("application/json");

	                 	       
	                 	        response.getWriter().write(jsonString);
	                 }
	             	       
			} catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	            response.getWriter().write("Error: " + e.getMessage());
	        } finally {
	            
	            if (connection != null) {
	                try {
	                    connection.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }




	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Connection connection = null;
        try {
        	Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/blogdata";
            String username = "postgres";
            String password = "1507";
            
            connection = DriverManager.getConnection(url, username, password);
            String u1 = request.getParameter("user");
            response.getWriter().write(u1);
            String sql = "DELETE  FROM data WHERE id = ?";
            	 try(PreparedStatement p1 = connection.prepareStatement(sql))
                 {p1.setInt(1, Integer.parseInt(u1));
                 p1.executeUpdate(); 
                 }
             	       
		} catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.getWriter().write("Error:" + e.getMessage());
        } finally {
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



		
		
	}

}
