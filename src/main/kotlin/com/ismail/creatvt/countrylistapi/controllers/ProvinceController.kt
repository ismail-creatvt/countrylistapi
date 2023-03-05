package com.ismail.creatvt.countrylistapi.controllers

import com.ismail.creatvt.countrylistapi.entities.Province
import com.ismail.creatvt.countrylistapi.repositories.ProvinceRepository
import com.ismail.creatvt.countrylistapi.services.ProvinceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/provinces")
class ProvinceController @Autowired constructor(private val provinceService: ProvinceService) {
    @GetMapping("/{countryId}")
    fun getProvincesByCountryId(@PathVariable countryId: Long?): List<Province?>? {
        return provinceService.getAllProvinces(countryId)
    }
}