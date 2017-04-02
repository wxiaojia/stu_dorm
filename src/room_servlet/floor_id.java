package room_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class floor_id extends HttpServlet {
	/**
	 *   显示要 修改宿舍信息
	 * 1.获取传过来的宿舍id
	 * 2.传到数据库查找信息
	 * 3.将信息传到alter_room.jsp
	 */
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		int floor_id=Integer.parseInt(req.getParameter("floor_id"));
		req.setAttribute("floor_id", floor_id);
		req.getRequestDispatcher("add_room.jsp").forward(req, resp);
	}

	

}
