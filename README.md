# Meteor Grant Disbursement - Q2

## Overview 
This application is developed using Java 8 (Springboot). Databased used: PostgreSQL.

## Setup
1. Clone the code to your local machine.
2. Ensure that your JAVA_HOME environment has been set and pointing to your your Java JDK. 
  MacOS example (Terminal, vim ~/.bash_profile): 
    ```
    export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.0.7.jdk/Contents/Home
    ```
3. Ensure that you have maven installed (eg. run mvn -v does not return an error and shows you a version of your maven). 
   Else, set up mvn (MacOS)
   ```
   brew install maven
   ```
4. Ensure that you have postgresql installed. (eg. run psql on terminal)
    Else, set up postgresql (MacOS) via terminal below. Alternatively, you can download it from their site at https://www.postgresql.org/download/
    ```
    brew install postgresql
    ```
5. To run the application locally, update the user and password of your postgres DB in application.properties and create a Database table called `meteor` in your local postgres. 
    Example: 
    ```
    CREATE DATABASE meteor;
    ```
6. Run the `init.sql` script using psql command line. 
    Example with username `meteor`:
    ```
    psql -U meteor -d meteor -a -f src/main/resources/init.sql
    ```
7. Open the source code and ensure that the JDK is set up for the project in your IDE.
8. (Please complete step 6 first) At the root directory, run `maven clean install` to download all dependencies and build the executable JAR.   
9. Then, run the application using `java -jar target/grant_disbursement-0.0.1-SNAPSHOT.jar`.
10. Finally, you can access the server at http://localhost:5000/ 

## Additional Notes
### Assumptions
* For pt 5. on grants - For each of the 5 grants, I returned a list of households that are eligible for 
them. Each household in the result contains family members that contributed to satisfying the grant condition.
(Except for Family Togetherness Scheme, where I chose to only return the husband and wife). 

### Others
* I have created some additional endpoints such as `/addMarriedCouple` to make it easier to add married couples due
to the existence of foreign key constraints to their spouse. I also added `updateFamilyMember` to allow 
for update of a family member detail.

* Uploaded a copy of `grants.postman_collection.json` for reference to API calls. - Import into Postman for better visibility.