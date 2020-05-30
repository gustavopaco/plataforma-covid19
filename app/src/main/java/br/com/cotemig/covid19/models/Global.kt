package br.com.cotemig.covid19.models

data class Global(
    var NewConfirmed: Int = 0,
    var TotalConfirmed: Int = 0,
    var NewDeaths: Int = 0,
    var TotalDeaths: Int = 0,
    var NewRecovered: Int = 0,
    var TotalRecovered: Int = 0
)