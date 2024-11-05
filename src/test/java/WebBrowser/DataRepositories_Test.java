package WebBrowser;

import Core.DataProviderFactory;
import Core.Support.General.Hooks;
import LizAI.Pages.Features.ClearData;
import LizAI.Pages.Features.DataRepositories;
import LizAI.Pages.Features.Feature;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DataRepositories_Test extends Hooks {
    Feature feature = new Feature(false);
    DataRepositories dataRepositories = new DataRepositories(false);
    ClearData clearData = new ClearData(false);
    @Test(priority = 1, dataProvider = "DataRepositories", dataProviderClass = DataProviderFactory.class)
    public void UploadFoler_Patient1(HashMap < String, String > data) throws InterruptedException {
        feature.select_Feature(data.get("DataRepositories"));
        clearData.clear_DataRepositories(data.get("Patient1"));
        dataRepositories.clickon_Upload();
        dataRepositories.select_UploadForm(data.get("UploadFolder"),data.get("Patient1"));
    }

    @Test(priority = 2, dataProvider = "DataRepositories", dataProviderClass = DataProviderFactory.class)
    public void UploadFoler_Patient2(HashMap < String, String > data) throws InterruptedException {
        feature.select_Feature(data.get("DataRepositories"));
        clearData.clear_DataRepositories(data.get("Patient2"));
        dataRepositories.clickon_Upload();
        dataRepositories.select_UploadForm(data.get("UploadFolder"),data.get("Patient2"));
    }
    @Test(priority = 3, dataProvider = "DataRepositories", dataProviderClass = DataProviderFactory.class)
    public void UploadFoler_Patient3(HashMap < String, String > data) throws InterruptedException {
        feature.select_Feature(data.get("DataRepositories"));
//        clearData.clear_DataRepositories(data.get("Patient3"));
        dataRepositories.clickon_Upload();
        dataRepositories.select_UploadForm(data.get("UploadFolder"),data.get("Patient3"));
    }
}
