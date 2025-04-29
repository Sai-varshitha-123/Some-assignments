import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import javax.sql.DataSource;
import jakarta.annotation.Resource;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
		@Resource(name = "jdbc/MyDB") // JDBC Resource
	    private DataSource dataSource;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  	
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Connection con = dataSource.getConnection();
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("Dashboard.jsp");
            } else {
                response.sendRedirect("login.jsp?error=Invalid Credentials");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}