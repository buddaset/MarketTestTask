plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
}

android {
    compileSdk = ConfigVersions.compileSdkVersion

    defaultConfig {
        minSdk = ConfigVersions.minSdkVersion
        targetSdk = ConfigVersions.targetSdkVersion

    }
    buildFeatures.viewBinding = true
}

dependencies {


    implementation(Dependencies.AndroidKTX.fragment)
    implementation(Dependencies.UI.materialComponents)
    implementation(Dependencies.Dagger2.dagger2)

    // Coroutines
    implementation(Dependencies.Kotlin.coroutinesCore)
    implementation(Dependencies.Kotlin.coroutinesAndroid)

    implementation(Dependencies.Navigation.navigationComponentFragmentKtx)

    implementation(Dependencies.Database.room)
}