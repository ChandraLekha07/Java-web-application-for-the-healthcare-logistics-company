package Register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
public class UserRegister extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String phone = request.getParameter("phno");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String cpwd = request.getParameter("cpwd");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharma","root","root");
			Statement stm=con.createStatement();
			if(uname == "" || phone == "" || email == "" || pwd == "" || cpwd == "") {
				out.print("All fields are required.");
			}else if(!pwd.equals(cpwd)){
				out.print("Passwords didnt match");
			}
			else {
				PreparedStatement pst=con.prepareStatement("insert into register values(?,?,?,?)"); 
				pst.setString(1, uname);
				pst.setString(2, phone);
				pst.setString(3, email);
				pst.setString(4, pwd);
				int n=pst.executeUpdate();
				con.close();
				RequestDispatcher rs = request.getRequestDispatcher("login.html");
				rs.forward(request,response);
			}
		}catch(Exception e) {
			out.print(e);
		}
	}

}
