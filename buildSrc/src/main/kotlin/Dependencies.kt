object Dependencies {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val hiltPlugin =  "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    object Plugins {
        const val detekt = "io.gitlab.arturbosch.detekt"
        const val ktlint = "org.jlleitschuh.gradle.ktlint"
        const val templates = "app.futured.arkitekt.templates"
    }

    object Kotlin {
        const val gradlePlugin = "gradle-plugin"
        const val stdlib = "stdlib-jdk7"
        const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:1.5.0-RC"
    }

    object Compose {
        const val animation = "androidx.compose.animation:animation:${Versions.composeVersion}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.composeVersion}"
        const val foundation_layout = "androidx.compose.foundation:foundation-layout:${Versions.composeVersion}"
        const val material = "androidx.compose.material:material:${Versions.composeVersion}"
        const val material_icons_extended = "androidx.compose.material:material-icons-extended:${Versions.composeVersion}"
        const val runtime_livedata = "androidx.compose.runtime:runtime-livedata:${Versions.composeVersion}"
        const val runtime = "androidx.compose.runtime:runtime:${Versions.composeVersion}"
        const val ui = "androidx.compose.ui:ui:${Versions.composeVersion}"
        const val ui_tooling = "androidx.compose.ui:ui-tooling:1.0.0-beta09" // Replace to composeVersion when fixed preview on current version
        const val activity = "androidx.activity:activity-compose:${Versions.activity}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayout}"
    }

    object Support {
        const val ktx = "androidx.core:core-ktx:${Versions.androidx}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
        const val activityKtx = "androidx.activity:activity-ktx:${Versions.activity}"

        const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
        const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"

        // Questionable
        const val vectordrawable = "androidx.vectordrawable:vectordrawable:${Versions.vectorDrawable}"
        const val preference = "androidx.preference:preference-ktx:${Versions.preference}"
    }

    object Accompanist {
        const val accompanistGlide = "com.google.accompanist:accompanist-glide:${Versions.accompanist}"
    }

    object NavigationComponents {
        const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"
        const val navigationHilt = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigation}"
    }

    object Networking {
        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    }

    object Serialization {
        const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serializationJson}"
        const val converter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.serializationConverter}"
    }

    object Taste {
        const val mvvmCrInteractors = "app.futured.arkitekt:cr-usecases:${Versions.arkitekt}"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }

    object Other {
        const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
        const val threetenbp = "org.threeten:threetenbp:${Versions.threetenbp}:"
    }

    object Test {
        const val core = "androidx.test:core:${Versions.testCore}"
        const val runner = "androidx.test:runner:${Versions.testRunner}"
        const val junit = "androidx.test.ext:junit:${Versions.junit}"
        const val mockk = "io.mockk:mockk:${Versions.mockk}"
    }
}
