import org.jetbrains.kotlin.config.KotlinCompilerVersion
import org.jetbrains.kotlin.gradle.internal.AndroidExtensionsExtension

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
    kotlin("plugin.serialization") version Versions.kotlin
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(ProjectSettings.compileSdkVersion)
    defaultConfig {
        applicationId = ProjectSettings.applicationId
        minSdkVersion(ProjectSettings.minSdk)
        targetSdkVersion(ProjectSettings.targetSdk)
        versionCode = ProjectSettings.versionCode
        versionName = ProjectSettings.versionName

        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments.apply {
                    put("room.schemaLocation", "$projectDir/schemas")
                }
            }
        }
    }

    androidExtensions {
        configure<AndroidExtensionsExtension> {
            isExperimental = true
        }
    }

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/LICENSE")
        exclude("README.md")
    }

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
    }

    sourceSets {
        getByName("main").java.setSrcDirs(setOf("src/main/kotlin"))
        create(ProjectSettings.Flavor.DEV).java.setSrcDirs(setOf("src/dev/kotlin"))
        create(ProjectSettings.Flavor.PROD).java.setSrcDirs(setOf("src/prod/kotlin"))
        create(ProjectSettings.Flavor.MOCK).java.setSrcDirs(setOf("src/mock/kotlin"))
        getByName("test").java.setSrcDirs(setOf("src/test/kotlin"))
        getByName("androidTest").java.setSrcDirs(setOf("src/androidTest/kotlin"))
    }

    signingConfigs {
        getByName(ProjectSettings.BuildType.DEBUG) {
            storeFile = rootProject.file("./keystore/debug.jks")
            storePassword = ProjectSettings.Debug.STORE_PASSWORD
            keyAlias = ProjectSettings.Debug.KEY_ALIAS
            keyPassword = ProjectSettings.Debug.KEY_PASSWORD
        }
        create(ProjectSettings.BuildType.RELEASE) {
            storeFile = rootProject.file("./keystore/release.jks")
            storePassword = ProjectSettings.Release.STORE_PASSWORD
            keyAlias = ProjectSettings.Release.KEY_ALIAS
            keyPassword = ProjectSettings.Release.KEY_PASSWORD
        }
    }

    buildTypes {
        buildTypes {
            getByName(ProjectSettings.BuildType.DEBUG) {
                isMinifyEnabled = false
                isShrinkResources = false
                signingConfig = signingConfigs.getByName(ProjectSettings.BuildType.DEBUG)
            }
            create(ProjectSettings.BuildType.ENTERPRISE) {
                isDebuggable = true
                isMinifyEnabled = true
                isShrinkResources = true
                signingConfig = signingConfigs.getByName(ProjectSettings.BuildType.DEBUG)
                proguardFile(getDefaultProguardFile("proguard-android.txt"))
                proguardFile(file("proguard-rules.pro"))
            }
            getByName(ProjectSettings.BuildType.RELEASE) {
                isMinifyEnabled = true
                isShrinkResources = true
                signingConfig = signingConfigs.getByName(ProjectSettings.BuildType.RELEASE)
                proguardFile(getDefaultProguardFile("proguard-android.txt"))
                proguardFile(file("proguard-rules.pro"))
            }
        }
    }

    flavorDimensions(ProjectSettings.Flavor.DIMENSION)

    productFlavors {
        create(ProjectSettings.Flavor.MOCK) {
            setDimension(ProjectSettings.Flavor.DIMENSION)
        }
        create(ProjectSettings.Flavor.DEV) {
            setDimension(ProjectSettings.Flavor.DIMENSION)
        }
        create(ProjectSettings.Flavor.PROD) {
            setDimension(ProjectSettings.Flavor.DIMENSION)
        }
    }

    lintOptions {
        textReport = true // Write a text report to the console (Useful for CI logs)
        isExplainIssues = false // HTML/XML reports are too verbose in console logs
        isCheckDependencies = false // Required to get all unused resource from other modules (disabled to speed up linting)
        isCheckTestSources = true // Also check test case code for lint issues
        isCheckReleaseBuilds = false // If we run a full lint analysis as build part in CI, we can skip redundant checks
    }
}

dependencies {
    // Kotlin
    implementation(kotlin(Dependencies.Kotlin.stdlib, KotlinCompilerVersion.VERSION))

    // Support
    implementation(Dependencies.Support.appcompat)
    implementation(Dependencies.Support.ktx)
    implementation(Dependencies.Support.vectordrawable)
    implementation(Dependencies.Support.lifecycleExtensions)
    kapt(Dependencies.Support.lifecycleCompiler)
    implementation(Dependencies.Support.lifecycleLiveData)
    implementation(Dependencies.Support.constraintLayout)
    implementation(Dependencies.Support.preference)

    // MVVM
    implementation(Dependencies.Taste.mvvmDagger)
    implementation(Dependencies.Taste.mvvmCrInteractors)

    // NavigationComponents
    implementation(Dependencies.NavigationComponents.fragment)

    // Networking
    implementation(Dependencies.Networking.okHttp)
    implementation(Dependencies.Networking.logging)
    implementation(Dependencies.Networking.retrofit)
    implementation(Dependencies.NavigationComponents.ui)

    // Serialization
    implementation(Dependencies.Serialization.serialization)
    implementation(Dependencies.Serialization.converter)

    // Dependency injection
    implementation(Dependencies.DependencyInjection.dagger)
    implementation(Dependencies.DependencyInjection.daggerAndroidSupport)
    kapt(Dependencies.DependencyInjection.daggerCompiler)
    kapt(Dependencies.DependencyInjection.daggerAndroidProcessor)

    // Other
    implementation(Dependencies.Other.timber)
    implementation(Dependencies.Other.threetenbp)

    // Testing
    testImplementation(Dependencies.Test.core)
    testImplementation(Dependencies.Test.runner)
    testImplementation(Dependencies.Test.junit)
    testImplementation(Dependencies.Test.mockk)
}
