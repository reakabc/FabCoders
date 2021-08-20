package com.reakabc.fabcoders

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailsActivity : AppCompatActivity() {

    lateinit var imageView: ImageView
    lateinit var instructions: TextView
    lateinit var glass: TextView
    lateinit var title: TextView
    lateinit var back: ImageButton

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        imageView = findViewById(R.id.iv_drink)
        instructions = findViewById(R.id.tv_instructions)
        glass = findViewById(R.id.tv_glass)
        title = findViewById(R.id.tv_title)
        back = findViewById(R.id.btn_back)
        back.setOnClickListener(View.OnClickListener {

            onNavigateUp()
            finishAfterTransition()

        })

        val intent = intent
        Glide.with(this).load(intent.getStringExtra("image")).into(imageView)
        instructions.text = intent.getStringExtra("instructions")
        title.text = intent.getStringExtra("title")
        glass.text = "Serve: ${intent.getStringExtra("glass")}"



    }

    override fun onBackPressed() {
        finishAfterTransition()
        super.onBackPressed()
    }
}