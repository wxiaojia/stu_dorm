package floor_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.floorDao;
import User.floor;

@SuppressWarnings("serial")
public class alter_floor extends HttpServlet {

	/**
	 *   显示要 修改宿舍楼信息
	 * 1.获取传过来的宿舍楼id
	 * 2.传到数据库查找信息
	 * 3.将信息传到alter_floor.jsp
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
		floor user=new floor();
		floorDao dao = new floorDao();
		user=dao.findId(id);
		request.getSession().setAttribute("alter", user);
		response.sendRedirect("alter_floor.jsp");
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
