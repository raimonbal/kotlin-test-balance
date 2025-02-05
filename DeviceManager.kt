// DeviceIdManager.kt
package com.balance.deviceidsdk

import android.content.Context
import android.provider.Settings
import androidx.annotation.RequiresPermission
import android.Manifest

class DeviceIdManager private constructor(private val context: Context) {
    
    companion object {
        @Volatile
        private var instance: DeviceIdManager? = null
        
        fun getInstance(context: Context): DeviceIdManager {
            return instance ?: synchronized(this) {
                instance ?: DeviceIdManager(context.applicationContext).also { instance = it }
            }
        }
    }
    
    /**
     * Returns the Android ID of the device.
     * This ID remains constant for the lifetime of the device for a given app signing key.
     * The ID may change if the app is uninstalled and reinstalled.
     *
     * @return String representing the device ID
     */
    fun getDeviceId(): String {
        return Settings.Secure.getString(
            context.contentResolver,
            Settings.Secure.ANDROID_ID
        )
    }
    
    /**
     * Returns a more comprehensive device identifier combining multiple sources.
     * Note: Requires READ_PHONE_STATE permission for IMEI access
     *
     * @return DeviceIdentifier object containing multiple device identifiers
     */
    @RequiresPermission(Manifest.permission.READ_PHONE_STATE)
    fun getCompleteDeviceIdentifier(): DeviceIdentifier {
        val androidId = getDeviceId()
        val manufacturer = android.os.Build.MANUFACTURER
        val model = android.os.Build.MODEL
        val brand = android.os.Build.BRAND
        
        return DeviceIdentifier(
            androidId = androidId,
            manufacturer = manufacturer,
            model = model,
            brand = brand
        )
    }
}