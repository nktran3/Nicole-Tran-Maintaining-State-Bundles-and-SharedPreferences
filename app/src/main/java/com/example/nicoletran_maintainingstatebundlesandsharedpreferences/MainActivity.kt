package com.example.nicoletran_maintainingstatebundlesandsharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var editText: EditText
    private val images = listOf(R.drawable.puppies1, R.drawable.puppies2, R.drawable.puppies3, R.drawable.puppies4, R.drawable.puppies5)
    private var savedImage: Int = images.first()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.image_view)
        editText = findViewById(R.id.edit_text)
        val button: Button = findViewById(R.id.button)

        val sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE)
        savedImage = sharedPreferences.getInt("image", images.first())
        val savedText = sharedPreferences.getString("text", "")
        imageView.setImageResource(savedImage)
        editText.setText(savedText)

        button.setOnClickListener {
            savedImage = images.random()
            imageView.setImageResource(savedImage)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        val sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE).edit()
        sharedPreferences.putInt("image", savedImage)
        sharedPreferences.putString("text", editText.text.toString())
        sharedPreferences.apply()
    }
}