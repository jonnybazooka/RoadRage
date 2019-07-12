# Road Rage Car Rental Company
This is a webapp of a simulated car rental company. It purpose is to learn jsp technology, Java EE and Hibernate.
## Server
This project is using servlet technology and is designed to run on Tomcat, but it should be possible to deploy it to any server supporting `.war` files.
### Security Constraints
Some parts of application are accessible only by a user defined as `ADMIN`. This user must be defined in `Tomcat/config/tomcat-users.xml` file. Following lines should be added:
```
<role rolename="ADMIN"/>
<user username="ADMIN" password="password" roles="ADMIN" />
```
## Database
This project is using Hibernate to manage entities. It requires `persistence.xml` file in META-INF directory located in `resources` root. This file is not tracked by git, and should be created after cloning and configured for local environment.

Connection pooling is provided by `hibernate-hikaricp`
## Bootstrap
All `.jsp` pages relay on external source of `css`: https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css