package com.example.ithome

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * 首页数据实体类
 * imageId：图片资源ID
 * Title：主标题
 * time：时间
 * comments：评论
 * editor:主编
 * content:新闻内容
 * inhoud:内容
 * inhoudImg:内容图片
 */
@Parcelize
class HomeData(
    val imageId: Int,
    val mainTitle: String,
    val time: String,
    val comments: String,
    val content:String,
    val inhoud_01:String="",
    val inhoud_02:String="",
    val inhoudImg01:Int=0,
    val inhoud_03:String="",
    val inhoudImg02:Int=0,
    val inhoud_04:String=""
):Parcelable