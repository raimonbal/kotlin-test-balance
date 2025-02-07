pluginManagement {
    repositories {
        google()  // ✅ Required for Android Gradle Plugin
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")  // ✅ Add JitPack repository
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")  // ✅ Add JitPack here as well
    }
}