package com.atguigu.javaweb.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

	/**
	 * 查询examstudent中所有学生的信息
	 */
	public List<Student> getAll() {

		List<Student> students = new ArrayList<Student>();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// 连接数据库
			String driverClass = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/atguigu?serverTimezone=GMT%2B8&useSSL=false";
			String user = "root";
			String password = "19960923";

			Class.forName(driverClass);
			con = DriverManager.getConnection(url, user, password);

			// 准备查询语句
			String sql = "select * from examstudent";

			// 查询
			preparedStatement = con.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int flow_id = resultSet.getInt("flow_id");
				int type = resultSet.getInt("type");
				String id_card = resultSet.getString("id_card");
				String exam_card = resultSet.getString("exam_card");
				String student_name = resultSet.getString("student_name");
				String location = resultSet.getString("location");
				int grade = resultSet.getInt("grade");

				Student student = new Student(flow_id, type, id_card, exam_card, student_name, location, grade);

				students.add(student);

			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return students;

	}

	public void deleteByFlowid(int flow_id) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			// 连接数据库
			String driverClass = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/atguigu?serverTimezone=GMT%2B8&useSSL=false";
			String user = "root";
			String password = "19960923";

			Class.forName(driverClass);
			con = DriverManager.getConnection(url, user, password);

			// 准备查询语句
			String sql = "delete  from examstudent where flow_id=?";

			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, flow_id);
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
