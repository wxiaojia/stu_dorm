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
	 * 添加的学号
	 * 获取宿舍号，查找是否有宿舍
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
		int i=dao.findstu(stuid);//查询学生是否被分配宿舍
		//System.out.println(i);
		allot al=new allot();
		al=dao.findroom(room_id);
		//分配至房间，寻找该房间的四个学生位是否位空
		int flag=1;
		studentsDao s=new studentsDao();
		students r=s.findId(stuid);
		if(i!=0){
			request.setAttribute("res", "该学生已经被分配");
			flag=0;
		}else if(r.getId()==0){
			request.setAttribute("res", "不存在该学生！");
			flag=0;
		}
		else{
			if(al.getIda()==0) dao.add_ida(room_id,stuid);
			else if(al.getIdb()==0) dao.add_idb(room_id, stuid);
			else if(al.getIdc()==0) dao.add_idc(room_id,stuid);
			else if(al.getIdd()==0) dao.add_idd(room_id, stuid);
			else {request.setAttribute("res", "该宿舍人数已满");flag=0;}
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
