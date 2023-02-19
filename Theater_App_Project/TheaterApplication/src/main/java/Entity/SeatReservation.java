package Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SeatReservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    private Shows show;

    @ManyToOne(optional = false)
    private Seat seat;

    @ManyToOne(optional = false)
    private CustomerAccount customerAccount;

    public SeatReservation() {
    }

    public SeatReservation(Shows show, Seat seat, CustomerAccount customerAccount) {
        this.show = show;
        this.seat = seat;
        this.customerAccount = customerAccount;
    }

    // Getters and setters...

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Shows getShow() {
        return show;
    }

    public void setShow(Shows show) {
        this.show = show;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }

    // Equals and hashCode...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeatReservation that = (SeatReservation) o;

        if (id != that.id) return false;
        if (!show.equals(that.show)) return false;
        return seat.equals(that.seat);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + show.hashCode();
        result = 31 * result + seat.hashCode();
        return result;
    }

}