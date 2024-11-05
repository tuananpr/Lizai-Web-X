package WebBrowser;

import Core.DataProviderFactory;
import Core.Support.General.Hooks;
import LizAI.Pages.Features.Feature;
import LizAI.Pages.Features.PatientRepositories;
import org.testng.annotations.Test;

import java.util.HashMap;


public class PatientRepositories_Test extends Hooks {
    Feature feature = new Feature(false);
    PatientRepositories patientRepositories = new PatientRepositories(false);
    String TimeZone = LizAI.Pages.Features.TimeZone.getCurrentTime();
    @Test(priority = 1, dataProvider = "PatientRepositories", dataProviderClass = DataProviderFactory.class)
    public void Create_CloneData_1Patient(HashMap <String, String> data) throws InterruptedException{
        feature.select_Feature(data.get("PatientRepositories"));
        patientRepositories.clickon_CloneData();
        patientRepositories.select_YourConnection(data.get("DicomWeb"));
        patientRepositories.select_Patient(data.get("PatientName"));
        patientRepositories.send_NameCloneData("1P " + TimeZone);
        patientRepositories.clickon_CloudDownload();

    }
}
