package com.ismail.creatvt.countrylistapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

@SpringBootApplication
class CountryListApiApplication

fun main(args: Array<String>) {
	runApplication<CountryListApiApplication>(*args)
}
