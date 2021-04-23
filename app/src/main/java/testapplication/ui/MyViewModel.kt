package testapplication.ui

import androidx.lifecycle.ViewModel
import testapplication.domain.*
import testapplication.ui.DocumentData

class MyViewModel(
    private val createDocumentUseCase : ICreateDocumentUseCase,
    private val getCurrencyCodeUseCase: IGetCurrencyCodeUseCase,
    private val getAccountListUseCase : IGetAccountListUseCase
) : ViewModel() {

    fun createDocument(): BaseDocumentEntity {
        return createDocumentUseCase.execute()
    }

    fun getAccountList(): InformationEntity {
        return getAccountListUseCase.execute()
    }

    fun getAnalytic(): List<CurrencyEntity> {
        return getCurrencyCodeUseCase.execute()
    }
}