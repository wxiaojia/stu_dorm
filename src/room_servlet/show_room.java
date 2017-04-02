package room_servlet;

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
public class show_room extends HttpServlet {

	/**显示房间
	 * 1.获取super_floor传来的id 
	 * 2.通过id到数据库获取所有房间
	 * 3.传到super_room
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
//======1.获取id
		int floor_id = Integer.parseInt(request.getParameter("floor_id"));
//======2.到数据库查找
		roomDao rooms=new roomDao();
		List<room> list=new ArrayList<room>();
		list=rooms.findId(floor_id);
//		System.out.println(floor_id);
//======3.传到super_floor
//		HttpSession session=request.getSession();
		request.setAttribute("list", list);	
		request.setAttribute("floor_id", floor_id);	
	
		request.getRequestDispatcher("super_room.jsp").forward(request, response);
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
