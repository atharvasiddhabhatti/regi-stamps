# java8_springboot-2.0.5-api-template-3.0

Spring Boot with MySQL

For instructions, Please refer to the link `https://pg-gitlab.altimetrik.com/PlaygroundEngineeringEnv/java8_springboot-2.0.5-api-template-3.0/blob/master/EclipseCheUserGuide.pdf`

To connect to database console of the app available over `app access url`, Please refer to `/src/main/resources/db-config-k8s.properties` having the `url` and `JDBC connection properties`

 User Guide

 swagger URL for local : http://localhost:8080/swagger-ui.html#/users

 Import postman collection from : https://www.getpostman.com/collections/c350acc4000588ac988e

 Step I : Register New user using /users/signup API .
 Example payload.
 {
     "username": "test",
     "email": "test@test.com",
     "password": "test",
     "roles": [
         "ROLE_ADMIN"
     ]
 }

 Step2 : Sign up using /users/signin API

 It will return  authentication token upon successful login.
 Copy token.

 Step 3 : Authorize swagger using  "Bearer <above token>".(For postman request replace Authorization with "above token" ) call /users/me  API.

 It will return logged in user details for valid token.


 step 4: Call /users/refresh API

 It will return  new fresh token.