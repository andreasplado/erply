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

## Clientside application:

Application is uploaded to 000wehost server located in this address:
https://erply-frontend-test.000webhostapp.com/shop.html


## Testing an application:

Try via POSTMAN or any other RESTful app tester

post
URL: https://erply-backend-test.herokuapp.com/api/v1/products/ (posts product)
```json
{
	"name":"Puldiga juhitav droon",
	"price": 15.5
}
```


update
URL: https://erply-backend-test.herokuapp.com/api/v1/products/1 (updates the product with id 1)

```json
{
	"name":"Telefoniga juhitav droon",
	"price": 15.5
}
```

delete
URL: https://erply-backend-test.herokuapp.com/api/v1/products/1 (deletes the product with id 1)

To see the result just go https://erply-backend-test.herokuapp.com/api/v1/products
