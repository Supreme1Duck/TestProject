package testapplication.domain

import io.reactivex.Single
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function3
import testapplication.data.mock.RepositoryImpl

interface ICreateDocumentUseCase {
    fun execute(): Single<DocumentEntity>
}

internal class CreateDocumentUseCase(
        private val repository: Repository
) : ICreateDocumentUseCase {

    override fun execute(): Single<DocumentEntity> {

        return Single.zip(
            repository.createDocument(),
            repository.getCurrencyList(),
            repository.getAccountList(),
            {
                document, currency, account ->
                DocumentEntity(
                    docNumber = document.docNumber,
                    date = document.date,
                    currency = currency,
                    account = account,
                )
            }
        )
    }
}


