package testapplication.data.mock

import testapplication.domain.*

class RepositoryImpl : Repository{
    override fun getAccountList(): InformationEntity {
        return InformationEntity(listOf(1561001903501,1561001903502, 1561001903503, 1561001903504))
    }

    override fun createDocument(): BaseDocumentEntity {
        return BaseDocumentEntity(1561001903505, "22.02.2021")
    }

    override fun getCurrencyList(): List<CurrencyEntity> {
        return listOf(CurrencyEntity(11, "USD"), CurrencyEntity(22, "EUR"), CurrencyEntity(33, "BYN"))
    }
}