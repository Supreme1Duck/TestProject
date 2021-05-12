package testapplication.domain

data class DocumentEntity(
        val docNumber: Long,
        val date: String,
        val account: List<String>,
        val currency: List<String>,
)

data class BaseDocumentEntity(
        val docNumber: Long,
        val date: String
)