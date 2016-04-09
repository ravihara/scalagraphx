# README #

This project captures the code samples which are given in GraphX programming guide at Apache-Spark website. This is created and tested only on Linux (Debian/Ubuntu) for now.

### What is this repository for? ###

* Quick summary: Sample GraphX project, using Scala APIs and SBT for build
* Version: Check in build.sbt file
* [Learn Markdown](https://bitbucket.org/tutorials/markdowndemo)

### How do I get set up? ###

* **Summary of set up:**

1. Install IntelliJ-IDEA editor, scala, sbt and apache-spark packages.

2. Install Scala plugin for IntelliJ-IDEA editor.

3. Clone and import this project in the IDE - Use SBT based project import.

4. Run; ***sbt clean package*** from project root.

5. Run; ***spark-submit --class "com.github.ravihara.samples.scalagraphx.SimpleApp" --master local[4] target/scala-2.10/simple-graphx-app_2.10-&lt;VERSION&gt;.jar*** from project root.


* **Configuration**

1. Set SPARK_HOME environment variable to point to Apache-Spark installation root folder.

2. Export PATH to include bin folders in scala, sbt, IntelliJ-IDEA and spark installations.


### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines