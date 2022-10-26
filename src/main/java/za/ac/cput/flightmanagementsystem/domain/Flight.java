/*
Flight.java
Flight Entity
Author: Daniel Marais 219476845
 */
package za.ac.cput.flightmanagementsystem.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity

public class Flight implements Serializable {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String flightId;


    private String planeId;

    private String crewId;

    private int seatsAvailable;

    protected Flight()
    {

    }

    private Flight(Builder builder) {
        this.id = builder.id;
        this.crewId = builder.crewId;
        this.planeId = builder.planeId;
        this.seatsAvailable = builder.seatsAvailable;
    }

    public Long getId() {
        return id;
    }

    public String getPlaneId() {
        return planeId;
    }

    public String getCrewId() {
        return crewId;
    }
    public String getFlightId() {
        return flightId;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }







    public static class Builder {
        private Long id;
        private String flightId;
        private String planeId;
        private String crewId;
        private int seatsAvailable;



        public Builder setFlightId(String flightId) {
            this.flightId = flightId;
            return this;
        }

        public Builder setPlaneId(String planeId) {
            this.planeId = planeId;
            return this;
        }

        public Builder setCrewId(String crewId) {
            this.crewId = crewId;
            return this;
        }

        public Builder setSeatsAvailable(int seatsAvailable) {
            this.seatsAvailable = seatsAvailable;
            return this;
        }

        public Builder copy(Flight flight) {
            this.id = flight.id;
            this.planeId = flight.planeId;
            this.seatsAvailable = flight.seatsAvailable;
            this.crewId = flight.crewId;
            return this;
        }


        public Flight build() {
            return new Flight(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return seatsAvailable == flight.seatsAvailable && Objects.equals(id, flight.id) && Objects.equals(flightId, flight.flightId) && Objects.equals(planeId, flight.planeId) && Objects.equals(crewId, flight.crewId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightId, planeId, crewId, seatsAvailable);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightId='" + flightId + '\'' +
                ", planeId='" + planeId + '\'' +
                ", crewId='" + crewId + '\'' +
                ", seatsAvailable=" + seatsAvailable +
                '}';
    }
}