# Movie App

## Description

This is a Java/Spring application that mimics a movie booking system. It presents all the movies from the database, available timetable for each movie and where to watch it. 

From Java's perspective, it contains 3 objects, movie, venue and timetable. The relation between movie with timetable and venue with timetable are both one to many, meaning one movie can have many timetables and one venue can have many timetables. 

![uml_diagram](/Users/fengyi/Downloads/project/BackEndProject/BackEndProject-main/MovieApp/readme/uml_diagram.png)

From Spring boot perspective, it has 4 laysers, persentation layer, business layer, persistence layer, and database layer. It contains controller, repository, model and SQL database to allow users to send and receive requests in JSON format. 

This application is part of the project concluding back-end knowledge we learned for the past 6 weeks using Java, Spring and SQL at Bright Network Technology Academy. 

## Usage

### Basic methods 

The basic methods such as getting attributes regarding movie, venue and timetable could be realised by sending the following request through [Postman](https://www.postman.com):

```java
localhost:8080/{request}
```

The example request and result is shown below:

```
localhost:8080/movies/title/Maniac
```

```json
{"id":4,"title":"Maniac","time_length":119,"rating":5,"genre":"Crime|Horror|Mystery|Romance|Thriller","price":15,"timetables":[{"id":73,"date":"Friday","time":"3:29 PM"},{"id":38,"date":"Sunday","time":"6:05 AM"},{"id":18,"date":"Monday","time":"3:43 AM"}]}
```

### Booking Movies 

This method can write user's request into a lcoal file called "MovieBookings.txt", also presents it in terminal. 

Before using this method, you should check whether the saved file address is correct. You can check it at "BookingMovie" file line 47 and 66 and "MovieController" file line 69. The advanced usage for booking movie can be reaslied by sending a request containing the following example: 

```
localhost:8080/booking/Rage of Angels/Monday/2:22 AM/Alex
```

After successfully sending the request in Postman, you should be able to see the following line in terminal and in your local MovieBooking file:

```
User: Alex UniqueID: 911, 
Movie: Rage of Angels', 100 minutes, Movie Rating = 4, Movie Genre = 'Action|Adventure|Drama|Romance', Ticket Price  = £17 
Viewing: Monday' at 2:22 AM' 
Venue: EVERYMAN'
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[Attribution-NonCommercial-NoDerivatives 4.0 International](https://creativecommons.org/licenses/by-nc-nd/4.0/legalcode)