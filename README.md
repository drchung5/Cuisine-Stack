# Cuisine Microservice using Zuul, Ribbon and Eureka

Listening on port: 7000

### Get all cuisines
curl --location --request GET 'http://localhost:8080/cuisine-service/cuisines'

### Get a cuisine
curl --location --request GET 'http://localhost:8080/cuisine-service/cuisines/1'

### Add a cuisine
curl --location --request POST 'http://localhost:8080/cuisine-service/cuisines' \
--header 'Content-Type: application/json' \
--data-raw '{"cuisine_id":4, "name":"Pho"}'