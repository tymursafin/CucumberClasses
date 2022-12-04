package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardSteps {

    WebDriver driver;
    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        System.out.println("OK");
    }

}
