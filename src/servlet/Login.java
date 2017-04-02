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
public class Login extends HttpServlet {
	/*登录判断
	 * 1.获取登录输入的内容
	 * 2.到数据库寻找此用户
	 * 3.如果有，密码是否正确
	 * 4.如果没有，跳到“账号不存在”页面 
	 * */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	@SuppressWarnings("unused")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
//======1.获取填入的登录信息
		String id=request.getParameter("id");
		String username=request.getParameter("username");
		String pwd=request.getParameter("password");
		int rights=Integer.parseInt(request.getParameter("right"));
		userDao dao=new userDao();
		int num= Integer.parseInt(id);
//======2.到数据库寻找此用户
		User use=dao.findId(num);
		if(use.getName()==null){
//======4没有此用户
			response.sendRedirect("false.jsp");
		}
		else{
//==========3有此用户
			if(use.getName().equals(username)&&use.getPw().equals(pwd)&&use.getRights()==rights){
//==============密码正确
				request.setAttribute("page",1);
				if(rights==0)	request.getRequestDispatcher("show_floor").forward(request, response);
				else if(rights==1) request.getRequestDispatcher("show_students").forward(request, response);
				else response.sendRedirect("find.jsp");
			}
//==========密码错误
			else response.sendRedirect("false.jsp");;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
