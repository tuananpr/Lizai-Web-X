package Core;

import LizAI.Pages.BaseLizAIPages;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import java.util.HashMap;

public class DataProviderFactory extends BaseLizAIPages {
    private static String studyName;

    public static void setStudyName(String studyName) {
        DataProviderFactory.studyName = studyName;
    }

    public DataProviderFactory(By locator, String pageName, boolean assertOpen) {super(locator, pageName, assertOpen);}


    @DataProvider(name= "SystemAdministrator")
    public static Object[][] dataSystemAdmin(){
        Object[][] oSystemAdmin = new Object[1][];
        HashMap<String, String> systemAdmin = new HashMap<String, String>();

        //Information
        systemAdmin.put("ID","tyler.nguyen@lizai.co");
        systemAdmin.put("Password","shdfkh@dsDSSDF39nmsad");
        systemAdmin.put("SystemAdminName","Tyler.Nguyen");


        oSystemAdmin[0] = new Object[] {systemAdmin};
        return oSystemAdmin;
    }

    @DataProvider(name= "Administrator")
    public static Object[][] dataAdmin() {


        Object[][] oAdmin = new Object[1][];
        HashMap<String, String> admin = new HashMap<String, String>();

        //Information
        admin.put("ID","matrixmax22@gmail.com");
        admin.put("Password","dfsgdfsjkertERTERDGF34534##$");
        admin.put("AdminName","MatrixMax22");

        oAdmin[0] = new Object[] {admin};
        return oAdmin;
    }



    @DataProvider(name= "UserAccount")
    public static Object[][] dataUser(){
        Object[][] oUser = new Object[1][];
        HashMap<String, String> user = new HashMap<String, String>();

        //Information
        user.put("ID","daisy.vo@lizai.co");
        user.put("Password","gfdmgnkdfjDSRFSD@2123");
        user.put("UserName","daisyvo");

        oUser[0] = new Object[] {user};
        return oUser;
    }



    @DataProvider(name = "Atlantis")
    public static Object[][] dataAtlantis(){
        Object[][] oAtlantis = new Object[1][];
        HashMap<String, String> atlantis = new HashMap<>();

        //Information
        atlantis.put("Atlantis","Atlantis");
        atlantis.put("Question1","Hello");
        atlantis.put("Question2","Tell me a patient ID of his?");
        atlantis.put("Question3","And gender?");
        atlantis.put("Question4","Tell me about summary of this attach file?");

        oAtlantis[0] = new Object[] {atlantis};
        return oAtlantis;
    }

    @DataProvider(name = "XT")
    public static Object[][] dataXT(){
        Object[][] oXT = new Object[1][];
        HashMap<String, String> xt = new HashMap<>();

        //information
        xt.put("XT","XT");
        xt.put("Upload Data","Upload data from your computer");
        xt.put("Select Data","Select data from your data repositories");

        xt.put("Upload Prostate Cancer","goc-prostate-cancer");
        xt.put("Upload Breast Cancer","goc-breast-cancer");
        xt.put("Upload Lung Cancer","goc-lung-cancer");
        xt.put("Upload HeadNeck Cancer","goc-head-neck-cancer");
        xt.put("Upload Data Image","data-Image");

        xt.put("Select Prostate Cancer","goc-prostate-cancer");
        xt.put("Select Breast Cancer","goc-breast-cancer");
        xt.put("Select Lung Cancer","goc-lung-cancer");
        xt.put("Select HeadNeck Cancer","goc-head-neck-cancer");



        xt.put("Prostate Cancer","Prostate Cancer");
        xt.put("Breast Cancer","Breast Cancer");
        xt.put("Lung Cancer","Lung Cancer");
        xt.put("Head and Neck Cancer","Head and Neck Cancer");


        oXT[0] = new Object[] {xt};
        return oXT;
    }



    @DataProvider(name = "DataRepositories")
    public static Object[][] dataDataRepositories(){
        Object[][] oDataRepositories = new Object[1][];
        HashMap<String, String> dataRepositories = new HashMap<>();

        //Information
        dataRepositories.put("DataRepositories","Data Repositories");
        dataRepositories.put("UploadFolder","Folder");
        dataRepositories.put("Patient1","DATA-PATIENT-1");
        dataRepositories.put("Patient2","DATA-PATIENT-2");
        dataRepositories.put("Patient3","DATA-PATIENT-3");


        oDataRepositories[0] = new Object[] {dataRepositories};
        return oDataRepositories;
    }

    @DataProvider(name = "PatientRepositories")
    public static Object[][] dataPatientRepositories(){
        Object[][] oPatientRepositories = new Object[1][];
        HashMap<String, String> patientRepositories = new HashMap<>();

        //Information
        patientRepositories.put("PatientRepositories","Patient");
        patientRepositories.put("DicomWeb","Dicom Web");
        patientRepositories.put("PatientName","ACRIN-FMISO-Brain-004");
        patientRepositories.put("NameCloneData","");

        oPatientRepositories[0] = new Object[] {patientRepositories};
        return oPatientRepositories;
    }

    @DataProvider(name = "Connection Config")
    public static Object[][] dataConnectionConfig(){
        Object[][] oConnectionConfig = new Object[1][];
        HashMap<String, String> connectionConfig = new HashMap<>();

        //Information
        connectionConfig.put("Connection Config","Connection Config");
        connectionConfig.put("DicomWeb","Dicom web");
        connectionConfig.put("DicomServer","Dicom server");
        connectionConfig.put("NameDicom","Matrix Dicom");
        connectionConfig.put("UserName","lizai");
        connectionConfig.put("Password","nUi7hjdsg0ogvabG");
        connectionConfig.put("RequestUrlAPI","http://18.219.196.205:8042");
        connectionConfig.put("Client identity","LizaiAET");
        connectionConfig.put("Dicom client port","4242");
        connectionConfig.put("Dicom client host","127.0.0.1");
        connectionConfig.put("Server identity","ORTHANC");
        connectionConfig.put("Dicom server port","4242");
        connectionConfig.put("Dicom server host","18.219.196.205");




        oConnectionConfig[0] = new Object[] {connectionConfig};
        return oConnectionConfig;
    }
}
