package xupt.se.ttms.view.schedule;

/**
 * 演出计划修改模块--界面
 * @author 西邮陈冠希
 */

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import xupt.se.ttms.model.Schedule;
import xupt.se.ttms.service.ScheduleSrv;
import xupt.se.ttms.view.viewUtil.ChangeBackground;

public class ScheduleEditUI {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the application.
	 */
	public ScheduleEditUI(Schedule schedule) {
		initialize();
		ChangeBackground.addIcon(frame);
		ChangeBackground.changeTopic();
		
		textField.setText(schedule.getStudio_id());
		textField_1.setText(schedule.getPlay_time());
		textField_2.setText(schedule.getPlay_name());
		textField_3.setText(schedule.getPlay_showTime());
		textField_4.setText(schedule.getPlay_ticketPrice());
		
	}
	
	protected void btnSaveClicked(){
		if (textField.getText() != null && textField_1.getText() != null && textField_2.getText() != null
				&& textField_3.getText() != null && textField_4.getText() != null) {
			ScheduleSrv scheduleSrv = new ScheduleSrv();

			scheduleSrv.modSchedule(textField.getText(), textField_2.getText(), textField_3.getText()
					, textField_1.getText(), textField_4.getText());
			frame.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "数据不完整");
		}		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("添加演出计划");
		frame.setBounds(100, 100, 732, 501);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("添加演出计划");
		lblNewLabel.setBounds(206, 13, 330, 57);
		lblNewLabel.setFont(new Font("隶书", Font.BOLD, 50));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("放映厅:");
		lblNewLabel_1.setBounds(88, 105, 95, 24);
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(190, 104, 169, 31);
		textField.setFont(new Font("楷体", Font.PLAIN, 20));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("剧目播放时间:");
		lblNewLabel_2.setBounds(14, 257, 169, 31);
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(190, 259, 169, 31);
		textField_1.setFont(new Font("楷体", Font.PLAIN, 20));
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("剧目名称:");
		lblNewLabel_3.setBounds(64, 154, 119, 24);
		lblNewLabel_3.setFont(new Font("楷体", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(190, 153, 169, 31);
		textField_2.setFont(new Font("楷体", Font.PLAIN, 20));
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("剧目上映时间:");
		lblNewLabel_4.setBounds(14, 208, 169, 24);
		lblNewLabel_4.setFont(new Font("楷体", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(190, 207, 169, 31);
		textField_3.setFont(new Font("楷体", Font.PLAIN, 20));
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("剧目票价:");
		lblNewLabel_5.setBounds(70, 312, 113, 24);
		lblNewLabel_5.setFont(new Font("楷体", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(190, 311, 169, 31);
		textField_4.setFont(new Font("楷体", Font.PLAIN, 20));
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("保存");
		btnNewButton.setBounds(206, 402, 95, 39);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSaveClicked();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 25));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBounds(371, 402, 95, 39);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton) {
					frame.setVisible(false);
				} else if (e.getSource() == btnNewButton) {
					btnSaveClicked();
				}
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 25));
		frame.getContentPane().add(btnNewButton_1);
	}
}
