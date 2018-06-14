package xupt.se.ttms.view.systemManage;

/**
 * 经理管理界面
 * @author 西邮陈冠希
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import xupt.se.ttms.view.login.ManagerLoginUI;
import xupt.se.ttms.view.play.PlayMgrUI;
import xupt.se.ttms.view.schedule.ScheduleMgrUI;
import xupt.se.ttms.view.stdioManage.StudioMgrUI;
import xupt.se.ttms.view.users.AboutUS;
import xupt.se.ttms.view.users.Users;
import xupt.se.ttms.view.viewUtil.ChangeBackground;

public class ManagerMgrUI {

	public JFrame frame;
	public int flag = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMgrUI window = new ManagerMgrUI();
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
	public ManagerMgrUI() {
		initialize();
		ChangeBackground.addIcon(frame);
		ChangeBackground.changeTopic();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("经理界面");
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("   经理界面");
		label.setFont(new Font("隶书", Font.BOLD, 70));
		label.setBounds(135, 95, 581, 104);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("管理剧目");
		button.setFont(new Font("楷体", Font.PLAIN, 25));
		button.setBounds(188, 261, 159, 44);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PlayMgrUI().frame.setVisible(true);
				frame.dispose();
			}
		});
		
		JButton button_1 = new JButton("查询演出计划");
		button_1.setFont(new Font("楷体", Font.PLAIN, 23));
		button_1.setBounds(401, 261, 183, 44);
		frame.getContentPane().add(button_1);
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ScheduleMgrUI().frame.setVisible(true);
				frame.dispose();
			}
		});
		
		JButton button_2 = new JButton("安排演出");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_2.setFont(new Font("楷体", Font.PLAIN, 25));
		button_2.setBounds(188, 318, 159, 44);
		frame.getContentPane().add(button_2);
		
		JButton btnNewButton = new JButton("查询演出");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 25));
		btnNewButton.setBounds(188, 375, 159, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton button_3 = new JButton("管理演出厅");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudioMgrUI().frame.setVisible(true);
				frame.dispose();
			}
		});
		button_3.setFont(new Font("楷体", Font.PLAIN, 25));
		button_3.setBounds(401, 316, 183, 44);
		frame.getContentPane().add(button_3);
		
		JButton btnNewButton_1 = new JButton("管理系统用户");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Users().frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 24));
		btnNewButton_1.setBounds(401, 375, 183, 44);
		frame.getContentPane().add(btnNewButton_1);
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton button_back = new JButton("返回");
		button_back.setFont(new Font("楷体", Font.PLAIN, 25));
		button_back.setBounds(650, 480, 100, 50);
		frame.getContentPane().add(button_back);
		button_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ManagerLoginUI().frame.setVisible(true);
				frame.dispose();
			}
		});
		
		JButton btnNewButton_about = new JButton("关于我们");
		btnNewButton_about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_about.setFont(new Font("楷体", Font.PLAIN, 24));
		btnNewButton_about.setBounds(295, 450, 160, 44);
		frame.getContentPane().add(btnNewButton_about);
		btnNewButton_about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AboutUS(flag).frame.setVisible(true);
				frame.dispose();
			}
		});
	}
}
