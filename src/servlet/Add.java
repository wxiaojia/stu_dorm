package servlet;
import DAO.userDao;
import User.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Add extends HttpServlet {
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
		String num=request.getParameter("id");
		String username=request.getParameter("sname");
		String pwd=request.getParameter("passw");
		String right=request.getParameter("right");
		userDao dao=new userDao();
		int id= Integer.parseInt(num);
		int rights= Integer.parseInt(right);
		User user=dao.findId(id);
		System.out.println(id);
		System.out.println(username);
		System.out.println(pwd);
		System.out.println(rights);
		if(user.getId()==0) {dao.add(id, username, pwd, rights);request.setAttribute("res","×¢²á³É¹¦,Çë·µ»ØÇ°ÍùµÇÂ¼");}
		else	request.setAttribute("res","×¢²áÊ§°Ü");
		request.getRequestDispatcher("res.jsp").forward(request, response);  
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
