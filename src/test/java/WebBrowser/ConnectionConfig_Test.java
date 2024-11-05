package WebBrowser;

import Core.DataProviderFactory;
import Core.Support.General.Hooks;
import LizAI.Pages.Features.ConnectionConfig;
import LizAI.Pages.Features.Feature;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ConnectionConfig_Test extends Hooks {
    Feature feature = new Feature(false);
    ConnectionConfig connectionConfig = new ConnectionConfig(false);

    @Test(priority = 1, dataProvider = "Connection Config", dataProviderClass =  DataProviderFactory.class)
    public void Create_DicomWeb_ConnectorConfig(HashMap <String, String> data){
        feature.select_Feature(data.get("Connection Config"));
        connectionConfig.clickon_NewDataConnector();
        connectionConfig.select_TypeDicom(data.get("DicomWeb"));
        connectionConfig.send_Info(data.get("DicomWeb"),data.get("NameDicom"),data.get("UserName"),data.get("Password"),data.get("RequestUrlAPI"),"","","","","","");
        connectionConfig.clickon_Create();
    }

    @Test(priority = 2, dataProvider = "Connection Config", dataProviderClass =  DataProviderFactory.class)
    public void Delete_ConnectionConfig (HashMap <String, String> data){
        feature.select_Feature(data.get("Connection Config"));
        connectionConfig.select_ConnectionConfig(data.get("NameDicom"));
        connectionConfig.clickon_DeleteConnectionConfig();
    }

    @Test(priority = 3, dataProvider = "Connection Config", dataProviderClass =  DataProviderFactory.class)
    public void Create_DicomServer_ConnectorConfig(HashMap <String, String> data){
        feature.select_Feature(data.get("Connection Config"));
        connectionConfig.clickon_NewDataConnector();
        connectionConfig.select_TypeDicom(data.get("DicomServer"));
        connectionConfig.send_Info(data.get("DicomServer"),data.get("NameDicom"),data.get("UserName"),data.get("Password"),"",data.get("Client identity"),data.get("Dicom client port"),data.get("Dicom client host"),data.get("Server identity"),data.get("Dicom server port"),data.get("Dicom server host"));
        connectionConfig.clickon_Create();
    }
}
