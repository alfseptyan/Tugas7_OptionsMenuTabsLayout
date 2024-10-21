package com.example.tugas7_optionsmenutabslayout

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas7_optionsmenutabslayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        @StringRes
        private val tabName = intArrayOf(
            R.string.tab_text_1,  // Ensure these string resources are defined in your strings.xml
            R.string.tab_text_2
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            setSupportActionBar(toolbar)
            // Set the adapter for the ViewPager
            viewPager.adapter = SectionsPagerAdapter(this@MainActivity)
            // Connect the TabLayout with the ViewPager
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = resources.getString(tabName[position])
            }.attach()
        }
    }
}
