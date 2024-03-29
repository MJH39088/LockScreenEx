// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
    }
}

plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false

    // Hilt
//    id("com.google.dagger.hilt.android") version "2.38.1" apply false

    // KSP
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
}