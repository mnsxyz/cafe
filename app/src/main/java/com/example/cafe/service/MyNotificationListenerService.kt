package com.example.cafe.service

import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import com.example.cafe.data.OrderEntity
import com.example.cafe.ui.view.order.orders
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.regex.Pattern

class MyNotificationListenerService : NotificationListenerService() {

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)
        val packageName: String = sbn?.packageName ?: "Null"
        val extraText: String? = sbn?.notification?.extras?.getString(Notification.EXTRA_TEXT)
        if (packageName == "com.ibk.android.ionebank" && extraText != null) {

            val pattern =
                Pattern.compile(".+ (\\d+)원 ([가-힣]+)\\n.+\\n(\\d{2}/\\d{2} \\d{2}:\\d{2})")
            val matcher = pattern.matcher(extraText)
            if (matcher.find()) {
                val amount = matcher.group(1) ?: ""
                val name = matcher.group(2) ?: ""
                val timeString = matcher.group(3) ?: ""
                val year = LocalDateTime.now().year
                val time =
                    LocalDateTime.parse(
                        "${year}/" + timeString,
                        DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")
                    )
                orders += OrderEntity(
                    sequence = orders.size,
                    amount = amount,
                    name = name,
                    time = time,
                    menu = "",
                    status = "결제 완료"
                )
            }
        }
    }

}