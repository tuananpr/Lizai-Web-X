package WebBrowser;

import Core.Support.General.Hooks;
import LizAI.Pages.Features.AccountManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Accountmanager_Test extends Hooks {
    @BeforeMethod
    public void setup(){
        before();
        beforeWeb();
    }

    @AfterMethod
    public void tearDown(){
        after();
    }

    SignIn_Test signInTest = new SignIn_Test();
    AccountManager accountManager = new AccountManager(false);
    String DisplayName = "MatrixTEST";
    String Title = "UserLV2";
    String FirstName = "Matrixmax";
    String LastName = "LV2";
    String DOB =  "01/04/1990";
    String Gender = "Female";
    String PhoneNumber = "0908090908";
    String Address = "130 Hồng Hà - 9 - Phú Nhuận";
    String Country = "Việt Nam";
    String Region = "South Eastern Vietnam";
    String City = "Hồ Chí Minh";
    @Test (priority = 1)
    public void UpdateAccountInformation() throws InterruptedException{
//        signInTest.Signin_Admin();
        accountManager.clickon_EditProfile();
        accountManager.send_Title(Title);
        accountManager.send_FirstName(FirstName);
        accountManager.send_LastName(LastName);
        accountManager.select_DayofBirth(DOB);
        accountManager.select_Gender(Gender);
        accountManager.send_PhoneNumber(PhoneNumber);
        accountManager.send_Address(Country,Region,City,Address);
        accountManager.click_Save();
        Assert.assertTrue(AccountManager.getToastMessage().contains("Success"),"Success");
        System.out.println("User Account Update Information " + AccountManager.getToastMessage());
    }
}
