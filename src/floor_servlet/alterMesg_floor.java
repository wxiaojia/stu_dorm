package floor_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.floor;
import DAO.floorDao;

@SuppressWarnings("serial")
public class alterMesg_floor extends HttpServlet {

	/**
	 * 修改宿舍楼信息
	 * 1.获取页面传来的信息
	 * 2.到数据库修改
	 * 3.修改完毕跳到show_floor
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
		int num = Integer.parseInt(request.getParameter("num"));
		String position=request.getParameter("position");
		floorDao f=new floorDao();
		floor fl=new floor();
		fl.setId(id);
		fl.setNum(num);
		fl.setPosition(position);
		f.updata(fl);
		request.getRequestDispatcher("show_floor").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
