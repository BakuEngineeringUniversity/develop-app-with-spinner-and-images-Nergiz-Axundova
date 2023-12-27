package com.example.spinnerimages

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.spinner)
        val imageView: ImageView = findViewById(R.id.imageView)

        val imageTitles = resources.getStringArray(R.array.image_titles)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, imageTitles)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                // Update ImageView based on the selected item
                val selectedImageTitle = imageTitles[position]
                val imageResourceId = getImageResourceId(selectedImageTitle)
                imageView.setImageResource(imageResourceId)
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing here
            }
        }
    }

    private fun getImageResourceId(imageTitle: String): Int {
        return when (imageTitle) {
            "Image 1" -> R.drawable.image1
            "Image 2" -> R.drawable.image2
            "Image 3" -> R.drawable.image3
            else -> R.drawable.ic_launcher_foreground
        }
    }
}
