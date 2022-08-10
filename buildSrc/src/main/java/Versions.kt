object Versions {

    const val compileSdkVersion = 32
    const val targetSdkVersion = 32
    const val minSdkVersion = 23
    const val buildToolsVersion = "30.2.2"
    const val versionCode = 1
    const val versionName = "1.0"
    const val applicationId = "com.example.markettesttask"

    const val kotlin = "1.6.20"
}

object Dependencies {

    val ui = UI
    val androidX = AndroidX
    val jetpack = Jetpack
    val test = Test

    object UI {
        private const val materialComponentVersion = "1.6.1"

        const val materialComponents =
            "com.google.android.material:material:$materialComponentVersion"
    }

    object AndroidX {
        private const val constraintLayoutVersion = "2.1.4"
        private const val appCompatVersion = "1.4.2"
        private const val coreKtxVersion = "1.7.0"

        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
        const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
        const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
    }

    object Jetpack {
        private const val navigationComponentVersion = "2.5.1"

        const val navigationComponentFragmentKtx = "androidx.navigation:navigation-fragment-ktx:$navigationComponentVersion"
        const val navigationComponentUiKtx = "androidx.navigation:navigation-ui-ktx:$navigationComponentVersion"
    }


    object Test {
        private const val junitVersion = "4.13.2"
        private const val junitExtVersion = "1.1.3"
        private const val espressoVersion = "3.4.0"

        const val junit = "junit:junit:$junitVersion"
        const val junitExt = "androidx.test.ext:junit:$junitExtVersion"
        const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"
    }
}





