object Dependencies {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"

    object Plugins {
        const val detekt = "io.gitlab.arturbosch.detekt"
        const val ktlint = "org.jlleitschuh.gradle.ktlint"
        const val templates = "app.futured.arkitekt.templates"
    }

    object Kotlin {
        const val gradlePlugin = "gradle-plugin"
        const val stdlib = "stdlib-jdk7"
    }

    object Support {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val ktx = "androidx.core:core-ktx:${Versions.androidx}"
        const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
        const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
        const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
        const val vectordrawable = "androidx.vectordrawable:vectordrawable:${Versions.vectorDrawable}"
        const val preference = "androidx.preference:preference-ktx:${Versions.preference}"
    }

    object DependencyInjection {
        const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
        const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
        const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    }

    object NavigationComponents {
        const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationComponents}"
        const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationComponents}"
        const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigationComponents}"
    }

    object Networking {
        const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    }

    object Taste {
        const val mvvmDagger = "app.futured.arkitekt:dagger:${Versions.arkitekt}"
        const val mvvmCrInteractors = "app.futured.arkitekt:cr-usecases:${Versions.arkitekt}"
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
