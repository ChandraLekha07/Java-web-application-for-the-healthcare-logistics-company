package Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("pwd");
		boolean status=false;  
		try {
			if(email == "" || password == "") {
				out.print("Allfields are requried.");
				RequestDispatcher rd=request.getRequestDispatcher("/login.html");
		        rd.include(request, response);
			}
			else {
		        Class.forName("com.mysql.jdbc.Driver");
		        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharma","root","root");
		        Statement smt = con.createStatement();
		        ResultSet rs=smt.executeQuery("select * from register where email = '"+email+"' and pass = '"+password+"'"); 
		        if(rs.next()) {
		        	String e = rs.getString("email");
		        	HttpSession session = request.getSession();
			        session.setAttribute("usermail", e);
			        RequestDispatcher rd=request.getRequestDispatcher("/welcome.jsp");
			        rd.forward(request, response);
		        }
		        else {
		            out.print("<script>alert(\"Invalid Email or Password.\")</script>");
		            RequestDispatcher rd=request.getRequestDispatcher("/login.html");
		            rd.include(request, response);
		          }
		        con.close();
		        }
		}catch(Exception e) {
			out.print(e);
		}
	}

}
