package xupt.se.ttms.service;

/**
 * 用户管理模块-service层
 * @author 西邮陈冠希
 */

import java.util.List;

import xupt.se.ttms.dao.EmployeeDAO;
import xupt.se.ttms.model.Employee;

public class EmployeeSrv {
	EmployeeDAO empDAO = new EmployeeDAO();
	
	public boolean loginIn(String userName, String password) {
		return empDAO.loginIn(userName, password);
	}
	
	public String employeePosition(String userName) {
		return empDAO.employeePosition(userName);
	}
	
	public String employeeRegistered(String userName, String password, String position) {
		return empDAO.employeeRegistered(userName, password, position);
	}
	
	public String employeeAddUser(String string_password, String string_name, String string_email
			, String string_position, String string_tel, String string_addr, String string_age, String string_sex) {

		return empDAO.employeeAddUser(string_password, string_name, string_email
				, string_position, string_tel, string_addr, string_age, string_sex);
	}
	
	public String employeeEditUser(String string_id, String string_password, String string_name, String string_email
			, String string_position, String string_tel, String string_addr, String string_age, String string_sex) {
		
		return empDAO.employeeEditUser(string_id, string_password, string_name, string_email
				, string_position, string_tel, string_addr, string_age, string_sex);
	}
	
	public String employeeBackId(String string_name) {
		return empDAO.employeeBackId(string_name);
	}
	
	public List<Employee> printInfo() {
		return empDAO.printInfo();
	}
}
