package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import User.students;

public class studentsDao {
	Connection con;
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/student";
	public studentsDao(){
		try{	
			Class.forName(driver);
			this.con=DriverManager.getConnection(url,"root","root");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * 添加学生
	 */
	public void add(int id, String name,int age, int sex, int phone, int grade, String sub){
		String sql="INSERT INTO students VALUES ( ?, ?, ?, ?,?,?,?)";
		try {
			PreparedStatement cmd=this.con.prepareStatement(sql);
			cmd.setInt(1, id);
			cmd.setString(2, name);
			cmd.setInt(3, age);
			cmd.setInt(4, sex);
			cmd.setInt(5, phone);
			cmd.setInt(6, grade);
			cmd.setString(7, sub);
			cmd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*删除功能*/
	public void delete(int id){
		String sql="delete from students where id = ?";
		try {
			PreparedStatement cmd=this.con.prepareStatement(sql);
			cmd.setInt(1, id);
			cmd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
//	修改学生信息
	public void updata(students st){
		String sql="update students set name='" + st.getName() + "', age='"+st.getAge()+"',sex="+st.getSex()+",phone="+st.getPhone()+",grade="+st.getGrade()+",sub='"+st.getSub()+"' where id='" + st.getId() + "'";
//		String sql="UPDATE floor SET num=?,position=? WHERE id = ?";
		try{
			PreparedStatement cmd=this.con.prepareStatement(sql);
//			cmd.setInt(1, fl.getId());
//			cmd.setInt(2, fl.getNum());
//			cmd.setString(3, fl.getPosition());
			cmd.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
//	显示所有学生
	public List<students> view(){
		ArrayList<students> list=new ArrayList<students>();
		String sql="select * from students";
		try{
			Statement cmd=con.createStatement();
			ResultSet res=cmd.executeQuery(sql);
			while(res.next()){
				students student =new students(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4),res.getInt(5),res.getInt(6),res.getString(7));
				list.add(student);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
//查找
@SuppressWarnings("finally")
public students findId(int id){
	students student = new students();
		try{
			String sql="select * from students where id=?";
			PreparedStatement cmd=con.prepareStatement(sql);
			cmd.setInt(1,id);
			ResultSet result = cmd.executeQuery();
			if(result.next()){
				student.setId(result.getInt(1));
				student.setName(result.getString(2));
				student.setAge(result.getInt(3));
				student.setSex(result.getInt(4));
				student.setPhone(result.getInt(5));
				student.setGrade(result.getInt(6));
				student.setSub(result.getString(7));
			}
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}finally{
			return student;	
		}
	}
//显示分页
	public List<students> page(int page){
		int num=15;
		ArrayList<students> page_list=new ArrayList<students>();
		String sql="select * from students order by id ASC limit "+(page-1)*num +","+num;
//		System.out.println(sql);
		try{
			Statement cmd=con.createStatement();
			ResultSet res=cmd.executeQuery(sql);
			while(res.next()){
				students fl =new students(res.getInt(1), res.getString(2),res.getInt(3), res.getInt(4),res.getInt(5),res.getInt(6),res.getString(7));
				page_list.add(fl);
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		return page_list;
	}
public static void main(String args[]){
	studentsDao dao=new studentsDao();
//	dao.add(7,"小家",20,0,123,2,"计算机",22);
//	ArrayList<students> user_list=new ArrayList<students>();
//	user_list=(ArrayList<students>) dao.view();
//	for(students u:user_list){
//		System.out.println(u.getId());
//		System.out.println(u.getName());
//		System.out.println(u.getAge());
//		System.out.println(u.getSex());
//		System.out.println(u.getPhone());
//		System.out.println(u.getGrade());
//		System.out.println(u.getSub());
//	}
	students user=dao.findId(2);
		System.out.println(user.getId());
		System.out.println(user.getName());
//		System.out.println(user.getPw());
//		System.out.println(user.getRights());
}
	
}
