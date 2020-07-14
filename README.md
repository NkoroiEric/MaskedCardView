# MaskedCardView

lib is locally on my machine and you to can do the same using:
gradlew build
gradlew publishToMavenLocal

and add this to your apps build 
allProjects {
  repositories {
         mavenLocal()
  }
}

implementation 'com.enterprise.lib:material:1.0.0-alpha01'
