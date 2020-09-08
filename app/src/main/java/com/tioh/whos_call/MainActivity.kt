package com.tioh.whos_call

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.tioh.whos_call.ext.checkSelfPermissionCompat
import com.tioh.whos_call.ext.requestPermissionsCompat

const val PERMISSION_REQUEST = 0

class MainActivity : AppCompatActivity(), ActivityCompat.OnRequestPermissionsResultCallback {

    private val callPermissions = arrayOf(
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_CALL_LOG
    )

    private val permissions = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission()
    }

    private fun checkPermission() {
        callPermissions.forEach {
            if (checkSelfPermissionCompat(it) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(it)
            }
        }
        if (permissions.size > 0) {
            requestPermission()
        }
    }

    private fun requestPermission() {
        requestPermissionsCompat(permissions.toTypedArray(), PERMISSION_REQUEST)
    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<String>,
            grantResults: IntArray
    ) {
        if (requestCode == PERMISSION_REQUEST) {
            grantResults.forEach {
                if (it == PackageManager.PERMISSION_GRANTED) {
                } else {
                }
            }
        }
    }
}