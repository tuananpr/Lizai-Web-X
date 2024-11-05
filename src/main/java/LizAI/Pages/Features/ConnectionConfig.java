package LizAI.Pages.Features;

import Core.Selenium.Button;
import Core.Selenium.ListOfElements;
import Core.Selenium.Textbox;
import LizAI.Pages.BaseLizAIPages;
import org.openqa.selenium.By;

public class ConnectionConfig extends BaseLizAIPages {
    private static final By by = By.xpath("");
    private static final String name = "Connection Config Page";

    //locators
    private final String xpath_NewDataConnector = "//app-list-connection//span[contains(text(),'New data connector')]/parent::button";
    private final String xpath_TypeDicom = "//app-create-edit-connector//mat-select";
    private final String xpath_ListDicom = "//mat-option[@role='option']";
    private final String xpath_Name = "//mat-card-content//input[@formcontrolname='name']";
    private final String xpath_UserName = "//mat-card-content//input[@formcontrolname='username']";
    private final String xpath_Password = "//mat-card-content//input[@formcontrolname='password']";
    private final String xpath_RequestUrlAPI = "//mat-card-content//input[@formcontrolname='requestUrlAPI']";
    private final String xpath_ClientIdentity = "//mat-card-content//input[@formcontrolname='clientIdentity']";
    private final String xpath_DicomClientPort = "//mat-card-content//input[@formcontrolname='dicomClientPort']";
    private final String xpath_DicomClientHost = "//mat-card-content//input[@formcontrolname='dicomClientHost']";
    private final String xpath_ServerIdentity = "//mat-card-content//input[@formcontrolname='serverIdentity']";
    private final String xpath_DicomServerPort = "//mat-card-content//input[@formcontrolname='dicomServerPort']";
    private final String xpath_DicomServerHost = "//mat-card-content//input[@formcontrolname='dicomServerHost']";
    private final String xpath_TypeText = "//form//mat-select[@role='combobox']//span/span";
    private final String xpath_Create = "//app-create-edit-connector//button[@color='primary']";
    private final String xpath_ListConnectionConfig = "//app-list-connection//table//td[contains(@class,'column-name')]";
    private final String xpath_ListConnectionConfig_Option = "//app-list-connection//table//td//button";
    private final String xpath_DeleteConnectionConfig = "//div[@role='menu']//button//span[@translate='delete']/parent::span/parent::button";
    private final String xpath_Confirm = "//app-confirm-dialog//span[contains(text(),'Confirm')]/parent::button";


    //elements
    private final Button button_NewDataConnector = new Button(By.xpath(xpath_NewDataConnector),"btn_NewDataConnector");
    private final Button button_TypeDicom = new Button(By.xpath(xpath_TypeDicom),"btn_TypeDicom");
    private final Textbox textbox_Name = new Textbox(By.xpath(xpath_Name),"tb_Name");
    private final Textbox textbox_UserName = new Textbox(By.xpath(xpath_UserName),"tb_UserName");
    private final Textbox textbox_Password = new Textbox(By.xpath(xpath_Password),"tb_Password");
    private final Textbox textbox_RequestUrlAPI = new Textbox(By.xpath(xpath_RequestUrlAPI),"tb_RequestUrlAPI");
    private final Textbox textbox_ClientIdentity = new Textbox(By.xpath(xpath_ClientIdentity),"tb_ClientIdentity");
    private final Textbox textbox_DicomClientPort = new Textbox(By.xpath(xpath_DicomClientPort),"tb_DicomClientPort");
    private final Textbox textbox_DicomClientHost = new Textbox(By.xpath(xpath_DicomClientHost),"tb_DicomClientHost");
    private final Textbox textbox_ServerIdentity = new Textbox(By.xpath(xpath_ServerIdentity),"tb_ServerIdentity");
    private final Textbox textbox_DicomServerPort = new Textbox(By.xpath(xpath_DicomServerPort),"tb_DicomServerPort");
    private final Textbox textbox_DicomServerHost = new Textbox(By.xpath(xpath_DicomServerHost),"tb_DicomServerHost");
    private final Button button_Create = new Button(By.xpath(xpath_Create),"btn_Create");
    private final Button button_DeleteConnectionConfig = new Button(By.xpath(xpath_DeleteConnectionConfig),"btn_DeleteConnectionConfig");
    private final Button button_Confirm = new Button(By.xpath(xpath_Confirm),"btn_Confirm");
    //contructor

    public ConnectionConfig(boolean assertOpen) {super(by,name,assertOpen);}

    public void clickon_NewDataConnector(){
        button_NewDataConnector.waitForClickable();
        button_NewDataConnector.click();
        waitForJSToComplete();
    }

    public void clickon_TypeDicom(){
        button_TypeDicom.waitForClickable();
        button_TypeDicom.click();
        waitForJSToComplete();
    }

    public void select_TypeDicom(String nameDicom){
        clickon_TypeDicom();
        waitForJSToComplete();
        ListOfElements listOfElements = new ListOfElements(By.xpath(xpath_ListDicom),"list_Dicom");
        for (int i = 0; i < listOfElements.getNumberOfElement(); i++) {
            if(listOfElements.getElement(i).getText().contains(nameDicom)){
                listOfElements.getElement(i).click();
                waitForJSToComplete();
            }
        }
    }

