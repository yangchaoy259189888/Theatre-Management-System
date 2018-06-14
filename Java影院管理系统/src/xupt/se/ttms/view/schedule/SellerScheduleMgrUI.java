package xupt.se.ttms.view.schedule;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import xupt.se.ttms.model.Schedule;
import xupt.se.ttms.service.ScheduleSrv;
import xupt.se.ttms.view.systemManage.SellerMgrUI;
import xupt.se.ttms.view.viewUtil.ChangeBackground;

public class SellerScheduleMgrUI {

	public JFrame frame;
	private JTextField textField;
	private ScheduleTable scd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellerScheduleMgrUI window = new SellerScheduleMgrUI();
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
	public SellerScheduleMgrUI() {
		initialize();
		ChangeBackground.addIcon(frame);
		ChangeBackground.changeTopic();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("管理演出计划");
		frame.setBounds(100, 100, 1300, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("管理演出计划");
		label.setFont(new Font("隶书", Font.BOLD, 60));
		label.setBounds(461, 23, 378, 84);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("请输入剧目名称:");
		label_1.setFont(new Font("楷体", Font.PLAIN, 25));
		label_1.setBounds(95, 685, 233, 21);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("楷体", Font.PLAIN, 25));
		textField.setBounds(291, 680, 233, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("查找");
		button.setFont(new Font("楷体", Font.PLAIN, 25));
		button.setBounds(538, 681, 96, 28);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnQueryClicked();
			}
		});
		
		JButton btnNewButton = new JButton("刷新");
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 25));
		btnNewButton.setBounds(650, 681, 96, 28);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showTable();
			}
		});
		
		JButton btnNewButton_2 = new JButton("返回");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SellerMgrUI().frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("楷体", Font.PLAIN, 25));
		btnNewButton_2.setBounds(1155, 671, 88, 49);
		frame.getContentPane().add(btnNewButton_2);
		
		//生成表格
		JScrollPane jsc = null;
		
		jsc = new JScrollPane();
		jsc.setBounds(40, 120, 1200, 500);
		frame.getContentPane().add(jsc);
		
		scd = new ScheduleTable(jsc);
		
		showTable();
	}
	
	private void btnQueryClicked() {
		if (!textField.getText().equals("")) {
			List<Schedule> scheduleList = new ScheduleSrv().prinfSchedule(textField.getText());
			scd.showScheduleList(scheduleList);
		} else {
			JOptionPane.showMessageDialog(null, "请输入检索条件");
		}
	}
	
	private void showTable() {
		List<Schedule> scheduleList = new ScheduleSrv().prinfSchedules();
		scd.showScheduleList(scheduleList);
	}
}



