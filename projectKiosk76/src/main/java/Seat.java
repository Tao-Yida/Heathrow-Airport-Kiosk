/**
 * Seat.java
 *
 * This is seat entity.
 *
 * @author Group76
 * @version 5.0
 */
public class Seat {
    char seatStatus;
    int  seatID;
    public Seat(){ }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatStatus(char seatStatus) {
        this.seatStatus = seatStatus;
    }

    public char getSeatStatus() { return seatStatus; }
}
