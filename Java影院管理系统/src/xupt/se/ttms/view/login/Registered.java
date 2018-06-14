package xupt.se.ttms.view.login;

/**
 * 注册界面
 * @author 西邮陈冠希
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import xupt.se.ttms.service.EmployeeSrv;
import xupt.se.ttms.view.viewUtil.ChangeBackground;

public class Registered {

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
					Registered window = new Registered();
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
	public Registered() {
		initialize();
		ChangeBackground.changeTopic();
		ChangeBackground.addIcon(frame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("凉凉剧院管理系统--注册界面");
		frame.setBounds(100, 100, 900, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("凉凉剧院注册");
		label.setFont(new Font("隶书", Font.BOLD, 55));
		label.setBounds(286, 78, 353, 74);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("用户名:");
		label_1.setFont(new Font("楷体", Font.PLAIN, 25));
		label_1.setBounds(240, 224, 101, 30);
		frame.getContentPane().add(label_1);
		
		JLabel lblNewLabel = new JLabel("密码:");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 25));
		lblNewLabel.setBounds(263, 291, 63, 31);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("楷体", Font.PLAIN, 20));
		textField.setBounds(333, 224, 306, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("SimSun 15", Font.PLAIN, 17));
		passwordField.setBounds(333, 291, 306, 31);
		frame.getContentPane().add(passwordField);
		
		JLabel label_2 = new JLabel("\u804C\u4F4D");
		label_2.setFont(new Font("楷体", Font.PLAIN, 25));
		label_2.setBounds(353, 358, 57, 31);
		frame.getContentPane().add(label_2);
		
		final JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"经理", "售票员"}));
		comboBox.setFont(new Font("楷体", Font.PLAIN, 20));
		comboBox.setBounds(410, 360, 94, 31);
		frame.getContentPane().add(comboBox);
		
		JButton button = new JButton("注册");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String string_userName = textField.getText();
				@SuppressWarnings("deprecation")
				String string_password = passwordField.getText();
				String string_position = "";
				
				if (string_userName.equals("")) {
					JOptionPane.showMessageDialog(frame.getContentPane(),
							"姓名不能为空!", "凉凉登录系统信息", JOptionPane.WARNING_MESSAGE);
				} else if (string_password.equals("")) {
					JOptionPane.showMessageDialog(frame.getContentPane(),
							"密码不能为空!", "凉凉登录系统信息", JOptionPane.WARNING_MESSAGE);
				} else {
					EmployeeSrv empSrv = new EmployeeSrv();
					if(comboBox.getSelectedIndex() == 0) {
						string_position = "经理";
					} else {
						string_position = "售票员";
					}
					String string = empSrv.employeeRegistered(string_userName,
							string_password, string_position);
					JOptionPane.showMessageDialog(frame.getContentPane(),
							"恭喜您在凉凉剧院注册成功\n"+"您申注册后的账号是：\n\t" + "0" + string +
							"\n请牢记，如有遗失请联系杨朝阳：17792035609"
							, "凉凉登录系统信息", JOptionPane.WARNING_MESSAGE);
					if(comboBox.getSelectedIndex() == 0) {
						new ManagerLoginUI().frame.setVisible(true);
					} else {
						new SellerLoginUI().frame.setVisible(true);
					}
					frame.dispose();
				}
			}
		});
		
		button.setFont(new Font("楷体", Font.PLAIN, 25));
		button.setBounds(320, 451, 114, 39);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0) {
					new ManagerLoginUI().frame.setVisible(true);
				} else {
					new SellerLoginUI().frame.setVisible(true);
				}
				frame.dispose();
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 25));
		button_1.setBounds(489, 451, 114, 39);
		frame.getContentPane().add(button_1);
	}
}
