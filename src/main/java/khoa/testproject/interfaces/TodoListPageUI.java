package khoa.testproject.interfaces;

public class TodoListPageUI {
    public static final String TODO_LIST_TEXTBOX = "//div[@class='row']//input[@type='text']";
    public static final String ADD_LIST_BUTTON = "//button[@class='btn btn-success btn-block glyphicon glyphicon-plus task-btn']";
    public static final String DELETE_BUTTON = "//a[contains(text(),'%s')]/parent::div/following-sibling::div//button";
    public static final String LOGOUT_BUTTON = "//button[@class='btn btn-default']";

}
