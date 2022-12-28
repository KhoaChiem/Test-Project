package khoa.testproject.pages;

import khoa.testproject.commons.BasePage;
import khoa.testproject.interfaces.GhLoginPageUI;
import org.openqa.selenium.WebDriver;

public class GhLoginPageObject extends BasePage {
    WebDriver driver;

    public GhLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUserNameTextbox(String userName) {
        waitForElementVisible(driver, GhLoginPageUI.USER_NAME_TEXTBOX);
        sendkeyToElement(driver, GhLoginPageUI.USER_NAME_TEXTBOX, userName);
    }

    public void inputPasswordTextbox(String password) {
        waitForElementVisible(driver, GhLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, GhLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickLoginButton() {
        waitForElementClickAble(driver, GhLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, GhLoginPageUI.LOGIN_BUTTON);
    }


    public void switchToTodoAppWindown(String todoAppTitle) {
        switchToWindowByTitle(driver, todoAppTitle);
    }
}
