/*
Luggage.Java
Luggage Entity
Author: Erin Rowan (215271157)
 */
package za.ac.cput.flightmanagementsystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Luggage implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String luggageId;
    private String flightId;
    private String passengerId;
    private String luggageType;
    private float weight;
    private boolean isOverWeight;
    private final float weightLimit = 20;



    protected Luggage() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLuggageId() {
        return luggageId;
    }

    public void setLuggageId(String passengerId, String flightId) {
        this.luggageId = flightId +"-"+passengerId;
    }

    public boolean isOverWeight() {
        return weight>weightLimit;
    }

    public void setOverWeight(boolean overWeight) {
        isOverWeight = overWeight;
    }

    public String getFlightId() {return flightId;}

    public void setFlightId(String flightId) {this.flightId = flightId;}


    public String getPassengerId() {
        return passengerId;
    }

    public float getWeight() {return weight;}

    public String getLuggageType() {
        return luggageType;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }
    public void setWeight(float weight) {this.weight = weight; isOverWeight(weight);}

    public void setLuggageType(String luggageType) {
        this.luggageType = luggageType;
    }

    public boolean isOverWeight(float weight) {
      return weight>weightLimit;}



    public static class Builder{
        private long id;
        private String luggageId;
        private String flightId;
        private String passengerId;
        private String luggageType;
        private float weight;
        private boolean isOverWeight;


        public Builder setId(Long id){this.flightId=flightId; return this;}
        public Builder setFlightId(String flightId){
            this.flightId = flightId;
            return this;
        }

        public Builder setPassengerId(String passengerId) {
            this.passengerId = passengerId;
            return this;
        }

        public Builder setWeight(float weight) {
            this.weight = weight;
            isOverWeight(weight);
            return this;
        }

        public Builder setLuggageType(String luggageType) {
            this.luggageType = luggageType;
            return this;
        }

        public Builder isOverWeight(float weight) {
            float weightLimit = 20;
            if (weight > weightLimit){
                this.isOverWeight = true;
            }else{ this.isOverWeight=false;}
            return this;
        }

        public Builder setLuggageId(){
            this.luggageId=this.flightId+"-"+this.passengerId;
            return this;
        }
        public Builder copy(Luggage luggage){
            this.id=luggage.id;
            this.luggageId=luggage.luggageId;
            this.flightId=luggage.flightId;
            this.passengerId=luggage.passengerId;
            this.luggageType=luggage.luggageType;
            this.weight=luggage.weight;
            this.isOverWeight=luggage.isOverWeight;
            return this;
        }

        public Luggage build(){
            return new Luggage(this);
        }
    }
    private Luggage(Builder builder){
        this.id=builder.id;
        this.luggageId=builder.luggageId;
        this.flightId= builder.flightId;
        this.passengerId=builder.passengerId;
        this.luggageType=builder.luggageType;
        this.weight=builder.weight;
        this.isOverWeight=builder.isOverWeight;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Luggage luggage = (Luggage) o;
        return Float.compare(luggage.weight, weight) == 0 && isOverWeight == luggage.isOverWeight && Float.compare(luggage.weightLimit, weightLimit) == 0 && Objects.equals(id, luggage.id) && Objects.equals(luggageId, luggage.luggageId) && Objects.equals(flightId, luggage.flightId) && Objects.equals(passengerId, luggage.passengerId) && Objects.equals(luggageType, luggage.luggageType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, luggageId, flightId, passengerId, luggageType, weight, isOverWeight, weightLimit);
    }

    @Override
    public String toString() {
        return "Luggage{" +
                "id=" + id +
                ", luggageId='" + luggageId + '\'' +
                ", flightId='" + flightId + '\'' +
                ", passengerId='" + passengerId + '\'' +
                ", luggageType='" + luggageType + '\'' +
                ", weight=" + weight +
                ", isOverWeight=" + isOverWeight +
                ", weightLimit=" + weightLimit +
                '}';
    }
}
