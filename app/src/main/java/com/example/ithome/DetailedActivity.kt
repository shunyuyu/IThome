package com.example.ithome

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_detailed.*
import kotlinx.android.synthetic.main.fragment_news_content.*
import java.io.FileReader

class DetailedActivity : AppCompatActivity() {
    companion object{
        fun actionStart(context: Context,news:HomeData){
            val intent:Intent=Intent(context,DetailedActivity::class.java).apply {
                putExtra("news_data",news)
            }
            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        supportActionBar?.hide()
        fullScreen(this)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        return_img.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        val newsData = intent.getParcelableExtra<HomeData>("news_data")
        if (newsData!=null)
        {
            val fragment = NewsContent as NewsContentFragment
            fragment.refresh(newsData)
        }
    }
}