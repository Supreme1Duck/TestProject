package testapplication.domain

interface Repository {

    fun getAccountList(): List<String>

    fun createDocument(): BaseDocumentEntity

    fun getCurrencyList(): List<String>

}