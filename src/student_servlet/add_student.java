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
public class add_student extends HttpServlet {

	/**
	 *   显示要 添加学生信息
	 * 1.获取传过来的学生id
	 * 2.传到数据库查找信息
	 * 3.将信息传到show_students
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("UTF-8");
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int sex = Integer.parseInt(request.getParameter("sex"));
		int phone = Integer.parseInt(request.getParameter("phone"));
		int grade = Integer.parseInt(request.getParameter("grade"));
		String sub = request.getParameter("sub");
		studentsDao dao = new studentsDao();
		students s=new students();
		s=dao.findId(id);
		if(s.getId()==0) {dao.add(id,name,age,sex,phone,grade,sub);}
		request.getRequestDispatcher("show_students").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
