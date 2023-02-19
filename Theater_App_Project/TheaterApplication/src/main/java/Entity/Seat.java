package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seatId;
	private String rowNumber;
    private String seatNumber;
    private String available;
    private long theaterHallId;
    
    
	public long getSeatId() {
		return seatId;
	}
	public void setSeatId(long seatId) {
		this.seatId = seatId;
	}
	public String getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public long getTheaterHallId() {
		return theaterHallId;
	}
	public void setTheaterHallId(long theaterHallId) {
		this.theaterHallId = theaterHallId;
	}
	@Override
	public String toString() {
		return ""+seatId;
	}
    
    
	
	
    
    
    
}
