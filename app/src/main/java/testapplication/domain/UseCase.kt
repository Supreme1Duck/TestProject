package testapplication.domain

interface ICreateDocumentUseCase {
    fun execute(): DocumentEntity
}

internal class CreateDocumentUseCase(
        private val repository: Repository
) : ICreateDocumentUseCase {

    override fun execute(): DocumentEntity {

        return DocumentEntity(
                repository.createDocument(),
                repository.createDocument(),
                repository.getAccountList(),
                repository.getCurrencyList(),
                0
        )
    }
}


