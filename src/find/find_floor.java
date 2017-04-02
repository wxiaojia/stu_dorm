package find;

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
public class find_floor extends HttpServlet {
	/**显示房间
	 * 1.获取传来的id 
	 * 2.通过id到数据库获取所有房间
	 * 3.传到show_findfloor
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
		int id = Integer.parseInt(request.getParameter("id"));
//======2.到数据库查找
		roomDao rooms=new roomDao();
		List<room> list=new ArrayList<room>();
		list=rooms.findId(id);
//======3.传到super_floor
//		HttpSession session=request.getSession();
		request.setAttribute("list", list);	
		request.getRequestDispatcher("show_findfloor.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
