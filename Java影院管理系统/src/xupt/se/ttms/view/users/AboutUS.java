package xupt.se.ttms.view.users;

/**
 * 关于我们-界面
 * @author 西邮陈冠希
 */

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import xupt.se.ttms.view.systemManage.ManagerMgrUI;
import xupt.se.ttms.view.systemManage.SellerMgrUI;
import xupt.se.ttms.view.viewUtil.ChangeBackground;

public class AboutUS {

	public JFrame frame;

	/**
	 * Create the application.
	 */
	public AboutUS(int flag) {
		initialize(flag);
		ChangeBackground.addIcon(frame);
		ChangeBackground.changeTopic();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int flag) {
		frame = new JFrame("关于我们");
		frame.setBounds(100, 100, 600, 346);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("关于我们");
		lblNewLabel.setBounds(192, 26, 227, 42);
		lblNewLabel.setFont(new Font("隶书", Font.PLAIN, 55));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("    凉凉剧院管理系统是由西安邮电大学计算机学院软件");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(14, 84, 554, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("1605杨朝阳，李杰，王栋，张梓卓，迪丽胡玛尔·吾许尔");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(14, 117, 554, 35);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("共同开发完成。");
		lblNewLabel_3.setBounds(14, 145, 554, 35);
		lblNewLabel_3.setFont(new Font("楷体", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("详情可致电杨朝阳tel：17792035609");
		lblNewLabel_4.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(14, 183, 554, 35);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag == 1) {
					new ManagerMgrUI().frame.setVisible(true);
				} else {
					new SellerMgrUI().frame.setVisible(true);
				}
				
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton.setBounds(488, 251, 80, 35);
		frame.getContentPane().add(btnNewButton);
	}
}
