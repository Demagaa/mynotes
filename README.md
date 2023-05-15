# My Notes project

This project is created to show my ability to work with Spring Boot.
The application enables the user to manage his notes. User is able to add, delete and edit his notes in user-friendly graphical interface

## Technologies

Java 17, Spring Boot, Data JPA, MySQL, Bootstrap, Maven, Docker

## Launch:

Interaction with the service is implemented via web browser (http://localhost:8080/)

Program needs MySQL database to be set up:

Database is dockerized, run compose command in INFO/db-docker folder, this will configure DB container with some sample data:

`docker compose up`

Alternatively you can run .sql script located in db-docker/init folder and configure DB on your local server. 
Connectivity setting can be adjusted in application.properties file (localhost:3308 and root account used by default).

## Project status
Improving stage
