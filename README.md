## Agency Booking REST API.

To build run

mvn clean install

After success build create the docker image by running

# docker build -t bookingapi:1 .

---------------------------------------------
After creating the image run

# docker run -p 8080:8080 --name tango bookingapi:1 

--------------------------------------------
#Preconfiguration for testing preloading data was created in the file
${Classpath}/resources/import.sql

Once the application is running you will be exposed to endpoints

# GET
http://localhost:8080/api/booking/reservations/{userId}
http://localhost:8080/api/booking/reservations/1000
# POST
http://localhost:8080/api/booking/reservations/save/{userId}
http://localhost:8080/api/booking/reservations/save/1000

Payload sample

{
"room": "S57",
"price": 1500,
"rooms": 1,
"persons": 1,
"children": 0,
"openBuffet": "N",
"arrivalDate": "2023-05-01",
"departureDate":"2023-05-03",
"stayDays": 2
}

# PUT
http://localhost:8080/api/booking/reservations/update/{userId}

Payload sample 

{
"id": 1,
"room": "S50",
"price": 250,
"rooms": 2,
"persons": 2,
"children": 2,
"openBuffet": "Y",
"arrivalDate": "2023-04-07",
"stayDays": 8
}

# DELETE
http://localhost:8080/api/booking/reservation/delete/{resId}
