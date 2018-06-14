package xupt.se.ttms.view.stdioManage;

/**
 * 增加演出厅界面
 * @author 西邮陈冠希
 */

import java.awt.EventQueue;
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

import xupt.se.ttms.service.StudioSrv;
import xupt.se.ttms.view.viewUtil.ChangeBackground;

public class StudioAddUI {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea txtArea;
	protected boolean rst = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudioAddUI window = new StudioAddUI();
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
	public StudioAddUI() {
		initialize();
		ChangeBackground.addIcon(frame);
		ChangeBackground.changeTopic();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("添加演出厅");
		frame.setBounds(100, 100, 732, 501);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("添加演出厅");
		label.setFont(new Font("隶书", Font.BOLD, 50));
		label.setBounds(226, 13, 270, 52);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("演出厅名称:");
		label_1.setFont(new Font("楷体", Font.PLAIN, 25));
		label_1.setBounds(42, 95, 150, 30);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("楷体", Font.PLAIN, 20));
		textField.setBounds(181, 95, 315, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("座位(行数):");
		label_2.setFont(new Font("楷体", Font.PLAIN, 25));
		label_2.setBounds(42, 151, 150, 30);
		frame.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("楷体", Font.PLAIN, 20));
		textField_1.setBounds(181, 151, 315, 31);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("座位(列数):");
		label_3.setFont(new Font("楷体", Font.PLAIN, 25));
		label_3.setBounds(42, 211, 150, 30);
		frame.getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("楷体", Font.PLAIN, 20));
		textField_2.setBounds(180, 211, 316, 31);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("演出厅简介:");
		label_4.setFont(new Font("楷体", Font.PLAIN, 25));
		label_4.setBounds(42, 293, 150, 30);
		frame.getContentPane().add(label_4);
		
		txtArea = new JTextArea();
		txtArea.setFont(new Font("楷体", Font.PLAIN, 20));
		txtArea.setLineWrap(true);
		
		JScrollPane scrollPane = new JScrollPane(txtArea);
		scrollPane.setBounds(180, 260, 473, 116);
		frame.getContentPane().add(scrollPane);
		
		JButton button = new JButton("保存");
		button.setFont(new Font("楷体", Font.PLAIN, 25));
		button.setBounds(42, 381, 106, 52);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnSaveClicked();
			}
		});
		
		JButton btnNewButton = new JButton("取消");
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 25));
		btnNewButton.setBounds(198, 381, 106, 52);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton) {
					frame.setVisible(false);
				} else if (e.getSource() == button) {
					btnSaveClicked();
				}
			}
		});
	}
	
	protected void btnSaveClicked(){
		if (textField.getText() != null && textField_1.getText() != null
				&& textField_2.getText() != null) {
			StudioSrv stuSrv = new StudioSrv();

			stuSrv.addStudio(textField.getText(), textField_1.getText(), textField_2.getText(), txtArea.getText());
			frame.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "数据不完整");
		}		
	}
}

