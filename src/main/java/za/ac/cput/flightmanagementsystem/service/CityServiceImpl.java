/*
 * Mary-Beth Agulhas
 * 219082367
 * CityServiceImpl
 */
package za.ac.cput.flightmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.flightmanagementsystem.domain.City;
import za.ac.cput.flightmanagementsystem.domain.Country;
import za.ac.cput.flightmanagementsystem.domain.Passenger;
import za.ac.cput.flightmanagementsystem.exception.NotFoundException;
import za.ac.cput.flightmanagementsystem.repository.ICityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl {

    private final ICityRepository repository;

    @Autowired
    public CityServiceImpl(ICityRepository repository){this.repository=repository;}

    public City addCity(City city){return repository.save(city);}

    public List<City> findAllCities(){
        return this.repository.findAll();
    }

    public City updateCity(City city){
        return repository.save(city);
    }

    public void deleteCity(Long id){
        repository.deleteById(id);

    }
    public City findCityById(Long id) {
        return repository.findCityById(id).orElseThrow(
                ()-> new NotFoundException("City by id "+id+" was not found"));
    }
    public City findCitiesByCountry(String countryId){
        return repository.findCityByCountryId(countryId).orElseThrow(
                ()-> new NotFoundException("City with Coutry ID: "+countryId+ " was not found"));

    }

}
