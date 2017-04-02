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
public class add_floor extends HttpServlet {

	/**�������ᶰ
	 * 1.��ȡid��num,postion
	 * 2.�����ݿ�����
	 * 3.��show_floor
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
		int id=Integer.parseInt(request.getParameter("id"));
		int num=Integer.parseInt(request.getParameter("num"));
		String position=request.getParameter("position");

		floorDao dao=new floorDao();
		floor fl=dao.findId(id);

		if(fl.getId()==0) {dao.add(id, num, position);}
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