# MAUI 
maui is a wrapper framework for Selenium Webdriver with the aim of providing an easier way of automating and executing tests.
The key features that maui offers are: Modularization and Element Type definition, as well as an automated retry mechanism for interacting with elements.

# Quick Start
check out the demo projects that are using maui: 

* [Test.Bash AutomationWeek Challenge](https://github.com/TestMonkeys/Test.Bash-Online---WebUi-Automation-Challenge---Intermediate)
* [CafeTownSend Demo TAS](https://github.com/monofrei/cafetownsend-atf)

# Features:
## PageObjects Definition
To define a page object you must annotate your page class with a human readable name and a relative url, and add the elements that are found on the page
```java
...
import org.testmonkeys.maui.pageobjects.AbstractPage;
import org.testmonkeys.maui.pageobjects.ElementAccessor;
import org.testmonkeys.maui.pageobjects.PageAccessor;
import org.testmonkeys.maui.pageobjects.elements.Button;
import org.testmonkeys.maui.pageobjects.elements.Input;

@Getter
@PageAccessor(name = "Landing Page", url = "/")
public class LandingPage extends AbstractPage {

    @ElementAccessor(elementName = "Submit button", byXPath = "//div[@id='submitDiv']//button")
    private Button submit;
    
    @ElementAccessor(elementName = "Username", byId = "username")
    private Input username;
...
```
The types available to use are: 
* Button
* CheckBox
* Hyperlink
* Input
* Label
* RadioButton
* Select

And you can define your custom elements to extend the list or alter the interaction.

## Retrieving the instance of a Page Object in your tests:
To get the instance of the page object you need to first initialize the Browser and PageFactory:
```java
WebDriver driver = new ChromeDriver();
Browser browser= new Browser(driver, TimeUnit.SECONDS, 10, 20);
PageFactory pageFactory=new PageFactory(browser, new PageScanner("com.yourProject.pageObjects.package"),"https://yourTestedSiteHere.com");
```
after intialisation you can retrieve the pageOjbect objects either by class name or by their name defined in the page accessor:
```java
LandingPage page= pageFactory.createPage(LandingPage.class);
```
or 
```java
LandingPage page= pageFactory.createPage("Landing Page");
```
## Opening the page in the browser

To open a specific page in the browser you can use the open method, defined in the AbstractPage class, it will take the web site's url from page factory, add the relative url defined for the page and open that in browser:
```java
page.open();
```

## Interacting with page elements

The web elements have methods for the interactions that are possible with their type and can be used directly:
```java
page.getUsername().type("admin");
loginPage.getSubmit().click();
```

## Defining modules
If you have a set of elements that you want to group, either because they are repeated on multiple pages, or they are part of a list you can define them as a custom module:
```java
public class MessageRow extends AbstractModule {

    @ElementAccessor(elementName = "Email", byXPath = ".//div[1]/p")
    private Label email;

    @ElementAccessor(elementName = "Subject", byXPath = ".//div[2]/p")
    private Label subject;

    public void click() {
        new ClickAction(subject).execute();
    }

}
```

## Working with Lists of elements

To define web element lists use GroupComponent<> class in your pageObject, annotate it with a standard @ElementAccessor, setting the locator that would find the elements in the list. This can be used with both web element components like inputs, labels or with custom defined modules:
```java
@PageAccessor(name = "Messages Page", url = "/messages")
public class MessagesPage extends AbstractPage {

    @ElementAccessor(elementName = "Messages", byXPath = "//div[@class='messages']//div[contains(@class,'row detail')]")
    private GroupComponent<MessageRow> messageList;
```
and in your tests you can get all the elements:
```java
List<MessageRow> messageElements= page.getMessageList().getAll();
```

# Compatibilities
maui is compatible with any java framework, and gives access to the underlying WebElement objects, it was also tested with BrowserStack

<a href="http://www.browserstack.com" target="_blank"><img src="https://github.com/TestMonkeys/maui/blob/browserStackIntegration/.browserStack/Browserstack-logo.svg" 
alt="BrowserStack" width="240"  /></a>
