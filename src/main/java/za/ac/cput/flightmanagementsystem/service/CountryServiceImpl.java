/*
 * Mary-Beth Agulhas
 * 219082367
 * CountryServieImpl
 */
package za.ac.cput.flightmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.flightmanagementsystem.domain.Country;
import za.ac.cput.flightmanagementsystem.domain.Ticket;
import za.ac.cput.flightmanagementsystem.exception.NotFoundException;
import za.ac.cput.flightmanagementsystem.repository.ICountryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl {
    private final ICountryRepository repository;

    @Autowired
    public CountryServiceImpl(ICountryRepository repository)
    {this.repository=repository;}


    public Country addCountry(Country country){
        return repository.save(country);}

    public List<Country> findAllCountries(){ return this.repository.findAll(); }

    public Country updateCountry(Country country){
        return repository.save(country);
    }
    public void deleteCountry(Long id){repository.deleteById(id);}

    public Country findCountryById(Long id){return repository.findCountryById(id).orElseThrow(
            ()->new NotFoundException("Country by id "+id+" was not found"));
    }
    public Country findCountryByCountryId(String countryId){
        return repository.findCountriesByCountryId(countryId).orElseThrow(
                ()->new NotFoundException("Country by Country ID: "+countryId+" was not found"));
    }







}
