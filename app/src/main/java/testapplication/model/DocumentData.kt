package testapplication.model

object DocumentData {

    val currency = mutableMapOf(11 to "EUR", 22 to "USD", 33 to "BYN")

    const val date = "15.05.2021"

    const val docNum = 113314531233

    val accCounts = listOf("100150713501",
            "100150713502",
            "100150713501",
            "100150713504")

    data class Documentation(val docNum: Long, val date: String)
    data class Analytic(val currencyList: List<String?>)
}