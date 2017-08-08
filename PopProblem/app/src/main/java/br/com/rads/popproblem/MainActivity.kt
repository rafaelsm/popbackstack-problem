package br.com.rads.popproblem

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_fragment_button.setOnClickListener {
            addFragment()
            it.isEnabled = false
        }
    }

    private fun addFragment() {
        supportFragmentManager.beginTransaction()
                .add(R.id.container, MyFragment.Companion.newInstance(), "MY_FRAGMENT")
                .addToBackStack(null)
                .commitAllowingStateLoss()
    }
}
