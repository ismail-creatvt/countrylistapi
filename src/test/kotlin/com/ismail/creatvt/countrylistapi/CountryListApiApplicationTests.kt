package com.ismail.creatvt.countrylistapi

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
	properties = [
		"spring.datasource.url=jdbc:mysql:mem:testdb"
	]
)
class CountryListApiApplicationTests {

	@Test
	fun contextLoads() {
	}

}
