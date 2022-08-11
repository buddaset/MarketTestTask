import org.gradle.api.JavaVersion

object Versions {

    // UI
    const val materialComponent = "1.6.1"
    const val constraintLayout = "2.1.4"
    const val appCompat = "1.4.2"

    // Ktx
    const val coreKtx = "1.7.0"
    const val fragmentKtx = "1.5.2"
    const val runtimeKtx = "2.5.1"
    const val viewModelKtx = "2.5.1"

    // Kotlin
    const val coroutine = "1.6.2"

    // Navigation
    const val navigationComponent = "2.5.1"

    //Test
    const val junit = "4.13.2"
    const val junitExt = "1.1.3"
    const val espresso = "3.4.0"
    // LifeCycle

    // Dagger 2
    const val dagger = "2.40.1"
    //Retrofit
    const val retrofit = "2.9.0"
    // Json-Serialization
    const val json = "1.2.2"
    // Converter Json
    const val converter = "0.8.0"
    //Interceptor
    const val interceptor ="4.9.0"



}

object Dependencies {

    object Dagger2 {
        const val dagger2 = "com.google.dagger:dagger:${Versions.dagger}"
        const val kapt = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val jsonSerialization =  "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.json}"
        const val converter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.converter}"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"

    }

    object AndroidKTX {
        const val core = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.runtimeKtx}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelKtx}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

    }

    object Kotlin {

        const val coroutinesCore =  "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    }



    object UI {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val materialComponents = "com.google.android.material:material:${Versions.materialComponent}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    }

    object Navigation {
        const val navigationComponentFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationComponent}"
        const val navigationComponentUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigationComponent}"

    }

    object Tests {
        const val junit = "junit:junit:${Versions.junit}"
        const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    }


}


object Modules {

    const val app = ":app"
    const val core = ":core"
    const val mainScreen = ":feature-main-screen"


}


object ConfigVersions {

    const val compileSdkVersion = 32
    const val targetSdkVersion = 32
    const val minSdkVersion = 23
    const val buildToolsVersion = "30.2.2"
    const val versionCode = 1
    const val versionName = "1.0"
    const val applicationId = "com.example.markettesttask"
    const val kotlinVersion = "1.6.20"
    val javaVersion = JavaVersion.VERSION_1_8

}





