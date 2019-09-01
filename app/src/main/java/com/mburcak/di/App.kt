package com.mburcak.di

import android.app.Application
import com.onesignal.OneSignal

class App : Application() {


    override fun onCreate() {
        super.onCreate()

        OneSignal.startInit(this)
            .setNotificationOpenedHandler(OneSignalHandler(applicationContext))
            .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
            .unsubscribeWhenNotificationsAreDisabled(true)
            .init()

    }


}


