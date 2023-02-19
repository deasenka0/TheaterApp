package Bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entity.Play;
import Service.PlayService;


@ManagedBean
@SessionScoped
public class WelcomeBean {
	
	private PlayService playService;
	private List<Play> plays;
	
	
	public WelcomeBean() { 
		  playService = new PlayService(); 
		  plays = playService.getAllPlays(); 
    }
	
	public String showPlay(long id) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("playIdforShow", id);
		return "search";
	}
	 
	public List<Play> getPlays() {
		
		if(playService  == null) {
			playService = new PlayService();
		}
		return playService.getAllPlays();
	}

	public void setPlays(List<Play> plays) {
		this.plays = plays;
	}
	
	

	

	
	
	
	
	
}
