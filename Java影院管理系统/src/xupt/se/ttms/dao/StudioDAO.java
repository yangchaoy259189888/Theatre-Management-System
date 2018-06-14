package xupt.se.ttms.dao;

/**
 * 管理演出厅模块-DAO层
 * @author 西邮陈冠希
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xupt.se.ttms.model.Studio;
import xupt.se.util.DBUtil;

public class StudioDAO {
	private DBUtil conn = null;
	
	/**
	 * 添加演出厅
	 * @param studio_name
	 * @param studio_row_count
	 * @param studio_col_count
	 * @param studio_introduction
	 */
	public void addStudio(String studio_name, String studio_row_count, String studio_col_count, String studio_introduction) {
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		
		String sql = "insert into studio(studio_name,studio_row_count,studio_col_count," +
				"studio_introduction) values('" + studio_name + "','" + 
				studio_row_count + "','" + studio_col_count + "','" + studio_introduction + "')";
		
		if(conn.insertTable(sql)) {
			conn.close();
			return;
		}
	}
	
	/**
	 * 修改演出厅
	 * @param studio_name
	 * @param studio_row_count
	 * @param studio_col_count
	 * @param studio_introduction
	 */
	public void modStudio(String studio_name, String studio_row_count, String studio_col_count
			, String studio_introduction) {
		
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		
		String sql = "UPDATE studio SET studio_name = '" + studio_name +
				"', studio_row_count = '" + studio_row_count + "', studio_col_count = '" + 
				studio_col_count + "', studio_introduction = '" + studio_introduction + "'"
				+" WHERE studio_name = " + "'" + studio_name + "'";
		
		if(conn.updateTable(sql)) {
			conn.close();
			return;
		}
	}
	
	/**
	 * 删除演出厅
	 * @param studio_id
	 */
	public void delStudio(String studio_id) {
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		int id = Integer.parseInt(studio_id);
		
		String sql = "DELETE FROM studio WHERE studio_id = " + id;
		
		if(conn.deleteTable(sql)) {
			conn.close();
			return;
		}
	}
	
	/**
	 * 查找-把数据库中匹配的演出厅的数据输出到界面
	 * @param studio_name
	 * @return
	 */
	public List<Studio> prinfStudio(String studio_name) {
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		String sql = "SELECT * FROM studio WHERE studio_name = '" + studio_name + "'";
		
		ResultSet rs = conn.selectTable(sql);
		List<Studio> stuList = new ArrayList<Studio>();
		try {
			while(rs.next()) {
				Studio stu = new Studio();
				stu.setStudio_id(rs.getString(1));
				stu.setStudio_name(rs.getString(2));
				stu.setStudio_row_count(rs.getString(3));
				stu.setStudio_col_count(rs.getString(4));
				stu.setStudio_introduction(rs.getString(5));
				stuList.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stuList;
	}
	
	/**
	 * 把数据库中的演出厅的数据输出到界面
	 * @return
	 */
	public List<Studio> prinfStudios() {
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		String sql = "SELECT * FROM studio";
		List<Studio> stuList = new ArrayList<Studio>();
		
		if (conn.selectTable(sql) != null) {
			ResultSet rs = conn.selectTable(sql);
			try {
				while(rs.next()) {
					Studio stu = new Studio();
					stu.setStudio_id(rs.getString(1));
					stu.setStudio_name(rs.getString(2));
					stu.setStudio_row_count(rs.getString(3));
					stu.setStudio_col_count(rs.getString(4));
					stu.setStudio_introduction(rs.getString(5));
					stuList.add(stu);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("studio表中没有数据");
		}
		conn.close();
		
		return stuList;
	}
}
