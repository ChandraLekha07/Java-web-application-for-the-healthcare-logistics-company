package adminlogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AdminLogin extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");  
      PrintWriter out = response.getWriter(); 
      String email=request.getParameter("email");  
      String pass=request.getParameter("pwd");  
      try {
        if(email == "" || pass == "") {
        out.print("<h2 style=\" color:white;\">All fields are requried.</h2>");
        RequestDispatcher rd=request.getRequestDispatcher("/admin.html");
        rd.include(request, response);
      }
        else {
          Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharma","root","root");
        Statement smt = con.createStatement();
        ResultSet rs=smt.executeQuery("select * from admin where email = '"+email+"' and pass = '"+pass+"'");
        if(rs.next()) {
          String n = rs.getString("fname");
          String e = rs.getString("email");
          String p = rs.getString("phonenumber");
          HttpSession session = request.getSession();
          session.setAttribute("adminname", n);
          session.setAttribute("adminemail", e);
          session.setAttribute("adminphone", p);
          RequestDispatcher rd=request.getRequestDispatcher("/Dashboard.jsp");
          rd.forward(request, response);
        }else {
          out.print("<script>alert(\"Invalid Email or Password.\")</script>");
          RequestDispatcher rd=request.getRequestDispatcher("/adminlogin.html");
          rd.include(request, response);
        }
        con.close();
        }
      }catch(Exception e) {
        out.print(e);
      }
  }

}