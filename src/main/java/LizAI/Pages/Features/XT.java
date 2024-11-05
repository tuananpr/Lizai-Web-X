package LizAI.Pages.Features;

import Core.Selenium.Button;
import Core.Selenium.FileUploader;
import Core.Selenium.ListOfElements;
import Core.Selenium.Textbox;
import LizAI.Pages.BaseLizAIPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class XT extends BaseLizAIPages {
    private static final By by = By.xpath("");
    private static final String name = "XT Page";

    //locators
    private final String xpath_NewTask = "//app-extracts-menu//button[@translate='newTask']";
    private final String id_ImportData = "importData";
    private final String id_UploadFolder = "uploadFolder";
    private final String xpath_UploadFolder = "//body//div[@role='tooltip']";
    private final String xpath_SelectDataFromYourDataRepositories = "//mat-bottom-sheet-container//span[@translate='selectDataFromYourDataRepositories']";
    private final String xpath_SelectYourTargetDisease = "//app-add-edit-extract//h2[@translate='selectYourTargetDisease']/parent::div";
    private final String xpath_ListDisease = "//mat-dialog-container//mat-card";
    private final String xpath_ConfirmDisease = "//mat-dialog-container//span[contains(text(),'Confirm')]/parent::button";
    private final String xpath_InputName = "//app-add-edit-extract//input[@formcontrolname='name']";
    private final String xpath_Extract = "//app-add-edit-extract//span[contains(text(),'Extract')]/parent::button";

    //elements
    private final Button button_NewTask = new Button(By.xpath(xpath_NewTask),"btn_NewTask");
    private final Button button_ImportData = new Button(By.id(id_ImportData),"btn_ImportData");
    private final FileUploader fileUploader_UploadFolder = new FileUploader(By.id(id_UploadFolder),"fu_UploadFolder");
    private final Button button_SelectDataFromYourDataRepositories = new Button(By.xpath(xpath_SelectDataFromYourDataRepositories),"btn_SelectDataFromYourDataRepositories");
    private final Button button_SelectYourTargetDisease = new Button(By.xpath(xpath_SelectYourTargetDisease),"btn_SelectYourTargetDisease");
    private final Button button_ConfirmDisease = new Button(By.xpath(xpath_ConfirmDisease),"btn_ConfirmDisease");
    private final Textbox textbox_InputName = new Textbox(By.xpath(xpath_InputName),"id_InputName");
    private final Button button_Extract = new Button(By.xpath(xpath_Extract),"btn_Extract");


    //contructor

    public XT(boolean assertOpen) {super(by,name,assertOpen);}

    public void clickon_NewTask(){
        button_NewTask.waitForClickable();
        button_NewTask.click();
        waitForJSToComplete();
    }

    public void clickon_ImportData(){
        button_ImportData.waitForClickable();
        button_ImportData.click();
        waitForJSToComplete();
    }

    public void select_UploadForm(String uploadForm, String fileorfolder) throws InterruptedException {
        switch (uploadForm) {
            case "Upload data from your computer":

                    fileUploader_UploadFolder.upload(System.getProperty("user.dir") + "/src/main/resources/DataExtract/" + fileorfolder);
                    waitForElementAppear(By.xpath("//app-add-edit-extract//ng-scrollbar"));

                break;
            case "Select data from your data repositories":
                button_SelectDataFromYourDataRepositories.waitForClickable();
                button_SelectDataFromYourDataRepositories.click();
                waitForJSToComplete();
                AtlantisPage atlantisPage = new AtlantisPage(false);
                waitForLoadingComplete();
                atlantisPage.send_InputName(fileorfolder);
                atlantisPage.clickon_Filter();
                atlantisPage.clickon_CheckboxAll();
                atlantisPage.clickon_Confirm();
                break;
        }

    }

    public void clickon_SelectYourTargetDisease(){
        button_SelectYourTargetDisease.waitForClickable();
        button_SelectYourTargetDisease.click();
        waitForJSToComplete();
    }

    public void select_Disease(String DiseaseName){
        clickon_SelectYourTargetDisease();
        waitForJSToComplete();
        ListOfElements listOfElements = new ListOfElements(By.xpath(xpath_ListDisease),"list_DiseaseName");
        for (int i = 0; i < listOfElements.getNumberOfElement(); i++) {
            if(listOfElements.getElement(i).getText().contains(DiseaseName)){
                listOfElements.getElement(i).click();
            }
        }
        clickon_ConfirmDisease();
    }

    public void clickon_ConfirmDisease(){
        button_ConfirmDisease.waitForClickable();
        button_ConfirmDisease.click();
        waitForJSToComplete();
    }

    public void send_InputName(String Name){
        textbox_InputName.waitForElementToBePresent();
        textbox_InputName.sendClearText(Name);
        waitForJSToComplete();
    }

    public void clickon_Extract(){
        button_Extract.waitForClickable();
        button_Extract.click();
        waitForJSToComplete();
    }
}
