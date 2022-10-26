package za.ac.cput.flightmanagementsystem.domain;
/*
   Author: Juan-Lee Zidane Klink (218236883)
   Date: 15 October 2022
*/

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Cabin_Crew implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String crewId;
    private String firstName;
    private String lastName;
    private String role;
    private String staffId;
    private String flightId;


    protected Cabin_Crew() {}
    //Constructor
    private Cabin_Crew(Builder builder){
        this.id = builder.id;
        this.crewId=builder.crewId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.role = builder.role;
        this.staffId=builder.staffId;
        this.flightId=builder.flightId;
    }

    public Long getId() {
        return id;
    }
    public String getCrewId() {return crewId;}
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    public String getStaffId() {return staffId;}
    public String getFlightId() {return flightId;}


    public static class Builder {
        private Long id;
        private String crewId;
        private String firstName;
        private String lastName;
        private String role;
        private String staffId;
        private String flightId;

        public Builder setId(Long id) {
            this.id =id;
            return this;
        }
        public Builder setCrewId(String crewId) {
            this.crewId = crewId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder setStaffId(String staffId) {
            this.staffId = staffId;
            return this;
        }
        public Builder setFlightId(String flightId) {
            this.flightId = flightId;
            return this;
        }

        public Builder copy(Cabin_Crew cabin_crew){
            this.id = cabin_crew.id;
            this.crewId=cabin_crew.crewId;
            this.firstName = cabin_crew.firstName;
            this.lastName = cabin_crew.lastName;
            this.role = cabin_crew.role;
            this.staffId=cabin_crew.staffId;
            this.flightId=cabin_crew.flightId;
            return this;
        }

        public Cabin_Crew build(){
            return new Cabin_Crew(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cabin_Crew that = (Cabin_Crew) o;
        return Objects.equals(id, that.id) && Objects.equals(crewId, that.crewId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(role, that.role) && Objects.equals(staffId, that.staffId) && Objects.equals(flightId, that.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, crewId, firstName, lastName, role, staffId, flightId);
    }

    @Override
    public String toString() {
        return "Cabin_Crew{" +
                "id=" + id +
                ", crewId='" + crewId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", staffId='" + staffId + '\'' +
                ", flightId='" + flightId + '\'' +
                '}';
    }
}

