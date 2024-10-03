# Course-Info
A java project where we are fetching the courses details from the PluralSight by the author name

## What are we going to build 
Let's build a course information API

## Requirement 
Store interesting courses in a database
Expose courses over a REST API 
Allow additionllal of notes the API 
Fill the databse with pluralSight courses information 

## How are we going to build this

+ Build tool - how we are to build this    ( Maven)
+ WEbAPI Call - how are we going to call pluralSight API with java ( Jackson )
+ JSOn Handling - API will return the json how are we going to parse it and handle this 
+ REST API - how we are going to expose a API  (JAX-RS /Jersey )
+ Databse interaction - how are going to save it in the Data base   (H2 database) 
+ Testing  (Junit)

All of the other challenges can be sorted out with JAVA frameworkds i.e Spring, Jakarta EE, Quarkus


Steps - 
1. Creating a CLI that will fetch the course info from PluralSight and will Store this into DataBase
![image](https://github.com/user-attachments/assets/6d675f3e-ebdc-4191-8b7c-b606fd66811a)

2. Next we will create a RestAPI server, we want the teammate to call this API to fetch the courses stored in the database
![image](https://github.com/user-attachments/assets/16903980-a8bb-465d-973e-8840e89c6183)

3. Database will be store in the local - first we will fetch the courses from Pluralsight then OUR rest API call will get the courses from the DATABASE in JSON and then we will add some additional info to this RESTAPI and expose our API call
![image](https://github.com/user-attachments/assets/514e7dee-58fe-4680-b3ed-f7cd008d0e91)






