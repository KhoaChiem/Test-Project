package khoa.testproject.testcase;

import khoa.testproject.commons.BaseTest;
import khoa.testproject.commons.PageGenerator;
import khoa.testproject.pages.GhLoginPageObject;
import khoa.testproject.pages.LoginPageObject;
import khoa.testproject.pages.TodoListPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPage extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    GhLoginPageObject ghLoginPage;
    TodoListPageObject todoListPage;

    String userName = "khoachiem";
    String password = "Chiemminhkhoa1";
    String githubTtitle = "Sign in to GitHub · GitHub";
    String todoAppTitle = "Todo App";
    String TodoList1 = "aa", TodoList2 = "bb", TodoList3 = "cc", TodoList4 = "dd", TodoList5 = "ee", TodoList6 = "ff", TodoList7 = "gg", TodoList8 = "hh", TodoList9 = "ii", TodoList10 = "jj";
    @Parameters({"browser","url"})
    @BeforeClass()
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGenerator.getLoginPage(driver);
    }
    @Test
    public void TC_01_Login_Using_Github_Account() {
        loginPage.clickToGithubLoginButton();
        loginPage.switchToGithubLoginWindow(githubTtitle);

        ghLoginPage = PageGenerator.getGhLoginPage(driver);
        ghLoginPage.inputUserNameTextbox(userName);
        ghLoginPage.inputPasswordTextbox(password);
        ghLoginPage.clickLoginButton();
        ghLoginPage.switchToTodoAppWindown(todoAppTitle);

        todoListPage = PageGenerator.getTodoListPage(driver);
        todoListPage.inputToDoList(TodoList1);
        todoListPage.clickAddButton();
        todoListPage.inputToDoList(TodoList2);
        todoListPage.clickAddButton();
        todoListPage.inputToDoList(TodoList3);
        todoListPage.clickAddButton();
        todoListPage.inputToDoList(TodoList4);
        todoListPage.clickAddButton();
        todoListPage.inputToDoList(TodoList5);
        todoListPage.clickAddButton();
        todoListPage.inputToDoList(TodoList6);
        todoListPage.clickAddButton();
        todoListPage.inputToDoList(TodoList7);
        todoListPage.clickAddButton();
        todoListPage.inputToDoList(TodoList8);
        todoListPage.clickAddButton();
        todoListPage.inputToDoList(TodoList9);
        todoListPage.clickAddButton();
        todoListPage.inputToDoList(TodoList10);
        todoListPage.clickAddButton();
        todoListPage.clickLogoutButton();

        loginPage = PageGenerator.getLoginPage(driver);
        Assert.assertTrue(loginPage.isLoginMessageDisplayed("To continue you will need to sign in first,"));
        loginPage.clickToGithubLoginButton();

        todoListPage = PageGenerator.getTodoListPage(driver);
        todoListPage.clickDeleteButton(TodoList5);
        todoListPage.clickDeleteButton(TodoList6);
        todoListPage.clickDeleteButton(TodoList7);
        todoListPage.clickDeleteButton(TodoList8);
        todoListPage.clickDeleteButton(TodoList9);
        todoListPage.clickDeleteButton(TodoList10);
        todoListPage.clickLogoutButton();

        loginPage = PageGenerator.getLoginPage(driver);
        Assert.assertTrue(loginPage.isLoginMessageDisplayed("To continue you will need to sign in first,"));
   }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}