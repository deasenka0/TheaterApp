package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Play {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long playId;
	private String writer;
	private String title;
    private String director;
    private String actors;
    
    
	public long getPlayId() {
		return playId;
	}
	public void setPlayId(long playId) {
		this.playId = playId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
    
    
    
	    
    
}
