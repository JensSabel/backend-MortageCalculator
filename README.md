# Backend for Mortage Calculator
Written with IntelliJ IDE using Java 17, npm v.9.4.0 and node v.19.6.0

# To run the backend
Navigate to the root file 'money' in the console, this is where the 'pom.xml' file is located

Note! Using the commands below requires that you have maven and Java installed on your computer!

Firstly, run the maven command to build a snapshot of the current application

    $ mvn package

Secondly, to run this snapshot you can use the following command:

    $ java -jar target/money-0.0.1-SNAPSHOT.jar 

ALTERNATIVELY: You can also run the maven program directly by using the following command:
    
    $ mvn exec:java

The program should now boot up with Spring and the backend is ready to process requests from the frontend application.

# Frontend application

Frontend application can be found from my other repository on GitHub: https://github.com/JensSabel/frontend-MortageCalculator
Instructions for the frontend can be found in the README.md for that repository

# Functionality and TODO

The backend currently consists of a temporary database that resets every time that the application runs. The backend uses the 8080 port.
Unfortunately, due to a heavy workload in school, I was not able to implement a fully functional database in time for the deadline, but the base constructions have been set up for it.
I reasoned that for an simple calculator as this, a database might not be needed, but absolutely something that could have value for example analytics.

//TODO:
Next step for the backend would be to implement a fully functional database and also setup Docker and docker-compose.yml file.