plugins {
    `maven-publish`
    kotlin("jvm") version "1.6.10"
    `java-library`
}

group = "dev.mfazio.bgg"
version = "0.5.0"

val artifactName = project.name
val artifactGroup = project.group.toString()
val artifactVersion = project.version.toString()
val publicationName = project.name

dependencies {
    val retrofitVersion = "2.9.0"

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-moshi:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-scalars:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-simplexml:$retrofitVersion") {
        exclude(mapOf("module" to "stax-api"))
        exclude(mapOf("module" to "stax"))
        exclude(mapOf("module" to "xpp3"))
    }
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.getByName("main").allSource)
}

publishing {
    publications {
        create<MavenPublication>(publicationName) {
            groupId = artifactGroup
            artifactId = artifactName
            version = artifactVersion
            from(components["kotlin"])

            artifact(sourcesJar)
        }
    }
}