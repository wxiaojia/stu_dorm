package floor_servlet;
import DAO.floorDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class delete_floor extends HttpServlet {

	/**
	 * 删除虚宿舍楼信息
	 *1.根据传来的id，在数据库查找该id并删除id
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//======删除id
		int id = Integer.parseInt(req.getParameter("id"));
			new floorDao().delete(id);
		resp.sendRedirect("show_floor");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		super.doGet(req, resp);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
