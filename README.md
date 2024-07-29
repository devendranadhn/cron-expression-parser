<h4>Cron Expression Parser : </h4>

Brief :
This parses the cron output and displays the more human readable format for the cron expression. 

Assumptions:
1. This will assume the format mentioned in the p

Step to build:
1. Use JDK17 for building the project. 
2. SET JAVA_HOME as JDK 17
3. run ``` mvn clean install``` for buidling the project as well as test cases.

Steps to run:
1. After building the project make you run using below command
2. execute ``` java -jar target/cron-expression-parser-1.0.jar "*/15 1-4 3,5 1 1-5 netstat"```
3. you can also use maven to execute - ```mvn clean install```. you can change the arguments in the pom.xml




