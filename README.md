 

# Requirements

Backend Requirements

* JDK 11 http://jdk.java.net/java-se-ri/11 (OpenJDK)
* Maven https://maven.apache.org/download.cgi
    

---

Requirements Setup For GNU/Linux:
--

1.You can use package manager:

Java:

    $ sudo apt-get update \
    && sudo apt-get install openjdk-11-jdk \
    && java -version

Maven:

    $ sudo apt install maven \
    && mvn -version

2.Manuel Setup:

* Get JDK And Maven compressed files.

* Then extract.

* Give name without space to files. (Java File: OpenJDK-11 | Maven: Maven)

* Then move files to any where permanently.

* Last thing you should set PATH and ENVIRONMENT VARIABLE:

    * Open terminal and open .bashrc file with any editor for edit this file. (I choose gedit for this example)

            $ gedit .bashrc

    * And then add this lines.        


    Maven:

        export M2_HOME=/${PATH}/${MAVEN-MAIN-DIRECTORY}
        export PATH=$M2_HOME/bin:$PATH

    Java:        

        export JAVA_HOME=/${PATH}/${JAVA-MAIN-DIRECTORY}
        export PATH=$JAVA_HOME/bin:$PATH

# Build And Run Application

## 1. Packaging:
* Get application source code with Git. (You should have git program for run this command or you can just download source code from browser)

        $ git clone https://github.com/erensayar/CourseOtomation.git
        $ cd ToDoApp

* Compilation and build with maven.
    
        $ mvn package
    
* Now we have a jar file.

        java -jar <jarFileName>.jar
        
## 2. Use Wrappers
Also you can use maven wrapper for run the app.(mvnw or mvnw.cmd)

If you don't want setups, you can use wrapper. Easiest way run the spring application.

    $ mvn spring-boot:run

# Default Application Configurations

* Server Port : <b>8000</b>
* Swagger Directory : /swagger-ui.html
* H2 Console Directory : /h2-console/login
* H2 Console Configurations:
    * User Name: sa
    * Datasource.url: jdbc:h2:course-otomation

![h2-db-config](./dev-doc/h2.png)
    

# I Prepared Collection With Saved Request & Saved Responses
* You can use swagger of course but if you want use postman or something u can import this collection. This collection include saved request and response and all endpoints. 

Directory: ./dev-doc/Course Otomation.postman_collection.json

Some Requests:

![Requests](./dev-doc/Postman.png)

# Entity Relation Diagram (ERD)

![Requests](./dev-doc/ERD.png)