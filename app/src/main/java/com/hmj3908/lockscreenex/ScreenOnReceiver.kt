package com.hmj3908.lockscreenex

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ScreenOnReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_SCREEN_ON) {
            val lockIntent = Intent(context, LockScreenActivity::class.java)
            lockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(lockIntent)
        }
    }
}