package testapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import testapplication.domain.*

class MyViewModel(
   private val document: ICreateDocumentUseCase
) : ViewModel() {

    fun onAccountsClick(): MutableLiveData<DocumentEntity>{
        _accountsList.value = document.execute()
        return _accountsList
    }

    private val _accountsList = MutableLiveData<DocumentEntity>()
}