package com.atguigu.ajax.app.servlet;

import com.atguigu.ajax.app.beans.Department;
import com.atguigu.ajax.app.beans.Location;
import com.atguigu.ajax.app.dao.BaseDao;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/employeeServlet"})
public class EmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String methodName = request.getParameter("method");
        try {
            Method method = getClass().getDeclaredMethod(methodName,
                    HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BaseDao baseDao = new BaseDao();

    protected void listLocations(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sql = "select location_id locationId,city from locations";
        List<Location> locations = baseDao.getForList(sql, Location.class);

        System.out.println(locations);
        request.setAttribute("locations", locations);

        request.getRequestDispatcher("/WEB-INF/pages/employees.jsp").forward(request, response);
    }

    protected void listDepartments(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String locationId = request.getParameter("locationId");
        String sql = "select department_id departmentId,department_name departmentName " +
                "from departments d where d.location_id=?";

        List<Department> departments = baseDao.getForList(sql,
                Department.class, Integer.parseInt(locationId));
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(departments);
        System.out.println(result);

        response.setContentType("text/javascript");
        response.getWriter().print(result);

    }
}

