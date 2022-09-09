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
    const val dagger = "2.38.1"

    //Retrofit
    const val retrofit = "2.9.0"

    // Json-Serialization
    const val json = "1.2.2"

    // Converter Json
    const val converter = "0.8.0"

    // Interceptor
    const val interceptor = "4.9.0"

    // AdapterDelegates
    const val adapterDelegates = "4.3.2"

    // Glide
    const val glide = "4.13.2"

    // CarouselLayoutManager
    const val carouselRecyclerView = "1.2.5"

    // FlowAdapter for Retrofit
    const val flowAdapter = "0.2.0"

    // SimpleRatingBar
    const val ratingBar = "0.1.5"

    // Room Database
    const val room = "2.4.3"
    // FireBase
    const val firebaseBom = "30.2.0"
    // FCM
    const val fcm = "23.0.8"


}

object Dependencies {

    object Firebase {

        const val bom ="com.google.firebase:firebase-bom:${Versions.firebaseBom}"
        const val messaging = "com.google.firebase:firebase-messaging-ktx:${Versions.fcm}"
    }

    object UI {


        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val materialComponents =
            "com.google.android.material:material:${Versions.materialComponent}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

        const val simpleRatingBar = "com.iarcuschin:simpleratingbar:${Versions.ratingBar}"

        const val carouselRecyclerView =
            "com.github.sparrow007:carouselrecyclerview:${Versions.carouselRecyclerView}"

    }

    object Glide {

        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val kapt = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    object AdapterDelegates {
        const val adapterDelegates =
            "com.hannesdorfmann:adapterdelegates4-kotlin-dsl:${Versions.adapterDelegates}"
        const val viewBinding =
            "com.hannesdorfmann:adapterdelegates4-kotlin-dsl-viewbinding:${Versions.adapterDelegates}"
    }

    object Dagger2 {
        const val dagger2 = "com.google.dagger:dagger:${Versions.dagger}"
        const val kapt = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val jsonSerialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.json}"
        const val converter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.converter}"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
        const val flowAdapter =
            "com.github.MohammadSianaki:Retrofit2-Flow-Call-Adapter:${Versions.flowAdapter}"

    }

    object AndroidKTX {
        const val core = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.runtimeKtx}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelKtx}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

    }

    object Kotlin {

        const val coroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
        const val coroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    }


    object Navigation {
        const val navigationComponentFragmentKtx =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navigationComponent}"
        const val navigationComponentUiKtx =
            "androidx.navigation:navigation-ui-ktx:${Versions.navigationComponent}"

    }

    object Tests {
        const val junit = "junit:junit:${Versions.junit}"
        const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    }

    object Database {

        const val room = "androidx.room:room-runtime:${Versions.room}"
        const val kapt = "androidx.room:room-compiler:${Versions.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.room}"

    }


}


object Modules {

    const val app = ":app"
    const val core = ":core"
    const val core_ui = ":core-ui"
    const val productDetails = ":feature-product-details"
    const val mainScreen = ":feature-main-screen"
    const val myCart = ":feature-my-cart"
    const val tabBar = ":feature-tab-bar"
    const val splashScreen = ":feature-splash-screen"


}


object ConfigVersions {

    const val compileSdkVersion = 32
    const val targetSdkVersion = 32
    const val minSdkVersion = 23
    const val versionCode = 1
    const val versionName = "1.0"
    const val applicationId = "com.example.markettesttask"
    const val kotlin = "1.6.20"
    const val gradle = "7.0.4"
    val javaVersion = JavaVersion.VERSION_1_8
    const val java = "1.8"
    const val  buildTools = "31.0.0"

}






