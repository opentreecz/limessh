plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "cz.opentree.limessh"
    compileSdk = 35

    defaultConfig {
        applicationId = "cz.opentree.limessh"
        minSdk = 26
        targetSdk = 35
        versionCode = providers.gradleProperty("limessh.versionCode").orElse("1").get().toInt()
        versionName = providers.gradleProperty("limessh.versionName").orElse("0.1.0-dev").get()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            // BouncyCastle ships duplicate .SF / .DSA signature files
            excludes += "/META-INF/*.SF"
            excludes += "/META-INF/*.DSA"
            excludes += "/META-INF/*.RSA"
            excludes += "/META-INF/DEPENDENCIES"
            excludes += "/META-INF/versions/**/OSGI-INF/MANIFEST.MF"
            merges += "/META-INF/LICENSE*"
            merges += "/META-INF/NOTICE*"
        }
    }
}

ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}

dependencies {
    // AndroidX core
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
    implementation("androidx.activity:activity-compose:1.9.3")

    // Compose BOM
    val composeBom = platform("androidx.compose:compose-bom:2024.12.01")
    implementation(composeBom)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.navigation:navigation-compose:2.8.5")

    // SSH engine – SSHJ (Apache-2.0, pure JVM, modern algorithms)
    implementation("com.hierynomus:sshj:0.40.0")
    // SSHJ requires BouncyCastle
    implementation("org.bouncycastle:bcprov-jdk18on:1.79")
    implementation("org.bouncycastle:bcpkix-jdk18on:1.79")

    // Local database – Room
    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")

    // DataStore Preferences (for terminal prefs / settings)
    implementation("androidx.datastore:datastore-preferences:1.1.1")

    // Kotlin Serialization (backup JSON, SFTP metadata)
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

    // Security / encrypted preferences
    implementation("androidx.security:security-crypto:1.1.0-alpha06")

    // Biometric authentication for inactivity lock
    implementation("androidx.biometric:biometric:1.1.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")

    // WorkManager (background backup/sync)
    implementation("androidx.work:work-runtime-ktx:2.10.0")

    // Shortcuts API
    implementation("androidx.core:core-google-shortcuts:1.1.0")

    // Testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.9.0")
    testImplementation("org.mockito:mockito-core:5.12.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.4.0")
    // Isolated in-process SSH servers for real password/key authentication tests.
    testImplementation("org.apache.sshd:sshd-core:2.14.0")
    // MINA's test-server Ed25519 support is optional; this is not shipped in the app.
    testImplementation("net.i2p.crypto:eddsa:0.3.0")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(composeBom)
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
