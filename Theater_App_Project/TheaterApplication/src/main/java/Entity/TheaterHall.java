package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TheaterHall {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long hallId;
	String name;
	private int numberOfRows;
	private int numOfSeats;
	
	
	public long getHallId() {
		return hallId;
	}
	public void setHallId(long hallId) {
		this.hallId = hallId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfRows() {
		return numberOfRows;
	}
	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}
	public int getNumOfSeats() {
		return numOfSeats;
	}
	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}
	
	
	
}
