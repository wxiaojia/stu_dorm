package student_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.studentsDao;
import User.students;

@SuppressWarnings("serial")
public class alter_students extends HttpServlet {
	/**
	 *   显示要 修改学生信息
	 * 1.获取传过来的学生id
	 * 2.传到数据库查找信息
	 * 3.将信息传到alter_studetns.jsp
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
//		int floor_id = Integer.parseInt(request.getParameter("floor_id"));
		studentsDao dao = new studentsDao();
		students student=new students();
//		System.out.println(id);
//		System.out.println(floor_id);
		student=dao.findId(id);
//		System.out.println(room.getId());
//		System.out.println(room.getPrice());
		request.getSession().setAttribute("alter", student);
	//	response.sendRedirect("alter_room.jsp");
		request.getRequestDispatcher("alter_student.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
