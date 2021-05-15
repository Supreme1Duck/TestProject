package testapplication.domain

import io.reactivex.Single

interface RepositoryGeneralData {

    fun getAccountList(): Single<List<String>>

    fun createDocument(): Single<BaseDocumentEntity>

    fun getCurrencyList(): Single<List<String>>
}