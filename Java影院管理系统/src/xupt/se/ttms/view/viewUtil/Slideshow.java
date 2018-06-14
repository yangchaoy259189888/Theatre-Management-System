package xupt.se.ttms.view.viewUtil;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import xupt.se.ttms.view.systemManage.SellerMgrUI;

public class Slideshow extends JFrame {
	private static final long serialVersionUID = 1L;
	MyJPanel mp;
    int index;
    ImageIcon[] imgs = {
            new ImageIcon("resource/image/21kela.jpg"),
            new ImageIcon("resource/image/fuchouzhelianm.jpg"),
            new ImageIcon("resource/image/honghaixingdong.jpg"),
            new ImageIcon("resource/image/tiankongzhicheng.jpg"),
            new ImageIcon("resource/image/gongfixiongmao.jpg"),
            new ImageIcon("resource/image/haoke.jpg"),
            new ImageIcon("resource/image/jialebihaidao.jpg"),
            new ImageIcon("resource/image/joy.jpg"),
        };
    
    public Slideshow() {
        mp = new MyJPanel();
        this.add(mp);
        //setUndecorated(true);
        this.setBounds(100, 100, 400, 560);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("海报展示");
        this.setVisible(true);
        Timer timer = new Timer(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mp.repaint();
            }
        });
        timer.start();
        
        this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent e) {
				new SellerMgrUI().frame.setVisible(true);
			}
        	
		});
    }
    
    public static void main(String[] args) {
        new Slideshow();
    }
    
    class MyJPanel extends JPanel{
		private static final long serialVersionUID = -6856240521257685504L;

		@Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(imgs[index%imgs.length].getImage(), 0, 0,this);
            index++;
        }
    }
}
