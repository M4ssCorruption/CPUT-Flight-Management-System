/*
Passenger.java
Passenger Entity
Author: Daniel Marais 219476845
 */
package za.ac.cput.flightmanagementsystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Passenger  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String passengerId;
    private String email;
    private String firstName;
    private String lastName;


    protected Passenger(){

    }
    private Passenger(Builder builder){
        this.id= builder.id;
        this.passengerId=builder.passengerId;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.email=builder.email;
    }


    public Long getId() {
        return id;
    }
    public String getPassengerId(){return passengerId;}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }



    public static class Builder{
        private Long id;
        private String firstName, lastName, email,passengerId;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setPassengerId(String passengerId) {
            this.passengerId = passengerId;
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

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder copy(Passenger passenger){

            this.id= passenger.id;
            this.passengerId=passenger.passengerId;
            this.firstName= passenger.firstName;
            this.lastName= passenger.lastName;
            this.email= passenger.email;
            return this;
        }
        public Passenger build(){
            return new Passenger(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(id, passenger.id) && Objects.equals(passengerId, passenger.passengerId) && Objects.equals(email, passenger.email) && Objects.equals(firstName, passenger.firstName) && Objects.equals(lastName, passenger.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passengerId, email, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", passengerId='" + passengerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
