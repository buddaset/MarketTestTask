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


    implementation(Dependencies.UI.appCompat)
    implementation(Dependencies.UI.constraintLayout)
    implementation(Dependencies.UI.materialComponents)
    implementation(Dependencies.UI.simpleRatingBar)
    implementation(Dependencies.UI.carouselRecyclerView)


    implementation(Dependencies.Navigation.navigationComponentFragmentKtx)

    implementation(Dependencies.Dagger2.dagger2)
    kapt(Dependencies.Dagger2.kapt)


    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.jsonSerialization)

    implementation(Dependencies.Kotlin.coroutinesCore)
    implementation(Dependencies.Kotlin.coroutinesAndroid)

    implementation(Dependencies.AdapterDelegates.adapterDelegates)
    implementation(Dependencies.AdapterDelegates.viewBinding)

    implementation(Dependencies.Glide.glide)




}