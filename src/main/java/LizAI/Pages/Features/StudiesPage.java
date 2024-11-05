package LizAI.Pages.Features;

import Core.Selenium.*;

import LizAI.Pages.BaseLizAIPages;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class StudiesPage extends BaseLizAIPages {

    private static final By by = By.xpath("");
    private static final String name = "Studies Page";

    public String StudyName;

    //locators
    private final String xpath_btn_Studies_AppMenu = "//app-aside-menu//mat-list-item//a[contains(@href,'studies')]";
    private final String xpath_btn_Study_Create = "//app-features//app-studies//button//span[contains(text(),'Create new study')]";
    private final String xpath_list_Study_Type = "//mat-dialog-container//form//mat-radio-button//label";
    private final String xpath_tb_Study_Code = "//mat-dialog-container//form//input[@formcontrolname=('code')]";
    private final String xpath_tb_Study_Name = "//mat-dialog-container//form//input[@formcontrolname=('name')]";
    private final String xpath_tb_Study_Description = "//mat-dialog-container//form//input[@formcontrolname=('description')]";
    private final String xpath_btn_Project_ViewBox = "//mat-dialog-container//form//mat-select";
    private final String xpath_sl_Project_Name = "//mat-dialog-container//form//mat-select/following::mat-option/span";
    private final String xpath_btn_Create = "//mat-dialog-container//span[contains(text(),'Create')]//parent::button";
    private final String xpath_list_icon_Study_Edit = "//app-study-list//table//mat-icon[contains(text(),'edit_square')]/parent::button";
    private final String xpath_label_Study_Code = "(//app-study-list//table//p/small)[1]";
    private final String xpath_lable_Study_Name = "(//app-study-list//table//h3/b)[1]";
    private final String xpath_filter_Name = "//app-study-list//mat-form-field//input[contains(@type,'text')]";
    private final String xpath_btn_Filter = "//app-study-list//span[contains(text(),'Filter')]//parent::button";
    private final String xpath_tb_Edit_Study_Name = "//mat-dialog-container//input[@formcontrolname='name']";
    private final String xpath_tb_Edit_Study_Description = "//mat-dialog-container//input[@formcontrolname='description']";
    private final String xpath_btn_Edit_Study_Confirm = "//mat-dialog-container//app-create-study-dialog//span[contains(text(),'Update')]//parent::button";
    private final String xpath_Files_Study = "//app-study-list//app-file-upload-to-study//mat-accordion//a";
    private final String xpath_btn_Upload = "//app-study-list//app-file-upload-to-study//mat-accordion//span[contains(text(),'Upload')]//parent::button";
    private final String xpath_list_Upload_Type = "//mat-bottom-sheet-container//a//span[contains(@class,'primary')]";
    private final String id_Upload_Files = "uploadFiles";
    private final String id_Upload_Folder = "uploadFolder";
    private final String xpath_Upload_ETL = "//mat-bottom-sheet-container//span[contains(text(),'Folder & Files')]";
    private final String xpath_Upload_ETL_Filter_Name = "//app-select-etl-tool-dialog//mat-form-field/div//input";
    private final String xpath_Upload_ETL_Filter_Button = "//app-select-etl-tool-dialog//span[contains(text(),'Filter')]/parent::button";
    private final String xpath_Upload_ETL_Addbox = "//app-select-etl-tool-dialog//table//button";
    private final String xpath_Upload_ETL_Upload_Files = "//app-select-etl-tool-dialog//span[contains(text(),'Upload')]/parent::button";
    private final String xpath_Study_Files_Filter = "//app-file-upload-to-study//mat-form-field//input";
    private final String xpath_Study_Files_Filter_Button = "//app-file-upload-to-study//span[contains(text(),'Filter')]/parent::button";
    private final String xpath_Study_Files_ListFilesName = "//app-file-upload-to-study//tbody/tr/td/div[contains(@class,'align')]";
    private final String xpath_Study_Files_ListFilesCheckbox = "//app-file-upload-to-study//tbody//mat-checkbox//input";
    private final String xpath_Study_Files_DeleteAll_Button = "//app-file-upload-to-study//table//th//mat-icon[contains(text(),'delete_outline')]/parent::button";
    private final String xpath_Study_Files_DeleteAll_Confirm = "//app-confirm-dialog//button[contains(text(),'Confirm')]";
    private final String xpath_Study_ListStudyName = "//app-study-list//table//td//h3/b";
    private final String xpath_Study_ListStudyCode = "";
    private final String xpath_Study_UploadPopupClose_Button = "//app-file-upload-popup//button[@aria-label='close']";

    //elements
    private final Button buttonUploadPopupClose = new Button(By.xpath(xpath_Study_UploadPopupClose_Button),"btn_UploadPopupClose");
    private final ListOfElements listOfElementsStudyName = new ListOfElements(By.xpath(xpath_Study_ListStudyName),"list_StudyName");
    private final ListOfElements listOfElementsStudyCode = new ListOfElements(By.xpath(xpath_Study_ListStudyCode),"list_StudyCode");
    private final Button buttonStudyFilesDeleteAllConfirm = new Button(By.xpath(xpath_Study_Files_DeleteAll_Confirm),"btn_StudyFilesDeleteAllConfirm");
    private final Button buttonDeleteAll = new Button(By.xpath(xpath_Study_Files_DeleteAll_Button),"btn_DeleteAll");
    private final ListOfElements listOfElementsStudyFilesListFilesName =  new ListOfElements(By.xpath(xpath_Study_Files_ListFilesName),"list_StudyFilesListFilesName");
    private final ListOfElements listOfElementsStudyFilesListFilesCheckbox = new ListOfElements(By.xpath(xpath_Study_Files_ListFilesCheckbox),"list_StudyFilesListFilesCheckbox");
    private final Button buttonStudyFilesFilter = new Button(By.xpath(xpath_Study_Files_Filter_Button),"btn_StudyFilesFilter");
    private final Textbox textboxStudyFilesFiler = new Textbox(By.xpath(xpath_Study_Files_Filter),"tb_StudyFilesFilter");
    private final Button buttonUploadETLUploadFiles = new Button(By.xpath(xpath_Upload_ETL_Upload_Files),"btn_UploadETLUploadFiles");
    private final Button buttonUploadETLAddbox = new Button(By.xpath(xpath_Upload_ETL_Addbox),"btn_UploadETLAddbox");
    private final Button buttonUploadETLFilterButton = new Button(By.xpath(xpath_Upload_ETL_Filter_Button),"btn_UploadETLFilterButton");
    private final Textbox textboxUploadETLFilterName = new Textbox(By.xpath(xpath_Upload_ETL_Filter_Name),"tb_UploadETLFilter");
    private final Button buttonUploadFromETL = new Button(By.xpath(xpath_Upload_ETL),"btn_UploadFromETL");
    private final FileUploader fileUploaderFolder = new FileUploader(By.id(id_Upload_Folder),"FileUpload_Folder");
    private final FileUploader fileUploaderFiles = new FileUploader(By.id(id_Upload_Files),"FileUpload_Files");
    private final Button buttonUpload = new Button(By.xpath(xpath_btn_Upload),"btn_UploadFiles");
    private final Button buttonViewListFilesInStudy = new Button(By.xpath(xpath_Files_Study),"btn_ViewListFilesInStudy");
    private final Button buttonEditStudyConfirm = new Button(By.xpath(xpath_btn_Edit_Study_Confirm),"btn_EditStudy");
    private final Textbox textboxEditStudyDescription = new Textbox(By.xpath(xpath_tb_Edit_Study_Description),"btn_EditStudyDescription");
    private final Textbox textboxEditStudyName = new Textbox(By.xpath(xpath_tb_Edit_Study_Name),"btn_EditStudyName");
    private final Button buttonStudiesAppMenu = new Button(By.xpath(xpath_btn_Studies_AppMenu),"btn_Studies_AppMenu");
    private final Button buttonCreateNewStudy = new Button(By.xpath(xpath_btn_Study_Create),"btn_CreateNewStudy");
    private final Textbox textboxInputCodeStudy = new Textbox(By.xpath(xpath_tb_Study_Code),"tb_CodeStudy");
    private final Textbox textboxInputNameStudy = new Textbox(By.xpath(xpath_tb_Study_Name),"tx_NameStudy");
    private final Textbox textboxInputDescriptionStudy = new Textbox(By.xpath(xpath_tb_Study_Description),"tx_DescriptionStudy");
    private final Button buttonSelectProject = new Button(By.xpath(xpath_btn_Project_ViewBox),"btn_SelectProject");
    private final Button buttonStudyCreate = new Button(By.xpath(xpath_btn_Create),"btn_CreateStudy");
    private final Label labelStudyCode = new Label(By.xpath(xpath_label_Study_Code),"label_StudyCode");
    private final Label labelStudyName = new Label(By.xpath(xpath_lable_Study_Name),"label_StudyName");
    private final Textbox textboxFilterName = new Textbox(By.xpath(xpath_filter_Name),"id_FilterName");
    private final Button buttonFilter = new Button(By.xpath(xpath_btn_Filter),"btn_Filter");
    private final Button buttonEditStudy = new Button(By.xpath(xpath_list_icon_Study_Edit),"btn_EditStudy");

    //constructor
    public StudiesPage(boolean assertOpen) {super(by,name,assertOpen);}

    public void clickon_StudiesAppMenu(){
        buttonStudiesAppMenu.waitForClickable();
        buttonStudiesAppMenu.click();
    }

    public void clickon_CreateNewStudy(){
        buttonCreateNewStudy.waitForClickable();
        buttonCreateNewStudy.click();
        waitForLoadingComplete();
    }

    public void select_StudyType(String studyType){
        ListOfElements listOfElements = new ListOfElements(By.xpath(xpath_list_Study_Type),"list_Study_Type");
        for (int i = 0; i < listOfElements.getNumberOfElement(); i++) {
                if(listOfElements.getElement(i).getText().equalsIgnoreCase(studyType)){
                    listOfElements.getElement(i).click();
                    waitForJSToComplete();
                }

            }
        }


    public void sendtext_StudyCode(String studyCode) {
        textboxInputCodeStudy.waitForElementToBePresent();
        textboxInputCodeStudy.sendClearText(studyCode);
        waitForJSToComplete();
    }

    public void sendtext_StudyName(String studyName) {
        textboxInputNameStudy.waitForElementToBePresent();
        textboxInputNameStudy.sendClearText(studyName);
        waitForJSToComplete();
    }

    public void sendtext_StudyDesciption(String studyDescription){
        textboxInputDescriptionStudy.waitForElementToBePresent();
        textboxInputDescriptionStudy.sendClearText(studyDescription);
        waitForJSToComplete();
    }

    public void clickon_SelectProject(){
        buttonSelectProject.waitForClickable();
        buttonSelectProject.click();
        waitForJSToComplete();
    }

    public void select_ProjectName(String projectName){
        clickon_SelectProject();
        ListOfElements listOfElements = new ListOfElements(By.xpath(xpath_sl_Project_Name),"list_Project_Name");
        for (int i = 0; i < listOfElements.getNumberOfElement(); i++) {
            listOfElements.scrollToElement(i);
            if(listOfElements.getElement(i).getText().equalsIgnoreCase(projectName)){
                    listOfElements.getElement(i).click();
                    waitForJSToComplete();
                }
            }
        }


    public void clickon_Create(){
        buttonStudyCreate.waitForClickable();
        buttonStudyCreate.click();
        waitForLoadingComplete();
    }




    public String getStudyCode(){
        waitForJSToComplete();
        String StudyCode = labelStudyCode.getText();
        System.out.println("StudyCode: " + StudyCode);
        return StudyCode.trim();
    }

    public String getStudyName(){
        waitForJSToComplete();
        String StudyName = labelStudyName.getText();
        System.out.println("StudyName: " + StudyName);
        return StudyName;
    }


    public void send_FilterStudyName(String studyCode){
        textboxFilterName.waitForElementToBePresent();
        textboxFilterName.sendClearText(studyCode);
        waitForJSToComplete();
        buttonFilter.waitForClickable();
        buttonFilter.click();
        waitForJSToComplete();
    }
    public void clickon_Edit_MyStudy(String studyName){
        for (int i = 0; i < listOfElementsStudyName.getNumberOfElement(); i++) {
            if(listOfElementsStudyName.getElement(i).getText().contains(studyName)){
                listOfElementsStudyName.getElement(i).findElements(By.xpath(xpath_list_icon_Study_Edit)).get(i).click();
            }
        }
        waitForJSToComplete();
    }

    public void send_EditStudyName(String editName){
        textboxEditStudyName.waitForElementToBePresent();
        textboxEditStudyName.sendClearText(editName);
        waitForJSToComplete();
    }

    public void send_EditStudyDescription(String studyDescription){
        textboxEditStudyDescription.waitForElementToBePresent();
        textboxEditStudyDescription.sendClearText(studyDescription);
        waitForJSToComplete();
    }

    public void clickon_EditStudyConfirm(){
        buttonEditStudyConfirm.waitForClickable();
        buttonEditStudyConfirm.click();
        waitForJSToComplete();
    }

    public void clickon_FilesInStudy(){
        buttonViewListFilesInStudy.waitForClickable();
        buttonViewListFilesInStudy.click();
        waitForLoadingComplete();
    }

    public void clickon_UploadFiles() {
        buttonUpload.waitForClickable();
        buttonUpload.click();
        waitForJSToComplete();

    }


    public void select_UploadFrom(String uploadFrom, String files){
        switch (uploadFrom) {
            case "UploadFile":
            fileUploaderFiles.upload(System.getProperty("user.dir")+ "/src/main/resources/pdf/" + files);
                break;
            case "UploadFolder":
            fileUploaderFolder.upload(System.getProperty("user.dir")+ "/src/main/resources/" + files);
                break;
            case "UploadfromETL":
            upload_fromETL(files);
                break;
        }
        waitForLoadingComplete();
        buttonUploadPopupClose.waitForClickable();
        buttonUploadPopupClose.click();
    }

    public void upload_fromETL(String files){
        buttonUploadFromETL.waitForClickable();
        buttonUploadFromETL.click();
        waitForLoadingComplete();
        textboxUploadETLFilterName.waitForElementToBePresent();
        textboxUploadETLFilterName.sendClearText(files);
        waitForJSToComplete();
        buttonUploadETLFilterButton.waitForClickable();
        buttonUploadETLFilterButton.click();
        waitForJSToComplete();
        buttonUploadETLAddbox.waitForClickable();
        buttonUploadETLAddbox.click();
        waitForJSToComplete();
        buttonUploadETLUploadFiles.waitForClickable();
        buttonUploadETLUploadFiles.click();
        waitForJSToComplete();
    }

    public void send_StudyFilesFilter(String fileName){
        textboxStudyFilesFiler.waitForElementToBePresent();
        textboxStudyFilesFiler.sendClearText(fileName);
        waitForJSToComplete();
        buttonStudyFilesFilter.waitForClickable();
        buttonStudyFilesFilter.click();
        waitForLoadingComplete();
    }

    public void select_StudyFile(String fileName) {
        clickon_FilesInStudy();
        send_StudyFilesFilter(fileName);
        for (int i = 0; i < listOfElementsStudyFilesListFilesName.getNumberOfElement(); i++) {
            if (listOfElementsStudyFilesListFilesName.getElement(i).getText().contains(fileName)) {
               listOfElementsStudyFilesListFilesName.getElement(i).findElements(By.xpath(xpath_Study_Files_ListFilesCheckbox)).get(i).click();
            }
        }
    }

    public void delele_StudyFile(String fileName){
        select_StudyFile(fileName);
        buttonDeleteAll.waitForClickable();
        buttonDeleteAll.click();
        waitForJSToComplete();
        buttonStudyFilesDeleteAllConfirm.waitForClickable();
        buttonStudyFilesDeleteAllConfirm.click();
        waitForLoadingComplete();
    }


}
