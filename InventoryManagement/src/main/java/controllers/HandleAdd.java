package controllers;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
 
import javax.sql.DataSource;
 
import jakarta.annotation.Resource;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
@WebServlet("/HandleAdd")
public class HandleAdd extends HttpServlet{
	
	@Resource(name="jdbc/MyDB")
	private DataSource dataSource; //we fetched database info
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		
		String name= request.getParameter("itemname");
		String desc = request.getParameter("itemdesc");
		int price = Integer.parseInt(request.getParameter("itemprice"));
		System.out.println(name);
		System.out.println(desc);
		System.out.println(price);
		
		
		try(Connection conn = dataSource.getConnection()) {
			if(request.getParameter("id")!=null) {
				int id=Integer.parseInt(request.getParameter("id"));
				String query="Update goods set name=?,description=?,price=? where id=?";
				PreparedStatement stmt=conn.prepareStatement(query);
				stmt.setString(1, name);
				stmt.setString(2, desc);
				stmt.setInt(3, price);
				stmt.setInt(4, id);
				stmt.executeUpdate();
				response.sendRedirect("HandleShow");
				
			}
			else {
			
				String query = "INSERT INTO goods (name,description,price) VALUES(?,?,?)";
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, name);
				stmt.setString(2, desc);
				stmt.setInt(3, price);
				stmt.executeUpdate();
				response.sendRedirect("index.jsp");
			}
			
		}catch(Exception e) {
			System.out.println("<h1>"+e.getStackTrace()+"</h1>");
		}
		
	}
 
}