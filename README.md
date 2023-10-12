[![Generic badge](https://img.shields.io/badge/BUILD-3.1.0-GREEN.svg)](https://bitbucket.agile.bns/scm/qat/quantum_cbt_application.git)

# Quantum Framework

This starter kit is designed to get you up and running using the Quantum framework (powered by [QAF](https://qmetry.github.io/qaf/latest/docs.html)) within few simple steps, and enable you to start writing your tests using simple [Cucumber](https://cucumber.io/).

**********************
### Getting Started
Get the Quantum application release from [here](https://bitbucket.agile.bns/scm/qat/cbt_quantum_application_release.git). For detailed instructions on getting started with the Quantum framework, refer to the [Installation Guide](https://confluence.agile.bns/display/QAT/Installation+Guide) in Confluence.

**********************
### Examples Included
* Selenium WebDriver
* LeanFT
* GigaFox
* OCR

**********************
### Project Directory Structure
```
.
│   pom.xml                                                         # Maven pom file for build and dependencies  
│   README.md                                                       # The current readme file  
│   build.yml                                                       # YAML config file for Build pipeline
│
├───resources                                                       # Default resources dir  
│       application.properties                                      # set credentials and other project properties for QAF
│
└───src												   	            
    └───main  
    │   ├───java                                                    # All code for project inside java directory  
    │   │   └───com  
    │   │       └───quantum                                         # com.quantum namespace  
    │   │           └───steps                                       # Package namespace for Gherkin/Cucumber step definitions  
    │   │               └───examples                                # Example step definitions  
    │   │               
    │   └───resources                                               # All project specific files here  
    │       │   assertMessages.properties                           # Property definitions used in qaf library AssertionService class  
    │       │   leanft.properties                                   # Controls all logging for LeanFT   
    │       │   log4j.properties                                    # Obsolete now, use test/resources/log4j.xml instead
    │       │   reportportal.properties                             # Controls all logging to Report Portal
    │       │      
    │       ├───android                                             # Additional Android properties. Specified in testng_appium file.  
    │       ├───common                                              # Common resources dir. Set with env.resources in application.properties
    │       ├───config                                              # TestNG xml test file directory  
    │       │       testng_appium.xml                               # TestNG file that runs appiumCalc feature file with @appium tag  
    │       │       testng_web.xml                                  # TestNG file that runs webSearch feature file with @Web tag  
    │       │     
    │       ├───data                                                # Data used in data driven tests stored here  
    │       ├───ios                                                 # Addition iOS properties. Specified in testng_appium file.  
    │       └───scenarios                                           # Cucumber/Gherkin feature files directory  
    │               └───examples
    │                        BranchLocator.feature                  # Sample feature file drives by testng_web xml file 
    │                        GigaFoxSample.feature                  # Confluence search test feature file called by testng_appium xml file  
    │ 
    └───test
        ├───java                                                    # All code for unit tests
        └───resources                                               # All resource specific files
                log4j.xml                                           # Controls all logging to console and log files
