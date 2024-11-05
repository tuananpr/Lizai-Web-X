package LizAI.Pages.Features;

import Core.Selenium.Button;
import Core.Selenium.FileUploader;
import Core.Utils.JsonUtil;
import LizAI.Pages.BaseLizAIPages;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataRepositories extends BaseLizAIPages {
    private static final By by = By.xpath("");
    private static final String name = "Data Repositories";

    //locators
    private final String xpath_Upload = "//app-files//span[contains(text(),'Upload')]/parent::button";
    private final String id_UploadFolder = "uploadFolder";
    private final String xpath_ListData = "//app-features//app-file-list";
    private final String xpath_ClosePopUpUpload = "//mat-card-title//mat-icon[contains(text(),'close')]/parent::button";
    private final String xpath_ContinueUpload = "//app-confirm-dialog//span[contains(text(),'Continue upload')]/parent::button";


    //elements
    private final Button button_Upload = new Button(By.xpath(xpath_Upload), "btn_Upload");
    private final FileUploader fileUploaderFolder = new FileUploader(By.id(id_UploadFolder), "fu_UploadFolder");
    private final Button button_ClosePopUpUpload = new Button(By.xpath(xpath_ClosePopUpUpload), "btn_ClosePopUpUpload");
    private final Button button_ContinueUpload = new Button(By.xpath(xpath_ContinueUpload), "btn_ContinueUpload");

    //contructor
    public DataRepositories(boolean assertOpen) {
        super(by, name, assertOpen);
    }

    public void clickon_Upload() {
        button_Upload.waitForClickable();
        button_Upload.click();
        waitForJSToComplete();
    }

    public void select_UploadForm(String uploadForm, String fileorfolder) throws InterruptedException {
        switch (uploadForm) {
            case "Folder":
                fileUploaderFolder.upload(System.getProperty("user.dir") + "/src/main/resources/" + fileorfolder);
                break;
        }
        for (int i = 0; i < 5; i++) {
            Thread.sleep(30000);
            if (button_ClosePopUpUpload.isElementDisplay()){
               clickon_ClosePopUpUpload();
               if(button_ContinueUpload.isElementDisplay()){
                   clickon_ContinueUpload();
               }
            } else {
                button_ClosePopUpUpload.isElementDisappear();
            break;
            }
        }
    }


    public void clickon_ContinueUpload(){
        button_ContinueUpload.waitForClickable();
        button_ContinueUpload.click();
        waitForJSToComplete();
    }

    public void clickon_ClosePopUpUpload(){
        button_ClosePopUpUpload.waitForClickable();
        button_ClosePopUpUpload.click();
        waitForJSToComplete();
    }
}



