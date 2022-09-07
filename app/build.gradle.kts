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
        buildConfigField("String","DATABASE_NAME","\"market_app_database\"")
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
        jvmTarget = ConfigVersions.java
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
    implementation(project(Modules.splashScreen))
    
    implementation(Dependencies.UI.appCompat)
    implementation(Dependencies.UI.constraintLayout)
    implementation(Dependencies.UI.materialComponents)

    implementation(Dependencies.Navigation.navigationComponentFragmentKtx)
    implementation(Dependencies.Navigation.navigationComponentUiKtx)

    implementation(Dependencies.Dagger2.dagger2)
    kapt(Dependencies.Dagger2.kapt)

    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.jsonSerialization)
    implementation(Dependencies.Retrofit.converter)
    implementation(Dependencies.Retrofit.interceptor)
    implementation(Dependencies.Retrofit.flowAdapter)

    implementation(Dependencies.Database.room)
    implementation(Dependencies.Database.ktx)
    kapt(Dependencies.Database.kapt)



}