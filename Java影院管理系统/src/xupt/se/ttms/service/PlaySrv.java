package xupt.se.ttms.service;

/**
 * 剧目管理模块-service层
 * @author 西邮陈冠希
 */

import java.util.List;

import xupt.se.ttms.dao.PlayDAO;
import xupt.se.ttms.model.Play;

public class PlaySrv {
	PlayDAO plDAO = new PlayDAO();
	
	public List<Play> prinfPlays() {
		return plDAO.prinfPlays();
	}
	
	public List<Play> prinfPlay(String string_play_name) {
		return plDAO.prinfPlay(string_play_name);
	}
	
	public void addPlay(String play_type, String play_lang, String play_name, String play_introduction
			, String play_length, String play_price) {
		
		plDAO.addPlay(play_type, play_lang, play_name, play_introduction, play_length, play_price);
	}
	
	public void modPlay(String play_type, String play_lang, String play_name, String play_introduction
			, String play_length, String play_price) {
		plDAO.modPlay(play_type, play_lang, play_name, play_introduction, play_length, play_price);
	}
	
	public void delPlay(String play_id) {
		plDAO.delPlay(play_id);
	}
}
