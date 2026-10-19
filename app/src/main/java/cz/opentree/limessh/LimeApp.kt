package cz.opentree.limessh

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class LimeApp : Application() {

    companion object {
        const val CHANNEL_SESSION = "limessh_session"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val sessionChannel = NotificationChannel(
                CHANNEL_SESSION,
                "Active SSH Sessions",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "Shows active LimeSSH connections"
                setShowBadge(false)
            }
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(sessionChannel)
        }
    }
}
