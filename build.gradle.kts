// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.gradle.versions)
    alias(libs.plugins.version.catalog.update)
//    alias(libs.plugins.compose.compiler) apply false
}

apply("${project.rootDir}/buildscripts/toml-updater-config.gradle")