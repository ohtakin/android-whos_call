package com.tioh.whos_call

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.widget.Toast
import org.apache.commons.lang3.StringUtils

class CallStateReceiver : BroadcastReceiver() {

    var ctx: Context? = null

    override fun onReceive(context: Context, intent: Intent) {
        ctx = context

        val extras = intent.extras
        if (extras != null) {
            val state = extras.getString(TelephonyManager.EXTRA_STATE)
            if (state == TelephonyManager.EXTRA_STATE_RINGING) {
                val incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
                if (StringUtils.isNotEmpty(incomingNumber)) {
                    Toast.makeText(ctx, incomingNumber, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}