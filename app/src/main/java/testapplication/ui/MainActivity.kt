package testapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import cz.septim.testapplication.R

class MainActivity : AppCompatActivity() {
    private lateinit var buttonCreate : ExtendedFloatingActionButton
    private var count : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        count = 0
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        buttonCreate = findViewById(R.id.fab)
        buttonCreate.setOnClickListener {
            count += 1
            if (count == 1) {
                buttonCreate.text = "Отправить"
                buttonCreate.icon = (ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_send_24, null))
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.main_container, firstFragment)
                            .commit()
                }
            }
            if (count == 2){
                buttonCreate.visibility = View.INVISIBLE
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.main_container, secondFragment)
                            .commit()
                }
            }
        }
    }

}