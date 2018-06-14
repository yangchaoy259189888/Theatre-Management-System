package xupt.se.ttms.model;

/**
 * 剧目管理模块-model数据层
 * @author 西邮陈冠希
 *
 */

public class Play {

	private String play_id;
	private String play_type;
	private String play_lang;
	private String play_name;
	private String play_introduction;
	private String play_length;
	private String play_price;
	
	public String getPlay_id() {
		return play_id;
	}
	
	public void setPlay_id(String play_id) {
		this.play_id = play_id;
	}
	
	public String getPlay_type() {
		return play_type;
	}
	
	public void setPlay_type(String play_type) {
		this.play_type = play_type;
	}
	
	public String getPlay_lang() {
		return play_lang;
	}
	
	public void setPlay_lang(String play_lang) {
		this.play_lang = play_lang;
	}
	
	public String getPlay_name() {
		return play_name;
	}
	public void setPlay_name(String play_name) {
		this.play_name = play_name;
	}
	
	public String getPlay_introduction() {
		return play_introduction;
	}
	
	public void setPlay_introduction(String play_introduction) {
		this.play_introduction = play_introduction;
	}
	
	public String getPlay_length() {
		return play_length;
	}
	public void setPlay_length(String play_length) {
		this.play_length = play_length;
	}
	
	public String getPlay_price() {
		return play_price;
	}
	
	public void setPlay_price(String play_price) {
		this.play_price = play_price;
	}
	
	@Override
	public String toString() {
		return "Play [play_id=" + play_id + ", play_type=" + play_type + ", play_lang=" + play_lang + ", play_name="
				+ play_name + ", play_introduction=" + play_introduction + ", play_length=" + play_length
				+ ", play_price=" + play_price + "]";
	}
}
