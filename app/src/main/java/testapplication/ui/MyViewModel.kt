package testapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import testapplication.domain.*

class MyViewModel(
   document: ICreateDocumentUseCase
) : ViewModel() {
    private val _documentLiveData = MutableLiveData<DocumentEntity>()
    private val disposable = CompositeDisposable()
    val documentLiveData : LiveData<DocumentEntity> = _documentLiveData

    init {
        disposable.add(
            document.execute()
                .subscribe{ doc -> _documentLiveData.value = doc}
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}