package Controller;
 
import java.io.IOException;

import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement; 

import javax.sql.DataSource;
 
import jakarta.annotation.Resource;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;
 
@WebServlet("/TestDB")

public class TestDB extends HttpServlet {

    private static final long serialVersionUID = 1L;
 
    @Resource(name = "jdbc/MyDB") // JDBC Resource

    private DataSource dataSource;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
 
        try (Connection conn = dataSource.getConnection();

             Statement stmt = conn.createStatement(); 

             ResultSet rs = stmt.executeQuery("SELECT NOW()")) {
 
            while (rs.next()) {

                out.println("<h1>Database Connected at: " + rs.getString(1) + "</h1>");

            }
 
        } catch (SQLException e) {

            out.println("<h1>Error: " + e.getMessage() + "</h1>");

            e.printStackTrace();

        }

    }

}

