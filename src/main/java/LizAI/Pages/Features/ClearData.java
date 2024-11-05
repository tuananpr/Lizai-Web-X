package LizAI.Pages.Features;

import Core.Selenium.Button;
import Core.Selenium.Label;
import Core.Selenium.ListOfElements;
import LizAI.Pages.BaseLizAIPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.plaf.SliderUI;

public class ClearData extends BaseLizAIPages {
    private static final By by = By.xpath("");
    private static final String name = "Clear data";

    //locator
    //Study
    private final String xpath_study = "//table//app-file-upload-to-study";
    private final String xpath_Study_Delete_Button = "//table//tbody//mat-icon[contains(text(),'delete_outline')]/parent::button";
    private final String xpath_Study_Delete_Confirm_Button = "//mat-dialog-container//app-confirm-dialog//button[@translate='confirm']";

    //Data Repositories
    private final String xpath_CheckboxAll = "//app-file-list//table//thead//div[@class='mdc-checkbox']";
    private final String xpath_Options = "//app-file-list//table//button[contains(@class,'ng-star-inserted')]";
    private final String xpath_DeleteDataRepositories = "//div[@role='menu']//mat-icon[@color='warn']/parent::button";
    private final String xpath_DeleteDataConfirm = "//app-confirm-dialog//span[contains(text(),'Confirm')]/parent::button";
    private final String xpath_ListFolder = "//app-file-list//table//td/div[contains(@class,'items')]";
    private final String xpath_ListButtonOptions = "//table//tbody//td//button";

    //elements
    private final ListOfElements listOfElementsStudy = new ListOfElements(By.xpath(xpath_study),"list_Study");
    private final Button buttonDeleteStudy = new Button(By.xpath(xpath_Study_Delete_Button),"btn_DeleteStudy");
    private final Button buttonDeleteConfirm = new Button(By.xpath(xpath_Study_Delete_Confirm_Button),"btn_DeleteConfirm");
    private final Button buttonCheckboxAllDataRepositories = new Button(By.xpath(xpath_CheckboxAll),"btn_CheckboxAllDataRepositories");
    private final Button buttonOptions = new Button(By.xpath(xpath_Options),"btn_Options");
    private final Button buttonDeleteDataRepositories = new Button(By.xpath(xpath_DeleteDataRepositories),"btn_DeleteAllDataRepositories");
    private final Button buttonDeleteDataConfirm = new Button(By.xpath(xpath_DeleteDataConfirm),"btn_DeleteConfirm");
    private final ListOfElements listOfElementsListFolder = new ListOfElements(By.xpath(xpath_ListFolder),"l_ListFolder");
    private final ListOfElements listOfElementsListButtonOptions = new ListOfElements(By.xpath(xpath_ListButtonOptions),"l_ListButtonOptions");
    //constructor
    public ClearData(boolean assertOpen) {super(by,name,assertOpen);}

    public void delete_Study(String studyName){
        for (int i = 0; i < listOfElementsStudy.getNumberOfElement(); i++) {
            if(listOfElementsStudy.getElement(i).getText().contains(studyName)){
                listOfElementsStudy.getElement(i).findElements(By.xpath(xpath_Study_Delete_Button)).get(i).click();
        }
            waitForJSToComplete();
            buttonDeleteConfirm.waitForClickable();
            buttonDeleteConfirm.click();
            waitForLoadingComplete();
        }
    }

    public void delete_AllDataRepositories(){
        buttonCheckboxAllDataRepositories.waitForClickable();
        buttonCheckboxAllDataRepositories.click();
        waitForJSToComplete();
        buttonOptions.waitForClickable();
        buttonOptions.click();
        waitForJSToComplete();
        clickon_DeleteDataRepositories();
        waitForLoadingComplete();
    }

    public void clear_DataRepositories(String DataName) {
        for (int i = 0; i < listOfElementsListFolder.getNumberOfElement(); i++) {
            if (listOfElementsListFolder.getElement(i).getText().contains(DataName)) {
                listOfElementsListButtonOptions.getElement(i).click();
                waitForJSToComplete();
                clickon_DeleteDataRepositories();
            }
        }
    }

    public void clickon_DeleteDataRepositories(){
        buttonDeleteDataRepositories.waitForClickable();
        buttonDeleteDataRepositories.click();
        waitForJSToComplete();
        buttonDeleteDataConfirm.waitForClickable();
        buttonDeleteDataConfirm.click();
        waitForLoadingComplete();
    }

}
