## High frequency exchange backend using SpringBoot and PostgreSQL
The goal of this project is to build a backend application which simulates trade matching in a stock exchange.

### Assumptions
All the incoming orders are processed, cleaned and stored in the database table `ordertb`.
A running instance of PostgreSQL server is present.

### Implementation details
 - Gradle provides the dependencies and build platform
 - Main package contains two classes
    - `DBConnect` - Helps connect to the database and methods are provided which return the fetched records as an ArrayList.
    - `Project1Application` - Runs the matching algorithm and SpringBoot REST service which provides the query endpoint.
 - The package `controller` has all the classes and interfaces necessary for communicating with SpringBoot for the restful service
 - The package `data` has two classes, which are bound to the Orders (unmatched records) and Trades (matched records).
 - PostgreSQL JDBC connects to the database
 
 - `DBConnect.createDatabases()` and `DBConnect.fillDbWithValues()` can be executed first to ensure that the databases 
 are created and have test values randomly generated and populated.
 
 ## REST Endpoints exposed
 All data can be queried at `localhost:8080` by appending the following:
 - `/api/stock/<stockname>` | To get orders matching a given stock name
 - `/api/party/<partyname>` | To get orders initiated a given party
 - `/api/price/<price>`     | To get orders matching the price
 - `/api/action/<action>`   | To filter orders by buy or sell
 - `/api/match/stock/<name>`     | To get the matched trades for given stock name
 - `/api/match/buyer/<name>`     | To get matched orders for a given buyer
 - `/api/match/sellerer/<name>`     | To get matched orders for a given seller
 - `/api/match/price/<price>`     | To get the matched trades matching the price
 - `/shutdown` | Shuts down the application