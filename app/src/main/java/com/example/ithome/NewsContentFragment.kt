package com.example.ithome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_news_content.*

class NewsContentFragment : Fragment() {

    private lateinit var news: HomeData

    companion object {
        const val KEY: String = "KEY"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_content, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState != null) {
            savedInstanceState.getParcelable<HomeData>(KEY)?.let { refresh(it) }
        }
    }

    fun refresh(data: HomeData) {
        news = data
        //显示布局内容
        ContenLayoutFrag.visibility = View.VISIBLE
        contentTitle.text = news.mainTitle
        contentTitle1.text = news.mainTitle
        contentTitle2.text = news.content
        contentTime.text = news.time
        ofText(inhoud_01, news.inhoud_01)
        ofText(inhoud_02, news.inhoud_02)
        ofIng(inhoud_img_01, news.inhoudImg01)
        inhoud_03.text = news.inhoud_03
        ofIng(inhoud_img_02, news.inhoudImg02)
        inhoud_04.text = news.inhoud_04
        Kommentaar.text = news.comments
    }

    private fun ofText(textView: TextView, string: String) {
        if (string == "") {
            textView.visibility = View.GONE
        } else {
            textView.text = string
        }
    }

    private fun ofIng(imageView: ImageView, int: Int) {
        if (int == 1) {
            imageView.visibility = View.GONE
        } else {
            imageView.setImageResource(int)
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (::news.isInitialized) {
            outState.putParcelable(KEY, news)
        }
    }
}