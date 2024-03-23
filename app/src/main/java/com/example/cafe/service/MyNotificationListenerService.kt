package com.example.cafe.service

import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import com.example.cafe.ui.home.Order
import com.example.cafe.ui.home.orders
import java.util.regex.Pattern

class MyNotificationListenerService : NotificationListenerService() {
    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)
        val packageName: String = sbn?.packageName ?: "Null"
        val extraText: String? = sbn?.notification?.extras?.getString(Notification.EXTRA_TEXT)
        if (packageName == "com.ibk.android.ionebank" && extraText != null) {

            val pattern =
                Pattern.compile(".+ (\\d+)원 ([가-힣]+)\\n(.+)\\n(\\d{2}/\\d{2} \\d{2}:\\d{2})")
            val matcher = pattern.matcher(extraText)
            if (matcher.find())
                orders += Order(
                    id = orders.size.toString(),
                    amount = matcher.group(1) ?: "",
                    name = matcher.group(2) ?: "",
                    accountNumber = matcher.group(3) ?: "",
                    time = matcher.group(4) ?: "",
                    menu = "",
                    status = "주문완료"
                )

        }
    }
}