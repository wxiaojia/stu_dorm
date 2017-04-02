package allot_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.allotDao;

@SuppressWarnings("serial")
public class delete_roomstu extends HttpServlet {

	/**
	 * 删除许文胜信息
	 *1.根据传来的id，在数据库查找该id并删除id
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//======删除id
		int room_id = Integer.parseInt(req.getParameter("room_id"));
		int id = Integer.parseInt(req.getParameter("id"));
		allotDao dao=new allotDao();
		if(id==1)
			dao.add_ida(room_id,0);
		if(id==2)
			dao.add_idb(room_id,0);
		if(id==3)
			dao.add_idc(room_id,0);
		if(id==4)
			dao.add_idd(room_id,0);
		req.setAttribute("room_id",room_id);
		req.getRequestDispatcher("room_people").forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		super.doGet(req, resp);
	}
	public void init() throws ServletException {
		// Put your code here
	}
}
