package com.example.capstone.sibaca.ui.landing

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.capstone.sibaca.R
import com.example.capstone.sibaca.WelcomeActivity

class LandingPageActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: LandingPagerAdapter
    private lateinit var nextButton: ImageView

    private val descriptions = arrayOf(
        "Sibaca. \n" +
                "Sistem Baca Cerdas (Aplikasi Pengenal Huruf & Angka) merupakan solusi terbaik yang dapat digunakan untuk mengurangi urgensi dengan membuat aplikasi membaca yang berfokus pada pengenalan teks dan angka.",
        "Sibaca siap membantu mengurangi kesulitanmu dalam membaca. Temukan keajaiban belajar dan nikmati pengalaman yang menyenangkan dengan Sibaca. Yuk, mari bersama-sama memperluas wawasan dan meningkatkan kemampuan literasi kita!"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        viewPager = findViewById(R.id.viewPager)
        nextButton = findViewById(R.id.nextButton)

        adapter = LandingPagerAdapter(descriptions)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == descriptions.size - 1) {
                    nextButton.visibility = View.VISIBLE
                } else {
                    nextButton.visibility = View.GONE
                }
            }
        })

        nextButton.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            if (viewPager.currentItem < descriptions.size - 1) {
                viewPager.currentItem += 1
            } else {
                // Tampilkan layar berikutnya atau lakukan tindakan lain
            }
        }
    }

    fun onNextImageClicked(view: View) {
        if (viewPager.currentItem < descriptions.size - 1) {
            viewPager.currentItem += 1
        } else {
            // Tampilkan layar berikutnya atau lakukan tindakan lain
        }
    }
}