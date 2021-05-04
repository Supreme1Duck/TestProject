package testapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import cz.septim.testapplication.R
import testapplication.data.mock.RepositoryImpl
import testapplication.domain.CreateDocumentUseCase

class FirstFragment : Fragment() {
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
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = MyViewModel(CreateDocumentUseCase(repository = RepositoryImpl()))

        viewModel.onAccountsClick().observe(this) {
            spinCount.adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, it.account)
            spinCurrency.adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, it.currency)
            edDocnum.setText(it.docNumber.toString())
            edDate.setText(it.date)
            edSumm.setText("0")
        }

        //spinCount.setOnItemClickListener(){
        //   viewModel.onAccountsClick()
        //}
    }
}