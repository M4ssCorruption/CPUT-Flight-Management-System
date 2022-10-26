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

public class Ticket implements Serializable {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String ticketId;
    private String passengerId;
    private String flightId;


    protected Ticket() {
    }

    public Ticket(Builder builder) {

        this.id = builder.id;
        this.ticketId = builder.ticketId;
        this.passengerId = builder.passengerId;
        this.flightId = builder.flightId;
    }

    public Long getId() {
        return id;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getFlightId() {
        return flightId;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", ticketId='" + ticketId + '\'' +
                ", passengerId='" + passengerId + '\'' +
                ", flightId='" + flightId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && Objects.equals(ticketId, ticket.ticketId) && Objects.equals(passengerId, ticket.passengerId) && Objects.equals(flightId, ticket.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticketId, passengerId, flightId);
    }

    public static class Builder {
        private Long id;
        private String ticketId;
        private String flightId;
        private String passengerId;


        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setTicketId(String ticketId) {
            this.ticketId = ticketId;
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


        private Builder copy(Ticket ticket) {
            this.id = ticket.id;
            this.ticketId = ticket.ticketId;
            this.flightId = ticket.flightId;
            this.passengerId = ticket.passengerId;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }


}







