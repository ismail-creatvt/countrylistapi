package com.ismail.creatvt.countrylistapi.csv

import com.opencsv.bean.CsvBindByName

data class CsvCountry(

    @CsvBindByName
    var id: Int = 0,

    @CsvBindByName
    var name: String? = null,

    @CsvBindByName(column = "country_code")
    var countryCode: String? = null,

    @CsvBindByName(column = "phone_code")
    var phoneCode: String? = null,

    @CsvBindByName
    var capital: String? = null,

    @CsvBindByName
    var currency: String? = null,

    @CsvBindByName(column = "currency_symbol")
    var currencySymbol: String? = null,

    @CsvBindByName
    var region: String? = null,

    @CsvBindByName
    var subregion: String? = null,

    @CsvBindByName
    var latitude: Double = 0.0,

    @CsvBindByName
    var longitude: Double = 0.0

)