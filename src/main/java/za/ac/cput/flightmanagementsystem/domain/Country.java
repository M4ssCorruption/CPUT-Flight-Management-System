/*
 * Mary-Beth Agulhas
 * 219082367
 * Country
 */
package za.ac.cput.flightmanagementsystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Country implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String countryId;
    private String countryName;

    protected Country(){

    }


    private Country(Builder builder) {
        this.id = builder.id;
        this.countryId=builder.countryId;
        this.countryName = builder.countryName;
    }

    public Long getId() {
        return id;
    }

    public String getCountryId(){return countryId;}
    public String getCountryName() {
        return countryName;
    }



    public static class Builder {

        private Long id;
        private String countryId;
        private String countryName;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }
        public Builder setCountryId(String countryId){
            this.countryId=countryId;
            return this;
        }

        public Builder setCountryName(String countryName) {
            this.countryName = countryName;
            return this;
        }

        public Builder copy(Country country) {
            this.id = country.id;
            this.countryName = country.countryName;
            return this;
        }

        public Country build() {
            return new Country(this);
        }

        private Builder Copy(Country country) {
            this.id = country.id;
            this.countryId=country.countryId;
            this.countryName = country.countryName;
            return this;
        }
    }
}
