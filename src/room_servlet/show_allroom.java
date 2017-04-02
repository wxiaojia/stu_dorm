package room_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.roomDao;
import User.room;

@SuppressWarnings("serial")
public class show_allroom extends HttpServlet {

	/**
	 * 显示宿舍楼
	 * 1.获取数据库中的所有宿舍楼数据
	 * 2.传到super_floor
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	/*	response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");*/
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("UTF-8");
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();
//======1.获取数据库中的所有宿舍楼数据
		roomDao f=new roomDao();
		List<room> room=new ArrayList<room>();
		String page=request.getParameter("page");
		if(page==null){
			page="1";
		}
//		floor=f.view();
		room=f.page(Integer.parseInt(page));
//		String name = request.getAttribute("use").toString();
//		request.setAttribute("use",name);
//		System.out.println(name);
//======2.传到super_floor
		HttpSession session=request.getSession();
		session.setAttribute("list", room);
		session.setAttribute("page", page);
//		response.sendRedirect("super_floor.jsp");
		request.getRequestDispatcher("show_allroom.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
