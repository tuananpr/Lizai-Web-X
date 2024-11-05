package LizAI.Pages.Features;

import Core.Selenium.Button;
import Core.Selenium.ListOfElements;
import Core.Selenium.Textbox;
import LizAI.Pages.BaseLizAIPages;
import org.openqa.selenium.By;

public class PatientRepositories extends BaseLizAIPages {
    private static final By by = By.xpath("");
    private static final String name = "PatientRepositories Page";

    //locators
    private final String xpath_CloneData = "//app-patient-repositories//span[contains(text(),'Clone data')]/parent::button";
    private final String xpath_SelectYourConnection = "//app-clone-data//h2[contains(text(),'Select your connection')]/parent::mat-card";
    private final String xpath_NameConnection = "//app-select-connection-dialog//mat-card[contains(text(),'')]";
    private final String xpath_ConfirmSelectConnection = "//app-select-connection-dialog//span[contains(text(),'Confirm')]/parent::button";
    private final String xpath_SelectThePatients = "//app-clone-data//h2[contains(text(),'Select the patients')]/parent::mat-card";
    private final String xpath_NamePatients = "//app-select-patient-drawer//mat-card//p[contains(@class,'text-basic')]";
    private final String xpath_ConfirmSelectPatient = "//app-select-patient-drawer//span[contains(text(),'Confirm')]/parent::button";
    private final String xpath_NameCloneData = "//app-clone-data//mat-form-field//input";
    private final String xpath_CloudDownload = "//app-clone-data//mat-icon[contains(text(),'cloud_download')]/parent::button";
    //elements

    private final Button button_CloneData = new Button(by.xpath(xpath_CloneData),"btn_CloneData");
    private final Button button_SelectYourConnection = new Button(by.xpath(xpath_SelectYourConnection),"btn_SelectYourConnection");
    private final Button button_ConfirmSelectConnection = new Button(by.xpath(xpath_ConfirmSelectConnection),"btn_ConfirmSelectConnection");
    private final Button button_SelectThePatients = new Button(by.xpath(xpath_SelectThePatients),"btn_SelectThePatients");
    private final Button button_ConfirmSelectPatient = new Button(by.xpath(xpath_ConfirmSelectPatient),"btn_ConfirmSelectPatient");
    private final Textbox textbox_InPutNameCloneData = new Textbox(by.xpath(xpath_NameCloneData),"tb_InputNameCloneData");
    private final Button button_CloudDownload = new Button(by.xpath(xpath_CloudDownload),"btn_CloudDownload");
    //contructor
    public PatientRepositories(boolean assertOpen) {super(by,name,assertOpen);}

    public void clickon_CloneData(){
        button_CloneData.waitForClickable();
        button_CloneData.click();
        waitForJSToComplete();
    }

    public void clickon_SelectYourConnection(){
        button_SelectYourConnection.waitForClickable();
        button_SelectYourConnection.click();
        waitForJSToComplete();
    }

    public void select_YourConnection(String NameConnection){
        clickon_SelectYourConnection();
        ListOfElements listOfElements = new ListOfElements(by.xpath(xpath_NameConnection),"list_NameConnection");
        for (int i = 0; i < listOfElements.getNumberOfElement(); i++) {
            if(listOfElements.getElement(i).getText().contains(NameConnection)){
                listOfElements.getElement(i).click();
                waitForJSToComplete();
            }
        }
        clickon_ConfirmSelectConnection();
    }

    public void clickon_ConfirmSelectConnection(){
        button_ConfirmSelectConnection.waitForClickable();
        button_ConfirmSelectConnection.click();
        waitForJSToComplete();
    }

    public void clickon_SelectThePatients(){
        button_SelectThePatients.waitForClickable();
        button_SelectThePatients.click();
        waitForLoadingComplete();
    }

    public void select_Patient(String PatientName){
        clickon_SelectThePatients();
        ListOfElements listOfElements = new ListOfElements(by.xpath(xpath_NamePatients),"list_Patients");
        for (int i = 0; i < listOfElements.getNumberOfElement(); i++) {
            listOfElements.scrollToElement(i);
            if(listOfElements.getElement(i).getText().contains(PatientName)){
                listOfElements.getElement(i).click();
                waitForJSToComplete();
                break;
            }
        }
        clickon_ConfirmSelectPatient();
    }

    public void clickon_ConfirmSelectPatient(){
        button_ConfirmSelectPatient.waitForClickable();
        button_ConfirmSelectPatient.click();
        waitForJSToComplete();
    }

    public void send_NameCloneData(String Name){
        textbox_InPutNameCloneData.waitForElementToBePresent();
        textbox_InPutNameCloneData.sendClearText(Name);
        waitForJSToComplete();
    }

    public void clickon_CloudDownload(){
        button_CloudDownload.waitForClickable();
        button_CloudDownload.click();
        waitForJSToComplete();
    }
}
