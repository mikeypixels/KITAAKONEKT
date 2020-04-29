val componentsVersion: String by rootProject.extra
val aimyboxVersion: String by rootProject.extra
val htextview_version = "0.1.6"

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

        renderscriptTargetApi = 29 //must match target sdk and build tools

        renderscriptSupportModeEnabled = true

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

    implementation("androidx.legacy:legacy-support-v4:1.0.0")

//    TODO: Remove this placeholder
    implementation ("com.google.android.gms:play-services-maps:17.0.0")
    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.0-beta-3")

    implementation("androidx.appcompat:appcompat:1.1.0")
//    implementation("com.android.support:design:28.0.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("com.tomer:fadingtextview:2.5")
    implementation("androidx.core:core-ktx:1.2.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.1")

    implementation("com.eightbitlab:blurview:1.6.2")

    implementation("com.justai.aimybox:components:$componentsVersion")
    implementation("com.justai.aimybox:core:$aimyboxVersion")
    implementation("com.justai.aimybox:google-platform-speechkit:$aimyboxVersion")
    implementation("com.justai.aimybox:rasa-api:$aimyboxVersion")

    implementation("com.shreyaspatil:MaterialNavigationView:1.2")
    implementation("androidx.annotation:annotation:1.1.0")
    implementation("androidx.core:core:1.3.0-alpha02")
    implementation("com.alexzh:circleimageview:1.2.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("com.google.android.material:material:1.2.0-alpha05")
    implementation("de.hdodenhof:circleimageview:3.0.1")

    annotationProcessor("com.google.auto.value:auto-value:1.5.2")
    provided("com.jakewharton.auto.value:auto-value-annotations:1.4")
    annotationProcessor("com.ryanharter.auto.value:auto-value-parcel:0.2.5")

    implementation("com.hanks:htextview-base:$htextview_version")  // base library

    implementation("com.hanks:htextview-fade:$htextview_version")        // optional
    implementation("com.hanks:htextview-line:$htextview_version")        // optional
    implementation("com.hanks:htextview-rainbow:$htextview_version")     // optional
    implementation("com.hanks:htextview-typer:$htextview_version")      // optional

    implementation("com.hanks:htextview-scale:$htextview_version")       // optional
    implementation("com.hanks:htextview-evaporate:$htextview_version")   // optional
    implementation("com.hanks:htextview-fall:$htextview_version")       // optional

    implementation("com.github.aakira:expandable-layout:1.6.0@aar")
}
