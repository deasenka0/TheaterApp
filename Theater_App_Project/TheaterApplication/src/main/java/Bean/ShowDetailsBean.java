package Bean;



import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DTO.ShowDTO;
import Entity.CustomerAccount;
import Entity.Seat;
import Entity.SeatReservation;
import Entity.Shows;
import Service.CustomerAccountService;
import Service.PlayService;
import Service.ShowService;

@ManagedBean
@RequestScoped
public class ShowDetailsBean {
	
	private ShowDTO show;
	private boolean logged;
	private List<Seat> availableSeats;
	private ShowService showService = new ShowService();
	private PlayService playService = new PlayService();
	private CustomerAccountService customerAccountService  = null;
	
	public ShowDetailsBean() {
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String showId = request.getParameter("showId");
		if(showId != null) {
			show = showService.getShowDTOByID(Long.parseLong(showId), playService);
			HttpSession session = request.getSession();
			if(session.getAttribute("customerAccount") != null) {
				//CustomerAccount account  = (CustomerAccount) session.getAttribute("customerAccount");
				logged = true;
				availableSeats = showService.getAvailableSeatsByHall(show.getTheaterHall().getHallId());
			}
		}else {
			Map<String, String[]> parameterMap = request.getParameterMap();
			for(Map.Entry<String, String[]> entry:parameterMap.entrySet()) {
				String []selectedSeatsValues = entry.getValue();
				String inputFieldKey    = entry.getKey();
				if(inputFieldKey.contains("seats")){
					
					if(selectedSeatsValues != null && selectedSeatsValues.length > 5) {			
					}else if(selectedSeatsValues != null && selectedSeatsValues.length < 0){
					}else {
						customerAccountService = new CustomerAccountService();
						HttpSession session = request.getSession();
						if(session.getAttribute("customerAccount") != null) {
							String selectedShowId = request.getParameter("j_idt6:selectShowID");
							CustomerAccount account  = (CustomerAccount) session.getAttribute("customerAccount");
							for(String seatId:selectedSeatsValues){
								
								Seat seat  = showService.getSeatById(Long.parseLong(seatId));
								Shows show = showService.showById(Long.parseLong(selectedShowId));
								
								SeatReservation reservation = new SeatReservation();
								reservation.setCustomerAccount(account);
								reservation.setSeat(seat);
								reservation.setShow(show);
								
								showService.reserveASeat(reservation);		
								seat.setAvailable("Booked");
								showService.updateSeatInfo(seat);
							}
						}
					}
					
					
				}
				
			}

		}
	}
	
	public String reserveSeats() {
		String view = "";
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		CustomerAccount customerAccount = null;
		if(session.getAttribute("customerAccount") != null) {
			view = "welcome";
				
		}else {
			view = "login";
		}
		
		return view;
	}
	
	
	
	public boolean isLogged() {
		return logged;
	}
	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	public List<Seat> getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(List<Seat> availableSeats) {
		this.availableSeats = availableSeats;
	}
	public ShowDTO getShow() {
		return show;
	}
	public void setShow(ShowDTO show) {
		this.show = show;
	}
	
	
}
