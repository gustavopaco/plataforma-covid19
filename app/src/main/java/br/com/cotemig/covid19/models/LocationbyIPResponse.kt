package br.com.cotemig.covid19.models

data class LocationbyIPResponse(
    var country : String = "",
    var countryCode : String = "",
    var region : String = "",
    var regionName : String = "",
    var city : String = "",
    var isp : String = "",
    var org : String = "",
    var query : String = ""
)