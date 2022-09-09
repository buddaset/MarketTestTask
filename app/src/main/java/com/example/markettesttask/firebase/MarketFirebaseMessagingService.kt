package com.example.markettesttask.firebase

import android.util.Log
import com.example.core.common.notification.NotificationFirebaseData
import com.example.core.common.notification.Notifications
import com.example.markettesttask.app.App
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import javax.inject.Inject

class MarketFirebaseMessagingService : FirebaseMessagingService() {


    @Inject
    lateinit var notifications: Notifications

    override fun onCreate() {
        (application as App ).appComponent.inject(this)
        super.onCreate()
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val data = NotificationFirebaseData(
                        title = remoteMessage.notification?.title ?: DEFAULT_TITLE,
                        content =remoteMessage.notification?.body ?: DEFAULT_BODY
        )

        notifications.showNotification(data)

    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("FirebaseTest", "token  -----$token")
    }


    companion object {

        private const val DEFAULT_TITLE ="title"
        private const val DEFAULT_BODY ="content"
    }

}
