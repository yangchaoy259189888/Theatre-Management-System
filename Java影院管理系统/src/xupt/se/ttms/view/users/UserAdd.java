package xupt.se.ttms.view.users;

/**
 * 添加用户界面
 * @author 西邮陈冠希
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import xupt.se.ttms.service.EmployeeSrv;
import xupt.se.ttms.view.viewUtil.ChangeBackground;

public class UserAdd {

	public JFrame frame;
	public JLabel lblNewLabel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAdd window = new UserAdd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserAdd() {
		initialize();
		ChangeBackground.addIcon(frame);
		ChangeBackground.changeTopic();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("管理系统用户");
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("管理系统用户");
		label.setBounds(238, 35, 355, 51);
		label.setFont(new Font("隶书", Font.BOLD, 55));
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel("    姓名:");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(408, 169, 95, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("楷体", Font.PLAIN, 20));
		textField_1.setBounds(499, 166, 225, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("    密码:");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(52, 169, 95, 24);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("楷体", Font.PLAIN, 20));
		textField_2.setBounds(149, 168, 225, 30);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("    职位:");
		lblNewLabel_3.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(52, 272, 95, 24);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("楷体", Font.PLAIN, 20));
		textField_3.setBounds(149, 271, 225, 30);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("    电话:");
		lblNewLabel_4.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(52, 326, 95, 24);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("楷体", Font.PLAIN, 20));
		textField_4.setBounds(148, 325, 226, 30);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("家庭住址:");
		lblNewLabel_5.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(52, 379, 95, 24);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("楷体", Font.PLAIN, 20));
		textField_5.setBounds(149, 378, 225, 30);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("    邮箱:");
		lblNewLabel_6.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(52, 223, 95, 24);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("楷体", Font.PLAIN, 20));
		textField_6.setBounds(149, 222, 225, 30);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("    年龄:");
		lblNewLabel_7.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(408, 272, 95, 24);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("楷体", Font.PLAIN, 20));
		textField_7.setBounds(499, 269, 225, 30);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("    性别:");
		lblNewLabel_8.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(408, 228, 95, 24);
		frame.getContentPane().add(lblNewLabel_8);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("男");
		rdbtnNewRadioButton.setFont(new Font("楷体", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBounds(524, 227, 56, 27);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("女");
		rdbtnNewRadioButton_1.setFont(new Font("楷体", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.setBounds(587, 227, 56, 27);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		ButtonGroup  bg=new ButtonGroup();
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton);
		
		JButton btnNewButton_2 = new JButton("保存");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String string_password = textField_2.getText();
				String string_name = textField_1.getText();
				String string_email = textField_6.getText();
				String string_position= textField_3.getText();
				String string_tel = textField_4.getText();
				String string_addr = textField_5.getText();
				String string_age = textField_7.getText();
				String string_sex;
				if(rdbtnNewRadioButton.isSelected()) {
					string_sex = "男";
				} else {
					string_sex = "女";
				}
				
				if(string_password.equals("") || string_name.equals("") || string_email.equals("")
						|| string_position.equals("") || string_tel.equals("") || string_addr.equals("")
						|| string_age.equals("") || string_sex.equals("")) {
					
					JOptionPane.showMessageDialog(frame.getContentPane(),
							"信息不能为空!", "凉凉登录系统信息", JOptionPane.WARNING_MESSAGE);
				} else {
					EmployeeSrv empSrv = new EmployeeSrv();
					String string = empSrv.employeeAddUser(string_password, string_name, string_email, string_position
							, string_tel, string_addr, string_age, string_sex);
					JOptionPane.showMessageDialog(frame.getContentPane(),
							"恭喜您在凉凉剧院注册成功\n"+"您申注册后的账号是：\n\t" + string +
							"\n请牢记，如有遗失请联系超管-杨朝阳：17792035609"
							, "凉凉登录系统信息", JOptionPane.WARNING_MESSAGE);
				}
				
				new Users().frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("楷体", Font.PLAIN, 25));
		btnNewButton_2.setBounds(284, 474, 90, 39);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("取消");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Users().frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_3.setFont(new Font("楷体", Font.PLAIN, 25));
		btnNewButton_3.setBounds(460, 474, 90, 39);
		frame.getContentPane().add(btnNewButton_3);
		
		lblNewLabel = new JLabel("添加");
		lblNewLabel.setFont(new Font("隶书", Font.BOLD, 45));
		lblNewLabel.setBounds(359, 99, 105, 39);
		frame.getContentPane().add(lblNewLabel);
	}
}
