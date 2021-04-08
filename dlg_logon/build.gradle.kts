import org.jetbrains.kotlin.backend.common.bridges.findImplementationFromInterface
import org.jetbrains.kotlin.library.impl.createKotlinLibrary

plugins {
//    id("org.jetbrains.kotlin.js") version "1.3.61"
    //id 'org.jetbrains.kotlin.js' version '1.4.31'
    kotlin("js") version "1.3.61"
}

group = "br.com.dlogica"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {

    implementation(project(":dlgw_araiz"))

    implementation(kotlin("stdlib-js"))

    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.3.2")
}

kotlin {
    target {
        nodejs()
        browser {
            this.webpackTask {
                this.destinationDirectory = File("${projectDir}/src/main")
                //this.destinationDirectory = File("${rootDir}/lib")
            }

            /*
            webpackTask {
                cssSupport.enabled = true
            }

            runTask {
                //output.libraryTarget = "comonjs2"
                cssSupport.enabled = true
            }

            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }

             */
            //binaries.executable()
        }
    }
//    sourceSets["main"].dependencies {
//        implementation(npm("dayjs", "^1.8.20"))
//    }
}

tasks {
    compileKotlinJs {
        kotlinOptions {
            moduleKind = "umd"
        }
    }
}
