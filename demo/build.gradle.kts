import com.android.build.gradle.ProguardFiles.getDefaultProguardFile
import org.gradle.kotlin.dsl.kotlin

plugins {
    `android-application`
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(SDK_TARGET)
    buildToolsVersion(BUILD_TOOLS)
    defaultConfig {
        minSdkVersion(SDK_MIN)
        targetSdkVersion(SDK_TARGET)
        applicationId = "com.example.collapsingtoolbarlayoutsubtitle"
        versionCode = 1
        versionName = "1.0"
    }
    sourceSets {
        getByName("main") {
            manifest.srcFile("AndroidManifest.xml")
            java.srcDirs("src")
            res.srcDir("res")
            resources.srcDir("src")
        }
    }
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    lintOptions {
        isAbortOnError = false
    }
}

dependencies {
    implementation(project(":collapsingtoolbarlayout-subtitle"))
    implementation(kotlin("stdlib", VERSION_KOTLIN))

    implementation(support("design", VERSION_SUPPORT))
    implementation(support("cardview-v7", VERSION_SUPPORT))

    implementation(bottomsheet("commons"))
    implementation(androidKTX())

    implementation("com.afollestad.material-dialogs:core:0.9.6.0")
}
