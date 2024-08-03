package com.example.cafe

import android.app.Application
import android.app.NotificationManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.provider.Settings
import com.example.cafe.service.MyNotificationListenerService
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CafeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (!isNotificationPermissionGranted()) {
            val intent = Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    private fun isNotificationPermissionGranted(): Boolean {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        return notificationManager.isNotificationListenerAccessGranted(
            ComponentName(
                this,
                MyNotificationListenerService::class.java
            )
        )
    }
}