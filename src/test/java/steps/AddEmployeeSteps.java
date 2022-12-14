package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import pages.EmployeeListPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    @When("user adds multiple employees and verify they are added successfully")
    public void user_adds_multiple_employees_and_verify_they_are_added_successfully(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> employeeNames = dataTable.asMaps();

        //getting the map from list of maps
        for (Map<String, String> employee : employeeNames) {
            //getting the  keys and values from every map
            String firstNameValue = employee.get("firstName");
            String middleNameValue = employee.get("middleName");
            String lastNameValue = employee.get("lastName");

            sendText(addEmployeePage.firstNameField, firstNameValue);
            sendText(addEmployeePage.lastNameField, lastNameValue);
            sendText(addEmployeePage.middleNameField, middleNameValue);

            click(addEmployeePage.saveButton);
            Thread.sleep(2000);
            //till this point one employee has been added
            //verifying the employee is home-work
            click(dashboardPage.addEmployeeOption);
            Thread.sleep(2000);
        }
    }

    @When("user adds multiple employee from excel using {string} and verify it")
    public void user_adds_multiple_employee_from_excel_using_and_verify_it(String sheetName) throws InterruptedException {

        List<Map<String, String>> empFromExcel = ExcelReader.excelListIntoMap(Constants.TESTDATA_FILEPATH, sheetName);

        //it returns one map from list of maps
        Iterator<Map<String, String>> itr = empFromExcel.iterator();

        while (itr.hasNext()) {
            //it returns the key and value for employee from excel
            Map<String, String> mapNewEmp = itr.next();

            sendText(addEmployeePage.firstNameField, mapNewEmp.get("firstName"));
            sendText(addEmployeePage.middleNameField, mapNewEmp.get("middleName"));
            sendText(addEmployeePage.lastNameField, mapNewEmp.get("lastName"));
            String empIdValue = addEmployeePage.empIdLocator.getAttribute("value");

            sendText(addEmployeePage.photo, mapNewEmp.get("photo"));

            if (!addEmployeePage.checkBox.isSelected()) {
                click(addEmployeePage.checkBox);
            }
            sendText(addEmployeePage.createUsernameField, mapNewEmp.get("username"));
            sendText(addEmployeePage.createPasswordField, mapNewEmp.get("password"));
            sendText(addEmployeePage.confirmPasswordField, mapNewEmp.get("confirmPassword"));

            click(addEmployeePage.saveButton);
            //verification is in home-work
            Thread.sleep(3000);

            click(dashboardPage.empListOption);
            Thread.sleep(2000);

            //to search the employee, we use emp id what we captured from attribute
            sendText(employeeListPage.empSearchIdField, empIdValue);
            click(employeeListPage.searchButton);

            //verifying the employee added from the excel file

            List<WebElement> rowData =
                    driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));


            for (int i =0; i<rowData.size(); i++){
                //getting the text of every element from here and storing it into string
                String rowText = rowData.get(i).getText();
                System.out.println(rowText);

                String expectedData = empIdValue + " " + mapNewEmp.get("firstName")
                        + " " + mapNewEmp.get("middleName") + " " + mapNewEmp.get("lastName");

                //verifying the exact details  of the employee
                Assert.assertEquals(expectedData, rowText);

            }

            click(dashboardPage.addEmployeeOption);
            Thread.sleep(2000);
        }
    }
}
