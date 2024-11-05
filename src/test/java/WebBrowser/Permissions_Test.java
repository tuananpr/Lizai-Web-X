package WebBrowser;

import Core.Support.General.Hooks;
import LizAI.Pages.Features.Permissions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Permissions_Test extends Hooks {

    @BeforeMethod
    public void setup(){
        before();
        beforeWeb();
    }

    @AfterMethod

    public void tearDown(){after();}
    String NameGroupPermissions = "TestUserGroupPermissons";
    String newGroupPermissions ;
    SignIn_Test signInTest = new SignIn_Test();
    Permissions permissions = new Permissions(false);
    @Test(priority = 1)
    public void Create_GroupPermissions() throws InterruptedException{
        List<String> GPermissions = new ArrayList<>();
        GPermissions.add("Users");
        GPermissions.add("Group Permissions");
        GPermissions.add("Workspace Types");
        GPermissions.add("System Studies");
        GPermissions.add("Studies");

//        signInTest.Signin_SystemAdmin();
        permissions.clickon_GroupPermissions();
        permissions.clickon_CreateNewTemplate();
        permissions.sendtext_NameGroupPermissions(NameGroupPermissions);
        permissions.select_GroupPermissions(GPermissions);
        permissions.clickon_Create();
        newGroupPermissions = permissions.getNameGroupPermissions(NameGroupPermissions);
    }

    @Test(priority = 2)
    public void Delete_GroupPermissions() throws InterruptedException{
//        signInTest.Signin_SystemAdmin();
        permissions.clickon_GroupPermissions();
        permissions.search_NameGroup(newGroupPermissions);
    }
}
