package student_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.studentsDao;
import User.students;

@SuppressWarnings("serial")
public class show_students extends HttpServlet {

	/**
	 * ��ʾѧ��
	 * 1.��ȡ���ݿ��е���������¥����
	 * 2.����show_students
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
//======1.��ȡ���ݿ��е���������¥����
		studentsDao s=new studentsDao();
		List<students> st=new ArrayList<students>();
		String page=request.getParameter("page");
		if(page==null){
			page="1";
		}
//		floor=f.view();
		st=s.page(Integer.parseInt(page));
//		String name = request.getAttribute("use").toString();
//		request.setAttribute("use",name);
//		System.out.println(name);
//======2.����super_floor
		HttpSession session=request.getSession();
		session.setAttribute("list", st);
		session.setAttribute("page", page);
//		response.sendRedirect("super_floor.jsp");
		request.getRequestDispatcher("show_students.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
