package LizAI.Pages.Features;

import Core.Selenium.Button;
import Core.Selenium.Textbox;
import LizAI.Pages.BaseLizAIPages;
import io.cucumber.java.en.But;
import org.openqa.selenium.By;

public class AtlantisPage extends BaseLizAIPages {
    private static final By by = By.xpath("");
    private static final String name = "Atlantis Page";

    //locators
    private final String xpath_NewConversation = "//app-ai-assistant-menu//button[@translate='newConversation']";
    private final String xpath_ImportData = "//app-ai-assistant-new-conversation//mat-card/h2[@translate='importData']";
    private final String xpath_SelectFromYourFiles = "//mat-bottom-sheet-container//span[contains(text(),'Select from your files')]";
    private final String xpath_InputName = "//mat-dialog-container//app-file-list//mat-form-field//input";
    private final String xpath_Filter = "//app-file-list//span[contains(text(),'Filter')]/parent::button";
    private final String xpath_CheckboxAll = "//app-file-list//table//thead//div[@class='mdc-checkbox']";
    private final String xpath_Confirm = "//app-import-files-dialog//span[contains(text(),'Confirm')]/parent::button";
    private final String xpath_StartConversation = "//app-ai-assistant-new-conversation//button[contains(text(),'Start conversation')]";
    private final String xpath_MessageAtlantis = "//app-conversation-detail//input";
    private final String xpath_SendMessage = "//app-conversation-detail//form//button";

    //elements
    private final Button buttonNewConversation = new Button(By.xpath(xpath_NewConversation),"btn_NewConversation");
    private final Button buttonImportData = new Button(By.xpath(xpath_ImportData),"btn_ImportData");
    private final Button buttonSelectFormYourFiles = new Button(By.xpath(xpath_SelectFromYourFiles),"btn_SelectFromYourFiles");
    private final Textbox textboxInputName = new Textbox(By.xpath(xpath_InputName),"tb_InputName");
    private final Button buttonFilter = new Button(By.xpath(xpath_Filter),"btn-Filter");
    private final Button buttonCheckboxAll = new Button(By.xpath(xpath_CheckboxAll),"btn_CheckboxAll");
    private final Button buttonConfirm = new Button(By.xpath(xpath_Confirm),"btn_Confirm");
    private final Button buttonStartConversation = new Button(By.xpath(xpath_StartConversation),"btn_StartConversation");
    private final Textbox textboxMessageAtlantis = new Textbox(By.xpath(xpath_MessageAtlantis),"tb_MessageAtlantis");
    private final Button buttonSendMessage = new Button(By.xpath(xpath_SendMessage),"btn_SendMessage");


    //contructor
    public AtlantisPage(boolean assertOpen) {super(by,name,assertOpen);}

    public void clickon_NewConversation(){
        buttonNewConversation.waitForClickable();
        buttonNewConversation.click();
        waitForJSToComplete();
    }

    public void clickon_ImportData(){
        buttonImportData.waitForClickable();
        buttonImportData.click();
        waitForJSToComplete();
    }

    public void clickon_SelectFromYourFiles(){
        buttonSelectFormYourFiles.waitForClickable();
        buttonSelectFormYourFiles.click();
        waitForLoadingComplete();
    }

    public void send_InputName(String InputName){
        textboxInputName.waitForElementToBePresent();
        textboxInputName.sendClearText(InputName);
        waitForJSToComplete();
    }

    public void clickon_Filter(){
        buttonFilter.waitForClickable();
        buttonFilter.click();
        waitForLoadingComplete();
    }

    public void clickon_CheckboxAll(){
        buttonCheckboxAll.waitForClickable();
        buttonCheckboxAll.click();
        waitForJSToComplete();
    }

    public void clickon_Confirm(){
        buttonConfirm.waitForClickable();
        buttonConfirm.click();
        waitForJSToComplete();
    }

    public void clickon_StartConversation(){
        buttonStartConversation.waitForClickable();
        buttonStartConversation.click();
        waitForLoadingComplete();
    }

    public void send_MessageAtlantis(String Message){
        textboxMessageAtlantis.waitForElementToBePresent();
        textboxMessageAtlantis.sendClearText(Message);
        waitForJSToComplete();
    }

    public void clickon_SendMessage(){
        buttonSendMessage.waitForClickable();
        buttonSendMessage.click();
        waitForLoadingComplete();
    }
}
