package xupt.se.ttms.view.login;

import xupt.se.ttms.view.viewUtil.BackgroundPicture;
import xupt.se.ttms.view.viewUtil.FlowWord;

/**
 * 此项目的运行入口
 * @author 西邮陈冠希
 *
 */

public class Main {

	public static void main(String[] args) {
		FlowWord flowWord = new FlowWord();
		BackgroundPicture backgroundPicture = new BackgroundPicture();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(4000);
					flowWord.dispose();
					backgroundPicture.dispose();
					
					new SellerLoginUI().frame.setVisible(true);;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

}
