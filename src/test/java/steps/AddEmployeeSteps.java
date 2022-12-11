package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        //WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        click(dashboardPage.pimOption);
    }
    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        //WebElement addEmployeeOption = driver.findElement(By.id("menu_pim_addEmployee"));
        click(dashboardPage.addEmployeeOption);
    }
    @When("user enter {string} and {string}")
    public void user_enter_firstname_and_lastname(String firstName, String lastName) {
        //WebElement firstName = driver.findElement(By.id("firstName"));
        //firstName.sendKeys("Sheldon ");
        sendText(addEmployeePage.firstNameField, firstName);

        //WebElement lastName = driver.findElement(By.id("lastName"));
        //lastName.sendKeys("Cooper");
        sendText(addEmployeePage.lastNameField, lastName);
    }

    @When("user enters {string} and {string} for adding multiple employees")
    public void user_enters_and_for_adding_multiple_employees(String firstNameValue, String lastNameValue) {
        sendText(addEmployeePage.firstNameField, firstNameValue);
        sendText(addEmployeePage.lastNameField, lastNameValue);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {

        //WebElement saveButton = driver.findElement(By.id("btnSave"));
        click(addEmployeePage.saveButton);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added");
    }
}
