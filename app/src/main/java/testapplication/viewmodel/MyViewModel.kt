package testapplication.viewmodel

import androidx.lifecycle.ViewModel
import testapplication.model.DocumentData

class MyViewModel : ViewModel() {

    fun createDocument(): DocumentData.Documentation {
       return DocumentData.Documentation(DocumentData.docNum, DocumentData.date)
    }

    fun getAccountList(): List<String> {
        return DocumentData.accCounts
    }

    fun getAnalytic(): DocumentData.Analytic{
        return DocumentData.Analytic(listOf(DocumentData.currency[11], DocumentData.currency[22], DocumentData.currency[33]))
    }
}