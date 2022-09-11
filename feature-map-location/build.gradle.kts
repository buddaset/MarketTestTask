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

    implementation(Dependencies.AndroidKTX.core)
    implementation(Dependencies.AndroidKTX.runtime)
    implementation(Dependencies.AndroidKTX.viewModel)
    implementation(Dependencies.AndroidKTX.fragment)

    implementation(Dependencies.UI.appCompat)
    implementation(Dependencies.UI.constraintLayout)
    implementation(Dependencies.UI.materialComponents)

    implementation("com.yandex.android:maps.mobile:4.2.0-lite")

}