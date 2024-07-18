SpringbootProject
This repository contains my SpringBoot project for a library management system, which utilizes a MySQL Database as well as different springboot technologies 
This README will also act as the documentation to my application.

I made sure to set up the proper environment for my application using IntelliJ, as well as downloading the MySQL workbench and Postman in order to test all of the required API endpoints. After setting up the environment, run the DemoApplication Class found in com.example.demo, which would initiate the app. For ease of access and feasibility, all POST, PUT, GET, DELETE commands were run on the Postman application, allowing me to directly view all my data
.
When using the Postman app, all of the data was entered in the JSON format, and this option can be chosen in the Body section, then choosing "raw."

Here is an example of adding a new book using POST.

We choose: POST

We enter the appropriate URL: http://localhost:8080/api/books

We enter some data for book title and author name:
{
    "title": "Example Book",
    "author": "Example Writer"
}
and the respective output would be:
{
    "id": 10, //assuming this is the 10th book to be added
    "title": "Example Book",
    "author": "Example Writer",
    "borrowed": false,
    "borrowedBy": null
}

http://localhost:8080/api/books allows us to view all the books in the database

http://localhost:8080/api/users allows us to view all the users in the database

http://localhost:8080/api/books/X where X is the ID number displays the relative book, and same for users.

A dependency was also added to the pom.xml file which helps ensure the validity of the entered data for the users when it comes to their age, email and name.

http://localhost:8080/api/books/borrow/X/byuser/Y where X is the book ID and Y is the user ID, allowing the user to borrow this book, thus updating the book's attributes.

http://localhost:8080/api/books/return/X/fromuser/Y where X is the book ID and Y is the user ID, allowing the user to return this book and correspondingly re-update the book attributes.

All the required API endpoints were implemented and are fully functional.
