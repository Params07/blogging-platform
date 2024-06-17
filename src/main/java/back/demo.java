package back;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class demo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/blogdata";
            String username = "postgres";
            String password = "1507";
            connection = DriverManager.getConnection(url, username, password);

            String op = request.getParameter("op");
            String em = request.getParameter("email");
            String pwd = request.getParameter("passwrd");
            System.out.println(em+" "+pwd);
            if ("signup".equals(op)) {
                if (!Exist(connection, em, pwd)) {
                    insertData(connection, em, pwd);
                    response.getWriter().write("Data inserted successfully");
                } else {
                    response.getWriter().write("Data already exists");
                }
            } else {
                if (Exist(connection, em, pwd)) {
                    response.getWriter().write("valid");
                } else {
                    response.getWriter().write("invalid");
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
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

    private void insertData(Connection connection, String em, String pwd) throws SQLException {
        String sql1 = "INSERT INTO credentials (email, pwd) VALUES (?, ?)";
        try (PreparedStatement p1 = connection.prepareStatement(sql1)) {
            p1.setString(1, em);
            p1.setString(2, pwd);
            p1.executeUpdate();
        }
    }

    private boolean Exist(Connection connection, String em, String pwd) throws SQLException {

        String sql = "SELECT COUNT(*) FROM credentials WHERE email = ? AND pwd = ?";
        System.out.println(em+" "+pwd);
        try (PreparedStatement p1 = connection.prepareStatement(sql)) {
            p1.setString(1, em);
            p1.setString(2, pwd);

            ResultSet resultSet = p1.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
            return false;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        doGet(request, response);
    }

}
