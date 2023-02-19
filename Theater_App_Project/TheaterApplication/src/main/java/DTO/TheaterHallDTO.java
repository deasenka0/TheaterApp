package DTO;

import java.util.List;

import Entity.Seat;

public class TheaterHallDTO {
	
	
	private long hallId;
	private String name;
    private List<Seat> seatPlan;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Seat> getSeatPlan() {
		return seatPlan;
	}
	public void setSeatPlan(List<Seat> seatPlan) {
		this.seatPlan = seatPlan;
	}
	public long getHallId() {
		return hallId;
	}
	public void setHallId(long hallId) {
		this.hallId = hallId;
	}
	
	
    
    
    

}
