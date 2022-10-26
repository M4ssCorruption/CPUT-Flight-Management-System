/*
Zaakirah Fakier
220461503
 */
package za.ac.cput.flightmanagementsystem.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity

public class CheckIn implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @NotNull
    private String ticketId;
    @NotNull
    private String reservedSeat;
    private String luggageId;


    protected CheckIn() {
    }


    private CheckIn(Builder builder) {
        this.id = builder.id;
        this.ticketId = builder.ticketId;
        this.reservedSeat = builder.reserveSeat;
        this.luggageId = builder.luggageId;
    }

    public Long getId() {
        return id;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getReservedSeat() {
        return reservedSeat;
    }

    public String getLuggageId() {
        return luggageId;
    }


    public static class Builder {
        public Long id;
        public String ticketId;
        public String reserveSeat;
        public String luggageId;


        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setTicketId(String ticketId) {
            this.ticketId = ticketId;
            return this;
        }

        public Builder setReserveSeat(String reserveSeat) {
            this.reserveSeat = reserveSeat;
            return this;
        }

        public Builder setLuggageId(String luggageId) {
            this.luggageId = luggageId;
            return this;
        }

        public Builder copy(CheckIn checkIn) {
            this.id = checkIn.id;
            this.ticketId = checkIn.ticketId;
            this.reserveSeat = checkIn.reservedSeat;
            this.luggageId = checkIn.luggageId;
            return this;
        }

        public CheckIn build() {
            return new CheckIn(this);
        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckIn checkIn = (CheckIn) o;
        return Objects.equals(id, checkIn.id) && Objects.equals(ticketId, checkIn.ticketId) && Objects.equals(reservedSeat, checkIn.reservedSeat) && Objects.equals(luggageId, checkIn.luggageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticketId, reservedSeat, luggageId);
    }

    @Override
    public String toString() {
        return "CheckIn{" +
                "id=" + id +
                ", ticketId='" + ticketId + '\'' +
                ", reservedSeat='" + reservedSeat + '\'' +
                ", luggageId='" + luggageId + '\'' +
                '}';
    }
}


