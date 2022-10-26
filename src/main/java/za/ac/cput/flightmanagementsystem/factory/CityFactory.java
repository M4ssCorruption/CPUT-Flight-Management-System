/*
 * Mary-Beth Agulhas
 * 219082367
 * CityFactory
 */
package za.ac.cput.flightmanagementsystem.factory;

import za.ac.cput.flightmanagementsystem.domain.City;
import za.ac.cput.flightmanagementsystem.domain.Country;
import za.ac.cput.flightmanagementsystem.Helper.helper;

public class CityFactory {
    public static City build(String cityName, String countryId)throws IllegalArgumentException{
        helper.checkStringParam("name",cityName);
        helper.checkIfObjectNull("CountryId",countryId);
        return new City.Builder()
                .setCityName(cityName)
                .setCountryId(countryId)
                .build();
    }
}
