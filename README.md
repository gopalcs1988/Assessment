# Assessment
This repository automates test scripts using Selenium WebDriver, TestNG framework, Maven, Docker, and Selenium Grid for execution.

## Implementation
Page Object Model (POM): Implemented the POM design pattern for test code maintainability.
Selenium Grid with Docker: Test execution on Selenium Grid using Docker for platform independence.

## Prerequisites
Java JDK 7 and above
Apache Maven
Any preferred IDE
Docker installed

## Configuration and Execution
Clone the repository to your local machine:

HTTPS: https://github.com/gopalcs1988/Assessment.git
Navigate to the cloned directory:

cd <repository_folder>

## Run the Docker Compose file to start the test environment:
### For Mac M1: 
> docker compose up

## View live script execution as a video:
Navigate to http://localhost:4444/
Click on the "Sessions" section to view the current execution.
Password for session execution on the grid: secret
After test script execution:

If "exited with code 1" is shown in the console, press Control + C to stop the Docker.

## Project Structure
```
Assessment
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── qa
│   │   │           ├── test
│   │   │           │   ├── base
│   │   │           │   │   └── TestBase.java
│   │   │           │   ├── core
│   │   │           │   │   └── BrowserInteractions.java
│   │   │           │   ├── pages
│   │   │           │   │   ├── HomePage.java
│   │   │           │   │   ├── SearchPage.java
│   │   │           │   │   └── SeatSelection.java
│   │   │           │   └── utils
│   │   │           │       └── LocatorType.java
│   │   └── resources
│   │
│   ├── test
│       ├── java
│       │   └── com
│       │       └── qa
│       │           └── test
│       │               └── testcases
│       │                   └── TicketBookingTest.java
│       └── resources
│
├── .github
│   └── workflows
│       └── selenium.yml
├── reports
├── docker-compose.yml
├── Dockerfile
├── pom.xml
├── README.md
└── TestNG.xml
```
