package xupt.se.ttms.model;

/**
 * 用户管理模块-model数据层
 * @author 西邮陈冠希
 *
 */

public class Employee {
	private String emp_No = null;			//工号
	private String emp_Name = null;			//姓名
	private String emp_Password = null;		//密码
	private String emp_Position = null;		//职位
	private String emp_Tel_Num = null;		//电话
	private String emp_Addr = null;			//住址
	private String emp_Email = null;		//邮箱
	private String emp_Age = null;			//年龄
	private String emp_Sex = null;			//性别
	
	public String getEmp_No() {
		return emp_No;
	}
	
	public void setEmp_No(String emp_No) {
		this.emp_No = emp_No;
	}
	
	public String getEmp_Name() {
		return emp_Name;
	}
	
	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}
	
	public String getEmp_Password() {
		return emp_Password;
	}
	
	public void setEmp_Password(String emp_Password) {
		this.emp_Password = emp_Password;
	}
	
	public String getEmp_Position() {
		return emp_Position;
	}
	
	public void setEmp_Position(String emp_Position) {
		this.emp_Position = emp_Position;
	}
	
	public String getEmp_Tel_Num() {
		return emp_Tel_Num;
	}
	
	public void setEmp_Tel_Num(String emp_Tel_Num) {
		this.emp_Tel_Num = emp_Tel_Num;
	}
	
	public String getEmp_Addr() {
		return emp_Addr;
	}
	
	public void setEmp_Addr(String emp_Addr) {
		this.emp_Addr = emp_Addr;
	}
	
	public String getEmp_Email() {
		return emp_Email;
	}
	
	public void setEmp_Email(String emp_Email) {
		this.emp_Email = emp_Email;
	}
	
	public String getEmp_Age() {
		return emp_Age;
	}
	
	public void setEmp_Age(String emp_Age) {
		this.emp_Age = emp_Age;
	}
	
	public String getEmp_Sex() {
		return emp_Sex;
	}
	
	public void setEmp_Sex(String emp_Sex) {
		this.emp_Sex = emp_Sex;
	}

	@Override
	public String toString() {
		return "Employee [emp_No=" + emp_No + ", emp_Name=" + emp_Name + ", emp_Password=" + emp_Password
				+ ", emp_Position=" + emp_Position + ", emp_Tel_Num=" + emp_Tel_Num + ", emp_Addr=" + emp_Addr
				+ ", emp_Email=" + emp_Email + ", emp_Age=" + emp_Age + ", emp_Sex=" + emp_Sex + "]";
	}
	
	
}
