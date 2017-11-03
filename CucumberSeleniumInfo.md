# Using Cucumber JVM and Selenium in Eclipse
## 1 General Information

### 1.1 Cucumber
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

### 1.2 Selenium 
Selenium is a portable software testing framework for web applications. It is written in
Java and the current stable release is version 3.5.0 published on August 10, 2017. The
framework consists of multiple components and provides the domain-specific language
Selenese to write test scripts. Alternative to writing tests directly in Selenese tests 
can be written in other programming languages like Java by using the provided Selenium 
client API to access the functionalities. Another important component of Selenium,
especially for the use in combination with Cucumber, is the Selenium Web Driver which
accepts commands in Selenes or via the client API and sends them to a browser by using the
specific browser driver (e.g. Geckodriver for Firefox).

## 2 Installation Tutorial

### 2.1 Cucumber-JVM
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

### 2.2 Selenium Web Driver
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
### 2.3 Cucumber Eclipse Plugin (optional)
The installation of the optional Cucumber Plugin is pretty easy and straightforward if you already installed a plugin via the Eclipse Marketplace. If not this guide should help you installing the plugin. First of all open up Eclipse and hover over “Help” in the upper bar. In the expanding drop-down menu click on “Eclipse Marketplace…”. In the window that opened search for “Cucumber” and the result should look similar to this:
![Cucumber Plugin Marketplace](https://raw.githubusercontent.com/DavidLehmann/EPortfolioCucumberJVM/master/Pictures/CucumberPluginMarketplace.PNG)

If it does, hit the “Install” button for "Natural 0.7.6" and follow the instructions. After the installation finished you will be prompted to restart Eclipse. After that the plugin should be successfully installed.
