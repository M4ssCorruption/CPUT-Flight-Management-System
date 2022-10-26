package za.ac.cput.flightmanagementsystem.domain;
/*
   Author: Juan-Lee Zidane Klink (218236883)
   Date: 15 October 2022
*/

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Plane implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String planeId;

    private String airlineId;

    protected Plane(){}

    //Constructor
    private Plane(Builder builder){
        this.id = builder.id;
        this.planeId=builder.planeId;
        this.airlineId = builder.airlineId;
    }

    public Long getId() {
        return id;
    }
    public String getPlaneId() {
        return planeId;
    }
    public String getAirlineId() {
        return airlineId;
    }



    public static class Builder {
        private Long id;
        private String planeId;
        private String airlineId;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }
        public Builder setPlaneId(String planeId) {
            this.planeId = planeId;
            return this;
        }

        public void setAirlineId(String airlineId) {
            this.airlineId = airlineId;
        }

        public Builder copy(Plane plane){
            this.id = plane.id;
            this.planeId=plane.planeId;
            this.airlineId = plane.airlineId;
            return this;
        }

        public Plane build(){
            return new Plane(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return Objects.equals(id, plane.id) && Objects.equals(planeId, plane.planeId) && Objects.equals(airlineId, plane.airlineId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, planeId, airlineId);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", planeId='" + planeId + '\'' +
                ", airlineId='" + airlineId + '\'' +
                '}';
    }
}
