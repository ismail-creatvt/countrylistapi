package com.ismail.creatvt.countrylistapi.entities

import jakarta.persistence.*
import org.hibernate.annotations.Formula

@Entity()
@Table(name = "country")
data class Country(
    @Id
    var id: Int = 0,
    var name: String? = null,

    @Column(name = "country_code")
    var countryCode: String? = null,

    @Column(name = "phone_code")
    var phoneCode: String? = null,
    var capital: String? = null,
    var currency: String? = null,

    @Column(name = "currency_symbol")
    var currencySymbol: String? = null,
    var region: String? = null,
    var subregion: String? = null,
    var latitude: Double = 0.0,
    var longitude: Double = 0.0,

    @Formula("(SELECT COUNT(p.id) FROM province p WHERE p.country_id = id)")
    var provincesCount:Int
)