object AppConfig {
    const val applicationId = "dev.jamile.superheroes"
    const val versionName = "1.0.0"
    const val buildToolsVersion = "30.0.3"
}

object AndroidSdk {
    const val minSdk = 23
    const val compile = 29
    const val target = compile
    const val jvmTarget = "1.8"
}

object BuildPlugins {
    const val androidApplication = "com.android.application"
    const val androidLib = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExt = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
    const val navSafeArgs = "androidx.navigation.safeargs.kotlin"
}

object ClasspathDependencies {

    object Versions {
        const val buildToolsVersion = "4.0.2"
        const val navSafeArgsVersion = "2.3.0"
        const val kotlinVersion = "1.4.10"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val navSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navSafeArgsVersion}"
}

object Libs {
    object Versions {
        const val annotationVersion = "13.0"
        const val appCompatVersion = "1.1.0"
        const val constraintLayout = "2.0.0-beta4"
        const val coreKtx = "1.3.2"
        const val coroutinesVersion = "1.3.4"
        const val fragmentVersion = "1.2.2"
        const val gsonVersion = "2.8.6"
        const val koinVersion = "2.1.6"
        const val kotlinVersion = ClasspathDependencies.Versions.kotlinVersion
        const val lifecycleVersion = "2.2.0"
        const val legacySupportVersion = "1.0.0"
        const val materialVersion = "1.2.1"
        const val multidexVersion = "2.0.1"
        const val navLibVersion = "2.3.0"
        const val okHttpVersion = "4.2.1"
        const val playServicesVersion = "17.2.1"
        const val retrofitBaseVersion = "2.7.1"
        const val retrofitCoroutinesVersion = "0.9.2"
        const val recyclerVersion = "1.1.0"
        const val timberVersion = "4.7.0"
    }

    const val annotationLib = "org.jetbrains:annotations:${Versions.annotationVersion}"
    const val appCompatLib = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val coreKtxLib = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val coroutinesCoreLib = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val coroutinesAndroidLib = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val fragmentLib = "androidx.fragment:fragment-ktx:${Versions.fragmentVersion}"
    const val gsonLib = "com.google.code.gson:gson:${Versions.gsonVersion}"
    const val koinCoreLib = "org.koin:koin-core:${Versions.koinVersion}"
    const val koinCoreExtLib = "org.koin:koin-core-ext:${Versions.koinVersion}"
    const val koinAndroidXExtLib = "org.koin:koin-androidx-ext:${Versions.koinVersion}"
    const val koinScopeLib = "org.koin:koin-androidx-scope:${Versions.koinVersion}"
    const val koinViewModelLib = "org.koin:koin-androidx-viewmodel:${Versions.koinVersion}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    const val legacySupportLib = "androidx.legacy:legacy-support-v13:${Versions.legacySupportVersion}"
    const val lifecycleExtensionsLib = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"
    const val lifecycleLiveDataLib = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val lifecycleRuntimeLib = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    const val lifecycleViewModelLib = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val materialLib = "com.google.android.material:material:${Versions.materialVersion}"
    const val multidexLib = "androidx.multidex:multidex:${Versions.multidexVersion}"
    const val navFragmentLib = "androidx.navigation:navigation-fragment-ktx:${Versions.navLibVersion}"
    const val navUiLib = "androidx.navigation:navigation-ui-ktx:${Versions.navLibVersion}"
    const val okHttpLib = "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"
    const val okHttpLoggingLib = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpVersion}"
    const val retrofitCoreLib = "com.squareup.retrofit2:retrofit:${Versions.retrofitBaseVersion}"
    const val retrofitCoroutinesLib = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutinesVersion}"
    const val retrofitGsonLib = "com.squareup.retrofit2:converter-gson:${Versions.retrofitBaseVersion}"
    const val timberLib = "com.jakewharton.timber:timber:${Versions.timberVersion}"
}

object TestLibs {
    private object Versions {
        const val espresso = "3.3.0"
        const val junit4 = "4.12"
        const val junitExt = "1.1.2"
    }
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val junit4 = "junit:junit:${Versions.junit4}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
}