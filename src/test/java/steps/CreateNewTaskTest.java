package steps;

import POM.CreateTaskPage;
import POM.TasksListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.TestBase;

import java.net.MalformedURLException;

public class CreateNewTaskTest extends TestBase {
    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;

    @Given("Click Add new Task")
    public void clickAddNewTask() throws MalformedURLException {
        Android_setUp();
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
    }

    @Given("Enter TaskName")
    public void enterTaskName() {
        createTaskPage.enterTaskName("Task 1");
    }

    @Given("Enter TaskDesc")
    public void enterTaskDesc() {
        createTaskPage.enterTaskDesc("Desc 1");
    }

    @When("Click Save")
    public void clickSave() {
        createTaskPage.clickSaveBtn();
    }

    @Then("Task added successfully")
    public void taskAddedSuccessfully() {
        //driver.hideKeyboard();
        tearDown();
    }
}
