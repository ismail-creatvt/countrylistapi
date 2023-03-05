package com.ismail.creatvt.countrylistapi.repositories

import com.ismail.creatvt.countrylistapi.entities.Province
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProvinceRepository : JpaRepository<Province?, Long?> {
    fun findByCountryId(countryId: Long?): List<Province?>?
}