# MaskedCardView

lib is local repo on my machine and you to can use it locally by running this commands:
gradlew build
gradlew publishToMavenLocal

and add this to your apps build 
allProjects {
  repositories {
         mavenLocal()
  }
}

implementation 'com.enterprise.lib:material:1.0.0-alpha01'
