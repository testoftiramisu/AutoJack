POC of Selenide based framework in Java for E2E UI testing.

This project is meant for educational purposes only. 

#### Dependencies

    selenide = "5.7.0"
    junit = "5.6.0"
    snakeyaml = "1.2.1"
    lombok = "1.18.12"
    log4j = "1.2.17"

#### System requirements

* Java 11
* Maven
* Chrome browser

### Environment Setup

1. Make sure Java 11 SDK is installed and configured (path to Java bin folder is added to PATH environment variable on Windows)

2. Download dependencies:
    * Download [Maven](http://maven.apache.org/download.cgi)
    * Download the latest version of [Chrome](https://www.google.com/chrome/) 
    
    Alternatively, for Mac users: 
       
    * Install Maven with [Homebrew](http://brew.sh/) (for MacOS)
    ```bash
    $ brew install maven
    ```

4. Environment configuration:

    * URL of target web site and browser could be configured using config files in _yml_ format in **src/main/resources** folder. 

  
#### Running from CLI:

```bash
$ mvn clean test
``` 
    
#### Resources

##### [Sauce Labs Documentation](https://wiki.saucelabs.com/)

##### [Selenide Documentation](https://selenide.org/documentation.html)

##### [Junit Documentation](http://junit.org/javadoc/latest/index.html)

##### [Java Documentation](https://docs.oracle.com/javase/7/docs/api/)


*This code is provided on an "AS-IS” basis without warranty of any kind, either express or implied, including without limitation any implied warranties of condition, uninterrupted use, merchantability, fitness for a particular purpose, or non-infringement. Your tests and testing environments may require you to modify this framework. Issues regarding this framework should be submitted through GitHub.*