package com.ismail.creatvt.countrylistapi.repositories

import com.ismail.creatvt.countrylistapi.entities.Country
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface CountryRepository : JpaRepository<Country?, Int?>
