val componentsVersion: String by rootProject.extra
val aimyboxVersion: String by rootProject.extra

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}

android {

    compileSdkVersion(29)

    defaultConfig {
        applicationId = "com.justai.aimybox.assistant"

        minSdkVersion(21)
        targetSdkVersion(29)

        versionName = componentsVersion
        versionCode = 1
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        getByName("release") {
            //TODO configure pro guard
        }
    }

    lintOptions {
        isCheckAllWarnings = true
        isWarningsAsErrors = false
        isAbortOnError = true
    }
}

repositories {
    mavenLocal()
    google()
    jcenter()
    mavenCentral()
    maven("https://kotlin.bintray.com/kotlinx")
    maven("https://dl.bintray.com/aimybox/aimybox-android-sdk/")
    maven("https://dl.bintray.com/aimybox/aimybox-android-assistant/")
}

dependencies {

    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.0-beta-3")

    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.recyclerview:recyclerview:1.0.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.core:core-ktx:1.1.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.1.0")

    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.1")

    implementation("com.justai.aimybox:components:$componentsVersion")
    implementation("com.justai.aimybox:core:$aimyboxVersion")
    implementation("com.justai.aimybox:google-platform-speechkit:$aimyboxVersion")
    implementation("com.justai.aimybox:rasa-api:$aimyboxVersion")

    implementation("com.shreyaspatil:MaterialNavigationView:1.2")
    implementation("androidx.annotation:annotation:1.1.0")
    implementation("androidx.core:core:1.3.0-alpha01")
    implementation("com.alexzh:circleimageview:1.2.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("com.google.android.material:material:1.2.0-alpha04")

    implementation( "com.github.aakira:expandable-layout:1.6.0@aar")
}
