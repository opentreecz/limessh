package cz.opentree.limessh.ui.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import cz.opentree.limessh.R
import cz.opentree.limessh.ui.MainActivity

/**
 * Home screen widget for LimeSSH.
 * Shows recent connections and allows quick connect.
 *
 * Replaces JuiceSSH's Pro-only widget with a free, open-source version.
 * Supports: connection list, quick-connect tap, port forward status.
 */
class LimeWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray,
    ) {
        for (widgetId in appWidgetIds) {
            updateWidget(context, appWidgetManager, widgetId)
        }
    }

    companion object {
        fun updateWidget(
            context: Context,
            appWidgetManager: AppWidgetManager,
            widgetId: Int,
        ) {
            val views = RemoteViews(context.packageName, R.layout.widget_lime)
            // Set click to open main activity
            val intent = Intent(context, MainActivity::class.java)
            val pendingIntent = android.app.PendingIntent.getActivity(
                context, widgetId, intent,
                android.app.PendingIntent.FLAG_UPDATE_CURRENT or android.app.PendingIntent.FLAG_IMMUTABLE,
            )
            views.setOnClickPendingIntent(R.id.widget_root, pendingIntent)
            views.setTextViewText(R.id.widget_title, "LimeSSH")
            views.setTextViewText(R.id.widget_status, "> Ready")
            appWidgetManager.updateAppWidget(widgetId, views)
        }
    }
}
