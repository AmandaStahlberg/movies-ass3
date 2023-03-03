# movies-ass3

## Introduction
This project is ann assignment for Experis academy . The project is a datastore and interface to store and manipulate movie characters. 
The application is built in Spring Web and uses PostgreSQL database through Hibernate with a RESTful API to allow users to manipulate the data. 
The database stores information about characters, movies they appear in, and the franchises these movies belong to. 
The application follows certain business rules and data requirements.

### Business Rules
One movie contains many characters, and a character can play in multiple movies.
One movie belongs to one franchise, but a franchise can contain many movies.

## Database
The datbase contains the following:

### Character
* Autoincremented Id
* Full name
* Alias (if applicable)
* Gender
* Picture (URL to photo – do not store an image)

### Movie
* Autoincremented Id
* Movie title
* Genre 
* Release year
* Director (just a string name)
* Picture (URL to a movie poster)
* Trailer (YouTube link most likely)

### Franchise
* Autoincremented Id
* Name
* Description

## Repositories and Services
This project uses Repositories (extending JPA Repository) to encapsulate data access, and Services to encapsulate any business logic.

## Seeding
Some dummy data is created using seeded data. There are at least three movies, with some characters and franchises. This is done via Spring with data.sql.

## Web API
This project uses Spring Web for the Web API. The following endpoints are provided:

## Generic CRUD
Full CRUD is expected for Movies, Characters, and Franchises. 

## Reporting
The application provides the following reports in addition to the basic reads for each entity:
* Get all the movies in a franchise.
* Get all the characters in a movie.
* Get all the characters in a franchise.


## Documentation
Proper documentation is created using Swagger / Open API.

