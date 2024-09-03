plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.example.calendarlibrary"
    compileSdk = 34
    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx.v283)
    implementation(libs.androidx.junit.ktx)
    coreLibraryDesugaring(libs.desugar.jdk.libs)
    val composeBom: Dependency = platform("androidx.compose:compose-bom:2022.10.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation(libs.ui)
    implementation(libs.androidx.material)
    implementation(libs.ui.tooling.preview)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
}
publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = project.findProperty("gpr.groupid") as String? ?: ""
            artifactId = "calendarlibrary"
            version = project.findProperty("gpr.version") as String? ?: ""

        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/LeoSvjetlicic/CalendarLibrary")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: ""
                password = project.findProperty("gpr.token") as String? ?: ""
            }
        }
    }
}
