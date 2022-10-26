/*
 * Mary-Beth Agulhas
 * 219082367
 * City
 */
package za.ac.cput.flightmanagementsystem.domain;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

@Entity
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String cityId;
    private String cityName;

    private String countryId;

    public City(){}

    private City(Builder builder){
        this.id=builder.id;
        this.cityId=builder.cityId;
        this.cityName=builder.cityName;
        this.countryId=builder.countryId;

    }

    public Long getId() {
        return id;
    }

    public String getCityId() {
        return cityId;
    }
    public String getCityName() {
        return cityName;
    }

    public String getCountryId() {
        return countryId;
    }




    public static class Builder {
        private Long id;
        private String cityId;
        private String cityName;
        private String countryId;

        public Builder setId(Long id)
        {
            this.id = id;
            return this;
        }
        public Builder setCityId(String cityId)
        {
            this.cityId = cityId;
            return this;
        }
        public Builder setCityName(String cityName)
        {
            this.cityName = cityName;
            return this;
        }

        public Builder setCountryId(String countryId)
        {
            this.countryId = countryId;
            return this;
        }


        public City build()
        {
            return new City(this);
        }

        private Builder Copy(City city){
            this.id=city.id;
            this.cityId=city.cityId;
            this.cityName=city.cityName;
            this.countryId=city.countryId;
            return this;

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) && Objects.equals(cityId, city.cityId) && Objects.equals(cityName, city.cityName) && Objects.equals(countryId, city.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityId, cityName, countryId);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityId='" + cityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", countryId='" + countryId + '\'' +
                '}';
    }
}
