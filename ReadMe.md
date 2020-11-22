# Prime Numbers Application
**Version 1.0.**

A RESTful service which calculates and returns all the prime numbers up to and including a number provided.

---
## Description
  
  
###Input Parameters  


**Initial** : initial - The application returns all prime numbers up to and including the number provided.  

**Strategy** : strategy - This is an optional parameter which is defaulted to "simple1" when not provided.
Different options for strategy parameter are : 	"simple1" , "simple2" and "sundaram".  

###Sample Calls

**Sample REST call 1**: http://localhost:8080/primes/10

**Sample Output 1**: {"strategy":"Simple1PrimeNumberGenerator","initial":10,"primes":[2,3,5,7],"errors":null}

**Sample REST call 2**: http://localhost:8080/primes/10?strategy=sundaram

**Sample Output 2**: {"strategy":"SundaramPrimeNumberGenerator","initial":10,"primes":[2,3,5,7],"errors":null}

---
## How to Run
- java -jar primes-0.0.1-SNAPSHOT.jar

## Available services
- GET [http://localhost:8080/primes/10]
- GET [http://localhost:8080/primes/10?strategy=sundaram] (strategy is an optional parameter - "simple1" , "simple2" and "sundaram".

---
## New Strategy Implementation
- Implement the interface - PrimeNumberApplicationStategy.class
- Update StrategySelector.java to include new case statement.

---
## Content Negotiation
Content Negotiation for different mediatypes is customised by WebConfig.java and overriding configureContentNegotiation method.

---
## Technology Stack
* Java 8
* [Spring Boot](https://spring.io/projects/spring-boot)
* Junit
* Marven
* Tomcat(in built)









