package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import User.allot;

public class allotDao {
	Connection con;
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/student";
	public allotDao(){
		try{	
			Class.forName(driver);
			this.con=DriverManager.getConnection(url,"root","root");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void add(int room){
		String sql="INSERT INTO allot(room) VALUES ( ?)";
		try {
			PreparedStatement cmd=this.con.prepareStatement(sql);
			cmd.setInt(1, room);
			cmd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void add_ida(int room,int ida){
		String sql="update allot set ida=" + ida + " where room='" + room + "'";
		try {
			PreparedStatement cmd=this.con.prepareStatement(sql);
			cmd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void add_idb(int room,int idb){
		String sql="update allot set idb=" + idb + " where room='" + room + "'";
		try {
			PreparedStatement cmd=this.con.prepareStatement(sql);
			cmd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void add_idc(int room,int idc){
		String sql="update allot set idc=" + idc + " where room='" + room + "'";
		try {
			PreparedStatement cmd=this.con.prepareStatement(sql);
			cmd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void add_idd(int room,int idd){
		String sql="update allot set idd=" + idd + " where room='" + room + "'";
		try {
			PreparedStatement cmd=this.con.prepareStatement(sql);
			cmd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	显示
	public List<allot> view(int room){
		ArrayList<allot> list=new ArrayList<allot>();
		String sql="select * from allot where room='"+room+"'";
		try{
			PreparedStatement cmd=this.con.prepareStatement(sql);
			ResultSet res=cmd.executeQuery(sql);
			while(res.next()){
				allot allot =new allot(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4),res.getInt(5));
				list.add(allot);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	//查找某房间的所有
	@SuppressWarnings("finally")
	public allot findroom(int room){
		allot allot= new allot();
		try{
			String sql="select * from allot where room=?";
			PreparedStatement cmd=con.prepareStatement(sql);
			cmd.setInt(1,room);
			ResultSet res= cmd.executeQuery();
			if(res.next()){
				allot.setRoom(res.getInt(1));
				allot.setIda(res.getInt(2));
				allot.setIdb(res.getInt(3));
				allot.setIdc(res.getInt(4));
				allot.setIdd(res.getInt(5));
			}
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}finally{
			return allot;	
		}
	}
	public int findstu(int id){
		int room_id=0;
		try{
			String sql="select room from allot where ida="+id+" or idb="+id+" or idc="+id+" or idd="+id;
			PreparedStatement cmd=con.prepareStatement(sql);
			ResultSet res=cmd.executeQuery(sql);
			res.next();
			room_id=res.getInt(1);
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
		return room_id;
	}
	public static void main(String args[]){
		allotDao dao=new allotDao();
		ArrayList<allot> user_list=new ArrayList<allot>();
//		floor fl=new floor(2,6,"啊啊啊");
//		dao.add(25,1);
//		dao.add_idb(25,3);
//		dao.add_idc(25,7);
//		dao.add_idd(25,9);
		user_list=(ArrayList<allot>) dao.view(25);
//		dao.updata(fl);
		for(allot u:user_list){
			System.out.println(u.getRoom());
			System.out.println(u.getIda());
			System.out.println(u.getIdb());
			System.out.println(u.getIdc());
			System.out.println(u.getIdd());
		}
//		allot user=dao.findroom(2);
//			System.out.println(user.getRoom());
//			System.out.println(user.getIda());
//			System.out.println(user.getIdb());
//		int i=0;
//		System.out.println(dao.findstu(1));
	}
}
