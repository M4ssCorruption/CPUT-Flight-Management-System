/*
 * Mary-Beth Agulhas
 * 219082367
 * Airport
 */
package za.ac.cput.flightmanagementsystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

@Entity

public class Airport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String airportName;
    private String airportId;
    private String cityId;

    protected Airport() {
    }

    private Airport(Builder builder) {
        this.id = builder.id;
        this.airportId=builder.airportId;
        this.airportName = builder.airportName;

        this.cityId = builder.cityId;
    }

    public Long getId()
    {
        return id;
    }

    public String getAirportName()
    {
        return airportName;
    }
    public String getAirportId()
    {
        return airportId;
    }

    public String getCityId()
    {
        return cityId;
    }







    public static class Builder{
        private Long id;
        private String airportId;
        private String airportName;

        private String cityId;

        public Builder id(Long  id){
            this.id = id;
            return this;
        }

        public Builder airportName(String airportName){
            this.airportName=airportName;
            return this;
        }public Builder airportId(String airportId){
            this.airportId=airportId;
            return this;
        }

        public Builder cityId(String cityId){
            this.cityId=cityId;
            return this;
        }

        public Airport build(){
            return new Airport(this);
        }

        private Builder Copy(Airport airport) {
            this.id = airport.id;
            this.airportId=airport.airportId;
            this.airportName = airport.airportName;
            this.cityId = airport.cityId;
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(id, airport.id) && Objects.equals(airportName, airport.airportName) && Objects.equals(airportId, airport.airportId) && Objects.equals(cityId, airport.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airportName, airportId, cityId);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", airportName='" + airportName + '\'' +
                ", airportId='" + airportId + '\'' +
                ", cityId='" + cityId + '\'' +
                '}';
    }
}
