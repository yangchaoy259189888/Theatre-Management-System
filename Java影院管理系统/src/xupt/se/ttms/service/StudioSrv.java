package xupt.se.ttms.service;

/**
 * 管理演出厅模块-service层
 * @author 西邮陈冠希
 */

import java.util.List;

import xupt.se.ttms.dao.StudioDAO;
import xupt.se.ttms.model.Studio;

public class StudioSrv {
	StudioDAO stuDAO = new StudioDAO();
	
	public void addStudio(String studio_name, String studio_row_count, String studio_col_count, String studio_introduction) {
		stuDAO.addStudio(studio_name, studio_row_count, studio_col_count, studio_introduction);
	}
	
	public void modStudio(String studio_name, String studio_row_count, String studio_col_count
			, String studio_introduction) {
		stuDAO.modStudio(studio_name, studio_row_count, studio_col_count, studio_introduction);
	}
	
	public void delStudio(String studio_id) {
		stuDAO.delStudio(studio_id);
	}
	
	public List<Studio> prinfStudio(String studio_name) {
		return stuDAO.prinfStudio(studio_name);
	}
	
	public List<Studio> prinfStudios() {
		return stuDAO.prinfStudios();
	}
}
