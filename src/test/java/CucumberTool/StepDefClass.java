package CucumberTool;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepDefClass {

//    WebDriver driver;
//    @Given("user is navigated to HRMS application")
//    public void user_is_navigated_to_hrms_application() {
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    }
//
//    @When("user enters username and password")
//    public void user_enters_username_and_password() {
//        WebElement userName = driver.findElement(By.xpath("//input[@id = 'txtUsername']"));
//        userName.sendKeys("admin");
//        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
//        password.sendKeys("Hum@nhrm123");
//    }
//
//    @When("user clicks on login button")
//    public void user_clicks_on_login_button() {
//        WebElement logIn = driver.findElement(By.xpath("//input[@name = 'Submit']"));
//        logIn.click();
//    }
//
//    @Then("user is successfully logged in")
//    public void user_is_successfully_logged_in() {
//        WebElement welcomeText = driver.findElement(By.xpath("//a[text() = 'Welcome Admin']"));
//        if(welcomeText.isDisplayed()){
//            System.out.println("Test case is passed");
//        }else{
//            System.out.println("Test case is failed ");
//        }
//
//        //boolean msgIsDisplayed = welcomeText.isDisplayed();
//        //Assert.assertTrue(msgIsDisplayed);
//    }


}
