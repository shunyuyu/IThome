package com.example.ithome

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.widget.Toast

class ITReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context,"IT Home 收到", Toast.LENGTH_LONG).show()
        val i = Intent(context,MainActivity::class.java)
        i.flags=FLAG_ACTIVITY_NEW_TASK
        context.startActivity(i)
    }
}
