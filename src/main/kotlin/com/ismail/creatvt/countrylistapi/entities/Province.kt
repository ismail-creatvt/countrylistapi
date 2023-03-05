package com.ismail.creatvt.countrylistapi.entities

import jakarta.persistence.*

@Entity
@Table(name = "province")
data class Province(
    @Id
    var id: Long? = null,

    @Column(name = "name")
    var name: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    var country: Country? = null,

    @Column(name = "province_code")
    var provinceCode: String? = null,

    @Column(name = "country_code")
    var countryCode: String? = null,

    @Column(name = "latitude")
    var latitude: Double? = null,

    @Column(name = "longitude")
    var longitude: Double? = null
)

