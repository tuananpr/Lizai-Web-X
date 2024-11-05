package WebBrowser;

import Core.DataProviderFactory;
import Core.Support.General.Hooks;
import LizAI.Pages.Features.SignInPage;
import org.testng.annotations.*;

import java.util.HashMap;


public class SignIn_Test extends Hooks {

    @BeforeMethod
    public void setup(){
        before();
        beforeWeb();
    }

//    @AfterMethod
//
//    public void tearDown(){
//        System.out.println("After..............................");
//        after();
//    }

    @Test(priority = 1, dataProvider = "SystemAdministrator", dataProviderClass = DataProviderFactory.class)
    public void Signin_SystemAdmin(HashMap<String, String>data) throws  InterruptedException{
        SignInPage signInPage = new SignInPage(true);
        signInPage.signIn(data.get("ID"),data.get("Password"));
        signInPage.waitForPageLoadComplete();
        signInPage.label_UserName(data.get("SystemAdminName"));
    }

    @Test(priority = 2, dataProvider = "Administrator", dataProviderClass = DataProviderFactory.class)
    public void Signin_Admin(HashMap<String, String>data) throws  InterruptedException {
        SignInPage signInPage = new SignInPage(true);
        signInPage.signIn(data.get("ID"),data.get("Password"));
        signInPage.waitForPageLoadComplete();
        signInPage.label_UserName(data.get("AdminName"));
    }

    @Test(priority = 3, dataProvider = "UserAccount", dataProviderClass = DataProviderFactory.class)
    public void Signin_User(HashMap<String, String>data) throws  InterruptedException {
        SignInPage signInPage = new SignInPage(true);
        signInPage.signIn(data.get("ID"),data.get("Password"));
        signInPage.waitForPageLoadComplete();
        signInPage.label_UserName(data.get("UserName"));

    }
}
