package WebBrowser;

import Core.DataProviderFactory;
import Core.Support.General.Hooks;
import LizAI.Pages.Modules.CurrentTime;
import LizAI.Pages.Features.StudiesPage;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Studies_Test extends Hooks {
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
CurrentTime currentTime = new CurrentTime(false);
StudiesPage studiesPage = new StudiesPage(false);
//public String studyName = studiesPage.getStudyName();

    @Test(priority = 1, dataProvider = "Administrator", dataProviderClass =  DataProviderFactory.class)
    public void Create_MyStudy(HashMap<String, String>data) {
        studiesPage.clickon_StudiesAppMenu();
        studiesPage.clickon_CreateNewStudy();
        studiesPage.select_StudyType("My studies");
        studiesPage.sendtext_StudyCode(currentTime.getCurrentTime()+ "_MyCode");
        studiesPage.sendtext_StudyName(currentTime.getCurrentTime()+ "_MyName");
        studiesPage.sendtext_StudyDesciption("MyDescription");
        studiesPage.select_ProjectName("Matrix_Project_1");
        studiesPage.clickon_Create();
        studiesPage.send_FilterStudyName(studiesPage.getStudyName());

    }

    @Test(priority = 2, dataProvider = "Administrator", dataProviderClass = DataProviderFactory.class)
    public void Edit_MyStudy_Name(HashMap<String, String> data)  {
        studiesPage.clickon_Edit_MyStudy(studiesPage.getStudyName());
        studiesPage.send_EditStudyName(studiesPage.getStudyCode());
        studiesPage.send_EditStudyDescription("This is my study");
        studiesPage.clickon_EditStudyConfirm();
    }

    @Test(priority = 3)
    public void Upload_Files(){
        studiesPage.clickon_UploadFiles();
        studiesPage.select_UploadFrom("UploadFile","NotesReport.xls");
    }

    @Test(priority = 4)
    public void Upload_Folder(){
        studiesPage.clickon_UploadFiles();
        studiesPage.select_UploadFrom("UploadFolder","pdf");
    }

    @Test(priority = 5)
    public void Upload_ETL(){
        studiesPage.clickon_UploadFiles();
        studiesPage.select_UploadFrom("UploadfromETL","NoteNew");
    }

    @Test(priority = 6)
    public void Delete_File(){


    }
}
