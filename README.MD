# User-Management System 

This is the basic User-Management System which provides the following functionality.

* Registration 
* Fetching
* Updation
* Deletion

## Installation

For using the above project Install some tools.
* Use the LTS version of Java 11 [jdk](https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html) to run the project.
* An IDE(Intellij preferred). You can use your own favourite IDE but make sure maven is installed.

## Usage

```python

 REST ENDPOINTS OF THE PROJECT:

# ACCESS DATABASE
http://localhost:8080/h2-console
       #JDBC url: jdbc:h2:mem:users
       #Username: admin
       #Password: admin



# REGISTERING A USER
http://localhost:8080/user/registeruser


# FETCHING ALL USER
http://localhost:8080/user/showalluser


# FETCH USER BY ID
http://localhost:8080/user/showuser/<provide user Id>


# FETCH USER BY USERNAME
http://localhost:8080/user/showuserbyname/<provide username>


# UPDATING A USER
http://localhost:8080/user/updateuser


# DELETE ALL USER
http://localhost:8080/user/deletealluser


# DELETE USER BY ID 
http://localhost:8080/user/deleteUserbyid/<provide ID>


```
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.


## Assumptions

* I had used In-memory H2 Relational Database for storing user data.
* You can use any other database such as PostgreSQL, MySQL.

* For the usage part go to the application.properties file and change the

```bash
spring.datasource.url= <Your Database url>
spring.datasource.driver-class-name= < Your database driver>

