package br.com.cotemig.covid19.models

data class CountryHistoricoResponse(
    var Country : String = "",
    var Confirmed : Int = 0,
    var Deaths : Int = 0,
    var Recovered : Int = 0,
    var Active : Int = 0,
    var Date : String = ""
)