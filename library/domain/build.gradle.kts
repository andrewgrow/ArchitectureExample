plugins {
    id("java-library")
    id ("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra.get("kotlinVersion") as String}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.3")
}