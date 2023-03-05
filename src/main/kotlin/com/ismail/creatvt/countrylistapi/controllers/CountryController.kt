package com.ismail.creatvt.countrylistapi.controllers

import com.ismail.creatvt.countrylistapi.entities.Country
import com.ismail.creatvt.countrylistapi.services.CountryService
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.InputStreamResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.File
import java.io.IOException


@RestController
@RequestMapping("/countries")
class CountryController(countryService: CountryService) {
    private val countryService: CountryService

    init {
        this.countryService = countryService
    }

    @get:GetMapping
    val allCountries: List<Country?>
        get() = countryService.allCountries

    @GetMapping("/flag/{imageName}/{size}")
    @kotlin.jvm.Throws(IOException::class)
    fun getFlag(@PathVariable imageName:String, @PathVariable size:String): ResponseEntity<Resource> {
        val resource = ClassPathResource("flags/${size}x${size}/$imageName.png")

        return if (resource.exists()) {
            val headers = HttpHeaders()
            headers.contentType = MediaType.IMAGE_JPEG
            ResponseEntity.ok().headers(headers)
                .body(InputStreamResource(resource.inputStream))
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
