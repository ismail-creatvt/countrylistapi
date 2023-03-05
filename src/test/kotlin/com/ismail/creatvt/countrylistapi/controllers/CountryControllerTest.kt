import com.ismail.creatvt.countrylistapi.controllers.CountryController
import com.ismail.creatvt.countrylistapi.entities.Country
import com.ismail.creatvt.countrylistapi.services.CountryService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito.*
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.InputStreamResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatusCode
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import java.io.IOException

class CountryControllerTest {

    private val countryService = mock(CountryService::class.java)
    private val countryController = CountryController(countryService)

    @Test
    fun testGetAllCountries() {
        // Arrange
        val countries = listOf(
            Country(1,"Afghanistan","AF","93","Kabul","AFN","؋","Asia","Southern Asia",33.0,65.0, 33),
            Country(2,"Aland Islands","AX","340","Mariehamn","EUR","€","Europe","Northern Europe",60.116667,19.9, 9)
        )
        `when`(countryService.allCountries).thenReturn(countries)

        // Act
        val result = countryController.allCountries

        // Assert
        assertEquals(countries, result)
        verify(countryService).allCountries
    }

    @Test
    fun testGetFlagSuccess() {
        // Arrange
        val imageName = "us"
        val size = "32"
        val expectedResource = spy(ClassPathResource("flags/${size}x${size}/$imageName.png"))
        `when`(expectedResource.exists()).thenReturn(true)

        // Act
        val result = countryController.getFlag(imageName, size)

        // Assert
        assertEquals(
            ResponseEntity.ok()
                .headers(HttpHeaders().apply {
                    contentType = MediaType.IMAGE_PNG
                })
                .body(InputStreamResource(expectedResource.inputStream)).statusCode, result.statusCode
        )
        verify(expectedResource).exists()
    }

    @Test
    fun testGetFlagNotFound() {
        // Arrange
        val imageName = "invalid"
        val size = "32"
        val expectedResource = spy(ClassPathResource("flags/${size}x${size}/$imageName.png"))
        `when`(expectedResource.exists()).thenReturn(false)

        // Act
        val result = countryController.getFlag(imageName, size)

        // Assert
        assertEquals(ResponseEntity.notFound().build<Resource>(), result)
        verify(expectedResource).exists()
    }
}
