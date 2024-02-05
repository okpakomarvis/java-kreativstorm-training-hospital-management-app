#### Marvis work, 29th january 2024
1. Added Jackson Package to POM file for JSON POGO converters
2. Added spring-boot-data-validation package to POM file for data validation
3. Added  h2 database Package to the POM file for embedded Database
4. Added application.yml file to the resource folder

#### Marvis work, 2nd february  2024
1. Added Spring JPA Package to POM file 
2. Created treatmentRepository in Repository Package
3. Created MedicalReportRepository in Repository Package
4. Created AppointmentRepository in Repository Package
#### Marvis work, 5th february  2024
1. Added jwt Package to POM file
2. Added spring security Package to POM file
3. Added lang common Package to POM file, Strings utilities library
4. Created service package
5. created UserService class to the service package
6. created JWTService class to the service package
7. created AuthenticationService class to the service package
8. created Impl package
9. created AuthenticationServiceImpl class to the impl package
10. created JWTServiceImpl class to the impl package
11. created UserServiceImpl class to the impl package
12. created config package 
13. created JWTAuthenticationFilter class to the config package
14. created SecurityConfiguration class to the config package
15. created controller package
16. created AuthenticationController class to the Controller package 
17. created dto package 
18. created JWTSigInAuthenticationResponse, RefreshTokenRequest, SignInRequest, SignUpRequest class's to the dto package
19. implemented UserDetails interface to the Users class
20. change username field in users file to email
21. deleted userLogin class from the entity package
22. deleted jdbcUserRepositoryImpl class from repository package
23. deleted sql query files from the resource folder
24. created Admin login details(email="admin@gmail.com", password="pass123") in the HmsApplication class implementing CommandLine
25. created 3 APIs(http://localhost:8080/api/v1/auth/signup, http://localhost:8080/api/v1/auth/signin, http://localhost:8080/api/v1/auth/refresh), APIs for signUp, sigIn and refresh for refresh token 
