import org.gradle.api.JavaVersion

object Versions {

    // UI
    const val materialComponent = "1.6.1"
    const val constraintLayout = "2.1.4"
    const val appCompat = "1.4.2"

    // Kotlin
    const val coreKtx = "1.7.0"

    // Navigation
    const val navigationComponent = "2.5.1"

    //Test
    const val junit = "4.13.2"
    const val junitExt = "1.1.3"
    const val espresso = "3.4.0"
    // LifeCycle
    const val lifecycle = "2.5.1"


}

object Dependencies {

    object Androidx {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"

    }

    object Lifecycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    }

    object UI {
        const val materialComponents =
            "com.google.android.material:material:${Versions.materialComponent}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    }

    object Navigation {
        const val navigationComponentFragmentKtx =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navigationComponent}"
        const val navigationComponentUiKtx =
            "androidx.navigation:navigation-ui-ktx:${Versions.navigationComponent}"

    }

    object Tests {
        const val junit = "junit:junit:${Versions.junit}"
        const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    }


}


object Modules {

    const val app = ":app"
    const val core = ":core"
    const val mainScreen = ":feature-main-screen"


}


object ConfigVersions {

    const val compileSdkVersion = 32
    const val targetSdkVersion = 32
    const val minSdkVersion = 23
    const val buildToolsVersion = "30.2.2"
    const val versionCode = 1
    const val versionName = "1.0"
    const val applicationId = "com.example.markettesttask"
    const val kotlinVersion = "1.6.20"
    val javaVersion = JavaVersion.VERSION_1_8

}





