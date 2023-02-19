package Entity;





import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shows {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long showId;
	private long playId;
	private long theatherHallId;
	private Date date;
	
	public long getShowId() {
		return showId;
	}
	public void setShowId(long showId) {
		this.showId = showId;
	}
	public long getPlayId() {
		return playId;
	}
	public void setPlayId(long playId) {
		this.playId = playId;
	}
	public long getTheatherHallId() {
		return theatherHallId;
	}
	public void setTheatherHallId(long theatherHallId) {
		this.theatherHallId = theatherHallId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
    
	    
}
