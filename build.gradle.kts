buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.3.13")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {

    id("com.android.application") version ConfigVersions.gradle apply false
    id("com.android.library") version ConfigVersions.gradle apply false
    id("org.jetbrains.kotlin.android") version ConfigVersions.kotlin apply false
    id("org.jetbrains.kotlin.jvm") version ConfigVersions.kotlin apply false
    id("org.jetbrains.kotlin.plugin.serialization") version ConfigVersions.kotlin
    id("com.google.gms.google-services") version "4.3.2"



}


tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}
