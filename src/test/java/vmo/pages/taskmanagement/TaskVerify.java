package vmo.pages.taskmanagement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.support.ui.ExpectedConditions;
import vmo.helper.AggregatedAsserts;
import vmo.helper.ElementHelper;
import vmo.pages.login.LoginElements;

import static org.assertj.core.api.Assertions.assertThat;


public class TaskVerify extends UIInteractionSteps {
    private ElementHelper elementHelper = new ElementHelper();
    private AggregatedAsserts asserts = new AggregatedAsserts();

    public void verifyTextBoxSearchDisplay() {
        assertThat($(LoginElements.ACCOUT_TEXTBOX).isDisplayed()).isTrue();
        assertThat($(LoginElements.PASSWORD_TEXTBOX).isDisplayed()).isTrue();
    }

    public void verifyHomePage() {
        assertThat($(LoginElements.LOGOUT).isDisplayed()).isTrue();
    }

    public void searchResultShouldContain(String searchKey) {
        assertThat($(TaskElements.SEARCH_RESULT(searchKey)).getText()).isEqualTo(searchKey);
        String element = $(TaskElements.TASK_NAME_SEARCH).getAttribute("innerHTML");
        Serenity.setSessionVariable("delete").to(element);
    }

    public void editFormShouldBeDisplay() {
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.EDIT_FORM)));
        assertThat($(TaskElements.EDIT_FORM).isDisplayed()).isTrue();
    }

    public void deleteTaskShouldBeDisplay() {
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.DELETE_TASK_POPUP)));
        assertThat($(TaskElements.DELETE_TASK_POPUP).isDisplayed()).isTrue();
    }

    public void selectedValueShouldBeCorrect(String name) {
        assertThat($(TaskElements.SELECTED_VALUE(name)).getText()).isEqualTo(name);
    }

    public void messageSuccessShouldBeDisplay() {
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.MSG_SUCCESS)));
        assertThat($(TaskElements.MSG_SUCCESS).isDisplayed()).isTrue();
    }

    public void messageSuccessShouldContain(String msg) {
        assertThat($(TaskElements.MSG_SUCCESS).getAttribute("innerHTML")).isEqualTo(msg);
    }

    public void verifyEditSuccess(String session) {
        String afterEdit = elementHelper.getSession(session);
        assertThat($(TaskElements.SEARCH_RESULT(afterEdit)).isDisplayed()).isTrue();
    }

    public void verifyDeleteSuccess(String session) {
        String afterDelete = elementHelper.getSession(session);
        Boolean notPresent = ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated($(TaskElements.SEARCH_RESULT(afterDelete)))).apply(getDriver());
        asserts.assertTrue("Verify delete success", Boolean.TRUE.equals(notPresent));
    }

    public void picShouldBeCorrect(String session) {
        String pic = elementHelper.getSession(session);
        assertThat($(TaskElements.SELECTED_PIC).getText().trim()).isEqualTo(pic);
    }
}
