# RF Transfer Schedule

## Description

This is a challenge proposed by RF.
The aim is to build a simple REST API that lets you schedule a transfer and list all transfers already scheduled.
The requirements doc is available at **requirements** folder.


## Proposed Solution

The proposed approach uses Java 8, Maven and an embedded relational database (H2) to store the transfer data.  
"Persistence" is done in memory, so each time you turn down your service you will lose all transfer data.

## How does it work

When you run the application a Embedded Tomcat Server starts to run and serves a simple REST API.
Every time you stop your application, stored transfer data is lost.

---

## Build and run the application

You must have a JDK 8 (or newer) and Maven installed in your machine, besides having access to the Internet so that Maven can download all the dependencies to build and test the application.
You must also have Git installed.

### Clone the repository

From the command prompt, run:
```
[user@machine workspace]$  git clone https://github.com/alexdemoraes/transfer-schedule.git 
```

### Build the application

After changing directory, run:
```
[user@machine transfer-schedule]$  mvn clean install
```
All the dependencies will be downloaded, all the code will be compiled, all the tests will be executed and a jar will be placed at **target** folder.


### Run the application

After changing directory, run:
```
[user@machine transfer-schedule]$  java -jar target/transfer-schedule-0.1.0-SNAPSHOT.jar
```
After about 15 seconds (depending on the power of your machine) the application will be up and responding HTTP requests.
You can schedule or list transfers using the [endpoints](#Endpoints) below.


### Stopping the application

You can stop the application pressing Control-C.


## Testing and code Coverage

To run unit tests the application and see the code coverage you should run:

```
mvn clean test
mvn jacoco:report
```

You can see the results opening the file **target/site/jacoco/index.html** in a browser.

---

## Endpoints:

- [**POST** /transfer/schedule](#schedule)
- [**GET** /transfer/list](#list)


---

### schedule

Returns a list of transfers

**Endpoint:**

```
/transfer/schedule
```

**Curl request command**

```
curl -H "Content-Type: application/json"   --request POST   --data '
{
"origin_account_number": "000001",
"destination_account_number": "000002",
"amount": 1000.00,
"fee": 3.00,
"transfer_date": "2019-07-30"
}'   http://localhost:8080/transfer/schedule
```


**Success Response Example:**

Status: 201-CREATED
```
{
	"amount": 1000.00,
	"fee": 80.00,
	"origin_account_number": "000001",
	"destination_account_number": "000002",
	"transfer_date": "2019-07-30",
	"creation_date": "2019-07-10"
}
```

**Bad Request Response Example**

Status: 400-Bad Request
```
{
	"status": 400,
	"errors": ["Transfer Date must be a future or present date"],
	"message example": {
		"amount": 100.00,
		"origin_account_number": "012345",
		"destination_account_number": "012346",
		"transfer_date": "2019-07-15"
	}
}
```

---

### list

Returns all transfers

**Endpoint:**

```
/transfer/list
```

**Curl request command**

```
curl -i -H "Content-Type: application/json"   --request GET   http://localhost:8080/transfer/list
```

**Response example:**

```
[
{
	"amount": 1000.00,
	"fee": 80.00,
	"origin_account_number": "01",
	"destination_account_number": "02",
	"transfer_date": "2019-07-30",
	"creation_date": "2019-07-10"
}, {
	"amount": 1000.00,
	"fee": 80.00,
	"origin_account_number": "01",
	"destination_account_number": "02",
	"transfer_date": "2019-07-30",
	"creation_date": "2019-07-10"
}, {
	"amount": 1000.00,
	"fee": 80.00,
	"origin_account_number": "01",
	"destination_account_number": "02",
	"transfer_date": "2019-07-30",
	"creation_date": "2019-07-10"
}
]
```


## To-do List

* Improve Application Logs
* Create Javadocs
* Implement DAO Coverage
* Retrieve database configuration properties from Environment variables instead of the properties file
* Implement pagination for list transfers

----

