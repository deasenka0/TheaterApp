package Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import DTO.SeatDTO;
import DTO.ShowDTO;
import DTO.TheaterHallDTO;
import Entity.CustomerAccount;
import Entity.Play;
import Entity.Seat;
import Entity.SeatReservation;
import Entity.Shows;
import Entity.TheaterHall;
import Util.CommonUtil;
import Util.HibernateUtil;

public class ShowService {

	
	public List<Shows> ShowByPlayId(long playId){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		List<Shows> list = new ArrayList<Shows>();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			String sql = "from Shows where  playId = "+playId;
			Query query = session.createQuery(sql);
			list = query.list();
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return list;
	}
	
	public List<Shows> ShowByPlayIdAndDate(long playId,Date date){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		List<Shows> list = new ArrayList<Shows>();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			String sql = "from Shows where  playId =:playId and date>=:date ";
			
			Query query = session.createQuery(sql);
			
			query.setLong("playId", playId);
			query.setDate("date", date);
			
			list = query.list();
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return list;
	}
	
	public void insertShow(Shows show) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.save(show);
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public TheaterHall getTheaterHallById(long id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		TheaterHall hall = new TheaterHall();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			hall = (TheaterHall)session.get(TheaterHall.class, id);
			trans.commit();
		}catch (Exception e) {
			
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return hall;
	}
	
	public List<ShowDTO> getShowData(long playId,PlayService playService){
		List<ShowDTO> showList = new ArrayList<ShowDTO>();
		try {
			
			List<Shows> showsList = ShowByPlayId(playId);
			
			for(Shows show:showsList){
				ShowDTO showdto = new ShowDTO();
				
				Play play = playService.getPlayById(show.getPlayId());
				
				showdto.setPlay(play);
				
				TheaterHallDTO theaterHallDTO = new TheaterHallDTO();
				TheaterHall hall = getTheaterHallById(show.getTheatherHallId());
				theaterHallDTO.setName(hall.getName());
				
				showdto.setId(show.getShowId());
				showdto.setTheaterHall(theaterHallDTO);
				String showTime = CommonUtil.getTimeFromDate(show.getDate());
				showdto.setStartTime(showTime);
				
				showList.add(showdto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return showList;
	}
	
	public List<ShowDTO> getShowDataByPlayAndDate(long playId,Date date,PlayService playService){
		List<ShowDTO> showList = new ArrayList<ShowDTO>();
		try {
			
			List<Shows> showsList = ShowByPlayIdAndDate(playId,date);
			
			for(Shows show:showsList){
				ShowDTO showdto = new ShowDTO();
				
				Play play = playService.getPlayById(show.getPlayId());
				
				showdto.setPlay(play);
				
				TheaterHallDTO theaterHallDTO = new TheaterHallDTO();
				TheaterHall hall = getTheaterHallById(show.getTheatherHallId());
				theaterHallDTO.setName(hall.getName());
				
				showdto.setId(show.getShowId());
				showdto.setTheaterHall(theaterHallDTO);
				String showTime = CommonUtil.getTimeFromDate(show.getDate());
				showdto.setStartTime(showTime);
				
				showList.add(showdto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return showList;
	}
	
	public ShowDTO getShowDTOByID(long showId,PlayService playService) {
		ShowDTO showDto = new ShowDTO();
		try {
			Shows shows = showById(showId);
			Play play = playService.getPlayById(shows.getPlayId());
			
			showDto.setPlay(play);
			
			TheaterHallDTO theaterHallDTO = new TheaterHallDTO();
			TheaterHall hall = getTheaterHallById(shows.getTheatherHallId());
			theaterHallDTO.setName(hall.getName());
			theaterHallDTO.setHallId(hall.getHallId());
			
			List<Seat> seats = getSeatsByHallId(hall.getHallId());
			
			
			
			showDto.setId(shows.getShowId());
			showDto.setTheaterHall(theaterHallDTO);
			String showTime = CommonUtil.getTimeFromDate(shows.getDate());
			showDto.setStartTime(showTime);
			
			showDto.setSeats(seats);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return showDto;
	}
	
	public Shows showById(long showId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Shows show = new Shows();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			show = (Shows)session.get(Shows.class, showId);
			trans.commit();
		}catch (Exception e) {
			
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return show;
	}
	
	public List<Seat> getSeatsByHallId(long hallId){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		List<Seat> list = new ArrayList<Seat>();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			String sql = "from Seat where  theaterHallId = "+hallId;
			Query query = session.createQuery(sql);
			list = query.list();
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return list;
	}
	
	public List<SeatReservation> getSeatsByCustomer(CustomerAccount account){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		List<SeatReservation> list = new ArrayList<SeatReservation>();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			
			String sql = "from SeatReservation sr where  sr.customerAccount.id = "+account.getId();
			Query query = session.createQuery(sql);
			list = query.list();
			if(list != null && list.size() > 0) {
				for(SeatReservation seatReservation:list) {
					Hibernate.initialize(seatReservation.getSeat());
					Hibernate.initialize(seatReservation.getShow());
					Hibernate.initialize(seatReservation.getCustomerAccount());
				}
			}
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Seat> getAvailableSeatsByHall(long hallId){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		List<Seat> list = new ArrayList<Seat>();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			String sql = "from Seat where available = 'Yes' and theaterHallId = "+hallId;
			Query query = session.createQuery(sql);
			list = query.list();
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return list;
	}
	
	public Seat getSeatById(long id){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		Seat seat = new Seat();
		try {
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			seat = (Seat)session.get(Seat.class, id);
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return seat;
	}
	
	public void reserveASeat(SeatReservation seatReservation) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.save(seatReservation);
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public void updateSeatInfo(Seat seat) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.update(seat);
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
}
