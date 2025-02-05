// DeviceIdentifier.kt
package com.balance.deviceidsdk

data class DeviceIdentifier(
    val androidId: String,
    val manufacturer: String,
    val model: String,
    val brand: String
)

// DeviceIdException.kt
package com.balance.deviceidsdk

class DeviceIdException(message: String, cause: Throwable? = null) : Exception(message, cause)