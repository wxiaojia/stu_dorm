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
public class alterMesg_room extends HttpServlet {


	/**
	 * 修改宿舍信息
	 * 1.获取页面传来的信息
	 * 2.到数据库修改
	 * 3.修改完毕跳到show_room
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
		roomDao r=new roomDao();
		room ro=new room();
		ro.setId(id);
		ro.setFloor(floor);
		ro.setBed(bed);
		ro.setPrice(price);
		ro.setPeople(people);
		ro.setFloor_id(floor_id);
		r.updata(ro);
		request.setAttribute("floor_id", floor_id);
		request.getRequestDispatcher("show_room").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
