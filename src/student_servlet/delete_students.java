package student_servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.studentsDao;

@SuppressWarnings("serial")
public class delete_students extends HttpServlet {


	/**
	 * ɾ��ѧ����Ϣ
	 *1.���ݴ�����id�������ݿ���Ҹ�id��ɾ��id
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//======ɾ��id
		int id = Integer.parseInt(req.getParameter("id"));
			new studentsDao().delete(id);
		resp.sendRedirect("show_students");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		super.doGet(req, resp);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
