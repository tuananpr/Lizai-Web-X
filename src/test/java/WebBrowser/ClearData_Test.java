package WebBrowser;

import Core.Support.General.Hooks;
import LizAI.Pages.Features.ClearData;
import LizAI.Pages.Features.StudiesPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClearData_Test extends Hooks {
//    @BeforeMethod
//    public void setup(){
//        before();
//        beforeWeb();
//    }
//
//    @AfterMethod
//    public void tearDown(){
//        System.out.println("After..............................");
//        after();
//    }


    @Test(priority = 1)
    public void Clear_Study(){
        StudiesPage studiesPage = new StudiesPage(false);
        studiesPage.clickon_StudiesAppMenu();
        ClearData clearData = new ClearData(false);
        clearData.delete_Study("Files");
    }
}
