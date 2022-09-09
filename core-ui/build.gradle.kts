plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
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

  

    implementation(Dependencies.UI.appCompat)
    implementation(Dependencies.UI.materialComponents)

}