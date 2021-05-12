package testapplication.data.mock

import io.reactivex.Single
import testapplication.domain.*

class RepositoryImpl : Repository{

    override fun getAccountList(): Single<List<String>> {
        return Single.just (
            listOf(
                "1561001903501",
                "1561001903502",
                "1561001903503",
                "1561001903504"
            )
        )
    }

    override fun createDocument(): Single<BaseDocumentEntity> {
        return Single.just(BaseDocumentEntity(1561001903505, "22.02.2021"))
    }

    override fun getCurrencyList(): Single<List<String>> {
        return Single.just(listOf("USD 11", "EUR 22", "BYN 33"))
    }
}