package testapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import cz.septim.testapplication.R
import org.koin.android.viewmodel.ext.android.viewModel

class FirstFragment : Fragment() {
    private lateinit var edDocnum: EditText
    private lateinit var edDate: EditText
    private lateinit var edSumm: EditText
    private lateinit var edInfo: EditText
    private lateinit var edCount: EditText
    private lateinit var spinCurrency: Spinner
    private lateinit var spinCount: Spinner
    private lateinit var buttonTap: Button
    private val myViewModel : MyViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.first_fragment,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edDocnum = view.findViewById(R.id.edit_docnum)
        edDate = view.findViewById(R.id.edit_date)
        edSumm = view.findViewById(R.id.edit_summ)
        edInfo = view.findViewById(R.id.edit_info)
        edCount = view.findViewById(R.id.edit_count)
        spinCurrency = view.findViewById(R.id.spin_val)
        spinCount = view.findViewById(R.id.spin_count)
        buttonTap = view.findViewById(R.id.button_tap)
        onButtonTapClickListener()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        myViewModel.documentLiveData.observe(this) {
            spinCount.adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, it.account)
            spinCurrency.adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, it.currency)
            edDocnum.setText(it.docNumber.toString())
            edDate.setText(it.date)
            edSumm.setText("0")
        }
        myViewModel.infoLiveData.observe(this, {
            edCount.setText(it.count.toString())
            edInfo.setText(it.info)
        })
    }

    fun onButtonTapClickListener(){
        buttonTap.setOnClickListener {
            myViewModel.plusOneToSum(myViewModel.infoLiveData.value!!.info,
                myViewModel.infoLiveData.value!!.count)
        }
    }
}