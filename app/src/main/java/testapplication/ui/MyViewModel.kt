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
   document: ICreateDocumentUseCase,
   infoData: IGetAdditionalInfo
) : ViewModel() {
    private val _documentLiveData = MutableLiveData<DocumentEntity>()
    private val disposable = CompositeDisposable()
    val documentLiveData : LiveData<DocumentEntity> = _documentLiveData
    private val _infoLiveData = MutableLiveData<AdditionalInfoData>()
    val infoLiveData : LiveData<AdditionalInfoData> = _infoLiveData

    init {
        disposable.add(
            document.execute()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { doc ->
                    _documentLiveData.value = doc
                }
        )
        disposable.add(
            infoData.execute()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{ data ->
                    _infoLiveData.value = data
                }
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}