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
	/*��¼�ж�
	 * 1.��ȡ��¼���������
	 * 2.�����ݿ�Ѱ�Ҵ��û�
	 * 3.����У������Ƿ���ȷ
	 * 4.���û�У��������˺Ų����ڡ�ҳ�� 
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
//======1.��ȡ����ĵ�¼��Ϣ
		String id=request.getParameter("id");
		String username=request.getParameter("username");
		String pwd=request.getParameter("password");
		int rights=Integer.parseInt(request.getParameter("right"));
		userDao dao=new userDao();
		int num= Integer.parseInt(id);
//======2.�����ݿ�Ѱ�Ҵ��û�
		User use=dao.findId(num);
		if(use.getName()==null){
//======4û�д��û�
			response.sendRedirect("false.jsp");
		}
		else{
//==========3�д��û�
			if(use.getName().equals(username)&&use.getPw().equals(pwd)&&use.getRights()==rights){
//==============������ȷ
				request.setAttribute("page",1);
				if(rights==0)	request.getRequestDispatcher("show_floor").forward(request, response);
				else if(rights==1) request.getRequestDispatcher("show_students").forward(request, response);
				else response.sendRedirect("find.jsp");
			}
//==========�������
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
