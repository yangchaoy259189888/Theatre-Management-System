package xupt.se.ttms.view.stdioManage;

/**
 * 管理演出厅模块-界面层
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

import xupt.se.ttms.model.Studio;
import xupt.se.ttms.service.StudioSrv;
import xupt.se.ttms.view.systemManage.ManagerMgrUI;
import xupt.se.ttms.view.viewUtil.ChangeBackground;

class StudioTable {
	private JTable jt;

	public StudioTable(JScrollPane jp) {
		//添加列名
		DefaultTableModel tabModel=new DefaultTableModel(){
			private static final long serialVersionUID = -4771322252312753869L;

			@Override              
			public boolean isCellEditable(int row,int column){
				return false;              
			};
		};
		tabModel.addColumn("ID");
		tabModel.addColumn("演出厅名");
		tabModel.addColumn("座位行数");
		tabModel.addColumn("座位列数");
		tabModel.addColumn("演出厅简介");
		//初始化列
		jt=new JTable(tabModel);
		
		//设置各列的宽度
	    TableColumnModel columnModel = jt.getColumnModel();
	    
        TableColumn column = columnModel.getColumn(0);
        column.setPreferredWidth(100);
        column = columnModel.getColumn(1);
        column.setPreferredWidth(200);
        column = columnModel.getColumn(2);
        column.setPreferredWidth(150);
        column = columnModel.getColumn(3);
        column.setPreferredWidth(150);
        column = columnModel.getColumn(4);
        column.setPreferredWidth(1000);   
        
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
	 * @return
	 */
	public Studio getStudio() {
		int rowSel = jt.getSelectedRow();
		if(rowSel >= 0){
			Studio stud = new Studio();
			stud.setStudio_id(jt.getValueAt(rowSel, 0).toString());
			stud.setStudio_name(jt.getValueAt(rowSel, 1).toString());
			stud.setStudio_row_count(jt.getValueAt(rowSel, 2).toString());
			stud.setStudio_col_count(jt.getValueAt(rowSel, 3).toString());
			if (jt.getValueAt(rowSel, 4) != null)
				stud.setStudio_introduction(jt.getValueAt(rowSel, 4).toString());
			else
				stud.setStudio_introduction("");

			return stud;
		} else {
			return null;
		}
	}
	
	// 创建JTable
	public void showStudioList(List<Studio> stuList) {
		try {
			DefaultTableModel tabModel = (DefaultTableModel) jt.getModel();
			tabModel.setRowCount(0);
			
			Iterator<Studio> itr = stuList.iterator();
			while (itr.hasNext()) {
				Studio stu = itr.next();
				Object data[] = new Object[5];
				data[0] = stu.getStudio_id();
				data[1] = stu.getStudio_name();
				data[2] = stu.getStudio_row_count();
				data[3] = stu.getStudio_col_count();
				data[4] = stu.getStudio_introduction();
				tabModel.addRow(data);
			}
			jt.invalidate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


public class StudioMgrUI {

	public JFrame frame;
	private JTextField textField;
	private StudioTable stb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudioMgrUI window = new StudioMgrUI();
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
	public StudioMgrUI() {
		initialize();
		ChangeBackground.addIcon(frame);
		ChangeBackground.changeTopic();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("管理演出厅");
		frame.setBounds(100, 100, 1300, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("管理演出厅");
		label.setFont(new Font("隶书", Font.BOLD, 60));
		label.setBounds(522, 24, 328, 84);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("请输入演出厅名称:");
		label_1.setFont(new Font("楷体", Font.PLAIN, 25));
		label_1.setBounds(77, 685, 233, 21);
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
		
		stb = new StudioTable(jsc);
		
		showTable();
	}
	
	private void btnAddClicked() {
		StudioAddUI addStuUI = new StudioAddUI();
		addStuUI.frame.setVisible(true);
	}

	private void btnModClicked() {
		Studio stu = stb.getStudio();
		if(null== stu){
			JOptionPane.showMessageDialog(null, "请选择要修改的演出厅");
			return; 
		}
		
		StudioEditUI modStuUI = new StudioEditUI(stu);
		modStuUI.frame.setVisible(true);
	}

	private void btnDelClicked() {
		Studio stud = stb.getStudio();
		if(null== stud){
			JOptionPane.showMessageDialog(null, "请选择要删除的演出厅");
			return; 
		}		
		
		int confirm = JOptionPane.showConfirmDialog(null, "确认删除所选？", "删除", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			StudioSrv stuSrv = new StudioSrv();
			stuSrv.delStudio(stud.getStudio_id());
			showTable();
		}
	}

	private void btnQueryClicked() {
		if (!textField.getText().equals("")) {
			List<Studio> stuList = new StudioSrv().prinfStudio(textField.getText());
			stb.showStudioList(stuList);
		} else {
			JOptionPane.showMessageDialog(null, "请输入检索条件");
		}
	}
	
	private void showTable() {
		List<Studio> stuList = new StudioSrv().prinfStudios();
		stb.showStudioList(stuList);
	}
	
}

