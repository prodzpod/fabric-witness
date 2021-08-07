plugins {
    id("fabric-loom") version Fabric.Loom.version
    val kotlinVersion: String by System.getProperties()
    kotlin("jvm").version(Jetbrains.Kotlin.version)
    `maven-publish`
}
minecraft {}
repositories {
    mavenCentral()
    maven(url = "https://maven.fabricmc.net/") { name = "Fabric" }
    maven(url = "https://server.bbkr.space/artifactory/libs-release") { name = "CottonMC" }
    maven(url = "https://maven.siphalor.de") { name = "Siphalor's Maven" }
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    minecraft("com.mojang", "minecraft", Minecraft.version)
    mappings("net.fabricmc", "yarn", Fabric.YarnMappings.version, classifier = Fabric.YarnMappings.classifier)

    modImplementation("net.fabricmc", "fabric-loader", Fabric.Loader.version)
    modImplementation("net.fabricmc", "fabric-language-kotlin", Fabric.Kotlin.version)
    modImplementation("net.fabricmc.fabric-api", "fabric-api", Fabric.API.version)

    modImplementation(Mods.libgui)
//    modImplementation(Mods.modmenu)
    modImplementation(files("$projectDir/libs/modmenu-2.0.4.jar"))
    modImplementation(Mods.nbtcrafting)

    implementation(Google.guava)

    testRuntimeOnly(JUnit.jupiter_engine)

    testImplementation(JUnit.jupiter)
    testImplementation(Google.truth)
}

// ensure that the encoding is set to UTF-8, no matter what the system default is
// this fixes some edge cases with special characters not displaying correctly
// see http://yodaconditions.net/blog/fix-for-java-file-encoding-problems-with-gradle.html
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks {
    val javaVersion = JavaVersion.VERSION_16
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        sourceCompatibility = javaVersion.toString()
        targetCompatibility = javaVersion.toString()
        options.release.set(javaVersion.toString().toInt())
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions { jvmTarget = javaVersion.toString() }
        sourceCompatibility = javaVersion.toString()
        targetCompatibility = javaVersion.toString()
    }
    jar { from("LICENSE") { rename { "${it}_${base.archivesName}" } } }
    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") { expand(mutableMapOf("version" to project.version)) }
    }
    java {
        toolchain { languageVersion.set(JavaLanguageVersion.of(javaVersion.toString())) }
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
        withSourcesJar()
    }
    processResources {
        filesMatching("fabric.mod.json") {
            expand(
                "modid" to Info.modid,
                "name" to Info.name,
                "version" to Info.version,
                "description" to Info.description,
                "kotlinVersion" to Jetbrains.Kotlin.version,
                "fabricApiVersion" to Fabric.API.version
            )
        }
    }
}

