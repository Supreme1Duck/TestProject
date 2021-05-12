package testapplication.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import testapplication.domain.*
import java.util.function.BiConsumer

class MyViewModel(
   document: ICreateDocumentUseCase
) : ViewModel() {
    private val _documentLiveData = MutableLiveData<DocumentEntity>()
    private val disposable = CompositeDisposable()
    val documentLiveData : LiveData<DocumentEntity> = _documentLiveData

    init {
        disposable.add(
            document.execute()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { doc -> _documentLiveData.value = doc},
                    { e -> Log.d("error", e.printStackTrace().toString())}
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}