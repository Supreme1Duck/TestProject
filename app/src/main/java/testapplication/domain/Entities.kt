package testapplication.domain

data class DocumentEntity(
        val docNumber: Long,
        val date: String,
        val account: List<String>,
        val currency: List<String>,
        val amount: Int
)

data class BaseDocumentEntity(
        val docNumber: Long,
        val date: String
)

// data class CurrencyEntity(
//        val code: Int,
//        val currencyName: String
// )