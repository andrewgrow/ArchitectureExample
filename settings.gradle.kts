include(":demo", ":demo-data", ":demo-domain")

val pathDemo = "demos/"
project(":demo").projectDir = File(rootDir, "${pathDemo}main")
project(":demo-domain").projectDir = File(rootDir, "${pathDemo}main-domain")
project(":demo-data").projectDir = File(rootDir, "${pathDemo}main-data")

include(":core", ":data", ":domain")
val pathLibrary = "library/"
project(":core").projectDir = File(rootDir, "${pathLibrary}core")
project(":domain").projectDir = File(rootDir, "${pathLibrary}domain")
project(":data").projectDir = File(rootDir, "${pathLibrary}data")

rootProject.name = "Architecture"
