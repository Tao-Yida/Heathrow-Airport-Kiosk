/**
 * Flight.java
 *
 * This is the Flight Entity.
 *
 * @author Group 76
 * @version 5.0
 */
public class Flight {

    String departure;
    String destination;
    String flightNo;
    String gate;
    String boardingTime;
    String departureTime;

    public Flight(){
    }
    public void setDeparture(String departure){
        this.departure = departure;
    }
    public String getDeparture(){
        return departure;
    }


    public void setDestination(String destination){
        this.destination = destination;
    }
    public String getDestination(){
        return destination;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }
    public String getFlightNo() {
        return flightNo;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }
    public String getGate() {
        return gate;
    }

    public void setBoardingTime(String boardingTime) {this.boardingTime = boardingTime;}
    public String getBoardingTime() {return boardingTime;}

    public void setDepartureTime(String departureTime) {this.departureTime = departureTime;}
    public String getDepartureTime() {return departureTime;}


}
