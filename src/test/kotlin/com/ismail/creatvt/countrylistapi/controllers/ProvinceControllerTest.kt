package com.ismail.creatvt.countrylistapi.controllers

import com.ismail.creatvt.countrylistapi.entities.Province
import com.ismail.creatvt.countrylistapi.services.ProvinceService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class ProvinceControllerTest {

    @Test
    fun testGetProvincesByCountryId() {
        // Arrange
        val mockProvinceService = mock(ProvinceService::class.java)
        val controller = ProvinceController(mockProvinceService)
        val countryId = 1L
        val expectedProvinces = listOf(
            Province(id = 1, name = "Province A"),
            Province(id = 2, name = "Province B")
        )
        `when`(mockProvinceService.getAllProvinces(countryId)).thenReturn(expectedProvinces)

        // Act
        val result = controller.getProvincesByCountryId(countryId)

        // Assert
        assertNotNull(result)
        assertEquals(expectedProvinces, result)
        verify(mockProvinceService).getAllProvinces(countryId)
    }

    @Test
    fun testGetProvincesByInvalidCountryId() {
        // Arrange
        val mockProvinceService = mock(ProvinceService::class.java)
        val controller = ProvinceController(mockProvinceService)
        val countryId = -1L
        `when`(mockProvinceService.getAllProvinces(countryId)).thenReturn(emptyList())

        // Act
        val result = controller.getProvincesByCountryId(countryId)

        // Assert
        assertNotNull(result)
        assertTrue(result.isNullOrEmpty())
        verify(mockProvinceService).getAllProvinces(countryId)
    }

    @Test
    fun testGetProvincesByInvalidCountryIdReturnsNotFound() {
        // Arrange
        val mockProvinceService = mock(ProvinceService::class.java)
        val controller = ProvinceController(mockProvinceService)
        val countryId = -1L
        `when`(mockProvinceService.getAllProvinces(countryId)).thenReturn(null)

        // Act
        val result = controller.getProvincesByCountryId(countryId)

        // Assert
        assertNull(result)
        verify(mockProvinceService).getAllProvinces(countryId)
    }

}