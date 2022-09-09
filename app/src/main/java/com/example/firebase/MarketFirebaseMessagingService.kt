package com.example.firebase

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Context
import android.util.Log
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavDeepLinkBuilder
import com.example.markettesttask.R
import com.example.markettesttask.app.App
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.messaging.ktx.remoteMessage
import okhttp3.internal.notify
import javax.inject.Inject

class MarketFirebaseMessagingService : FirebaseMessagingService() {


    @Inject
    lateinit var notifications: Notifications

    override fun onCreate() {
        (application as App ).appComponent.inject(this)
        super.onCreate()
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d("FirebaseTest", "onMessageReceive")
        notifications.showNotification(remoteMessage)

    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("FirebaseTest", "token  -----$token")
    }

}

interface Notifications {

    fun showNotification(remoteMessage: RemoteMessage)
}

class FireBaseNotifications @Inject constructor(private val context: Context): Notifications {



    private val notificationManagerCompat : NotificationManagerCompat =
        NotificationManagerCompat.from(context)

    private fun initialize() {
        if (notificationManagerCompat.getNotificationChannel(CHANNEL_FIREBASE_NAME) == null) {
            notificationManagerCompat.createNotificationChannel(
                NotificationChannelCompat.Builder(CHANNEL_FIREBASE_NAME, NotificationManagerCompat.IMPORTANCE_HIGH)
                    .setName(CHANNEL_FIREBASE_NAME)
                    .build()
            )
        }
    }

    override fun showNotification(remoteMessage: RemoteMessage) {
        initialize()
        val pendingIntent = createPendingIntent()

        val builder = NotificationCompat.Builder(context, CHANNEL_FIREBASE_NAME)
            .setContentTitle(remoteMessage.notification?.title)
            .setContentText(remoteMessage.notification?.body)
            .setAutoCancel(true)
            .setSmallIcon(com.example.feature_product_details.R.drawable.ic_my_cart)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)


        notificationManagerCompat.notify(CART_NOTIFICATION_ID, builder.build())
    }

    @SuppressLint("ResourceType")
    private fun createPendingIntent(): PendingIntent  =
        NavDeepLinkBuilder(context)
            .setGraph(R.navigation.application_graph)
            .setDestination(R.id.myCartFragment)
            .createPendingIntent()


    companion object {

        private const val CHANNEL_FIREBASE_NAME = "fire_base"
        private const val CART_NOTIFICATION_ID = 1001
    }
}