package com.beo.foody.data

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// this is kick-off of Hilt, this must need
// At AndroidManifest add android:name=".data.MyApplication" in "application" tag
@HiltAndroidApp
class MyApplication : Application() {
}