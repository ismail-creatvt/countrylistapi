package com.ismail.creatvt.countrylistapi.mapper

import com.ismail.creatvt.countrylistapi.csv.CsvProvince
import com.ismail.creatvt.countrylistapi.entities.Province
import com.ismail.creatvt.countrylistapi.repositories.CountryRepository

class CsvProvinceMapper {

    companion object{
        fun map(countryRepository: CountryRepository, csvProvince: CsvProvince):Province {
            return Province(
                csvProvince.id,
                csvProvince.name,
                countryRepository.findById(csvProvince.countryId?:-1).get(),
                csvProvince.provinceCode,
                csvProvince.countryCode,
                csvProvince.latitude,
                csvProvince.longitude
            )
        }
    }
}
