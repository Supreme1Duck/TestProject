package testapplication.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cz.septim.testapplication.R

class FinalActivity : AppCompatActivity() {

    private lateinit var myArray: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.final_activity)
    }
}