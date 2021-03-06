import dependencies.Dep

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}
android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.2")

    defaultConfig {
        minSdkVersion(26)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))

    implementation(project("path" to ":domain:use_case"))
    implementation(project("path" to ":core"))

    // Kotlin
    implementation(Dep.Kotlin.stdLib)
    implementation(Dep.Kotlin.coroutines)
    implementation(Dep.Kotlin.androidCoroutinesDispatcher)

    // AndroidX
    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.AndroidX.coreKtx)
    implementation(Dep.AndroidX.constraintLayout)
    implementation(Dep.AndroidX.recyclerView)
    implementation(Dep.AndroidX.lifecycleExt)
    implementation(Dep.AndroidX.lifecycleVieModel)
    implementation(Dep.AndroidX.lifecycleReactive)
    implementation(Dep.AndroidX.navigation)
    implementation(Dep.AndroidX.navigationUI)

    // Dagger2
    implementation(Dep.Dagger.dagger)
    implementation(Dep.Dagger.support)
    kapt(Dep.Dagger.compiler)

    // Test
    testImplementation(Dep.Test.junit4)
    testImplementation(Dep.Test.assertJ)
}
