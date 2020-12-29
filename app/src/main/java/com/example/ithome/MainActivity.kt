package com.example.ithome


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_news_content.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    //标志单双页 false为单页 true为双页
    var isTwoPane = false

    private val homeDataList = ArrayList<HomeData>()

    private fun initHomeData() {
        repeat(10)
        {
            homeDataList.add(HomeData(R.drawable.meizu01,"魅族17系列京东双十一限时优惠：搭载骁龙865,到手价3199元起",
                "2020-11-02 10:50","588" ,"IT之家（az）",
                "IT之家11月2日消息 魅族 17 系列于今年 5 月发布，全系配备 Super AMOLED 定制显示屏，配备骁龙 865+UFS 3.1 存储方案，现已开启苏宁限时优惠。",
                "目前，魅族 17 系列可限时领券优惠 500 元，支持 24 期免息，到手价 3199 元起，还赠壳膜套装。",
            R.drawable.meizu,"作为魅族科技的年度旗舰手机，魅族 17 Pro 采用陶瓷机身设计，标配 LPDDR5 内存，支持 27W 无线超充、无线反充，采用 6400W 全场景 AR 影像系统。",
            R.drawable.meizu01,"IT之家了解到，魅族17内置4500mAh电池，支持30快充，后置6400万全场景四摄。"))
            homeDataList.add(HomeData(R.drawable.img_3,"安卓 11 降临,realme X50 Pro 5G 推送 realme UI2.0 公测版",
                "2020-11-02 10:50","158" ,"IT之家（az）","IT之家11月2日消息 魅族 17 系列于今年 5 月发布，全系配备 Super AMOLED 定制显示屏，配备骁龙 865+UFS 3.1 存储方案，现已开启苏宁限时优惠。","IT之家11月2日消息 魅族 17 系列于今年 5 月发布，全系配备 Super AMOLED 定制显示屏，配备骁龙 865+UFS 3.1 存储方案，现已开启苏宁限时优惠。",inhoudImg01= R.drawable.img_7))
            homeDataList.add(HomeData(R.drawable.img_4,"iPhone 锁定屏幕键盘输入密码时可能漏输,苹果在 iOS 14.2 修复了",
                "2020-11-02 10:50","20" ,"IT之家（az）","\"IT之家11月2日消息 魅族 17 系列于今年 5 月发布，全系配备 Super AMOLED 定制显示屏，配备骁龙 865+UFS 3.1 存储方案，现已开启苏宁限时优惠。\"",inhoudImg01= R.drawable.img_7))
            homeDataList.add(HomeData(R.drawable.img_5,"原神 10 月收入全球游戏第一，在 78 个国家位列前十",
                "2020-11-02 10:50","0" ,"IT之家（az）",inhoud_02 = "目前，魅族 17 系列可限时领券优惠 500 元，支持 24 期免息，到手价 3199 元起，还赠壳膜套装。",inhoudImg01= R.drawable.img_7))
            homeDataList.add(HomeData(R.drawable.img_8,"小红书回应 “用户笔记存在大尺度内容”：已封禁，对涉黄、色情信息 “零容忍”",
                "2020-11-02 10:50","268" ,"IT之家（az）","目前，魅族 17 系列可限时领券优惠 500 元，支持 24 期免息，到手价 3199 元起，还赠壳膜套装。",inhoud_03 = "目前，魅族 17 系列可限时领券优惠 500 元，支持 24 期免息，到手价 3199 元起，还赠壳膜套装。"))
            homeDataList.add(HomeData(R.drawable.img_9,"苹果 Safari 浏览器翻译功能现已上线更多国家",
                "2020-11-02 10:50","15" ,"IT之家（az）","","",inhoudImg01= R.drawable.img_7))
            homeDataList.add(HomeData(R.drawable.img_10,"iPhone 12 京东控股店降价：64G 版低至 5999 元",
                "2020-11-02 10:50","6" ,"IT之家（az）","","",inhoudImg01= R.drawable.img_7))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        //判断单双页
        isTwoPane = NewsContentTowPanl !=null



        initHomeData()
        RecyclerViewTest.layoutManager = LinearLayoutManager(this)
        val adapter = NewsAdapter(homeDataList)
        RecyclerViewTest.adapter = adapter

        search_boks.setOnClickListener{
            startActivity(Intent(this, SearchActivity::class.java))
        }

        fullScreen(this)
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    inner class NewsAdapter(private val newsList:List<HomeData>):
        RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val imgID: ImageView = view.findViewById(R.id.item_image)
            val mainTitle: TextView = view.findViewById(R.id.item_title)
            val time: TextView = view.findViewById(R.id.item_time)
            val comments: TextView = view.findViewById(R.id.item_comments)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
            val viewHolder = ViewHolder(view)
            viewHolder.itemView.setOnClickListener {
                if (isTwoPane) {
                    val fragment: NewsContentFragment = NewsContentTowPanl as NewsContentFragment
                    fragment.refresh(newsList[viewHolder.adapterPosition])
                } else {
                    DetailedActivity.actionStart(parent.context, newsList[viewHolder.adapterPosition])
                }
            }
            return viewHolder
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val homeData = homeDataList[position]
            holder.imgID.setImageResource(homeData.imageId)
            holder.mainTitle.text = homeData.mainTitle
            val newTime:String = homeData.time
            holder.time.text = homeData.time.substring(IntRange(newTime.length-5,newTime.length-1))
            holder.comments.text = homeData.comments
        }

        override fun getItemCount()=newsList.size
    }
}