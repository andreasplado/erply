# erply

## Serverside application


Written in: Spring boot(Java) </br>
Web service host provider is herouku.</br>
Service end-points: https://erply-backend-test.herokuapp.com/api/v1/products/</br>
Database: H2Db</br>
To deploy this serverside app locally you need maven.
```
mvn spring-boot:run
```


## Client-side web application:

Client-side web app is located in https://erply-frontend-test.000webhostapp.com/shop.html#home

Try via POSTMAN or any other RESTful app tester

post
URL: https://erply-backend-test.herokuapp.com/api/v1/products/
```json
{
	"name":"Puldiga juhitav droon",
	"price": 15.5
}
```
(posts product)

update
URL: https://erply-backend-test.herokuapp.com/api/v1/products/1
(updates the product with id 1)

```json
{
	"name":"Telefoniga juhitav droon",
	"price": 15.5
}
```

delete
URL: https://erply-backend-test.herokuapp.com/api/v1/products/1
(deletes the product with id 1)

To see the result just go https://erply-backend-test.herokuapp.com/api/v1/products or watch how data is getting automatically displayed on the client app located in https://erply-frontend-test.000webhostapp.com/shop.html#home
