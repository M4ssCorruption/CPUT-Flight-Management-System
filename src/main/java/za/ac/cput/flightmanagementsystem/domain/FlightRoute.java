
package za.ac.cput.flightmanagementsystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class FlightRoute implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String routeId;
    private String departureAirport;
    private String destinationAirport;

    protected FlightRoute(){

    }
    private FlightRoute(Builder builder) {
        this.id = builder.id;
        this.routeId = builder.routeId;
        this.departureAirport = builder.departureAirport;
        this.destinationAirport = builder.destinationAirport;
    }
    public Long getId(){return id;}
    public String getRouteId() {
        return routeId;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public static class Builder{

        private Long id;
        private String routeId;
        private String  departureAirport;
        private String destinationAirport;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }
        public Builder setRouteId(String routeId) {
            this.routeId = routeId;
            return this;
        }

        public Builder setDepartureAirport(String departureAirport) {
            this.departureAirport = departureAirport;
            return this;
        }

        public Builder setDestinationAirport(String destinationAirport) {
            this.destinationAirport = destinationAirport;
            return this;
        }

        private Builder Copy(FlightRoute flightRoute) {
            this.id = flightRoute.id;
            this.routeId = flightRoute.routeId;
            this.departureAirport = flightRoute.departureAirport;
            this.destinationAirport = flightRoute.destinationAirport;
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightRoute that = (FlightRoute) o;
        return Objects.equals(id, that.id) && Objects.equals(routeId, that.routeId) && Objects.equals(departureAirport, that.departureAirport) && Objects.equals(destinationAirport, that.destinationAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routeId, departureAirport, destinationAirport);
    }

    @Override
    public String toString() {
        return "FlightRoute{" +
                "id=" + id +
                ", routeId='" + routeId + '\'' +
                ", departureAirport='" + departureAirport + '\'' +
                ", destinationAirport='" + destinationAirport + '\'' +
                '}';
    }
}