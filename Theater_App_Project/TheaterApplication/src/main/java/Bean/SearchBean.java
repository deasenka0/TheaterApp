package Bean;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import DTO.ShowDTO;
import DTO.TheaterHallDTO;
import Entity.Play;
import Entity.Shows;
import Service.PlayService;
import Service.ShowService;
import Util.CommonUtil;

@ManagedBean
@RequestScoped
public class SearchBean {
	
	private PlayService playService = new PlayService();
	private ShowService showService = new ShowService();
	private List<ShowDTO> shows;
	private String date;
	
	public String search() {		
		try {
			
			long playId = 0;
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext externalContext = context.getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();

			playId = (long) sessionMap.get("playIdforShow");
			//Date searchDate = CommonUtil.StringToDate(this.date);
			//this.shows = showService.getShowDataByPlayAndDate(playId,searchDate,playService);
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("showDate", this.date);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	public List<ShowDTO> getShows() {
		long playId = 0;
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();

		playId = (long) sessionMap.get("playIdforShow");
		String showDate = (String) sessionMap.get("showDate");
		
		if(playId > 0 && showDate != null && !showDate.equals("")) {
			Date searchDate = CommonUtil.StringToDate(this.date);
			this.shows = showService.getShowDataByPlayAndDate(playId,searchDate,playService);
		}else {
			this.shows = showService.getShowData(playId, playService);
		}
		return shows;
	}

	public void setShows(List<ShowDTO> shows) {
		this.shows = shows;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
