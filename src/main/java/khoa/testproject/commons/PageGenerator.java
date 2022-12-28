package khoa.testproject.commons;


import khoa.testproject.pages.GhLoginPageObject;
import khoa.testproject.pages.LoginPageObject;
import khoa.testproject.pages.TodoListPageObject;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static GhLoginPageObject getGhLoginPage(WebDriver driver){
        return new GhLoginPageObject(driver);
    }

    public static TodoListPageObject getTodoListPage(WebDriver driver){
        return new TodoListPageObject(driver);
    }

}
