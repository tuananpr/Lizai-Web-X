package WebBrowser;

import Core.DataProviderFactory;
import Core.Support.General.Hooks;
import LizAI.Pages.Features.Feature;
import LizAI.Pages.Features.TimeZone;
import LizAI.Pages.Features.XT;
import org.testng.annotations.Test;

import java.util.HashMap;

public class XT_Test extends Hooks {
    Feature feature = new Feature(false);
    XT xt = new XT(false);

    String TimeZone = LizAI.Pages.Features.TimeZone.getCurrentTime();
    @Test(priority = 1, dataProvider = "XT", dataProviderClass = DataProviderFactory.class)
    public void Create_NewTask_Select_Prostate_Cancer(HashMap < String, String > data) throws InterruptedException {
        feature.select_Feature(data.get("XT"));
        xt.clickon_NewTask();
        xt.clickon_ImportData();
        xt.select_UploadForm(data.get("Select Data"),data.get("Select Prostate Cancer"));
        xt.select_Disease(data.get("Prostate Cancer"));
        xt.send_InputName("1" + TimeZone);
        xt.clickon_Extract();
    }

    @Test(priority = 2, dataProvider = "XT", dataProviderClass = DataProviderFactory.class)
    public void Create_NewTask_Select_Breast_Cancer(HashMap < String, String > data) throws InterruptedException {
        feature.select_Feature(data.get("XT"));
        xt.clickon_NewTask();
        xt.clickon_ImportData();
        xt.select_UploadForm(data.get("Select Data"),data.get("Select Breast Cancer"));
        xt.select_Disease(data.get("Breast Cancer"));
        xt.send_InputName("2" + TimeZone);
        xt.clickon_Extract();
    }

    @Test(priority = 3, dataProvider = "XT", dataProviderClass = DataProviderFactory.class)
    public void Create_NewTask_Select_Lung_Cancer(HashMap < String, String > data) throws InterruptedException {
        feature.select_Feature(data.get("XT"));
        xt.clickon_NewTask();
        xt.clickon_ImportData();
        xt.select_UploadForm(data.get("Select Data"),data.get("Select Lung Cancer"));
        xt.select_Disease(data.get("Lung Cancer"));
        xt.send_InputName("3" + TimeZone);
        xt.clickon_Extract();
    }

    @Test(priority = 4, dataProvider = "XT", dataProviderClass = DataProviderFactory.class)
    public void Create_NewTask_Select_HeadNeck_Cancer(HashMap < String, String > data) throws InterruptedException {
        feature.select_Feature(data.get("XT"));
        xt.clickon_NewTask();
        xt.clickon_ImportData();
        xt.select_UploadForm(data.get("Select Data"),data.get("Select HeadNeck Cancer"));
        xt.select_Disease(data.get("Head and Neck Cancer"));
        xt.send_InputName("4" + TimeZone);
        xt.clickon_Extract();
    }


    @Test(priority = 5, dataProvider = "XT", dataProviderClass = DataProviderFactory.class)
    public void Create_NewTask_Upload_Prostate_Cancer(HashMap < String, String > data) throws InterruptedException {
        feature.select_Feature(data.get("XT"));
        xt.clickon_NewTask();
        xt.clickon_ImportData();
        xt.select_UploadForm(data.get("Upload Data"),data.get("Upload Prostate Cancer"));
        xt.select_Disease(data.get("Prostate Cancer"));
        xt.send_InputName("5" + TimeZone);
        xt.clickon_Extract();
    }

    @Test(priority = 6, dataProvider = "XT", dataProviderClass = DataProviderFactory.class)
    public void Create_NewTask_Upload_Breast_Cancer(HashMap < String, String > data) throws InterruptedException {
        feature.select_Feature(data.get("XT"));
        xt.clickon_NewTask();
        xt.clickon_ImportData();
        xt.select_UploadForm(data.get("Upload Data"),data.get("Upload Breast Cancer"));
        xt.select_Disease(data.get("Breast Cancer"));
        xt.send_InputName("6" + TimeZone);
        xt.clickon_Extract();
    }

    @Test(priority = 7, dataProvider = "XT", dataProviderClass = DataProviderFactory.class)
    public void Create_NewTask_Upload_Lung_Cancer(HashMap < String, String > data) throws InterruptedException {
        feature.select_Feature(data.get("XT"));
        xt.clickon_NewTask();
        xt.clickon_ImportData();
        xt.select_UploadForm(data.get("Upload Data"),data.get("Upload Lung Cancer"));
        xt.select_Disease(data.get("Lung Cancer"));
        xt.send_InputName("7" + TimeZone);
        xt.clickon_Extract();
    }

    @Test(priority = 8, dataProvider = "XT", dataProviderClass = DataProviderFactory.class)
    public void Create_NewTask_Upload_HeadNeck_Cancer(HashMap < String, String > data) throws InterruptedException {
        feature.select_Feature(data.get("XT"));
        xt.clickon_NewTask();
        xt.clickon_ImportData();
        xt.select_UploadForm(data.get("Upload Data"),data.get("Upload HeadNeck Cancer"));
        xt.select_Disease(data.get("Head and Neck Cancer"));
        xt.send_InputName("8" +TimeZone);
        xt.clickon_Extract();
    }

    @Test(priority = 9, dataProvider = "XT", dataProviderClass = DataProviderFactory.class)
    public void Create_NewTask_Upload_DataImage(HashMap < String, String > data) throws InterruptedException {
        feature.select_Feature(data.get("XT"));
        xt.clickon_NewTask();
        xt.clickon_ImportData();
        xt.select_UploadForm(data.get("Upload Data"),data.get("Upload Data Image"));
        xt.select_Disease(data.get("Head and Neck Cancer"));
        xt.send_InputName("9" + TimeZone);
        xt.clickon_Extract();
    }
}
