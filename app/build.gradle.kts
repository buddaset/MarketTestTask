plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlinx-serialization")
    id ("kotlin-kapt")

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



        buildConfigField("String", "BASE_URL", "\"${properties["BASE_URL"]}\"")
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
    implementation(project(Modules.core_ui))
    implementation(project(Modules.mainScreen))
    implementation(project(Modules.productDetails))
    implementation(project(Modules.myCart))
    implementation(project(Modules.tabBar))

    implementation(Dependencies.AndroidKTX.core)
    implementation(Dependencies.AndroidKTX.runtime)
    implementation(Dependencies.AndroidKTX.viewModel)
    implementation(Dependencies.AndroidKTX.fragment)

    implementation(Dependencies.UI.appCompat)
    implementation(Dependencies.UI.constraintLayout)
    implementation(Dependencies.UI.materialComponents)

    implementation(Dependencies.Navigation.navigationComponentFragmentKtx)
    implementation(Dependencies.Navigation.navigationComponentUiKtx)

    testImplementation(Dependencies.Tests.junit)
    androidTestImplementation(Dependencies.Tests.junitExt)
    androidTestImplementation(Dependencies.Tests.junitExt)

    implementation(Dependencies.Dagger2.dagger2)
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



}