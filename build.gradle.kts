// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {

    id("com.android.application") version ConfigVersions.gradle apply false
    id("com.android.library") version ConfigVersions.gradle apply false
    id("org.jetbrains.kotlin.android") version ConfigVersions.kotlin apply false
    id("org.jetbrains.kotlin.jvm") version ConfigVersions.kotlin apply false
    id("org.jetbrains.kotlin.plugin.serialization") version ConfigVersions.kotlin


}


tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}