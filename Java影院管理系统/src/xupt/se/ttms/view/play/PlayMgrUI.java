package xupt.se.ttms.view.play;

/**
 * 剧目管理模块-界面层
 * @author 西邮陈冠希
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import xupt.se.ttms.model.Play;
import xupt.se.ttms.service.PlaySrv;
import xupt.se.ttms.view.systemManage.ManagerMgrUI;
import xupt.se.ttms.view.viewUtil.ChangeBackground;

class PlayTable {
	private JTable jt;

	public PlayTable(JScrollPane jp) {
		//添加列名
		DefaultTableModel tabModel=new DefaultTableModel(){
			private static final long serialVersionUID = -4771322252312753869L;

			@Override              
			public boolean isCellEditable(int row,int column){
				return false;              
			};
		};
		tabModel.addColumn("ID");
		tabModel.addColumn("剧目类型");
		tabModel.addColumn("剧目语种");
		tabModel.addColumn("剧目名称");
		tabModel.addColumn("剧目介绍");
		tabModel.addColumn("剧目时长");
		tabModel.addColumn("剧目票价");
		//初始化列
		jt=new JTable(tabModel);
		
		//设置各列的宽度
	    TableColumnModel columnModel = jt.getColumnModel();
	    
        TableColumn column = columnModel.getColumn(0);
        column.setPreferredWidth(30);
        column = columnModel.getColumn(1);
        column.setPreferredWidth(100);
        column = columnModel.getColumn(2);
        column.setPreferredWidth(100);
        column = columnModel.getColumn(3);
        column.setPreferredWidth(200);
        column = columnModel.getColumn(4);
        column.setPreferredWidth(500);   
        column = columnModel.getColumn(5);
        column.setPreferredWidth(100);   
        column = columnModel.getColumn(6);
        column.setPreferredWidth(100);   
        
        //设置表格高度
        jt.setRowHeight(30);
        jt.setFont(new Font("楷体", Font.PLAIN, 20));
        //设置表头高度
        JTableHeader tableHeader = jt.getTableHeader();
        tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 30));
        tableHeader.setFont(new Font("楷体", Font.PLAIN, 22));
        //设置表内容居中
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();  
        cr.setHorizontalAlignment(JLabel.CENTER);  
        jt.setDefaultRenderer(Object.class, cr);  
        //表头内容居中
        ((DefaultTableCellRenderer)jt.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);  
        jt.getTableHeader().setBackground(Color.lightGray);
        
		jp.add(jt);
		jp.setViewportView(jt);
	}
	
	/**
	 * 获取选中的一行数据
	 * @author 西邮陈冠希
	 */
	public Play getPlay() {
		int rowSel = jt.getSelectedRow();
		if(rowSel >= 0){
			Play play = new Play();
			play.setPlay_id(jt.getValueAt(rowSel, 0).toString());
			play.setPlay_type(jt.getValueAt(rowSel, 1).toString());
			play.setPlay_lang(jt.getValueAt(rowSel, 2).toString());
			play.setPlay_name(jt.getValueAt(rowSel, 3).toString());
			play.setPlay_introduction(jt.getValueAt(rowSel, 4).toString());
			play.setPlay_length(jt.getValueAt(rowSel, 5).toString());
			play.setPlay_price(jt.getValueAt(rowSel, 6).toString());

			return play;
		} else {
			return null;
		}
	}
	
	// 创建JTable
	public void showPlayList(List<Play> plList) {
		try {
			DefaultTableModel tabModel = (DefaultTableModel) jt.getModel();
			tabModel.setRowCount(0);
			
			Iterator<Play> itr = plList.iterator();
			while (itr.hasNext()) {
				Play play = itr.next();
				Object data[] = new Object[7];
				data[0] = play.getPlay_id();
				data[1] = play.getPlay_type();
				data[2] = play.getPlay_lang();
				data[3] = play.getPlay_name();
				data[4] = play.getPlay_introduction();
				data[5] = play.getPlay_length();
				data[6] = play.getPlay_price();
				
				tabModel.addRow(data);
			}
			jt.invalidate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


public class PlayMgrUI {

	public JFrame frame;
	private JTextField textField;
	private PlayTable ptb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayMgrUI window = new PlayMgrUI();
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
	public PlayMgrUI() {
		initialize();
		ChangeBackground.addIcon(frame);
		ChangeBackground.changeTopic();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("管理剧目");
		frame.setBounds(100, 100, 1300, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("管理剧目");
		label.setFont(new Font("隶书", Font.BOLD, 60));
		label.setBounds(522, 24, 328, 84);
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
		
		JButton button_1 = new JButton("添加");
		button_1.setFont(new Font("楷体", Font.PLAIN, 25));
		button_1.setBounds(857, 671, 88, 49);
		frame.getContentPane().add(button_1);
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnAddClicked();
			}
		});
		
		JButton button_2 = new JButton("修改");
		button_2.setFont(new Font("楷体", Font.PLAIN, 25));
		button_2.setBounds(945, 671, 88, 49);
		frame.getContentPane().add(button_2);
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnModClicked();
			}
		});
		
		JButton btnNewButton_1 = new JButton("删除");
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 25));
		btnNewButton_1.setBounds(1033, 671, 88, 49);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnDelClicked();
			}
		});
		
		JButton btnNewButton_2 = new JButton("返回");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerMgrUI().frame.setVisible(true);
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
		
		ptb = new PlayTable(jsc);
		
		showTable();
	}
	
	private void btnAddClicked() {
		PlayAddUI addPlUI = new PlayAddUI();
		addPlUI.frame.setVisible(true);
	}

	private void btnModClicked() {
		Play play = ptb.getPlay();
		if(null== play){
			JOptionPane.showMessageDialog(null, "请选择要修改的剧目");
			return;
		}
		
		PlayEditUI modPlUI = new PlayEditUI(play);
		modPlUI.frame.setVisible(true);
	}

	private void btnDelClicked() {
		Play play = ptb.getPlay();
		if(null== play){
			JOptionPane.showMessageDialog(null, "请选择要删除的剧目");
			return; 
		}		
		
		int confirm = JOptionPane.showConfirmDialog(null, "确认删除所选？", "删除", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			PlaySrv playSrv = new PlaySrv();
			playSrv.delPlay(play.getPlay_id());
			showTable();
		}
	}

	private void btnQueryClicked() {
		if (!textField.getText().equals("")) {
			List<Play> playList = new PlaySrv().prinfPlay(textField.getText());
			ptb.showPlayList(playList);
		} else {
			JOptionPane.showMessageDialog(null, "请输入检索条件");
		}
	}
	
	private void showTable() {
		List<Play> playList = new PlaySrv().prinfPlays();
		ptb.showPlayList(playList);
	}
}