    public void send_Info(String typeDicom, String name, String userName, String password, String requestUrlAPI,
                          String clientIdentity, String dicomClientPort, String dicomClientHost,
                          String serverIdentity, String dicomServerPort, String dicomServerHost) {

        if (typeDicom.equals("Dicom web")) {
            // Sending information for Dicom Web connection
            send_Name(name);
            send_UserName(userName);
            send_Password(password);
            send_RequestUrlAPI(requestUrlAPI);
        } else if (typeDicom.equals("Dicom server")) {
            // Sending information for Dicom Server connection
            send_Name(name);
            send_ClientIdentity(clientIdentity);
            send_DicomClientPort(dicomClientPort);
            send_DicomClientHost(dicomClientHost);
            send_ServerIdentity(serverIdentity);
            send_DicomServerPort(dicomServerPort);
            send_DicomServerHost(dicomServerHost);
            send_UserName(userName);
            send_Password(password);
        } else {
            // Handle invalid typeDicom
            System.out.println("No connection configuration found for type: " + typeDicom);
            // Optionally throw an exception
            throw new IllegalArgumentException("Unsupported DICOM type: " + typeDicom);
        }
    }
//    public void send_InforConnectionConfig(String typeDicom, String name, String userName, String password, String requestUrlAPI, String clientIdentity, String dicomClientPort, String dicomClientHost, String serverIdentity, String dicomServerPort, String diconServerHost){
//        switch (typeDicom){
//            case "Dicom Web":
//                send_Name(name);
//                send_UserName(userName);
//                send_Password(password);
//                send_RequestUrlAPI(requestUrlAPI);
//                break;
//
//            case "Dicom Server":
//                send_Name(name);
//                send_ClientIdentity(clientIdentity);
//                send_DicomClientPort(dicomClientPort);
//                send_DicomClientHost(dicomClientHost);
//                send_ServerIdentity(serverIdentity);
//                send_DicomServerPort(dicomServerPort);
//                send_DicomServerHost(diconServerHost);
//                send_UserName(userName);
//                send_Password(password);
//                break;
//        }
//    }

    public void send_Name(String name){
        textbox_Name.waitForElementToBePresent();
        textbox_Name.sendClearText(name);
        waitForJSToComplete();
    }

    public void send_UserName(String userName){
        textbox_UserName.waitForElementToBePresent();
        textbox_UserName.sendClearText(userName);
        waitForJSToComplete();
    }

    public void send_Password(String password){
        textbox_Password.waitForElementToBePresent();
        textbox_Password.sendClearText(password);
        waitForJSToComplete();
    }

    public void send_RequestUrlAPI(String requestUrlAPI){
        textbox_RequestUrlAPI.waitForElementToBePresent();
        textbox_RequestUrlAPI.sendClearText(requestUrlAPI);
        waitForJSToComplete();
    }

    public void send_ClientIdentity(String clientIdentity){
        textbox_ClientIdentity.waitForElementToBePresent();
        textbox_ClientIdentity.sendClearText(clientIdentity);
        waitForJSToComplete();
    }

    public void send_DicomClientPort(String dicomClientPort){
        textbox_DicomClientPort.waitForElementToBePresent();
        textbox_DicomClientPort.sendClearText(dicomClientPort);
        waitForJSToComplete();
    }

    public void send_DicomClientHost(String dicomClientHost){
        textbox_DicomClientHost.waitForElementToBePresent();
        textbox_DicomClientHost.sendClearText(dicomClientHost);
        waitForJSToComplete();
    }

    public void send_ServerIdentity(String serverIdentity){
        textbox_ServerIdentity.waitForElementToBePresent();
        textbox_ServerIdentity.sendClearText(serverIdentity);
        waitForJSToComplete();
    }

    public void send_DicomServerPort(String dicomServerPort){
        textbox_DicomServerPort.waitForElementToBePresent();
        textbox_DicomServerPort.sendClearText(dicomServerPort);
        waitForJSToComplete();
    }

    public void send_DicomServerHost(String dicomServerHost){
        textbox_DicomServerHost.waitForElementToBePresent();
        textbox_DicomServerHost.sendClearText(dicomServerHost);
        waitForJSToComplete();
    }

    public void clickon_Create(){
        button_Create.waitForClickable();
        button_Create.click();
        waitForJSToComplete();
    }

    public void select_ConnectionConfig(String nameConnection) {
        ListOfElements listOfElementsConnectConfig = new ListOfElements(By.xpath(xpath_ListConnectionConfig), "list_ConnectionConfig");
        ListOfElements listOfElementsConnectionConfigOption = new ListOfElements(By.xpath(xpath_ListConnectionConfig_Option), "list_ConnectionConfig_Option");

        for (int i = 0; i < listOfElementsConnectConfig.getNumberOfElement(); i++) {
            // Check if the current element's text matches the provided connection name
            if (listOfElementsConnectConfig.getElement(i).getText().contains(nameConnection)) {
                // Click on the corresponding option
                // Assuming that the options are aligned with the configurations by index
                if (i <= listOfElementsConnectionConfigOption.getNumberOfElement()) {
                    listOfElementsConnectionConfigOption.getElement(i).click();
                    break; // Exit the loop after clicking
                } else {
                    System.out.println("No corresponding option found for " + nameConnection);
                }
            }
        }

    }

    public void clickon_DeleteConnectionConfig(){
        button_DeleteConnectionConfig.waitForClickable();
        button_DeleteConnectionConfig.click();
        waitForJSToComplete();
        clickon_Comfirm();
    }

    public void clickon_Comfirm(){
        button_Confirm.waitForClickable();
        button_Confirm.click();
        waitForJSToComplete();
    }
}
