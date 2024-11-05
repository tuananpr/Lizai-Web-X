package LizAI.Pages.Features;

import Core.Selenium.Button;
import Core.Selenium.ListOfElements;
import Core.Selenium.Textbox;
import LizAI.Pages.BaseLizAIPages;
import org.openqa.selenium.By;

import java.util.List;

public class Permissions extends BaseLizAIPages {
    private static final By by = By.xpath("//app-group-permission");
    private static final String name = "Permissions Page";

    //locators
    private final String xpath_GroupPermissions = "//app-aside-menu//mat-list-item//a[@href='/group-permissions']";
    private final String xpath_CreateNewTemplate = "//app-group-permissions/div/button";
    private final String xpath_InputNameGroupPermissions = "//app-create-group-permission-dialog/div/form//input";
    private final String xpath_UserPermissions = "//section/mat-checkbox[@id='mat-mdc-checkbox-1']//label";
    private final String xpath_CheckCaptcha = "//app-re-captcha//iframe[@title='reCAPTCHA']";
    private final String xpath_Create = "//app-create-group-permission-dialog//button[2]";
    private final String xpath_Confirm = "//app-confirm-dialog//button[contains(text(),'Confirm')]";
    private final String xpath_ListNameGroupPermissions = "//section/mat-checkbox//label";
    private final String xpath_ListGroupPermissions = "//app-group-permission-list//table//td[contains(@class,'mat-column-name')]";
    private final String xpath_DeleteGroupPermissions = "//app-group-permission-list//table//button[2]";
    private final String xpath_SearchName = "//app-group-permission-list//mat-label[@translate='name']/following::input";
    private final String xpath_Filter = "//app-group-permission-list//button/span[contains(text(),'Filter')]";
    //elements
    private final Button buttonGroupPermissions = new Button(By.xpath(xpath_GroupPermissions), "btn_GroupPermissions");
    private final Button buttonCreateNewTemplate = new Button(By.xpath(xpath_CreateNewTemplate), "btn_CreateNewTemplate");
    private final Textbox textboxInputNameGroupPermissions = new Textbox(By.xpath(xpath_InputNameGroupPermissions), "tb_InputNameGroupPermissions");
    private final Button buttonUserPermissions = new Button(By.xpath(xpath_UserPermissions), "btn_UserPermissions");

    private final Button buttonCaptcha = new Button(By.xpath(xpath_CheckCaptcha), "btn_Captcha");
    private final Button buttonCreate = new Button(By.xpath(xpath_Create), "btn_Create");
    private final Button buttonConfirm = new Button(By.xpath(xpath_Confirm), "btn_Confirm");
    private final Button buttonDelete = new Button(By.xpath(xpath_DeleteGroupPermissions), "btn_Delete");
    private final Textbox textboxNameSearh = new Textbox(By.xpath(xpath_SearchName), "tb_NameSearch");
    private final Button buttonFilter = new Button(By.xpath(xpath_Filter), "btn_Filter");
    //constructor

    public Permissions(boolean assertOpen) {
        super(by, name, assertOpen);
    }

    public void clickon_GroupPermissions() {
        buttonGroupPermissions.waitForClickable();
        buttonGroupPermissions.click();
        waitForJSToComplete();
    }

    public void clickon_CreateNewTemplate() {
        buttonCreateNewTemplate.waitForClickable();
        buttonCreateNewTemplate.click();
        waitForJSToComplete();
    }

    public void sendtext_NameGroupPermissions(String NameGroupPermissions) {
        textboxInputNameGroupPermissions.waitForElementToBeDisplay();
        textboxInputNameGroupPermissions.sendClearText(NameGroupPermissions);
        waitForJSToComplete();
    }


    public void clickon_Captcha() throws InterruptedException {
        buttonCaptcha.waitForClickable();
        Thread.sleep(10000);
        buttonCaptcha.click();
        waitForLoadingComplete();
    }

    public void clickon_Create() {
        buttonCreate.isButtonClickable();
        buttonCreate.click();
        waitForLoadingComplete();
    }

    public String getNameGroupPermissions(String NameGroupPermissions){
        ListOfElements listOfElements = new ListOfElements(By.xpath(xpath_ListGroupPermissions),"ListGroupPermissions");
        for (int i = 0; i < listOfElements.getNumberOfElement(); i++) {
            if (listOfElements.getElement(i).getText().equalsIgnoreCase(NameGroupPermissions)){
                String NewGroup = listOfElements.getElement(i).getText();
                System.out.println(NewGroup + " has been created successfully");
                return NewGroup;
            }
        }
        return NameGroupPermissions;
    }



    public void clickon_Confirm() {
        buttonConfirm.waitForClickable();
        buttonConfirm.click();
        waitForPageLoadComplete();
    }

    public void search_NameGroup(String NameGroup) throws InterruptedException {
        waitForLoadingComplete();
        textboxNameSearh.sendClearText(NameGroup);
        waitForJSToComplete();
        clickon_Filter();
        clickon_Delete();
        System.out.println("Deleted " + NameGroup + " successfully");
    }

    public void clickon_Filter() {
        buttonFilter.waitForClickable();
        buttonFilter.click();
        waitForLoadingComplete();
    }

    public void clickon_Delete() throws InterruptedException {
        buttonDelete.waitForClickable();
        buttonDelete.click();
        waitForJSToComplete();
        buttonConfirm.waitForClickable();
        buttonConfirm.click();
        waitForLoadingComplete();
    }


//     WebElement Deelement = by.findElement(String.format("//app-group-permission-list//table/tbody//td[contains(text(),'%s')]/following-sibling::td/button[@color='warn']" ).equals(NameGroup));


    public void select_GroupPermissions(List<String> nameGroup) {
        ListOfElements listOfElements = new ListOfElements(By.xpath(xpath_ListNameGroupPermissions), "list_NameGroupPermissions");
        for (int i = 0; i < listOfElements.getNumberOfElement(); i++) {
            listOfElements.scrollToElement(i);
            for (int j = 0; j < nameGroup.size(); j++) {
                if (listOfElements.getElement(i).getText().equalsIgnoreCase(nameGroup.get(j))) {
                    listOfElements.getElement(i).click();
                    waitForJSToComplete();
                }
            }
        }
    }




}
