package com.thefuntasty.androidprojecttemplate

import android.app.Service
import android.content.Intent
import android.os.IBinder

class TestService : Service() {


    //TODO: Test Service only to check new lint checks, but tpyos (typos) shouldnt be a reported problem
    override fun onBind(intent: Intent?): IBinder? = null
}
