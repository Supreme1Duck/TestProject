package testapplication.domain

data class DocumentEntity(
        val docNumber: Long,
        val date: String,
        val account: String,
        val currency: String,
        val currencyCode: Int,
        val amount: Int
)

data class InformationEntity(
        val docNumber: List<Long>
)

data class BaseDocumentEntity(
        val docNumber: Long,
        val date: String
)

data class CurrencyEntity(
        val code: Int,
        val currencyName: String
)