package testapplication.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import cz.septim.testapplication.R
import testapplication.viewmodel.MyViewModel

class SecondActivity : AppCompatActivity() {
    private lateinit var edDocnum: EditText
    private lateinit var edDate: EditText
    private lateinit var edSumm: EditText
    private lateinit var spinCurrency: Spinner
    private lateinit var spinCount: Spinner
    private lateinit var fab :ExtendedFloatingActionButton
    private lateinit var viewModel : MyViewModel
    private lateinit var arrayDocNumAdapter : ArrayAdapter<String>
    private lateinit var arrayCurrAdapter : ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        viewModel = MyViewModel()
        arrayDocNumAdapter = ArrayAdapter(this, R.layout.spinner_item, viewModel.getAccountList())
        arrayCurrAdapter = ArrayAdapter(this, R.layout.spinner_item, viewModel.getAnalytic().currencyList)
        createWidgets()
        fillWidgets()
        fab.setOnClickListener {
            startActivity(Intent(this, FinalActivity::class.java))
        }
    }

    private fun createWidgets(){
        edDocnum = findViewById(R.id.edit_docnum)
        edDate = findViewById(R.id.edit_date)
        edSumm = findViewById(R.id.edit_summ)
        spinCurrency = findViewById(R.id.spin_val)
        spinCount = findViewById(R.id.spin_count)
        spinCount.adapter = arrayDocNumAdapter
        spinCurrency.adapter = arrayCurrAdapter
        fab = findViewById(R.id.fab_2)
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