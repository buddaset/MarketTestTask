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

    implementation(project(Modules.core_ui))

    implementation(Dependencies.UI.appCompat)
    implementation(Dependencies.UI.constraintLayout)
    implementation(Dependencies.UI.materialComponents)

    implementation(Dependencies.Navigation.navigationComponentFragmentKtx)








}