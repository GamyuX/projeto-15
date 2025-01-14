package com.example.projeto_15

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.projeto_15.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.bottomNavigationView3.setOnItemSelectedListener {
            selecionarMenu(it)
            true
        }
    }

    private fun selecionarMenu(it: MenuItem) {
        when (it.itemId) {
            R.id.home -> replaceFragment(HomeFragment())
            R.id.colections -> replaceFragment(collectionsFragment())
            R.id.accessibilit -> replaceFragment(AccessibilitFragment())
            R.id.Exit -> finish()
            else -> {
                replaceFragment(HomeFragment())
            }
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}