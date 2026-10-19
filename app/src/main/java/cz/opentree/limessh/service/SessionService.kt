package cz.opentree.limessh.service

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import cz.opentree.limessh.LimeApp
import cz.opentree.limessh.R
import cz.opentree.limessh.ui.MainActivity

/**
 * Foreground service that keeps SSH sessions alive across activity lifecycle.
 * Uses FOREGROUND_SERVICE_CONNECTED_DEVICE type for Android 14+.
 */
class SessionService : Service() {

    override fun onCreate() {
        super.onCreate()
        startForeground(NOTIFICATION_ID, buildNotification(0))
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val sessionCount = intent?.getIntExtra(EXTRA_SESSION_COUNT, 0) ?: 0
        if (sessionCount <= 0) {
            stopForeground(STOP_FOREGROUND_REMOVE)
            stopSelf()
        } else {
            val notification = buildNotification(sessionCount)
            getSystemService(android.app.NotificationManager::class.java)
                ?.notify(NOTIFICATION_ID, notification)
        }
        return START_NOT_STICKY
    }

    private fun buildNotification(sessionCount: Int): Notification {
        val openIntent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        }
        val pendingIntent = PendingIntent.getActivity(
            this, 0, openIntent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val title = if (sessionCount <= 1) "LimeSSH session active"
        else "$sessionCount LimeSSH sessions active"

        return NotificationCompat.Builder(this, LimeApp.CHANNEL_SESSION)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(title)
            .setContentIntent(pendingIntent)
            .setOngoing(true)
            .setCategory(NotificationCompat.CATEGORY_SERVICE)
            .build()
    }

    companion object {
        const val NOTIFICATION_ID = 1
        const val EXTRA_SESSION_COUNT = "session_count"
    }
}
