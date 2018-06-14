package xupt.se.ttms.view.viewUtil;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowWord extends JFrame{
	private static final long serialVersionUID = 4171454850759140121L;
	private JPanel text;
	private static String str = "  欢迎使用凉凉剧院管理系统";		// 显示文本
	private int x = 10;
	
	public FlowWord() {
		setLocationRelativeTo(null);
		text = new JPanel(){
			private static final long serialVersionUID = 7633828902009421639L;
			
			@Override
			public void paint(Graphics g) {
				g.setColor(Color.lightGray);
				g.setColor(Color.black);
				Font font = new Font("隶书", Font.BOLD, 70);
				g.setFont(font);
				FontMetrics fm = g.getFontMetrics();
				int strWidth = fm.stringWidth(str);							// 得到字符串的宽度
				int width = text.getWidth();								// 得到显示屏的宽度
				if(x < 0 && Math.abs(x) > width){
					x = 10;
				}
				g.drawString(str, x, 60);
				g.drawString(str, strWidth + x, 60);
			}
			@Override
			public void update(Graphics g) {
				paint(g);
			}
			
		};
		
		text.setPreferredSize(new Dimension(1000, 70));
		add(text);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while(true){
						// 改变显示的位置 
						x = x - 5;
						repaint();
						Thread.sleep(50);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		setLocation(500, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		enableInputMethods(false);
		pack();
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlowWord();
	}

}

