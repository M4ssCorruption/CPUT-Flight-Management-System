/*
 * Mary-Beth Agulhas
 * 219082367
 * CountryFactory
 */
package za.ac.cput.flightmanagementsystem.factory;

import za.ac.cput.flightmanagementsystem.domain.Country;
import za.ac.cput.flightmanagementsystem.Helper.helper;

public class CountryFactory {
    public static Country build(String countryName,String countryId)
    {

        helper.checkStringParam("countryName", countryName);
        return new Country.Builder().setCountryId(countryId).setCountryName(countryName).build();
    }

}
