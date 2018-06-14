package xupt.se.ttms.view.login;

/**
 * 售票员登录界面
 * @author 西邮陈冠希
 *
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
import xupt.se.ttms.view.systemManage.SellerMgrUI;
import xupt.se.ttms.view.viewUtil.ChangeBackground;

public class SellerLoginUI {

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
					SellerLoginUI window = new SellerLoginUI();
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
	public SellerLoginUI() {
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
		frame.setTitle("凉凉剧院管理系统--售票员登录");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("  售票员登录");
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
						if (position.equals("售票员")) {
							frame.dispose();
							new SellerMgrUI().frame.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(
									frame.getContentPane(), "您输入的不是售票员账号!",
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
				new Registered().frame.setVisible(true);
				frame.dispose();
			}
		});
		
		JButton button = new JButton("售票员登录");
		button.setBounds(0, 0, 125, 27);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("凉凉剧院管理系统--售票员登录");
				lblNewLabel_3.setText("  售票员登录");
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 17));
		frame.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("经理登录");
		btnNewButton.setBounds(122, 0, 113, 27);
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerLoginUI().frame.setVisible(true);;
				frame.dispose();
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
