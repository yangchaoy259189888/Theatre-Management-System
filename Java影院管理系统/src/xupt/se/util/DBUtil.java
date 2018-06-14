package xupt.se.util;

/**
 * 数据库连接，关闭，插入，修改，删除操作
 * @author 西邮陈冠希
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties; 

public class DBUtil {
	private final String dbConnFile = "resource/database/jdbc.properties";
	private Connection conn = null;
	private String dbDriver;	//定义驱动  
    private String dbURL;		//定义URL  
    private String userName;	//定义用户名  
    private String password;	//定义密码	
	public PreparedStatement statement = null; // 执行
    
    //从配置文件取数据库链接参数  
    private void loadConnProperties(){  
        Properties props = new Properties();  
        try {  
            props.load(new FileInputStream(dbConnFile));//根据配置文件路径加载配置文件  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        this.dbDriver = props.getProperty("driver");//从配置文件中取得相应的参数并设置类变量  
        this.dbURL = props.getProperty("url");  
        this.userName = props.getProperty("username");  
        this.password = props.getProperty("password");  
     
    }
    
	public boolean openConnection(){
		try {  
			loadConnProperties();
            Class.forName(dbDriver);  
            this.conn = DriverManager.getConnection(dbURL,userName,password);
            return true;
        } catch(ClassNotFoundException classnotfoundexception) {  
              classnotfoundexception.printStackTrace();  
            System.err.println("db: " + classnotfoundexception.getMessage());  
        } catch(SQLException sqlexception) {  
            System.err.println("db.getconn(): " + sqlexception.getMessage());  
        }
		return	false;
	}
	
	//数据库查找
	public ResultSet selectTable(String sql){
		ResultSet resultSet = null;
		try {
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
		} catch (Exception e) {
			System.out.println("查询数据库表时出错");
			e.printStackTrace();
		}
		
		return resultSet;
	}
	
	//数据库对表的插入
	public boolean insertTable(String sql) {
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("数据库插入表元素时出错");
			e.printStackTrace();
		}

		return false;
	}
	
	//数据库对表的删除
	public boolean deleteTable(String sql){
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("数据库删除表元素时出错");
			e.printStackTrace();
		}
		
		return false;
	}
	
	//数据库中对表的修改
	public boolean updateTable(String sql){
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("数据库修改表元素时出错");
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void close() {
		try {
			this.conn.close();
			this.statement.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库关闭出错");
		}
	}
}
