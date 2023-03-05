package com.ismail.creatvt.countrylistapi.csv

import com.opencsv.bean.CsvBindByName

data class CsvProvince(
    @CsvBindByName
    var id: Long? = null,

    @CsvBindByName
    var name: String? = null,

    @CsvBindByName(column = "country_id")
    var countryId: Int? = null,

    @CsvBindByName(column = "province_code")
    var provinceCode: String? = null,

    @CsvBindByName(column = "country_code")
    var countryCode: String? = null,

    @CsvBindByName
    var latitude: Double? = null,

    @CsvBindByName
    var longitude: Double? = null
)