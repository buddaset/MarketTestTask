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


    implementation(Dependencies.Navigation.navigationComponentFragmentKtx)
    implementation(Dependencies.Navigation.navigationComponentUiKtx)

    implementation(Dependencies.Dagger2.dagger2)
    kapt(Dependencies.Dagger2.kapt)

    // Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.jsonSerialization)


    // Coroutines
    implementation(Dependencies.Kotlin.coroutinesCore)
    implementation(Dependencies.Kotlin.coroutinesAndroid)

}