plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = ConfigVersions.compileSdkVersion

    defaultConfig {
        applicationId = ConfigVersions.applicationId
        minSdk = ConfigVersions.minSdkVersion
        targetSdk = ConfigVersions.targetSdkVersion
        versionCode = ConfigVersions.versionCode
        versionName = ConfigVersions.versionName

        testInstrumentationRunner ="androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = ConfigVersions.javaVersion
        targetCompatibility = ConfigVersions.javaVersion
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(Modules.core))
    implementation(project(Modules.mainScreen))

    implementation(Dependencies.Androidx.coreKtx)
    implementation(Dependencies.Androidx.appCompat)

    implementation(Dependencies.UI.constraintLayout)
    implementation(Dependencies.UI.materialComponents)

    implementation(Dependencies.Navigation.navigationComponentFragmentKtx)
    implementation(Dependencies.Navigation.navigationComponentUiKtx)

    testImplementation(Dependencies.Tests.junit)
    androidTestImplementation(Dependencies.Tests.junitExt)
    androidTestImplementation(Dependencies.Tests.junitExt)


}