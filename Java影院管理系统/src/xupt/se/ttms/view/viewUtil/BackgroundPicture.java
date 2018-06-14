package xupt.se.ttms.view.viewUtil;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BackgroundPicture extends JFrame {
	private static final long serialVersionUID = 7032485929024193849L;
	private JPanel panel;
	
	public BackgroundPicture() {
		panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
		    public void paint(Graphics g) {
		        super.paint(g);
		        Graphics2D g2 = (Graphics2D)g; //强转成2D
		        ImageIcon ii1 = new ImageIcon("resource/image/beijing2.jpg");
		        //dimision.width是窗体的宽度，dimision.height是窗体的高度
		        g2.drawImage(ii1.getImage(), 0, 0, 1280,400, null);
			}
		};
		
		this.setUndecorated(true);
		panel.setPreferredSize(new Dimension(1280,400));
		this.setBackground(new Color(0, 0, 0, 0));
		this.setUndecorated(true);
		this.setBounds(0, 0, 1280,400);
		this.add(panel);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new BackgroundPicture();
	}

}
