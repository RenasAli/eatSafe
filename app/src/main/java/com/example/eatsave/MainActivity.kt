package com.example.eatsave

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.eatsave.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Scanner())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.scanner -> {
                    replaceFragment(Scanner())
                }
                R.id.groups -> {
                    replaceFragment(settings())
                }
                R.id.wallet -> {
                    replaceFragment(Wallet())
                }

            }
            true
        }
    }
    private fun replaceFragment( fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}