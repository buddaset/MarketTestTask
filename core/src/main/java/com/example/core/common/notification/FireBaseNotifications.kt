package com.example.core.common.notification

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

import com.example.core.common.resource_manager.ResourceManager
import com.example.core_ui.R
import javax.inject.Inject

class FireBaseNotifications @Inject constructor(
    private val context: Context,
    private val resourceManager: ResourceManager
) : Notifications {


    private val notificationManagerCompat: NotificationManagerCompat =
        NotificationManagerCompat.from(context)

    private fun initialize() {
        if (notificationManagerCompat.getNotificationChannel(CHANNEL_FIREBASE_NAME) == null) {
            notificationManagerCompat.createNotificationChannel(
                NotificationChannelCompat.Builder(
                    CHANNEL_FIREBASE_NAME,
                    NotificationManagerCompat.IMPORTANCE_HIGH
                )
                    .setName(CHANNEL_FIREBASE_NAME)
                    .build()
            )
        }
    }


    override fun showNotification(data: NotificationFirebaseData) {
        initialize()
        val pendingIntent = createPendingIntent()

        val builder = NotificationCompat.Builder(context, CHANNEL_FIREBASE_NAME)
            .setContentTitle(data.title)
            .setContentText(data.content)
            .setAutoCancel(true)
            .setSmallIcon(R.drawable.ic_my_cart)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)


        notificationManagerCompat.notify(CART_NOTIFICATION_ID, builder.build())
    }


    private fun createPendingIntent(): PendingIntent {
        val intent =
            Intent(context, Class.forName(resourceManager.getString(R.string.path_main_activity)))
                .setAction(Intent.ACTION_VIEW)

        return PendingIntent.getActivity(
            context,
            REQUIRE_CODE,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
    }


    companion object {

        private const val CHANNEL_FIREBASE_NAME = "fire_base"
        private const val CART_NOTIFICATION_ID = 1001
        private const val REQUIRE_CODE = 10
    }

}