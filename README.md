# Govstack Automation Project

This repository contains automated tests for the **Govstack** platform using **Selenium**, **Java**, **TestNG**, **Cucumber**, **ExtentReports**, and **Allure Reports**. This project is aimed at automating functional tests, providing detailed and interactive reports for test execution.

## Technologies Used

- **Selenium WebDriver**: A browser automation tool for testing web applications.
- **Java**: Programming language used to write the test scripts.
- **TestNG**: Testing framework used for organizing and running tests.
- **Cucumber**: A tool for Behavior-Driven Development (BDD) that helps in writing tests in Gherkin syntax.
- **ExtentReports**: A reporting tool for generating detailed, interactive HTML reports.
- **Allure Reports**: A powerful reporting tool for generating interactive and visually appealing test reports.

## Prerequisites

Before running the tests, ensure that you have the following installed:

- **Java** (JDK 8 or higher) - [Download Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- **Maven** - [Download Maven](https://maven.apache.org/download.cgi)
- **Eclipse** or **IntelliJ IDEA** or any Java IDE
- **Selenium WebDriver** - Automatically downloaded by Maven dependencies
- **TestNG** - Automatically handled by Maven
- **Cucumber** - Automatically handled by Maven
- **ExtentReports** - Automatically handled by Maven
- **Allure Commandline** - [Installation Guide](https://docs.qameta.io/allure/)

## Setup Instructions

1. **Clone the repository:**

   ```bash
   git clone https://github.com/ghd-digital/qa-automation-testing.git
   cd govstack-automation

   Install Maven dependencies:

If you don't have Maven installed, install it first. Then, run the following command in the project directory:
mvn clean install
