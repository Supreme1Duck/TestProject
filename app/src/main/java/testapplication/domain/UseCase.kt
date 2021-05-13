package testapplication.domain

import io.reactivex.Single
import testapplication.ui.AdditionalInfoData
import java.util.function.BiFunction

interface ICreateDocumentUseCase {
    fun execute(): Single<DocumentEntity>
}

internal class CreateDocumentUseCase(
        private val repositoryGeneralData: RepositoryGeneralData
) : ICreateDocumentUseCase {

    override fun execute(): Single<DocumentEntity> {

        return Single.zip(
            repositoryGeneralData.createDocument(),
            repositoryGeneralData.getCurrencyList(),
            repositoryGeneralData.getAccountList(),
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

interface IGetAdditionalInfo{
    fun execute() : Single<AdditionalInfoData>
}

internal class GetAdditionalInfo(
    val repositoryAdditionalData: RepositoryAdditionalData
    ) : IGetAdditionalInfo{
    override fun execute() : Single<AdditionalInfoData>{
        return Single.zip(
            repositoryAdditionalData.getCount(),
            repositoryAdditionalData.getInfo(),
            {
                count, info -> AdditionalInfoData(
                  count = count,
                  info = info
                )
            }
        )
    }
}


