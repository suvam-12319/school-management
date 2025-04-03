package controller;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.Studentservice;
import entity.Student;

@WebServlet("/register")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("resigter class triggerd");
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String gender=req.getParameter("gender");
		
		Student st1=new Student();
		st1.setName(name);
		st1.setId(id);
		st1.setAge(age);
		st1.setGender(gender);
		
		Studentservice service=new Studentservice();
		
		int res=service.save(st1);
		if (res!=0) {
			RequestDispatcher dispatcher=req.getRequestDispatcher("welcome.html");
		    dispatcher.forward(req, resp);
		}
		else
		{
			PrintWriter pr=resp.getWriter();
			pr.print("<h1>DATA NOT SAVED</h1>");
		}
	}
}

