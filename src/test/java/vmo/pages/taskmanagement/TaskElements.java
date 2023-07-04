package vmo.pages.taskmanagement;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class TaskElements extends PageObject{
    public static By TASK_MANAGEMENT = By.xpath("//div/a[text()='Task Management']");
    public static By BUTTON_ADD = By.xpath("//button/span[text()='Add']");
    public static By MEETING_SEARCH = By.xpath("//span[text()='Search']");
    public static By MEETING_MYEC = By.xpath("//div[text()='MyEC']");
    public static By TASK_NAME = By.xpath("//input[@name='taskName']");
    public static By PRIORITY = By.xpath("//*[@id='rc_select_1']");
    public static By PRIORITY_NORMAL = By.xpath("//*[@id='rc_select_1']");


}
