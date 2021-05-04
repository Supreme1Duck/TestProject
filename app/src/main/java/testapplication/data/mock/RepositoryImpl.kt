package testapplication.data.mock

import testapplication.domain.*

class RepositoryImpl : Repository{
    override fun getAccountList(): List<String> {
        return listOf("1561001903501","1561001903502", "1561001903503", "1561001903504")
    }

    override fun createDocument(): BaseDocumentEntity {
        return BaseDocumentEntity(1561001903505, "22.02.2021")
    }

    override fun getCurrencyList(): List<String> {
        return listOf("USD 11", "EUR 22", "BYN 33")
    }
}