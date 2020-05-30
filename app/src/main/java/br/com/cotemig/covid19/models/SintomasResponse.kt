package br.com.cotemig.covid19.models

data class SintomasResponse(
    var sintomascomuns : List<String>,
    var sintomasraros : List<String>,
    var sintomasgraves : List<String>,
    var recomendacoes: List<String>,
    var temposintomas : String = ""
)