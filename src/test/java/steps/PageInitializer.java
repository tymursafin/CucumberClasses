package steps;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeListPage;
import pages.LoginPage;

public class PageInitializer {
    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static AddEmployeePage addEmployeePage;
    public static EmployeeListPage employeeListPage;

    public static void initializePageObject() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        addEmployeePage = new AddEmployeePage();
        employeeListPage = new EmployeeListPage();
    }
}
