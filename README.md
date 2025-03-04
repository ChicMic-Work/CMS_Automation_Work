# CMS Hybrid Automation Framework

## Overview
A comprehensive test automation framework that combines Selenium WebDriver for web automation &  Appium for mobile automation, and TestNG for test management. This hybrid framework is designed to support both web and mobile testing in an integrated environment.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Framework Components](#framework-components)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Mobile Testing Setup](#mobile-testing-setup)
- [Jenkins Integration](#jenkins-integration)
- [Useful Resources](#useful-resources)
- [CI/CD Details](#ci-cd-details)

## Prerequisites
- Java JDK (Latest LTS version)
- Eclipse IDE, Visual studio code or IntelliJ IDEA
- Maven
- Node.js and npm
- Appium
- XCode (for iOS testing)
- Git

## Framework Components
- **Selenium WebDriver**: Web automation testing
- **Appium**: Mobile automation testing
- **TestNG**: Test execution and management
- **Maven**: Dependency and build management
- **Allure**: Test reporting
- **Page Object Model (POM)**: Design pattern for enhanced maintainability

## Project Structure
```
CMSmobileframework
├─── TestNg
├─── src
│    ├─── main
│    │    ├─── cms.allure.reporting    # Reporting framwork
│    │    ├─── cms.pages               # Page Object classes
│    │    └─── cms.utils               # Utility classes
│    │
│    └─── test
│         ├─── cms01.logintest
│         ├─── cms02.homeScreen
│         └─── cms03.fuelcustomcase
│
├─── pom.xml
└─── Test Suites
     └─── Mobile Suites
```

## Setup Instructions

### 1. Java Setup
#### Windows:
1. Download Java from [Oracle Java SE Downloads](https://www.oracle.com/java/technologies/javase-downloads.html)
2. Run the installer
3. Set JAVA_HOME environment variable
4. Add Java to PATH

#### macOS:
1. Download Java from Oracle website
2. Run the DMG installer
3. Verify installation: `java -version`

### 2. Eclipse Setup
#### Windows:
1. Download Eclipse IDE for Java Developers
2. Run the installer
3. Select installation folder
4. Choose workspace location

#### macOS:
1. Download Eclipse DMG
2. Drag to Applications folder
3. Launch and select workspace

### 3. Maven Project Setup
1. Create new Maven project in Eclipse
2. Add dependencies in pom.xml:
```xml
<dependencies>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.8.0</version>
        <scope>test</scope>
    </dependency>
    <!-- Add other dependencies as needed -->
</dependencies>
```

## Mobile Testing Setup

### Appium Setup
1. Install Appium:
```bash
npm install -g appium@next
sudo npm i -g appium
```

2. Install Drivers:
```bash
* appium driver install xcuitest

* appium driver install uiautomator2
```

### iOS Testing Configuration
Example Desired Capabilities:
```json
{
  "platformName": "iOS",
  "appium:platformVersion": "16.6.1",
  "appium:automationName": "XCUITest",
  "appium:deviceName": "Your iPhone",
  "appium:bundleId": "com.cms.mobile",
  "appium:xcodeOrgId": "YOUR_ORG_ID",
  "appium:xcodeSigningId": "iPhone Developer",
  "appium:udid": "YOUR_DEVICE_UDID"
}
```

## Jenkins Integration

### Jenkins Setup on macOS
```bash
# Install Jenkins LTS
brew install jenkins-lts

# Start Jenkins
brew services start jenkins-lts

# Restart Jenkins
brew services restart jenkins-lts

# Update Jenkins
brew upgrade jenkins-lts
```

## Git Commands
```bash
# Remove existing remote
git remote rm origin

# Add new remote
git remote add origin https://your-repository-url.git
``` 

## Useful Resources
- [Appium Documentation](https://appium.io/docs/en/2.0/)
- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [Git Command Reference](https://confluence.atlassian.com/bitbucketserver/basic-git-commands-776639767.html)

## CI/CD Details

To run the login test case as part of your CI/CD pipeline, use the following Maven command:

```bash
mvn test -Plogincase
```

Ensure that your CI/CD environment is set up with all the necessary prerequisites and dependencies as outlined in the [Prerequisites](#prerequisites) section. This includes having Java, Maven, and any other required tools installed and configured properly.

For Jenkins integration, make sure Jenkins is configured to execute this command as part of your build process. You can add this command in the Jenkins build step to automate the testing process.

Refer to the [Jenkins Integration](#jenkins-integration) section for more details on setting up Jenkins with this project.
