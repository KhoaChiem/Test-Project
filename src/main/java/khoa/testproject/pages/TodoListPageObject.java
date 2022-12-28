package khoa.testproject.pages;

import khoa.testproject.commons.BasePage;
import khoa.testproject.interfaces.TodoListPageUI;
import org.openqa.selenium.WebDriver;

public class TodoListPageObject extends BasePage {
    WebDriver driver;

    public TodoListPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToDoList(String todoList) {
        waitForElementVisible(driver, TodoListPageUI.TODO_LIST_TEXTBOX);
        sendkeyToElement(driver, TodoListPageUI.TODO_LIST_TEXTBOX, todoList);
    }

    public void clickAddButton() {
        waitForElementClickAble(driver, TodoListPageUI.ADD_LIST_BUTTON);
        clickToElement(driver, TodoListPageUI.ADD_LIST_BUTTON);
    }

    public void clickLogoutButton() {
        waitForElementClickAble(driver, TodoListPageUI.LOGOUT_BUTTON);
        clickToElement(driver, TodoListPageUI.LOGOUT_BUTTON);
    }

    public void clickDeleteButton(String todoListPosition) {
        waitForElementClickAble(driver, TodoListPageUI.DELETE_BUTTON,todoListPosition);
        clickToElement(driver, TodoListPageUI.DELETE_BUTTON, todoListPosition);
        sleepInSecond(1);
    }
}
