package com.mburcak.di

import android.content.Context
import android.content.Intent
import com.mburcak.ui.activity.MainActivity
import com.onesignal.OSNotificationAction
import com.onesignal.OSNotificationOpenResult
import com.onesignal.OneSignal

import org.json.JSONObject


class OneSignalHandler internal constructor(internal var context: Context) : OneSignal.NotificationOpenedHandler {

    override fun notificationOpened(result: OSNotificationOpenResult) {
        val actionType = result.action.type
        val data = result.notification.payload.additionalData
        var activityToBeOpened: String? = null

        if (data != null) {
            activityToBeOpened = data.optString("activityToBeOpened", null)
        }

        val intent = Intent(context, MainActivity::class.java)
        intent.flags =
            Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NO_HISTORY)

        if (activityToBeOpened != null) {
            DynamicConstants.MOVE_FRAGMENT_NAME_BY_NOTIFICATION = activityToBeOpened
        }
        context.startActivity(intent)

    }
}