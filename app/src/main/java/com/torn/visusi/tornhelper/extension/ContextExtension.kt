package com.torn.visusi.tornhelper.extension

import android.content.Context
import android.content.pm.PackageManager

fun Context.getMetaData() = this.packageManager?.getApplicationInfo(this.packageName, PackageManager.GET_META_DATA)?.metaData
