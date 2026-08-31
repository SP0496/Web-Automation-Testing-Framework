# Web Automation Testing Framework

A Selenium WebDriver automation framework developed using Java, TestNG, Maven and the Page Object Model design pattern. This project automates end-to-end test scenarios on the SauceDemo testing website.

## Technologies Used

* Java 17
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model
* WebDriverManager
* Extent Reports
* Git and GitHub

## Automated Test Scenarios

* Valid user login
* Products page validation
* Add a product to the cart
* Cart item validation
* Checkout form submission
* Complete purchase
* Order confirmation validation
* Automatic browser closing

## Framework Features

* Page Object Model design pattern
* Reusable explicit waits using `WebDriverWait`
* Test execution using TestNG
* Maven dependency management
* Automatic ChromeDriver setup
* Screenshot capture when a test fails
* Extent HTML test reports
* Test suite execution using `testng.xml`
* Password-manager warning prevention
* Assertions for test result validation

## Project Structure

```text
src
├── main
│   └── java
│       ├── base
│       │   └── BaseTest.java
│       ├── pages
│       │   ├── LoginPage.java
│       │   ├── ProductsPage.java
│       │   ├── CartPage.java
│       │   └── CheckoutPage.java
│       └── utils
│           ├── WaitUtils.java
│           ├── ScreenshotUtils.java
│           └── ExtentManager.java
│
└── test
    └── java
        ├── listeners
        │   └── TestListener.java
        └── tests
            ├── LoginTest.java
            └── ShoppingTest.java
```

## Test Website

This project uses the SauceDemo testing website:

https://www.saucedemo.com/

Test credentials:

```text
Username: standard_user
Password: secret_sauce
```

These are public demo credentials provided only for testing.

## Prerequisites

Install the following software before running the project:

* Java JDK 17
* Eclipse or IntelliJ IDEA
* Maven
* Google Chrome
* Git

## How to Run the Project

1. Clone the repository:

```bash
git clone https://github.com/SP0496/Web-Automation-Testing-Framework.git
```

2. Open the project in Eclipse or IntelliJ IDEA.

3. Update the Maven project to download the required dependencies.

4. Right-click `testng.xml`.

5. Select:

```text
Run As → TestNG Suite
```

Alternatively, run using Maven:

```bash
mvn clean test
```

## Test Reports

After execution, the Extent HTML report is generated inside:

```text
reports/ExtentReport.html
```

TestNG results are generated inside:

```text
test-output/
```

## Failure Screenshots

If a test fails, a screenshot is automatically captured inside:

```text
screenshots/
```

The screenshot filename contains the test name and execution time.

## Test Result

The framework successfully executes the SauceDemo login and complete purchase flow using reusable Page Object classes and TestNG assertions.

## Author

**Satish Anadasu**

GitHub: [SP0496](https://github.com/SP0496)
