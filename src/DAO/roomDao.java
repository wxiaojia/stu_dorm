package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import User.room;

public class roomDao {
	Connection con;
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/student";
	public roomDao(){
		try{	
			Class.forName(driver);
			this.con=DriverManager.getConnection(url,"root","root");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//添加宿舍房
	public void add(int id,int floor,int bed,int price,int people,int floor_id){
		String sql="INSERT INTO accommodation VALUES ( ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement cmd=this.con.prepareStatement(sql);
			cmd.setInt(1, id);
			cmd.setInt(2, floor);
			cmd.setInt(3, bed);
			cmd.setInt(4, price);
			cmd.setInt(5, people);
			cmd.setInt(6, floor_id);
			cmd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	显示所有房间
	public List<room> view(){
		ArrayList<room> list=new ArrayList<room>();
		String sql="select * from accommodation order by id ASC";
		try{
			Statement cmd=con.createStatement();
			ResultSet res=cmd.executeQuery(sql);
			while(res.next()){
				room room =new room(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4),res.getInt(5),res.getInt(6));
				list.add(room);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
//查找某栋的所有房间
	@SuppressWarnings("finally")
	public List<room> findId(int id){
//		room rooms= new room();
		ArrayList<room> list=new ArrayList<room>();
		try{
			String sql="select * from accommodation where floor_id=? ORDER BY id ASC";
			PreparedStatement cmd=con.prepareStatement(sql);
			cmd.setInt(1,id);
			ResultSet result = cmd.executeQuery();
			while(result.next()){
				room ro=new room(result.getInt(1),result.getInt(2),result.getInt(3),result.getInt(4),result.getInt(5),result.getInt(6));
				list.add(ro);
			}
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}finally{
			return list;	
		}
}
//查找某栋的某间房间
		@SuppressWarnings("finally")
		public room findroom(int id){
			room rooms= new room();
//			ArrayList<room> list=new ArrayList<room>();
			try{
				String sql="select * from accommodation where id=?";
				PreparedStatement cmd=con.prepareStatement(sql);
				cmd.setInt(1,id);
				ResultSet res= cmd.executeQuery();
				if(res.next()){
					rooms.setId(res.getInt(1));
					rooms.setFloor(res.getInt(2));
					rooms.setBed(res.getInt(3));
					rooms.setPrice(res.getInt(4));
					rooms.setPeople(res.getInt(5));
					rooms.setFloor_id(res.getInt(6));
				}
			}
			catch(Exception ex){
				System.out.println(ex.toString());
			}finally{
				return rooms;	
			}
	}
	//	修改宿舍信息
		public void updata(room ro){
			String sql="update accommodation set floor=" + ro.getFloor() + ", bed='"+ro.getBed()+"', price='"+ro.getPrice()+"',people='"+ro.getBed()+"' where id='" + ro.getId() + "'";
//			String sql="UPDATE floor SET num=?,position=? WHERE id = ?";
			try{
				PreparedStatement cmd=this.con.prepareStatement(sql);
//				cmd.setInt(1, ro.getId());
//				cmd.setInt(2, ro.floor);
//				cmd.setInt(3, bed);
//				cmd.setInt(4, price);
//				cmd.setInt(5, people);
//				cmd.setInt(6, floor_id);
				cmd.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		/* 删除功能*/
		public void delete(int id){
			String sql="delete from accommodation where id = ?";
			try {
				PreparedStatement cmd=this.con.prepareStatement(sql);
				cmd.setInt(1, id);
				cmd.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		//显示分页
		public List<room> page(int page){
			int num=15;
			ArrayList<room> page_list=new ArrayList<room>();
			String sql="select * from accommodation order by id ASC limit "+(page-1)*num +","+num;
//			System.out.println(sql);
			try{
				Statement cmd=con.createStatement();
				ResultSet res=cmd.executeQuery(sql);
				while(res.next()){
					room fl =new room(res.getInt(1), res.getInt(2), res.getInt(3),res.getInt(4),res.getInt(5),res.getInt(6));
					page_list.add(fl);
					}
			}catch(Exception e){
				e.printStackTrace();
			}
			return page_list;
		}
	public static void main(String args[]){
		roomDao dao=new roomDao();
//		room room=new room(1,1,4,1700,4,3);
//		dao.updata(room);
		dao.add(6,2,3,67,8,9);
//		dao.findId(8);
		
		ArrayList<room> user_list=new ArrayList<room>();
		user_list=(ArrayList<room>) dao.page(1);
//		ro=dao.findroom(3, 1);
		for(room u:user_list){
			System.out.println(u.getId()+"\t"+u.getFloor()+"\t"+u.getBed()+"\t"+u.getPrice()+"\t"+u.getPeople()+"\t"+u.getFloor_id());
//			System.out.println("+");
		}
//		room ro=dao.findroom(01);
//			System.out.println(ro.getId());
//			System.out.println(ro.getFloor());
//			System.out.println(ro.getBed());
//			System.out.println(ro.getPrice());
//			System.out.println(ro.getFloor_id());
	}

//查找姓名
//@SuppressWarnings("finally")
//public User findId(int id){
//		User user = new User();
//		try{
//			String sql="select * from user where id=?";
//			PreparedStatement cmd=con.prepareStatement(sql);
//			cmd.setInt(1,id);
//			ResultSet result = cmd.executeQuery();
//			if(result.next()){
//				user.setId(result.getInt(1));
//				user.setName(result.getString(2));
//				user.setPw(result.getString(3));
//				user.setRights(result.getInt(4));
//			}
//		}
//		catch(Exception ex){
//			System.out.println(ex.toString());
//		}finally{
//			return user;	
//		}
//	}

}
