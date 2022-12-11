package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.concurrent.TimeUnit;

public class LoginSteps extends CommonMethods {

//    WebDriver driver;
    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        openBrowserAndLaunchApplication();

//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        //LoginPage loginPage = new LoginPage();
        //WebElement userName = driver.findElement(By.xpath("//input[@id = 'txtUsername']"));
        //userName.sendKeys(ConfigReader.getPropertyValue("username"));
        sendText(loginPage.usernameTextField, ConfigReader.getPropertyValue("username"));
        //WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        //password.sendKeys(ConfigReader.getPropertyValue("password"));
        sendText(loginPage.passwordTextField, ConfigReader.getPropertyValue("password"));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        WebElement logIn = driver.findElement(By.xpath("//input[@name = 'Submit']"));
        click(logIn);
    }

    @When("user enters ess username and ess password")
    public void user_enters_ess_username_and_ess_password() {
        WebElement userName = driver.findElement(By.xpath("//input[@id = 'txtUsername']"));
        sendText(userName, "asmahuma321");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        sendText(password,"Hum@nhrm123");
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        WebElement userName = driver.findElement(By.xpath("//input[@id = 'txtUsername']"));
        sendText(userName, "admin123");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        sendText(password,"Hum@nhrm123");
    }

    @Then("error message displayed")
    public void error_message_displayed() {
        System.out.println("Error message displayed");
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_lggen_in() {
        //WebElement welcomeMessage = driver.findElement(By.id("welcome"));
        if (dashboardPage.welcomeAdminMessage.isDisplayed()) {
            System.out.println("Test case is passed");
        } else {
            System.out.println("Test is failed");
        }
    }

}
