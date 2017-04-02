package DAO;
import User.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class userDao {
	Connection con;
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/student";
	public userDao(){
		try{	
			Class.forName(driver);
			this.con=DriverManager.getConnection(url,"root","root");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * 添加管理员
	 * id int 编号
	 * name Sting 姓名
	 * pw String 密码
	 * rights int 权限
	 */
	public void add(int id, String name, String pw, int rights){
		String sql="INSERT INTO user VALUES ( ?, ?, ?, ?)";
		try {
			PreparedStatement cmd=this.con.prepareStatement(sql);
			cmd.setInt(1, id);
			cmd.setString(2, name);
			cmd.setString(3, pw);
			cmd.setInt(4, rights);
			cmd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	显示所有学生
	public List<User> view(){
		ArrayList<User> list=new ArrayList<User>();
		String sql="select * from user";
		try{
			Statement cmd=con.createStatement();
			ResultSet res=cmd.executeQuery(sql);
			while(res.next()){
				User student =new User(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4));
				list.add(student);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
//查找姓名
@SuppressWarnings("finally")
public User findId(int id){
		User user = new User();
		try{
			String sql="select * from user where id=?";
			PreparedStatement cmd=con.prepareStatement(sql);
			cmd.setInt(1,id);
			ResultSet result = cmd.executeQuery();
			if(result.next()){
				user.setId(result.getInt(1));
				user.setName(result.getString(2));
				user.setPw(result.getString(3));
				user.setRights(result.getInt(4));
			}
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}finally{
			return user;	
		}
	}
public static void main(String args[]){
	userDao dao=new userDao();
//	dao.add(55,"小佳","456","普通管理员");
	ArrayList<User> user_list=new ArrayList<User>();
	user_list=(ArrayList<User>) dao.view();
	for(User u:user_list){
		System.out.println(u.getId());
		System.out.println(u.getName());
		System.out.println(u.getPw());
		System.out.println(u.getRights());
	}
//	User user=dao.findId(2);
//		System.out.println(user.getId());
//		System.out.println(user.getName());
//		System.out.println(user.getPw());
//		System.out.println(user.getRights());
}
	
}
