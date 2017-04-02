package room_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.allotDao;
import DAO.floorDao;
import DAO.roomDao;
import User.allot;
import User.room;

@SuppressWarnings("serial")
public class add_room extends HttpServlet {

	/**添加宿舍
	 * 1.获取id，num,postion
	 * 2.到数据库添加
	 * 3.到show_room
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
		int floor = Integer.parseInt(request.getParameter("floor"));
		int bed = Integer.parseInt(request.getParameter("bed"));
		int price = Integer.parseInt(request.getParameter("price"));
		int people = Integer.parseInt(request.getParameter("people"));
		int floor_id = Integer.parseInt(request.getParameter("floor_id"));

		roomDao dao=new roomDao();
		room ro=dao.findroom(id);
		floorDao daof=new floorDao();
		
		allotDao daoallot=new allotDao();
		allot allot= new allot();
		allot=daoallot.findroom(id);
		if(allot.getRoom()==0) daoallot.add(id);
		
		if(daof.findId(floor_id).getId()==0){ request.setAttribute("res","不存在该楼");request.getRequestDispatcher("res.jsp").forward(request, response); }
		else if(ro.getId()==0) {
			dao.add(id, floor,bed,price,people,floor_id);
			daoallot.add(id);
			request.getRequestDispatcher("show_room").forward(request, response);
			}
		else request.getRequestDispatcher("show_room").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
