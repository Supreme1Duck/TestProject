package testapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import cz.septim.testapplication.R

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
        arrayDocNumAdapter = ArrayAdapter(context!!, R.layout.spinner_item, viewModel.getAccountList())
        arrayCurrAdapter = ArrayAdapter(context!!, R.layout.spinner_item, viewModel.getAnalytic().currencyList)
        spinCount.adapter = arrayDocNumAdapter
        spinCurrency.adapter = arrayCurrAdapter
        fillWidgets()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = MyViewModel()
    }

    private fun fillWidgets(){
        edDocnum.setText(viewModel.createDocument().docNum.toString(), TextView.BufferType.EDITABLE)
        edDate.setText(viewModel.createDocument().date, TextView.BufferType.EDITABLE)
    }

    // For the future usage

    //fun getValues() : Array<String>{
    //    return arrayOf(edDocnum.toString(), edDate.toString(), edSumm.toString(),
    //            spinCurrency.selectedItem.toString(),
    //            spinAccNumber.selectedItem.toString())
    //}

}