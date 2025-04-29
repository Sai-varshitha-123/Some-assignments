package controllers;

import jakarta.annotation.Resource;
import models.Goods;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


@WebServlet("/HandleShow")
public class HandleShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/MyDB")
	private DataSource dataSource;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Goods> goods=new ArrayList<>();
		try {
			Connection conn=dataSource.getConnection();
			String query="Select * from goods";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				goods.add(new Goods(rs.getInt("id"), rs.getString("name"),rs.getString("description"),rs.getInt("price")));
			}
			
			req.setAttribute("goods", goods);
			req.getRequestDispatcher("show.jsp").forward(req, res);
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
