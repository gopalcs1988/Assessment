# Assessment
This repository automates test scripts using Selenium WebDriver, TestNG framework, Maven, Docker, and Selenium Grid for execution.

## Implementation
Page Object Model (POM): Implemented the POM design pattern for test code maintainability.
Selenium Grid with Docker: Test execution on Selenium Grid using Docker for platform independence.

## Prerequisites
- Java JDK 7 and above
- Apache Maven
- Any preferred IDE
- Docker installed

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

Password for session execution on the grid: **secret**

After test script execution:

If "exited with code 1" is shown in the console, press Control + C to stop the Docker.

## Extend Report along with snapshots
Once the script executes successfully, the HTML report will be available at <project_directory>/reports/report.html. If any failures occur during execution, the report will contain the error log and corresponding snapshots to help debug the failure.

## Execute the scripts from github actions workflow
Navigate to 'https://github.com/gopalcs1988/Assessment/actions'

Click on the 'Run Assessment Tests' on left side under the Actions 

Click 'Run workflow' drop down and choose the branch as 'main' and click 'Run workflow' button to trigger the job


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
## Framework Setup

### TestNG and Maven
- The `TestNG.xml` file is located in the project root directory. Currently, the script is executed only on the Chrome browser; support for other browsers is currently out of scope for the business logic.
- The `pom.xml` file is located in the project root directory. Maven is used to build, deploy, and run the tests.

### Docker
- The `Dockerfile` contains the configuration to set up the Docker image to run the test scripts along with Maven commands. The `docker-compose.yaml` file contains the services for Selenium Hub, Chrome, and the test script image.

### Test Inputs
- The test scripts are currently implemented using static values, and no JSON or property files are maintained to handle dynamic values.



