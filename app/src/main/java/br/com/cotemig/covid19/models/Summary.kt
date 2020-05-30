package br.com.cotemig.covid19.models

data class Summary (
    var Global: Global,
    var Countries: List<Country>
)