# Using Cucumber JVM and Selenium in Eclipse
## Table of Contents
 1. [General Information](#1GeneralInformation)
    1. [Cucumber](#1.1Cucumber)
    2. [Selenium](#1.2Selenium)
 2. [Installation Tutorial](#2InstallationTutorial)
    1. [Cucumber-JVM](2.1CucumberJVM)
    2. [Selenium Web Driver](2.2SeleniumWebDriver)
    3. [Cucumber Eclipse Plugin](2.3CucumberEclipsePlugin)
 3. [Gherkin](3Gherkin)
    1. [General Information](3.1GeneralInformation)
    2. [Syntax](3.2Syntax)

## <a name="1GeneralInformation"></a>1 General Information

### <a name="1.1Cucumber"></a> 1.1 Cucumber
Cucumber is a software tool used by programmers to test other software. The original 
implementation is written in Ruby and was designed for Ruby testing exclusively. Nowadays
many different programming languages are supported through multiple implementations e.g. 
Cuke4php for PHP or Cucumber-JVM for Java.
The tool provides a Behavior-Driven Development (BDD) framework and allows you to run
automated acceptance tests written in BDD style. Central to this is the programming language
called Gherkin. Gherkin enables you to specify expected software behaviors in a logical 
language easy to understand because of its similarities to natural languages. However, Cucumber
doesn’t provide built-in browser automation if you want to test websites or web applications. 
For that purpose you can integrate existing solutions like for example Selenium

### <a name="1.2Selenium"></a> 1.2 Selenium 
Selenium is a portable software testing framework for web applications. It is written in
Java and the current stable release is version 3.5.0 published on August 10, 2017. The
framework consists of multiple components and provides the domain-specific language
Selenese to write test scripts. Alternative to writing tests directly in Selenese tests 
can be written in other programming languages like Java by using the provided Selenium 
client API to access the functionalities. Another important component of Selenium,
especially for the use in combination with Cucumber, is the Selenium Web Driver which
accepts commands in Selenes or via the client API and sends them to a browser by using the
specific browser driver (e.g. Geckodriver for Firefox).

## <a name="2InstallationTutorial"></a> 2 Installation Tutorial

### <a name="2.1CucumberJVM"></a> 2.1 Cucumber-JVM
Sadly there is no preconfigured installation that can be downloaded and executed so we 
have to get the necessary files ourselves. **Important:** Do not confuse the eclipse plugin of
cucumber you will find when searching for cucumber in the Eclipse Marketplace with the 
real cucumber! This plugin is handy and enables syntax-highlighting for the gherkin 
programming language but it’s not mandatory.
The cucumber functionality is spilt up into multiple modules that are contained in 
different .jar files. This enables the user to choose the components of cucumber that
are necessary for the project. The following list of jars/modules contains the jars used
in the example project of this GitHub repository and which should suffice for most of the
projects as a basic version of cucumber. Important: Be careful with the versions of the
files and check if they are compatible with each other in both of the integration methods
because incompatible versions can cause problems/errors. The current recommended versions 
(Oct 17) are:
 -	cucumber-core-1.2.5
 -	cucumber-java-1.2.5
 -	cucumber-junit-1.2.5
 -	cucumber-jvm-deps-1.0.5
 -	cucumber-reporting-3.10.0
 -	gherkin-2.12.2
 -	mockito-all-2.0.2-beta
 -	cobertura-2.1.1
 -	junit-4.12 (if not already installed)
 
 If you need additional functionality, like for example the support of Android for 
 Cucumber, then you always can check if Cucumber provides this functionality and download
 the corresponding .jar file if it exists.
There are two relatively easy methods to get the jar files and integrate them into a
project. The first and easiest way is simply by adding the files with the help of maven
into your project. All jar files are published in the central Maven repository and can
be simply added to a Maven project by adding dependencies for the needed .jar files to 
the pom.xml and rebuild the project dependencies. The code snippet shows an example 
extract from a pom.xml which adds the cucumber-java and cucumber-junit .jar to the project
build.
```XML
    <dependency>
        <groupId>info.cukes</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>1.2.4</version>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>info.cukes</groupId>
        <artifactId>cucumber-junit</artifactId>
        <version>1.2.4</version>
        <scope>test</scope>
    </dependency>
```
In the case you don’t use Maven or don’t want to use it in your project you will have to 
use the second, more complicated method to setup Cucumber-JVM. You will have to add the 
necessary .jar files manually to the project after you downloaded them. To download the 
files you can use the online Maven Repository by using [https://search.maven.org](https://search.maven.org) 
and search for the files and download them. The pictures below show an exemplary download of the
cucumber-java.jar to illustrate the procedure. 
![Maven Search](https://raw.githubusercontent.com/DavidLehmann/EPortfolioCucumberJVM/master/Pictures/MavenSearch.PNG)
Of course you can use other means to search for a download, for example Google.

After you now downloaded all the needed archives you just need to integrate them into your project by including them into the
projects library. If you don’t how to do that the following screenshots will guide you through the process. 

![Build Path Selection](https://raw.githubusercontent.com/DavidLehmann/EPortfolioCucumberJVM/master/Pictures/BuildPathSelection.PNG)

Right-Click on the project you want to add the cucumber jars. Then select "Build Path" and click on "Configure Build Path..."
![Add External JARS](https://raw.githubusercontent.com/DavidLehmann/EPortfolioCucumberJVM/master/Pictures/AddExternalJARS.PNG)

Open the the tab "Libraries" in the window that opened. Click on the button "Add External JARs.."
and navigate to the downloaded files and add them. After you confirm the .jars should appear in 
the middle window and you can click on "Apply" and close the window.

### <a name="2.2SeleniumWebDriver"></a> 2.2 Selenium Web Driver
The installation of the Selenium Web Driver is similar to the second installation method of Cucumber JVM. First of all you will have to download the necessary files which you can get from [http://www.seleniumhq.org/download/](http://www.seleniumhq.org/download/). 
Screenshot
The files are downloaded as a .zip compressed file. After you unzip them you see that it contains the file client-combined-3.6.0.jar, a lib folder containing .jar files and some additional files. To setup the Selenium Web Driver in your project you now have to add the client-combined-3.6.0.jar and all the .jar files from the lib folder into the build path like before (see 2.1).
Lastly, you have to download a browser driver for the browser you want selenium to operate on. The example projects of this e-portfolio use the “geckodriver” for Firefox which you can download [here](https://github.com/mozilla/geckodriver/releases). Of course there are other browser drivers, for example “chromedriver”, but I won’t cover them here for simplicity reasons and because they should function similar to the “geckodriver” and the shown procedures should apply to them too.
After you downloaded and unzipped the file you will just have to remember the path so you can access the driver from your code. I suggest that you move the “geckodriver.exe” to your project folder, to simplify navigating to the file and finding it.
Now you can access the driver via a created WebDriver-Object in your Java-Code, like the following listing illustrates.
```Java
WebDriver driver = null;
// Create a new instance of the Firefox driver
System.setProperty(“webdriver.gecko.driver”,”PATH_TO_GECKODRIVER.EXE”);
driver = new FirefoxDriver();
```
### <a name="2.3CucumberEclipsePlugin"></a> 2.3 Cucumber Eclipse Plugin (optional)
The installation of the optional Cucumber Plugin is pretty easy and straightforward if you already installed a plugin via the Eclipse Marketplace. If not this guide should help you installing the plugin. First of all open up Eclipse and hover over “Help” in the upper bar. In the expanding drop-down menu click on “Eclipse Marketplace…”. In the window that opened search for “Cucumber” and the result should look similar to this:
![Cucumber Plugin Marketplace](https://raw.githubusercontent.com/DavidLehmann/EPortfolioCucumberJVM/master/Pictures/CucumberPluginMarketplace.PNG)

If it does, hit the “Install” button for "Natural 0.7.6" and follow the instructions. After the installation finished you will be prompted to restart Eclipse. After that the plugin should be successfully installed.

## <a name="3Gherkin"></a> 3 Gherkin
### <a name="3.1GeneralInformation"></a> 3.1 General Information
Gherkin is a programming language used in Cucumber which is designed to be a non-technical programming language and used to describe use cases of a software system. The language should be human readable, which means that it should be readable for people with little knowledge of programming. This fact allows an entire development team (including managers etc.) to enforce unambiguous requirements from the very start of the project.

### <a name="3.2Syntax"></a> 3.2 Syntax
The Gherkin language is structured in a line-oriented design, similar to programming languages like Python and is stored in Feature-Files. These executable test script files use the file extension .feature and should contain a single feature definition for the test system. The structure of a file is defined by using whitespaces or control characters, like for example “#” which is used for line-comments. Instructions in the .feature files are recognized by a Gherkin keyword followed by a String. 
In general Cucumber tests are divided into individual Features represented in separate .feature files. These files are again divided into Scenarios, which are a sequence of Steps. In the following these specific parts will be covered and explained in more detail:
-	Feature: A feature describes one specific function of the tested software and can be considered a Use Case of the tested application. To define a Feature in Gherkin the “Feature:” keyword is used. The keyword is followed by the name for the Feature on the same line as the keyword. In the following lines a description of the Feature can be optionally supplied.
-	Scenario: A feature consists of multiple scenarios, which all describe a single flow of actions or events through the specific Feature. A scenario is recognized by the keyword “Scenario” and represents the executable test case for the system. If there is the need to test multiple runs through a scenario but with different values, a scenario template using placeholders can be defined with the help of the keyword “Scenario Outline”. When this keyword is used the placeholders marked by the tags (e.g. “<Example>”) are replaced with values from the table defined after the keyword “Examples:” in each run. In this connection the headers of the table have to equal the used placeholder names.
- Steps: The essential part of a Scenario is defined with the help of Steps that outline preconditions and the actions that going to be performed. A Step is defined with the help of the keywords “Given”, “When” and “Then” followed by a String describing the Step. The keywords defining a Step have different but intuitive meanings:
   - “Given” is used to describe preconditions that have to be met and allows a pre-test setup. 
   - “When” is used to describe user actions that happen during a test
   - “Then” is used to describe results of the actions taken during “When” clauses.
Lastly, conjunctions of this keywords can be formed with the help of the keywords “And” and “But” which both represent a logical “and” but “But” is used for the negative form

Lastly, to better illustrate the usage of Gherkin, all of the explained topics can be reviewed in the following listing (login.feature of the example project): 
```Gherkin
Feature: Login
	As a webapplication user
	In order to use the web application the user
	needs to log in
	
	If the user provides valid information he will be
	redirected to the application page. Otherwise
	the error message will be shown.
	
	Scenario: valid admin login
	Given User is on Login page
	When User provides username "Admin" and password "admin"
	Then User should be successfully logged in as Admin
	
	Scenario: valid user login
	Given User is on Login page
	When User provides username "User" and password "1234"
	Then User should be successfully logged in as User
	
	Scenario Outline: invalid logins
	Given User is on Login page
	When User provides username <username> and User provides password <password>
	Then User should not be logged in 
	And User should be shown an error message
	
	Examples:
		| username | password |
                | tester   | test     |
		| Admin    | wrong    |
```

