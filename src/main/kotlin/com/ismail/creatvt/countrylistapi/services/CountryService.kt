package com.ismail.creatvt.countrylistapi.services

import com.ismail.creatvt.countrylistapi.entities.Country
import com.ismail.creatvt.countrylistapi.repositories.CountryRepository
import org.springframework.stereotype.Service

@Service
class CountryService(private val countryRepository: CountryRepository) {

    val allCountries: List<Country?>
        get() = countryRepository.findAll()

}
