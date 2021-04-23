package testapplication.domain

interface Repository {

    fun getAccountList(): InformationEntity

    fun createDocument(): BaseDocumentEntity

    fun getCurrencyList(): List<CurrencyEntity>

}