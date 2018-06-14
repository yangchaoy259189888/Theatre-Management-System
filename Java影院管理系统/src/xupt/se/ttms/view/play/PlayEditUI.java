package xupt.se.ttms.view.play;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import xupt.se.ttms.model.Play;
import xupt.se.ttms.service.PlaySrv;
import xupt.se.ttms.view.viewUtil.ChangeBackground;

public class PlayEditUI {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextArea txtArea;

	/**
	 * Create the application.
	 * @param play 
	 */
	public PlayEditUI(Play play) {
		initialize();
		ChangeBackground.addIcon(frame);
		ChangeBackground.changeTopic();
		
		textField.setText(play.getPlay_type());
		textField_1.setText(play.getPlay_lang());
		textField_2.setText(play.getPlay_name());
		textField_3.setText(play.getPlay_length());
		textField_4.setText(play.getPlay_price());
		txtArea.setText(play.getPlay_introduction());
	}
	
	protected void btnSaveClicked(){
		if (textField.getText() != null && textField_1.getText() != null && textField_2.getText() != null
				&& textField_3.getText() != null && textField_4.getText() != null) {
			PlaySrv plSrv = new PlaySrv();

			plSrv.modPlay(textField.getText(), textField_1.getText(), textField_2.getText()
					, txtArea.getText(), textField_3.getText(), textField_4.getText());
			frame.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "数据不完整");
		}		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("修改剧目");
		frame.setBounds(100, 100, 732, 501);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("修改剧目");
		lblNewLabel.setBounds(256, 13, 212, 57);
		lblNewLabel.setFont(new Font("隶书", Font.BOLD, 50));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("剧目类型:");
		lblNewLabel_1.setBounds(48, 104, 119, 24);
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(163, 104, 138, 31);
		textField.setFont(new Font("楷体", Font.PLAIN, 20));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("剧目语种:");
		lblNewLabel_2.setBounds(349, 101, 119, 31);
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(464, 104, 169, 31);
		textField_1.setFont(new Font("楷体", Font.PLAIN, 20));
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("剧目名称:");
		lblNewLabel_3.setBounds(48, 154, 119, 24);
		lblNewLabel_3.setFont(new Font("楷体", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(163, 155, 305, 31);
		textField_2.setFont(new Font("楷体", Font.PLAIN, 20));
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("剧目时长:");
		lblNewLabel_4.setBounds(48, 208, 119, 24);
		lblNewLabel_4.setFont(new Font("楷体", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(163, 205, 138, 31);
		textField_3.setFont(new Font("楷体", Font.PLAIN, 20));
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("剧目票价:");
		lblNewLabel_5.setBounds(349, 208, 113, 24);
		lblNewLabel_5.setFont(new Font("楷体", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(464, 209, 169, 31);
		textField_4.setFont(new Font("楷体", Font.PLAIN, 20));
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("剧目简介:");
		lblNewLabel_6.setBounds(48, 273, 119, 24);
		lblNewLabel_6.setFont(new Font("楷体", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_6);
		
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
				if (e.getSource() == btnNewButton_1) {
					frame.setVisible(false);
				} else if (e.getSource() == btnNewButton) {
					btnSaveClicked();
				}
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 25));
		frame.getContentPane().add(btnNewButton_1);
		
		txtArea = new JTextArea();
		txtArea.setFont(new Font("楷体", Font.PLAIN, 20));
		txtArea.setLineWrap(true);
		
		JScrollPane scrollPane = new JScrollPane(txtArea);
		scrollPane.setBounds(163, 260, 473, 116);
		frame.getContentPane().add(scrollPane);
	}
}
