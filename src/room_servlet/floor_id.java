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
	 *   ��ʾҪ �޸�������Ϣ
	 * 1.��ȡ������������id
	 * 2.�������ݿ������Ϣ
	 * 3.����Ϣ����alter_room.jsp
	 */
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		int floor_id=Integer.parseInt(req.getParameter("floor_id"));
		req.setAttribute("floor_id", floor_id);
		req.getRequestDispatcher("add_room.jsp").forward(req, resp);
	}

	

}
