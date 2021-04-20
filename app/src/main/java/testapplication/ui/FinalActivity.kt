package testapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import cz.septim.testapplication.R

class SecondFragment : Fragment(R.layout.final_activity) {

    private lateinit var myArray: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}