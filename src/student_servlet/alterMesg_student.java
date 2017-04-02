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
public class alterMesg_student extends HttpServlet {
	/**
	 * 修改学生信息
	 * 1.获取页面传来的信息
	 * 2.到数据库修改
	 * 3.修改完毕跳到show_students
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
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int sex= Integer.parseInt(request.getParameter("sex"));
		int phone= Integer.parseInt(request.getParameter("phone"));
		int grade= Integer.parseInt(request.getParameter("grade"));
		String sub = request.getParameter("sub");
//		System.out.println(id);
//		System.out.println(name);
//		System.out.println(st.getAge());
//		System.out.println(st.getSex());
//		System.out.println(st.getPhone());
//		System.out.println(st.getGrade());
//		System.out.println(st.getSub());
		studentsDao s=new studentsDao();
		students st=new students();
//		System.out.println(st.getId());
//		System.out.println(st.getName());
//		System.out.println(st.getAge());
//		System.out.println(st.getSex());
//		System.out.println(st.getPhone());
//		System.out.println(st.getGrade());
//		System.out.println(st.getSub());
		st.setId(id);
		st.setName(name);
		st.setAge(age);
		st.setSex(sex);
		st.setPhone(phone);
		st.setGrade(grade);
		st.setSub(sub);
		s.updata(st);
//		request.setAttribute("id", id);
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
