plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.apollographql.apollo3").version("3.7.2")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}
android {
    namespace = "com.example.graphqlpractice"
    compileSdk = 32

    defaultConfig {
        applicationId = "com.example.graphqlpractice"
        minSdk = 28
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    apollo {
        service("service") {
            packageName.set("com.example.graphqlpractice")
        }
    }
}

dependencies {
    val composeUiVersion: String by rootProject.extra
    val navVersion: String = "2.5.3"

    implementation("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation ("androidx.activity:activity-compose:1.3.1")
    implementation ("androidx.compose.ui:ui:$composeUiVersion")
    implementation ("androidx.compose.ui:ui-tooling-preview:$composeUiVersion")
    implementation ("androidx.compose.material:material:1.1.1")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.4")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.0")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:$composeUiVersion")
    debugImplementation ("androidx.compose.ui:ui-tooling:$composeUiVersion")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:$composeUiVersion")

    implementation("com.apollographql.apollo3:apollo-runtime:3.7.2")
  //  implementation("com.apollographql.apollo:apollo-coroutines-support:3.7.2")


    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")


    implementation("androidx.navigation:navigation-compose:$navVersion")

    implementation("androidx.compose.material:material-icons-extended:$composeUiVersion")

   // implementation(" androidx.hilt:hilt-navigation-compose:1.0.0-alpha02")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
}

kapt {
    correctErrorTypes = true
}