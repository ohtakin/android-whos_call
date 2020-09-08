package com.tioh.whos_call.ext

import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

fun AppCompatActivity.checkSelfPermissionCompat(permission: String) = ActivityCompat.checkSelfPermission(this, permission)

fun AppCompatActivity.requestPermissionsCompat(permissionsArray: Array<String>, requestCode: Int) {
    ActivityCompat.requestPermissions(this, permissionsArray, requestCode)
}