# Checkout from git:
    git clone <url>
    cd reward-points

# Testing:
    mvn test

# Running the app:
    mvn spring-boot:run 


# APIs With Examples:
* [GET] / - gets all transactions
* [GET] /customer-id/101 - gets all transactions belonging to customer 101
* [GET] /get-reward-points?amount=230 - gets reward points based on amount USD 230
* [GET] /get-reward-points-by-customer-id/101 - gets reward points based on the transactions done by customer with id 101
* [GET] /4 - gets the transaction with id 4
* [POST with payload] / - saves a transactions


#Default Configuration (defines the break points and multipliers for the rewards):
* firstThreshold=50
* firstThresholdMultiplier=1
* secondThreshold=100
* secondThresholdMultiplier=2

### Dependencies
* spring-boot-starter-web
* lombok
* spring-boot-starter-test (test scope)