package allot_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.allotDao;
import DAO.studentsDao;
import User.allot;

@SuppressWarnings("serial")
public class room_people extends HttpServlet {
	/**显示房间
	 * 1.获传来的id 
	 * 2.通过id到数据库获取信息
	 * 3.传到room_people
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
//======1.获取id,房号
		int room_id = Integer.parseInt(request.getParameter("room_id"));
//		System.out.println(room_id);
//======2.到数据库查找
		allotDao dao=new allotDao();
		allot list=new allot();
		list=dao.findroom(room_id);
		studentsDao stu=new studentsDao();
		request.setAttribute("stua", stu.findId(list.getIda()));
		request.setAttribute("stub", stu.findId(list.getIdb()));
		request.setAttribute("stuc", stu.findId(list.getIdc()));
		request.setAttribute("stud", stu.findId(list.getIdd()));
//======3.传到super_floor
//		HttpSession session=request.getSession();
//		request.setAttribute("list", list);	
		request.setAttribute("room_id", room_id);	
//		System.out.print(id);
		request.getRequestDispatcher("allot_student.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
