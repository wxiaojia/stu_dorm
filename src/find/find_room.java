package find;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.roomDao;
import User.room;


@SuppressWarnings("serial")
public class find_room extends HttpServlet {
	/**
	 *   Ѱ�ҷ���
	 * 1.���ݿ���Ѱ��
	 * 2.����
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
		roomDao rooms=new roomDao();
		room ro=new room();
		int id = Integer.parseInt(request.getParameter("id"));
//		floor=f.view();
		ro=rooms.findroom(id);
//		String name = request.getAttribute("use").toString();
//		request.setAttribute("use",name);
//		System.out.println(name);
//		System.out.println(st.getId());
//======2.����
		HttpSession session=request.getSession();
		session.setAttribute("list", ro);
		if(ro.getId()==0) request.setAttribute("str", "�����ڷ���");
		else request.setAttribute("str", "���ڸ÷��䣬��Ϣ����");
		request.getRequestDispatcher("show_findroom.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
