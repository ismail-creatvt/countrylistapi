package com.ismail.creatvt.countrylistapi

import com.ismail.creatvt.countrylistapi.entities.Country
import com.ismail.creatvt.countrylistapi.csv.CsvCountry
import com.ismail.creatvt.countrylistapi.csv.CsvProvince
import com.ismail.creatvt.countrylistapi.entities.Province
import com.ismail.creatvt.countrylistapi.mapper.CsvCountryMapper
import com.ismail.creatvt.countrylistapi.mapper.CsvProvinceMapper
import com.ismail.creatvt.countrylistapi.repositories.CountryRepository
import com.ismail.creatvt.countrylistapi.repositories.ProvinceRepository
import com.opencsv.bean.CsvToBean
import com.opencsv.bean.CsvToBeanBuilder
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import java.io.File
import java.io.FileReader
import java.io.IOException

@Component
@Order(1)
@Slf4j
class CsvDataInitializer @Autowired constructor(
    countryRepository: CountryRepository,
    provinceRepository: ProvinceRepository
) : CommandLineRunner {
    private val countryRepository: CountryRepository
    private val provinceRepository: ProvinceRepository

    init {
        this.countryRepository = countryRepository
        this.provinceRepository = provinceRepository
    }

    @Throws(Exception::class)
    override fun run(vararg args: String?) {
        initializeDataFromCsv()
    }

    @Throws(IOException::class)
    private fun initializeDataFromCsv() {
        // Read countries.csv and initialize the Country table
        val countriesFile = File(javaClass.classLoader.getResource("countries.csv")?.file ?: return)
        val countryReader = FileReader(countriesFile)

        val countryCsvToBean: CsvToBean<CsvCountry> = CsvToBeanBuilder<CsvCountry>(countryReader)
            .withType(CsvCountry::class.java)
            .withIgnoreLeadingWhiteSpace(true)
            .build()
        val countries: List<Country> = countryCsvToBean.parse().map {
            CsvCountryMapper.map(it)
        }
        countryRepository.saveAll(countries)
        println("Inserted ${countries.size} countries to Database")

        // Read provinces.csv and initialize the Province table
        val provinceFile = File(javaClass.classLoader.getResource("provinces.csv")?.file ?: return)
        val provinceReader = FileReader(provinceFile)

        val provinceCsvToBean: CsvToBean<CsvProvince> = CsvToBeanBuilder<CsvProvince>(provinceReader)
            .withType(CsvProvince::class.java)
            .withIgnoreLeadingWhiteSpace(true)
            .build()
        val provinces: List<Province> =
            provinceCsvToBean.parse().map { CsvProvinceMapper.map(countryRepository, it) }
        provinceRepository.saveAll(provinces)
        println("Inserted ${provinces.size} provinces to Database")
    }
}
