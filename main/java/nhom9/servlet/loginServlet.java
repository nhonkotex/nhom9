package nhom9.servlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import nhom9.connection.DbCon;
import nhom9.dao.UserDao;
import nhom9.model.User;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");
			
			try {
				UserDao udao = new UserDao(DbCon.getConnetion());
			User user = udao.userLogin(email, password);
			
			
			if(user != null) {
					request.getSession().setAttribute("auth", user);
					response.sendRedirect("index.jsp");
					
					
					
			} else {
				out.println("<h3 style='color:crimson; text-align: center'>Bạn đã có thể nhập sai mật khẩu hoặc chưa có tài khoản!!! </h3>");
				out.println("<h4 style='text-align: center'><a href='login.jsp'> Mời bạn quay lại đăng nhập nhé.</a> </h4>");
			
			}
			
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
		
		}
	}
	}
	