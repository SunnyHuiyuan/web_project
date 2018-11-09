package com.atguigu.javaweb.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flow_id=request.getParameter("flow_id");
		StudentDao studentDao=new StudentDao();
		studentDao.deleteByFlowid(Integer.parseInt(flow_id));
		
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

}
