plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.compose)
}

android {
  namespace = "com.toanitdev.moviedb"
  compileSdk = 36

  defaultConfig {
    applicationId = "com.toanitdev.moviedb"
    minSdk = 24
    targetSdk = 36
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    debug {

      isDebuggable = true
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

      buildConfigField("String", "BASE_URL", "\"${project.properties["BASE_URL_DEV"]}\"")
      buildConfigField("String", "API_KEY", "\"${project.properties["API_KEY_DEV"]}\"")
    }
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

      buildConfigField("String", "BASE_URL", "\"${project.properties["BASE_URL_PROD"]}\"")
      buildConfigField("String", "API_KEY", "\"${project.properties["API_KEY_PROD"]}\"")
    }


  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    jvmTarget = "11"
  }
  buildFeatures {
    compose = true
    buildConfig = true
  }
}

dependencies {

  //Gson
  implementation("com.google.code.gson:gson:2.11.0")

  //Coil
  implementation("io.coil-kt.coil3:coil-compose:3.2.0")
  implementation("io.coil-kt.coil3:coil-network-okhttp:3.2.0")


  // retrofit
  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  implementation("com.squareup.retrofit2:converter-gson:2.9.0")

  //lifecycle
  implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

  //koin
  implementation(platform("io.insert-koin:koin-bom:3.5.6"))
  implementation("io.insert-koin:koin-android")
  implementation("io.insert-koin:koin-androidx-compose")


  //Paging 3
  val pagingVersion = "3.4.2"
  implementation("androidx.paging:paging-runtime:$pagingVersion")
  implementation("androidx.paging:paging-compose:$pagingVersion")

  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.activity.compose)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.ui)
  implementation(libs.androidx.ui.graphics)
  implementation(libs.androidx.ui.tooling.preview)
  implementation(libs.androidx.material3)
  implementation(libs.material3)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation(platform(libs.androidx.compose.bom))
  androidTestImplementation(libs.androidx.ui.test.junit4)
  debugImplementation(libs.androidx.ui.tooling)
  debugImplementation(libs.androidx.ui.test.manifest)
}