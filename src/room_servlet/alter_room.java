package room_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.roomDao;
import User.room;

@SuppressWarnings("serial")
public class alter_room extends HttpServlet {
	/**
	 *   显示要 修改宿舍信息
	 * 1.获取传过来的宿舍id
	 * 2.传到数据库查找信息
	 * 3.将信息传到alter_room.jsp
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
		roomDao dao = new roomDao();
		room room=new room();
//		System.out.println(id);
//		System.out.println(floor_id);
		room=dao.findroom(id);
//		System.out.println(room.getId());
//		System.out.println(room.getPrice());
		request.getSession().setAttribute("alter", room);
	//	response.sendRedirect("alter_room.jsp");
		request.getRequestDispatcher("alter_room.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
