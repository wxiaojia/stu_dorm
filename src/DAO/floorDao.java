package DAO;
import User.floor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class floorDao {
	Connection con;
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/student";
	public floorDao(){
		try{	
			Class.forName(driver);
			this.con=DriverManager.getConnection(url,"root","root");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 * ÃÌº”Àﬁ…·¬•
	 * id int ±‡∫≈
	 * num  int Àﬁ…· È
	 * position String Œª÷√
	 */
	public void add(int id, int num,String position){
		String sql="INSERT INTO floor VALUES ( ?, ?, ?)";
		try {
			PreparedStatement cmd=this.con.prepareStatement(sql);
			cmd.setInt(1, id);
			cmd.setInt(2, num);
			cmd.setString(3, position);
			cmd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	œ‘ æÀ˘”–Àﬁ…·¬•
	public List<floor> view(){
		ArrayList<floor> list=new ArrayList<floor>();
		String sql="select * from floor ORDER BY id ASC";
		try{
			Statement cmd=con.createStatement();
			ResultSet res=cmd.executeQuery(sql);
			while(res.next()){
				floor floor =new floor(res.getInt(1), res.getInt(2), res.getString(3));
				list.add(floor);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	/*
	 * …æ≥˝π¶ƒ‹
	 * id int ¬•±‡∫≈
	 */
	public void delete(int id){
		String sql="delete from floor where id = ?";
		try {
			PreparedStatement cmd=this.con.prepareStatement(sql);
			cmd.setInt(1, id);
			cmd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	//≤È’“¬•
	@SuppressWarnings("finally")
	public floor findId(int id){
			floor floor = new floor();
			try{
				String sql="select * from floor where id=?";
				PreparedStatement cmd=con.prepareStatement(sql);
				cmd.setInt(1,id);
				ResultSet result = cmd.executeQuery();
				if(result.next()){
					floor.setId(result.getInt(1));
					floor.setNum(result.getInt(2));
					floor.setPosition(result.getString(3));
				}
			}
			catch(Exception ex){
				System.out.println(ex.toString());
			}finally{
				return floor;	
			}
	}
//	–ﬁ∏ƒÀﬁ…·¬•–≈œ¢
	public void updata(floor fl){
		String sql="update floor set num=" + fl.getNum() + ", position='"+fl.getPosition()+"' where id='" + fl.getId() + "'";
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
//œ‘ æ∑÷“≥
	public List<floor> page(int page){
		int num=15;
		ArrayList<floor> page_list=new ArrayList<floor>();
		String sql="select * from floor order by id ASC limit "+(page-1)*num +","+num;
//		System.out.println(sql);
		try{
			Statement cmd=con.createStatement();
			ResultSet res=cmd.executeQuery(sql);
			while(res.next()){
				floor fl =new floor(res.getInt(1), res.getInt(2), res.getString(3));
				page_list.add(fl);
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		return page_list;
	}
	public static void main(String args[]){
		floorDao dao=new floorDao();
//		ArrayList<floor> user_list=new ArrayList<floor>();
//		floor fl=new floor(2,6,"∞°∞°∞°");
////		dao.add(1,5,"œ¥");		
		dao.add(12,5,"¿≤¿≤¿≤");
		dao.add(13,5,"¿≤¿≤¿≤");
		dao.add(14,5,"¿≤¿≤¿≤");
		dao.add(15,5,"¿≤¿≤¿≤");
		dao.add(16,5,"¿≤¿≤¿≤");
//		user_list=(ArrayList<floor>) dao.view();
//		dao.updata(fl);
//		for(floor u:user_list){
//			System.out.println(u.getId());
//			System.out.println(u.getNum());
//			System.out.println(u.getPosition());
//		}
		floor user=dao.findId(2);
			System.out.println(user.getId());
			System.out.println(user.getNum());
			System.out.println(user.getPosition());

	}
		



}
