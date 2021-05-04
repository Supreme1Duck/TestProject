package testapplication.data.mock

import io.reactivex.Single
import io.reactivex.SingleOnSubscribe
import testapplication.domain.*

class RepositoryImpl : Repository{
    override fun getAccountList(): Single<List<String>> {
        return Single.create {
            it.onSuccess(listOf("1561001903501", "1561001903502", "1561001903503", "1561001903504"))
            it.onError(Throwable("Error occured in method getAccountList()"))
        }
    }


    override fun createDocument(): Single<BaseDocumentEntity> {
        return Single.create{
            it.onSuccess(BaseDocumentEntity(1561001903505, "22.02.2021"))
            it.onError(Throwable("Error occured in method createDocument()"))
        }
    }

    override fun getCurrencyList(): Single<List<String>> {
        return Single.create{
            it.onSuccess(listOf("USD 11", "EUR 22", "BYN 33"))
            it.onError(Throwable("Error occured in method getCurrencyList()"))
        }
    }
}