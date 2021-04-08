import org.jetbrains.kotlin.utils.strings.substringWithContext

plugins {
//    id("org.jetbrains.kotlin.js") version "1.3.61"
    //id 'org.jetbrains.kotlin.js' version '1.4.31'
    kotlin("js") version "1.3.61"
}

group = "br.com.dlogica"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))
}

kotlin {
    target {
        nodejs()
        browser {
            this.webpackTask {
                //var sdir = "${rootProject}"

                this.destinationDirectory = File("${rootDir}/dlg_logon/src/main")
//                this.destinationDirectory = File("${projectDir}/build")

//                this.destinationDirectory = File("${rootDir}/lib")
//                this.destinationDirectory = File("src/main/resources")
            }
        }
    }
    sourceSets["main"].dependencies {
        implementation(npm("dayjs", "^1.8.20"))
    }
}

tasks {
    compileKotlinJs {
        kotlinOptions {
            moduleKind = "umd"
        }
    }
}
