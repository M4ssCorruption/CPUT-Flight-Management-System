/*
Seat.java
Seat Entity
Author: Erin Rowan 215271157
 */
package za.ac.cput.flightmanagementsystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Seat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    Long id;
    String seatId;
    String flightId;
    int rowNum;
    String seatNum;
    boolean available;
    String passengerId;





    public Long getId() {
        return id;
    }
    public String getSeatId(){return seatId;}

    public String getPassengerId() {
        return passengerId;
    }

    public String getFlightId() {
        return flightId;
    }


    public String getSeatNum() {
        return seatNum;
    }


    public int getRowNum() {
        return rowNum;
    }


    public boolean isAvailable() {
        return available;
    }



    public Seat(){

    }

    private Seat(Builder builder){
        this.id=builder.id;
        this.seatId=builder.seatId;
        this.passengerId=builder.passengerId;
        this.seatNum=builder.seatNum;
        this.rowNum=builder.rowNum;
        this.flightId=builder.flightId;
        this.available=builder.available;
    }

    public static class Builder{
        Long id;
        String seatId;
        String flightId;
        int rowNum;
        String seatNum;
        boolean available;
        String passengerId;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }
        public Builder setSeatId(String seatId) {
            this.seatId = seatId;
            return this;
        }

        public Builder setPassengerId(String passengerId) {
            this.passengerId = passengerId;
            return this;
        }

        public Builder setFlightId(String flightId) {
            this.flightId = flightId;
            return this;
        }

        public Builder setRowNum(int rowNum) {
            this.rowNum = rowNum;
            return this;
        }
        public Builder setSeatNum(String seatNum) {
            this.seatNum = seatNum;
            return this;
        }

        public Builder setAvailable(boolean available) {
            this.available = available;
            return this;
        }

        public Builder copy(Seat seat) {
            this.id = seat.id;
            this.seatId=seat.seatId;
            this.passengerId = seat.passengerId;
            this.seatNum = seat.seatNum;
            this.rowNum = seat.rowNum;
            this.flightId = seat.flightId;
            this.available = seat.available;
            return this;
        }

        public Seat build(){return new Seat(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return rowNum == seat.rowNum && available == seat.available && Objects.equals(id, seat.id) && Objects.equals(seatId, seat.seatId) && Objects.equals(flightId, seat.flightId) && Objects.equals(seatNum, seat.seatNum) && Objects.equals(passengerId, seat.passengerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seatId, flightId, rowNum, seatNum, available, passengerId);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", seatId='" + seatId + '\'' +
                ", passengerId='" + passengerId + '\'' +
                ", flightId='" + flightId + '\'' +
                ", rowNum=" + rowNum +
                ", seatNum='" + seatNum + '\'' +
                ", available=" + available +
                '}';
    }
}
