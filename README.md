Title: My Notes project

This project is created mainly to show my ability to work with Spring Boot.
The application enables the user to manage his notes. User is able to add, delete and edit his notes in user-friendly graphical interface

Technologies: Spring Boot, local MySQL database, Bootstrap, Java 17

Launch: 

In order to work properly program needs local MySQL database set up:

Using the command line:

1. If you do not already have the software, download MySQL Server and install the product.

2. Change the max_allowed_packet variable to at least 256M to allow storing larger models in the repository. See the official MySQL documentation here for details.

3. From the command line, create the database:

create database spring_web_notes;

4. Execute the following query to create a new user and grant privileges to the database rapidminer_server:

grant all privileges on spring_web_notes.* to rmUser@localhost identified by 'pswd';

With privileges granted, you have finished creating the WebNotes Server database. Record the username, password, and schema name and return to the installation instructions to complete the RapidMiner Server installation.

5. Set up the connectivity setting in application.properties file


Project status: improvement state
