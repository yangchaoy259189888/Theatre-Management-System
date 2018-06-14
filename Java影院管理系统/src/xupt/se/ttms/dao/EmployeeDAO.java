package xupt.se.ttms.dao;

/**
 * 用户管理模块-DAO层
 * @author 西邮陈冠希
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xupt.se.ttms.model.Employee;
import xupt.se.util.DBUtil;

public class EmployeeDAO {
	private DBUtil conn = null;
	
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean loginIn(String userName, String password) {
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		Integer name = Integer.parseInt(userName);
		String sql = "SELECT emp_password FROM employee WHERE emp_id = " + name;
		if (conn.selectTable(sql) == null) {
			return false;
		}
		conn.close();
		
		return true;
	}
	/**
	 * 返回用户的职位信息 “经理”or“售票员”
	 * @param userName
	 * @return
	 */
	public String employeePosition(String userName){
		String position = "";
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		Integer name = Integer.parseInt(userName);
		String sql = "SELECT emp_position FROM employee WHERE emp_id = " + name;
		try {
			//ResultSet 是个结果集。不能直接取记录的信息，比如：rs.getString("name");需要循环历遍的，那怕结果集返回的只有一条记录。
			ResultSet rs = conn.selectTable(sql);
			while (rs.next()) {
				position = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn.close();
		
		return position;
	}
	
	/**
	 * 注册用户，传入用户名，密码，职位
	 * @param userName
	 * @param password
	 * @param position
	 * @return
	 */
	public String employeeRegistered(String userName, String password, String position) {
		String id = "";
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		String sql = "insert into employee(emp_name,emp_password,emp_position) values('" + userName
				+ "','" + password + "','" + position + "')";
		
		if (conn.insertTable(sql)) {
			String emp_id = "SELECT emp_id " + "FROM employee";
			ResultSet rs = conn.selectTable(emp_id);
			try {
				while(rs.next()) {
					id = rs.getString(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return id;
	}
	
	/**
	 * 添加用户，返回一个账号id
	 * @param string_password
	 * @param string_name
	 * @param string_email
	 * @param string_position
	 * @param string_tel
	 * @param string_addr
	 * @param string_age
	 * @param string_sex
	 * @return
	 */
	public String employeeAddUser(String string_password, String string_name, String string_email
			, String string_position, String string_tel, String string_addr, String string_age, String string_sex) {

		String id = "";
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		String sql = "insert into employee(emp_name,emp_password,emp_position,emp_tel_num,emp_addr"
				+ ",emp_email,emp_age,emp_sex) values"
				+ "('" + string_name + "','" 
				+ string_password + "','" 
				+ string_position + "','" 
				+ string_tel + "','" 
				+ string_addr + "','"
				+ string_email + "','"
				+ string_age + "','"
				+ string_sex + "')";
		
		if(conn.insertTable(sql)) {
			String emp_id = "SELECT emp_id " + "FROM employee";
			ResultSet rs = conn.selectTable(emp_id);
			try {
				while(rs.next()) {
					id = rs.getString(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return id;
	}
	
	/**
	 * 修改用户信息
	 * @param string_password
	 * @param string_name
	 * @param string_email
	 * @param string_position
	 * @param string_tel
	 * @param string_addr
	 * @param string_age
	 * @param string_sex
	 * @return
	 */
	public String employeeEditUser(String string_id, String string_password, String string_name, String string_email
			, String string_position, String string_tel, String string_addr, String string_age, String string_sex) {
		String id = "";
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		Integer integer_id = Integer.parseInt(string_id);
		
		String sql = "update employee set emp_name = '" + string_name
				+ "', emp_password = '" + string_password
				+ "', emp_email = '" + string_email
				+ "', emp_position = '" + string_position
				+ "', emp_tel_num = '" + string_tel
				+ "', emp_addr = '" + string_addr
				+ "', emp_age = '" + string_age
				+ "', emp_sex = '" + string_sex
				+ "' where emp_id = " + integer_id;
		
		if(conn.updateTable(sql)) {
			String emp_id = "SELECT emp_id " + "FROM employee where emp_id = " + integer_id;
			ResultSet rs = conn.selectTable(emp_id);
			try {
				while(rs.next()) {
					id = rs.getString(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return id;
	}
	
	/**
	 * 利用除了id以外的其他信息返回id，因为修改用户信息的时候需要用id来定位
	 * @param string_password
	 * @param string_name
	 * @param string_email
	 * @param string_position
	 * @param string_tel
	 * @param string_addr
	 * @param string_age
	 * @param string_sex
	 * @return
	 */
	public String employeeBackId(String string_name) {
		
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		String sql = "select emp_id from employee where emp_name = '" + string_name + "'";
		
		String emp_id = "";
		ResultSet rs = conn.selectTable(sql);
		try {
			if(rs.next()) {
				emp_id = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emp_id;
	}
	
	/**
	 * 把数据库结果集返回的数据用Employee设置，并且存到List集合中
	 * @return
	 */
	public List<Employee> printInfo() {
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		List<Employee> empList = new ArrayList<Employee>();
		String sql = "SELECT * FROM employee";
		
		ResultSet rs = conn.selectTable(sql);
		try {
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmp_No(rs.getString(1));
				emp.setEmp_Name(rs.getString(2));
				emp.setEmp_Password(rs.getString(3));
				emp.setEmp_Position(rs.getString(4));
				emp.setEmp_Tel_Num(rs.getString(5));
				emp.setEmp_Addr(rs.getString(6));
				emp.setEmp_Email(rs.getString(7));
				emp.setEmp_Age(rs.getString(8));
				emp.setEmp_Sex(rs.getString(9));
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return empList;
	}
}
