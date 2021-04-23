package testapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import cz.septim.testapplication.R
import testapplication.data.mock.RepositoryImpl
import testapplication.domain.CreateDocumentUseCase
import testapplication.domain.GetAccountListUseCase
import testapplication.domain.GetCurrencyCodeUseCase

class FirstFragment : Fragment(R.layout.first_fragment) {
    private lateinit var edDocnum: EditText
    private lateinit var edDate: EditText
    private lateinit var edSumm: EditText
    private lateinit var spinCurrency: Spinner
    private lateinit var spinCount: Spinner
    private lateinit var viewModel : MyViewModel
    private lateinit var arrayDocNumAdapter : ArrayAdapter<String>
    private lateinit var arrayCurrAdapter : ArrayAdapter<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.first_fragment,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edDocnum = view.findViewById(R.id.edit_docnum)
        edDate = view.findViewById(R.id.edit_date)
        edSumm = view.findViewById(R.id.edit_summ)
        spinCurrency = view.findViewById(R.id.spin_val)
        spinCount = view.findViewById(R.id.spin_count)
        viewModel = MyViewModel(CreateDocumentUseCase(createDocument = RepositoryImpl()::createDocument),
            GetCurrencyCodeUseCase(getCurrencyList = RepositoryImpl()::getCurrencyList),
            GetAccountListUseCase(getAccountList = RepositoryImpl()::getAccountList)
        )

        spinCount.adapter = ArrayAdapter(requireContext(), 0, viewModel.getAccountList().docNumber)
        val arr = viewModel.getAnalytic()
        spinCurrency.adapter = ArrayAdapter(requireContext(), 0, listOf(arr[0].toString(),
                arr[1].toString(),
                arr[2].toString())
        )

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}