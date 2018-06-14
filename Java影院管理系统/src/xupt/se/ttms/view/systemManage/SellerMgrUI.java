package xupt.se.ttms.view.systemManage;

/**
 * 售票员管理界面
 * @author 西邮陈冠希
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import xupt.se.ttms.view.login.SellerLoginUI;
import xupt.se.ttms.view.schedule.SellerScheduleMgrUI;
import xupt.se.ttms.view.users.AboutUS;
import xupt.se.ttms.view.viewUtil.ChangeBackground;
import xupt.se.ttms.view.viewUtil.Slideshow;

public class SellerMgrUI {

	public JFrame frame;
	public int flag = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellerMgrUI window = new SellerMgrUI();
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
	public SellerMgrUI() {
		initialize();
		ChangeBackground.addIcon(frame);
		ChangeBackground.changeTopic();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("售票员界面");
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("  售票员界面");
		label.setFont(new Font("隶书", Font.BOLD, 70));
		label.setBounds(135, 95, 581, 104);
		frame.getContentPane().add(label);
		
		JButton button_1 = new JButton("海报展示");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Slideshow();
				frame.dispose();
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 25));
		button_1.setBounds(401, 317, 183, 44);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("售票");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_2.setFont(new Font("楷体", Font.PLAIN, 25));
		button_2.setBounds(188, 379, 159, 44);
		frame.getContentPane().add(button_2);
		
		JButton btnNewButton = new JButton("查询演出");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SellerScheduleMgrUI().frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 25));
		btnNewButton.setBounds(188, 317, 159, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton button_3 = new JButton("统计销售额");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setFont(new Font("楷体", Font.PLAIN, 25));
		button_3.setBounds(401, 378, 183, 46);
		frame.getContentPane().add(button_3);
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
				new SellerLoginUI().frame.setVisible(true);
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

