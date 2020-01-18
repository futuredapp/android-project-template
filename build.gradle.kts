import app.futured.androidprojecttemplate.Clean
import app.futured.androidprojecttemplate.DependencyUpdates
import app.futured.androidprojecttemplate.LintCheck
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Dependencies.gradlePlugin)
        classpath(kotlin(Dependencies.Kotlin.gradlePlugin, Versions.kotlin))
        classpath(Dependencies.NavigationComponents.safeArgs)
    }
}

plugins {
    idea
    id(Dependencies.Plugins.detekt) version Versions.detekt
    id(Dependencies.Plugins.ktlint) version Versions.ktlintGradle
    id(Dependencies.Plugins.templates) version Versions.templates
}

tasks {
    register<Clean>("clean")
    register<LintCheck>("lintCheck")
    register<DependencyUpdates>("dependencyUpdates")
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { setUrl("https://jitpack.io") }
        gradlePluginPortal()
    }
}

subprojects {
    apply(plugin = Dependencies.Plugins.ktlint)

    ktlint {
        version.set(Versions.ktlint)
        ignoreFailures.set(true)
        android.set(true)
        outputToConsole.set(true)
        reporters.set(setOf(ReporterType.PLAIN, ReporterType.CHECKSTYLE))
    }
}

detekt {
    version = Versions.detekt
    input = files(rootDir, "buildSrc/")
    filters = ".*/resources/.*,.*/build/.*"
    config = files("$rootDir/detekt.yml")
    failFast = false
}

ktlint {
    version.set(Versions.ktlint)
    ignoreFailures.set(true)
    android.set(true)
    outputToConsole.set(true)
    reporters.set(setOf(ReporterType.PLAIN, ReporterType.CHECKSTYLE))
}
