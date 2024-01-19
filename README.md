![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)

# Nopcommerce Framework Selenium Java by haterest

This framework is written in Java, implement a Selenium test project with `Selenium 4` and `Maven`. Everything is set up and tests can be added straight away. 
It build for [Nopcommerce](https://demo.nopcommerce.com/) site, to execute the tests just browse test suite below or using command line and type `mvn clean test`.
The project will using Google Chrome by default if no other browser is stated.

## :arrow_forward: System requirements
* Install JDK >= 11
* Intall Chrome browser | Firefox browser | Edge browser
* Setup Maven environment
* Using IntelliJ IDEA (recommend)
* Install [Git](https://git-scm.com/downloads)

## :arrow_forward: How to use
:white_circle: Using cmd/Git in project dir follow command below:
* Chrome (default) `mvn clean test`
* Headless Chrome `mvn clean test -DbrowserName=h_chrome`
* Firefox (not recommend) `mvn clean test -DbrowserName=firefox`
* Headless Firefox (not recommend) `mvn clean test -DbrowserName=h_firefox`
* Edge `mvn clean test -DbrowserName=edge`
* Safari (only MAC OS) `mvn clean test -DbrowserName=safari`
> Due to bug with the Firefox browser so don't run it with Firefox

:white_circle: Using test suite for running the test by following the project path `\src\test\resources\RunNopcommerceTest.xml`

---

> Grid, Extend Report and Parallel features will be update late...
