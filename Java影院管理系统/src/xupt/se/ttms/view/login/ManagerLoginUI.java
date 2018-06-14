package xupt.se.ttms.view.login;

/**
 * 经理登录界面
 * @author 西邮陈冠希
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import xupt.se.ttms.service.EmployeeSrv;
import xupt.se.ttms.view.systemManage.ManagerMgrUI;
import xupt.se.ttms.view.viewUtil.ChangeBackground;

public class ManagerLoginUI {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerLoginUI window = new ManagerLoginUI();
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
	public ManagerLoginUI() {
		initialize();
		ChangeBackground.addIcon(frame);
		ChangeBackground.changeTopic();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
			}
		});
		frame.setAlwaysOnTop(true);
		frame.setBounds(0,0, 560, 420);
		frame.setLocationRelativeTo(null);
		frame.setTitle("凉凉剧院管理系统--经理登录");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JLabel lblNewLabel_3 = new JLabel("   经理登录");
		lblNewLabel_3.setFont(new Font("隶书", Font.BOLD, 35));
		lblNewLabel_3.setBounds(146, 105, 296, 44);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("密码:");
		lblNewLabel_1.setBounds(109, 235, 72, 18);
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(168, 232, 274, 28);
		passwordField.setFont(new Font("SimSun 15", Font.PLAIN, 17));
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton_1 = new JButton("登录");
		btnNewButton_1.setBounds(139, 291, 113, 48);
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 25));
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String string_userName = textField.getText();
				@SuppressWarnings("deprecation")
				String string_password = passwordField.getText();
				if (string_password.equals("") || string_userName.equals("")) {
					JOptionPane.showMessageDialog(
							frame.getContentPane(), "密码或账号不能为空!",
							"凉凉登录系统信息", JOptionPane.WARNING_MESSAGE);
				} else {
					EmployeeSrv empSrv = new EmployeeSrv();
					if (empSrv.loginIn(string_userName, string_password)) {
						String position = empSrv.employeePosition(string_userName);
						if (position.equals("经理")) {
							frame.dispose();
							new ManagerMgrUI().frame.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(
									frame.getContentPane(), "您输入的不是经理账号!",
									"凉凉登录系统信息", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(
								frame.getContentPane(), "密码或账号错误，登录失败!",
								"凉凉登录系统信息", JOptionPane.ERROR_MESSAGE);
						System.out.println("登录失败");

					}
				} 
			}
		});
		
		JButton btnNewButton_2 = new JButton("注册");
		btnNewButton_2.setBounds(304, 291, 113, 48);
		btnNewButton_2.setFont(new Font("楷体", Font.BOLD, 25));
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("经理注册按钮已点击");
				new Registered().frame.setVisible(true);
				frame.dispose();
			}
		});
		
		JButton button = new JButton("售票员登录");
		button.setBounds(0, 0, 125, 27);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SellerLoginUI().frame.setVisible(true);
				frame.dispose();
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 17));
		frame.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("经理登录");
		btnNewButton.setBounds(122, 0, 113, 27);
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("凉凉剧院管理系统--经理登录");
				lblNewLabel_3.setText("   经理登录");
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("  凉凉剧院管理系统");
		lblNewLabel_2.setBounds(10, 23, 514, 108);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("隶书", Font.BOLD, 50));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("账号:");
		lblNewLabel.setBounds(109, 174, 72, 18);
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(168, 171, 274, 28);
		textField.setFont(new Font("楷体", Font.PLAIN, 20));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}

