package WebBrowser;

import Core.DataProviderFactory;
import Core.Support.General.Hooks;
import LizAI.Pages.Features.AtlantisPage;
import LizAI.Pages.Features.Feature;
import LizAI.Pages.Features.SignInPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Atlantis_Test extends Hooks {
    Feature feature = new Feature(false);
    AtlantisPage atlantisPage = new AtlantisPage(false);
    String TimeZone = LizAI.Pages.Features.TimeZone.getCurrentTime();
    @Test(priority = 1, dataProvider = "Atlantis", dataProviderClass = DataProviderFactory.class)
    public void Create_Conversation_Patient1(HashMap < String, String > data) {
        feature.select_Feature(data.get("Atlantis"));
        atlantisPage.clickon_NewConversation();
        atlantisPage.clickon_ImportData();
        atlantisPage.clickon_SelectFromYourFiles();
        atlantisPage.send_InputName("DATA-PATIENT-1");
        atlantisPage.clickon_Filter();
        atlantisPage.clickon_CheckboxAll();
        atlantisPage.clickon_Confirm();
        atlantisPage.clickon_StartConversation();
        atlantisPage.send_MessageAtlantis(TimeZone);
        atlantisPage.clickon_SendMessage();
        atlantisPage.send_MessageAtlantis(data.get("Question2"));
        atlantisPage.clickon_SendMessage();
        atlantisPage.send_MessageAtlantis(data.get("Question3"));
        atlantisPage.clickon_SendMessage();
        atlantisPage.send_MessageAtlantis(data.get("Question4"));
        atlantisPage.clickon_SendMessage();
    }

    @Test(priority = 2, dataProvider = "Atlantis", dataProviderClass = DataProviderFactory.class)
    public void Create_Conversation_Patient2(HashMap < String, String > data) {
        feature.select_Feature(data.get("Atlantis"));
        atlantisPage.clickon_NewConversation();
        atlantisPage.clickon_ImportData();
        atlantisPage.clickon_SelectFromYourFiles();
        atlantisPage.send_InputName("DATA-PATIENT-2");
        atlantisPage.clickon_Filter();
        atlantisPage.clickon_CheckboxAll();
        atlantisPage.clickon_Confirm();
        atlantisPage.clickon_StartConversation();
        atlantisPage.send_MessageAtlantis(data.get("Question1"));
        atlantisPage.clickon_SendMessage();
        atlantisPage.send_MessageAtlantis(data.get("Question2"));
        atlantisPage.clickon_SendMessage();
        atlantisPage.send_MessageAtlantis(data.get("Question3"));
        atlantisPage.clickon_SendMessage();
        atlantisPage.send_MessageAtlantis(data.get("Question4"));
        atlantisPage.clickon_SendMessage();
    }

    @Test(priority = 3, dataProvider = "Atlantis", dataProviderClass = DataProviderFactory.class)
    public void Create_Conversation_Patient3(HashMap < String, String > data) {
        feature.select_Feature(data.get("Atlantis"));
        atlantisPage.clickon_NewConversation();
        atlantisPage.clickon_ImportData();
        atlantisPage.clickon_SelectFromYourFiles();
        atlantisPage.send_InputName("DATA-PATIENT-3");
        atlantisPage.clickon_Filter();
        atlantisPage.clickon_CheckboxAll();
        atlantisPage.clickon_Confirm();
        atlantisPage.clickon_StartConversation();
        atlantisPage.send_MessageAtlantis(data.get("Question1"));
        atlantisPage.clickon_SendMessage();
        atlantisPage.send_MessageAtlantis(data.get("Question2"));
        atlantisPage.clickon_SendMessage();
        atlantisPage.send_MessageAtlantis(data.get("Question3"));
        atlantisPage.clickon_SendMessage();
        atlantisPage.send_MessageAtlantis(data.get("Question4"));
        atlantisPage.clickon_SendMessage();
    }
}
