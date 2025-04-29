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
 
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
 
	  @Resource(name = "jdbc/MyDB") // JDBC Resource
	    private DataSource dataSource;
 
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	response.setContentType("text/html");
	    	PrintWriter out = response.getWriter();
	    	
	    	//db connection
	    	try {
	    		 Connection conn = dataSource.getConnection();
	             String sqlQuery = "INSERT INTO students (name,email,age) VALUES (?,?,?)";
	             PreparedStatement stmt = conn.prepareStatement(sqlQuery);
	             //setting parameter
	             stmt.setString(1,request.getParameter("name"));
	             stmt.setString(2,request.getParameter("email"));
	             stmt.setInt(3,Integer.parseInt(request.getParameter("age")));
	             stmt.executeUpdate();	 //run the prepared statement
	             response.sendRedirect("MainServlet");
 
	       
	    	}catch(Exception e) {
	    		out.println("<h1>Error:"+e.getMessage()+"</h1>");
	    	}
	    }
	    
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
	            	 students.add(new  Student(rs.getInt("age"), rs.getString("name"), rs.getString("email")));
	             }
 
	       
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	request.setAttribute("students", students);
	    	request.getRequestDispatcher("index.jsp").forward(request, response);
	    	
	    }
}