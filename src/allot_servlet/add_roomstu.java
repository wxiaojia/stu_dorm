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
import User.students;

@SuppressWarnings("serial")
public class add_roomstu extends HttpServlet {

	/**
	 * ��ӵ�ѧ��
	 * ��ȡ����ţ������Ƿ�������
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	@SuppressWarnings("unused")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int room_id = Integer.parseInt(request.getParameter("room_id"));
		int stuid = Integer.parseInt(request.getParameter("stuid"));
		
		allotDao dao=new allotDao();
		int i=dao.findstu(stuid);//��ѯѧ���Ƿ񱻷�������
		//System.out.println(i);
		allot al=new allot();
		al=dao.findroom(room_id);
		//���������䣬Ѱ�Ҹ÷�����ĸ�ѧ��λ�Ƿ�λ��
		int flag=1;
		studentsDao s=new studentsDao();
		students r=s.findId(stuid);
		if(i!=0){
			request.setAttribute("res", "��ѧ���Ѿ�������");
			flag=0;
		}else if(r.getId()==0){
			request.setAttribute("res", "�����ڸ�ѧ����");
			flag=0;
		}
		else{
			if(al.getIda()==0) dao.add_ida(room_id,stuid);
			else if(al.getIdb()==0) dao.add_idb(room_id, stuid);
			else if(al.getIdc()==0) dao.add_idc(room_id,stuid);
			else if(al.getIdd()==0) dao.add_idd(room_id, stuid);
			else {request.setAttribute("res", "��������������");flag=0;}
		}
		
		if(flag==0) request.getRequestDispatcher("res.jsp").forward(request, response);
		else request.getRequestDispatcher("room_people").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}
}
