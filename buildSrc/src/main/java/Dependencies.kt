object Versions {
    const val kotlin = "1.3.21"
    const val appCompat = "1.4.0"
    const val coreKtx = "1.7.0"
    const val constraintLayout = "2.1.4"
    const val junit = "4.13.2"
    const val espressoCore = "3.5.1"
    const val retrofit = "2.9.0"
    const val retrofitCoroutines = "0.9.2"
    const val retrofitGson = "2.6.0"
    const val gson = "2.10"
    const val okHttp = "4.10.0"
    const val coroutines = "1.5.2"
    const val hilt = "2.44"
    const val lifecycle = "2.5.1"
    const val nav = "2.5.3"
    const val room = "2.4.2"
    const val recyclerview = "1.2.1"
    const val glide = "4.13.0"
    const val androidJunit = "1.1.5"
    const val material = "1.4.0"
}

object Libraries {
    // KOIN
    val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    // ROOM
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    val roomRunTime = "androidx.room:room-runtime:${Versions.room}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    // RETROFIT
    val retrofitCoroutineAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
    val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    // GLIDE
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    val material = "com.google.android.material:material:${Versions.material}"
}

object KotlinLibraries {
    val kotlinCoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object AndroidLibraries {
    // KOTLIN
    val kotlinCoroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    // ANDROID
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
    val navigationFrag = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
}

object TestLibraries {
    // ANDROID TEST
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    val junit = "androidx.test.ext:junit:${Versions.androidJunit}"
    val junitTest = "junit:junit:${Versions.junit}"
}