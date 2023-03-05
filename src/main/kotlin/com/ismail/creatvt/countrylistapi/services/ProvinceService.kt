package com.ismail.creatvt.countrylistapi.services

import com.ismail.creatvt.countrylistapi.entities.Country
import com.ismail.creatvt.countrylistapi.entities.Province
import com.ismail.creatvt.countrylistapi.repositories.ProvinceRepository
import org.springframework.stereotype.Service

@Service
class ProvinceService(private val provinceRepository: ProvinceRepository) {

    fun getAllProvinces(countryId: Long?) = provinceRepository.findByCountryId(countryId)

}