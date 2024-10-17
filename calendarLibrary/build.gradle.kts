plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.leosvjetlicic.calendarlibrary"
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
    implementation(libs.ui)
    implementation(libs.androidx.material)
    implementation(libs.ui.tooling.preview)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "io.github.leosvjetlicic"
                artifactId = "calendar-library"
                version = "1.2.0"
                from(components["release"])

                pom {
                    packaging = "aar"
                    name.set("CalendarLibrary")
                    description.set("Customizable calendar library for android applications")
                    url.set("https://github.com/LeoSvjetlicic/CalendarLibrary.git")
                    inceptionYear.set("2024")
                    licenses {
                        license {
                            name.set("MIT License")
                            url.set("https://github.com/LeoSvjetlicic/CalendarLibrary/blob/main/LICENSE")
                        }
                    }
                    developers {
                        developer {
                            id.set("LeoSvjetlicic")
                            name.set("Leo Svjetlicic")
                            email.set("leo.svjetlicic@gmail.com")
                        }
                    }
                    scm {
                        connection.set("scm:git:github.com//LeoSvjetlicic/CalendarLibrary")
                        developerConnection.set("scm:git:ssh://github.com/LeoSvjetlicic/CalendarLibrary.git")
                        url.set("https://github.com/LeoSvjetlicic/CalendarLibrary")
                    }
                }
            }
        }

        repositories {
            maven {
                url = uri("$buildDir/generated/release") // For testing locally
            }
        }
    }
}
