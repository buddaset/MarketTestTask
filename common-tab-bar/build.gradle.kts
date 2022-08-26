plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("kotlinx-serialization")
    id ("kotlin-kapt")
}

android {
    compileSdk = ConfigVersions.compileSdkVersion

    defaultConfig {
        minSdk = ConfigVersions.minSdkVersion
        targetSdk = ConfigVersions.targetSdkVersion
    }
    buildTypes {
        release {
            isMinifyEnabled = true

        }
    }
    buildFeatures.viewBinding = true
}
dependencies {


    implementation(project(Modules.core))
    implementation(project(Modules.core_ui))
    implementation(project(Modules.mainScreen))

    implementation(Dependencies.AndroidKTX.core)
    implementation(Dependencies.AndroidKTX.runtime)
    implementation(Dependencies.AndroidKTX.viewModel)
    implementation(Dependencies.AndroidKTX.fragment)

    implementation(Dependencies.UI.appCompat)
    implementation(Dependencies.UI.constraintLayout)
    implementation(Dependencies.UI.materialComponents)

    implementation(Dependencies.Navigation.navigationComponentFragmentKtx)
    implementation(Dependencies.Navigation.navigationComponentUiKtx)

    implementation(Dependencies.Dagger2.dagger2)
    implementation("com.github.peceoqicka:GalleryLayoutManagerX:1.0.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")

    kapt(Dependencies.Dagger2.kapt)


    // Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.jsonSerialization)
    implementation(Dependencies.Retrofit.converter)
    implementation(Dependencies.Retrofit.interceptor)
    implementation(Dependencies.Retrofit.flowAdapter)


    // Coroutines
    implementation(Dependencies.Kotlin.coroutinesCore)
    implementation(Dependencies.Kotlin.coroutinesAndroid)

    implementation(Dependencies.AdapterDelegates.adapterDelegates)
    implementation(Dependencies.AdapterDelegates.viewBinding)

    implementation(Dependencies.Glide.glide)
    kapt(Dependencies.Glide.kapt)



}