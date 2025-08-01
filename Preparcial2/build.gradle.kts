plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.hibernate:hibernate-core:6.2.7.Final")
    implementation("mysql:mysql-connector-java:8.0.33")
}

tasks.test {
    useJUnitPlatform()
}
