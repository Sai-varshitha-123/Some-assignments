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
 
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
 
	  @Resource(name = "jdbc/MyDB") // JDBC Resource
	    private DataSource dataSource;
 
	   
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	List<Student> students = new ArrayList<>();
	    	
	    	//db connection
	    	try {
	    		 Connection conn = dataSource.getConnection();
	             Statement stmt = conn.createStatement();
	             String sqlQuery = "SELECT * from students";
	             ResultSet  rs = stmt.executeQuery(sqlQuery);
	            
	             while(rs.next()) {
	            	 students.add(new Student(rs.getInt("age"), rs.getString("name"),rs.getString("email")));
	             }
 
	       
	    	}catch(Exception e) {
	    		e.printStackTrace();	
	    	}
	    	request.setAttribute("students", students);
	    	request.getRequestDispatcher("index.jsp").forward(request, response);
	    	
	    }
}