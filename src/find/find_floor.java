package find;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.roomDao;
import User.room;

@SuppressWarnings("serial")
public class find_floor extends HttpServlet {
	/**��ʾ����
	 * 1.��ȡ������id 
	 * 2.ͨ��id�����ݿ��ȡ���з���
	 * 3.����show_findfloor
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
//======1.��ȡid
		int id = Integer.parseInt(request.getParameter("id"));
//======2.�����ݿ����
		roomDao rooms=new roomDao();
		List<room> list=new ArrayList<room>();
		list=rooms.findId(id);
//======3.����super_floor
//		HttpSession session=request.getSession();
		request.setAttribute("list", list);	
		request.getRequestDispatcher("show_findfloor.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
