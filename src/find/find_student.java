package find;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.allotDao;
import DAO.studentsDao;
import User.students;

@SuppressWarnings("serial")
public class find_student extends HttpServlet {
	/**
	 *   Ѱ��ѧ��
	 * 1.���ݿ���Ѱ��
	 * 2.����fine_student
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
		students st=new students();
		int id = Integer.parseInt(request.getParameter("id"));
//		floor=f.view();
		st=s.findId(id);
		
		allotDao a=new allotDao();
		int room_id=a.findstu(id);
		
//		String name = request.getAttribute("use").toString();
//		request.setAttribute("use",name);
//		System.out.println(name);
//		System.out.println(st.getId());
//======2.����
		HttpSession session=request.getSession();
		session.setAttribute("list", st);
		if(st.getId()==0) request.setAttribute("str", "�����ڸ�ѧ��");
		else {request.setAttribute("str", "���ڸ�ѧ������Ϣ����");request.setAttribute("room_id", room_id);}
//		response.sendRedirect("show_findstudent.jsp");
		request.getRequestDispatcher("show_findStudent.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
