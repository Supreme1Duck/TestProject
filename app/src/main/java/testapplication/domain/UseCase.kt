package testapplication.domain

interface ICreateDocumentUseCase {
    fun execute() : BaseDocumentEntity
}

interface IGetCurrencyCodeUseCase{
    fun execute(): List<CurrencyEntity>
}

interface IGetAccountListUseCase{
    fun execute(): InformationEntity
}

internal class CreateDocumentUseCase(
        private val createDocument: () -> BaseDocumentEntity
): ICreateDocumentUseCase{

    override fun execute() : BaseDocumentEntity{
        return createDocument.invoke()
    }
}

internal class GetCurrencyCodeUseCase(
        private val getCurrencyList: () -> List<CurrencyEntity>
): IGetCurrencyCodeUseCase{

    override fun execute() : List<CurrencyEntity> {
        return getCurrencyList.invoke()
    }
}


internal class GetAccountListUseCase(
        private val getAccountList: () -> InformationEntity
): IGetAccountListUseCase{

    override fun execute() : InformationEntity {
        return getAccountList.invoke()
    }
}


