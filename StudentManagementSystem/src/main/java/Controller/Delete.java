package Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import javax.sql.DataSource;
 
 
 
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Student;
 
@WebServlet("/Delete")
public class Delete extends HttpServlet {
 
	  @Resource(name = "jdbc/MyDB") // JDBC Resource
	    private DataSource dataSource;
 
	   
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    		String email = request.getParameter("email");
	    		
	    		try {
		    		 Connection conn = dataSource.getConnection();
		             String sqlQuery = "DELETE FROM students WHERE email =?";
		             PreparedStatement stmt = conn.prepareStatement(sqlQuery);
		             //setting parameter
		             stmt.setString(1,email);
		             stmt.executeUpdate();	 //run the prepared statement
		       
 
		       
		    	}catch(Exception e) {
		    		e.printStackTrace();
		    	}
	    		request.getRequestDispatcher("index.jsp").forward(request, response);
	    
	    }
}