package za.ac.cput.flightmanagementsystem.domain;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Airline implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String airlineId;
    private String airlineName;

    protected Airline(){

    }

    private Airline(Builder builder) {
        this.id = builder.id;
        this.airlineId=builder.airlineId;
        this.airlineName = builder.airlineName;
    }


    public Long getId() {
        return id;
    }

    public String getAirlineId() {
        return airlineId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return Objects.equals(id, airline.id) && Objects.equals(airlineId, airline.airlineId) && Objects.equals(airlineName, airline.airlineName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airlineId, airlineName);
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", airlineId='" + airlineId + '\'' +
                ", airlineName='" + airlineName + '\'' +
                '}';
    }

    public static class Builder {
        private Long id;
        private String airlineId;
        private String airlineName;


        public Builder setId(Long id) {
            this.id = id;
            return this;
        }
        public Builder setId(String airlineId) {
            this.airlineId = airlineId;
            return this;
        }

        public Builder setAirlineName(String airlineName) {
            this.airlineName = airlineName;
            return this;
        }
        private Builder Copy (Airline airline) {
            this.id = airline.id;
            this.airlineId=airline.airlineId;
            this.airlineName = airline.airlineName;
            return this;
        }
        public Airline build(){
            return new Airline(this);
        }
    }
}