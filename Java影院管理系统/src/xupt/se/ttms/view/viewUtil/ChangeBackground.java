package xupt.se.ttms.view.viewUtil;

/**
 * 自己写的一个修改背景图片和修改主题的工具
 * @author 西邮陈冠希
 */

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class ChangeBackground {
	//更改主题
	public static void changeTopic() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//添加背景图片
	public static void addIcon(JFrame frame) {
		ImageIcon icon = new ImageIcon("resource/image/beijing.jpg");
		JLabel imgLabel = new JLabel(icon);
		frame.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE)); 
		imgLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		Container contain = frame.getContentPane();  
        ((JPanel) contain).setOpaque(false);   
	}	
}
