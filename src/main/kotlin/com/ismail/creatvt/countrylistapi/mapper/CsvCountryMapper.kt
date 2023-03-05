package com.ismail.creatvt.countrylistapi.mapper

import com.ismail.creatvt.countrylistapi.entities.Country
import com.ismail.creatvt.countrylistapi.csv.CsvCountry

class CsvCountryMapper {

    companion object {
        fun map(csvCountry: CsvCountry): Country {
            return Country(
                csvCountry.id,
                csvCountry.name,
                csvCountry.countryCode,
                csvCountry.phoneCode,
                csvCountry.capital,
                csvCountry.currency,
                csvCountry.currencySymbol,
                csvCountry.region,
                csvCountry.subregion,
                csvCountry.latitude,
                csvCountry.longitude,
                0
            )
        }
    }
}