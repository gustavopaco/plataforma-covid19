package br.com.cotemig.covid19.models

data class CasosEstados(
    var uf : String = "",
    var state : String = "",
    var cases : Int = 0,
    var deaths : Int = 0,
    var suspects : Int = 0,
    var refuses : Int = 0
)