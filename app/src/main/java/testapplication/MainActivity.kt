package testapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import cz.septim.testapplication.R
import testapplication.activities.SecondActivity

class MainActivity : AppCompatActivity() {
    lateinit var buttonCreate : ExtendedFloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCreate = findViewById(R.id.fab)
        buttonCreate.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

}