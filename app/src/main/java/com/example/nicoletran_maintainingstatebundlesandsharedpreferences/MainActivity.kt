package com.example.nicoletran_maintainingstatebundlesandsharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private val images = listOf(R.drawable.puppies1, R.drawable.puppies2, R.drawable.puppies3, R.drawable.puppies4, R.drawable.puppies5)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.image_view)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val randomImage = images.random()
            imageView.setImageResource(randomImage)
        }
    }
}