package xupt.se.ttms.dao;

/**
 * 剧目管理模块-DAO层
 * @author 西邮陈冠希
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xupt.se.ttms.model.Play;
import xupt.se.util.DBUtil;

public class PlayDAO {
	private DBUtil conn = null;
	
	/**
	 * 输出数据库的信息到界面
	 * @return
	 */
	public List<Play> prinfPlays() {
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		String sql = "select * from play";
		List<Play> plList = new ArrayList<Play>();
		
		ResultSet rs = conn.selectTable(sql);
		try {
			while(rs.next()) {
				Play pl = new Play();
				pl.setPlay_id(rs.getString(1));
				pl.setPlay_type(rs.getString(2));
				pl.setPlay_lang(rs.getString(3));
				pl.setPlay_name(rs.getString(4));
				pl.setPlay_introduction(rs.getString(5));
				pl.setPlay_length(rs.getString(6));
				pl.setPlay_price(rs.getString(7));
				plList.add(pl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plList;
	}
	
	/**
	 * 输出查找到的一个信息
	 * @param string_play_name
	 * @return
	 */
	public List<Play> prinfPlay(String string_play_name) {
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		String sql = "select * from play where play_name = '" + string_play_name + "'";
		List<Play> plList = new ArrayList<Play>();
		
		ResultSet rs = conn.selectTable(sql);
		try {
			while(rs.next()) {
				Play pl = new Play();
				pl.setPlay_id(rs.getString(1));
				pl.setPlay_type(rs.getString(2));
				pl.setPlay_lang(rs.getString(3));
				pl.setPlay_name(rs.getString(4));
				pl.setPlay_introduction(rs.getString(5));
				pl.setPlay_length(rs.getString(6));
				pl.setPlay_price(rs.getString(7));
				plList.add(pl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return plList;
	}
	
	/**
	 * 添加剧目
	 */
	public void addPlay(String play_type, String play_lang, String play_name, String play_introduction
			, String play_length, String play_price) {
		
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		
		String sql = "insert into play(play_type,play_lang,play_name," +
				"play_introduction,play_length,play_ticket_price) values('" 
				+ play_type + "','" 
				+ play_lang + "','" 
				+ play_name + "','" 
				+ play_introduction + "','" 
				+ play_length + "','"
				+ play_price + "')";
		
		if(conn.insertTable(sql)) {
			conn.close();
			return;
		}
	}
	
	/**
	 * 修改剧目
	 * @param play_type
	 * @param play_lang
	 * @param play_name
	 * @param play_introduction
	 * @param play_length
	 * @param play_price
	 */
	public void modPlay(String play_type, String play_lang, String play_name, String play_introduction
			, String play_length, String play_price) {
		
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		
		String sql = "update play set play_type = '"
				+ play_type + "',play_lang = '"
				+ play_lang + "',play_name = '"
				+ play_name + "',play_introduction = '"
				+ play_introduction + "',play_length = '"
				+ play_length + "',play_ticket_price = '"
				+ play_price + "' "
				+ "where play_name = '" + play_name + "'";

		if(conn.updateTable(sql)) {
			conn.close();
			return;
		}
	}
	
	public void delPlay(String play_id) {
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		
		int id = Integer.parseInt(play_id);
		
		String sql = "delete from play where play_id = " + id;
		
		if(conn.deleteTable(sql)) {
			conn.close();
			return;
		}
	}
}
