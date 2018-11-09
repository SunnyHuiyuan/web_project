package com.atguigu.javaweb.mvc;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listAllStudents")
public class ListAllStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentDao studentDao = new StudentDao();
		List<Student> students = studentDao.getAll();

		request.setAttribute("students", students);

		// 请求的转发
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/students.jsp");
		requestDispatcher.forward(request, response);
	}

}
