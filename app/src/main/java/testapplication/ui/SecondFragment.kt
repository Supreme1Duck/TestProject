package testapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import cz.septim.testapplication.R

class SecondFragment : Fragment(R.layout.second_fragment) {

    private lateinit var myArray: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}