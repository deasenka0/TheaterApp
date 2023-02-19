package DTO;

import java.util.List;

import Entity.Play;
import Entity.Seat;

public class ShowDTO {

	private long id;
	private Play play;
	private TheaterHallDTO theaterHall;
	private List<Seat> seats;
	private String startTime;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Play getPlay() {
		return play;
	}
	public void setPlay(Play play) {
		this.play = play;
	}
	public TheaterHallDTO getTheaterHall() {
		return theaterHall;
	}
	public void setTheaterHall(TheaterHallDTO theaterHall) {
		this.theaterHall = theaterHall;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	
	
	
	
	
	
	
	
	
	
}
