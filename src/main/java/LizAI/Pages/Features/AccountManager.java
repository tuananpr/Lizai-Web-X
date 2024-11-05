package LizAI.Pages.Features;

import Core.Selenium.Button;
import Core.Selenium.ListOfElements;
import Core.Selenium.Select;
import Core.Selenium.Textbox;
import LizAI.Pages.BaseLizAIPages;
import LizAI.Pages.Modules.Address;
import LizAI.Pages.Modules.Calendar;
import org.openqa.selenium.By;

public class AccountManager extends BaseLizAIPages {
    private static final By by = By.xpath("");
    private static final String name = "Account manager Page";

    //locators
    private final String xpath_Avatar = "//app-header//mat-toolbar-row//div[@class='avatar']";
    private final String xpath_AccountManagement ="//div//a[@href='/account-manager']";
    private final String xpath_EditProfile = "//app-account-management//button//span[contains(text(),'Edit profile')]";
    private final String xpath_DisplayName = "//input[@formcontrolname='displayName']";
    private final String xpath_Title = "//input[@formcontrolname='title']";
    private final String xpath_FirstName = "//input[@formcontrolname='firstName']";
    private final String xpath_LastName = "//input[@formcontrolname='lastName']";
    private final String xpath_PhoneNumber = "//mat-form-field//input[@formcontrolname='phone']";
    private final String xpath_Gender = "//mat-select[@formcontrolname='gender']";
    private final String xpath_gender = "//div[@role='listbox']/mat-option";
    private final String xpath_Save = "//app-account-management//button[@color='primary']";

    //elements
    private final Button button_Avarta = new Button(By.xpath(xpath_Avatar),"btn_Avarta");
    private final Button button_AccountManagement = new Button(By.xpath(xpath_AccountManagement),"btn_Accountmanagement");
    private final Button button_EditProfile = new Button(By.xpath(xpath_EditProfile),"btn_EditProfile");
    private final Textbox textbox_DisplayName = new Textbox(By.xpath(xpath_DisplayName),"tb_DisplayName");
    private final Textbox textbox_Title = new Textbox(By.xpath(xpath_Title),"tb_Title");
    private final Textbox textbox_FirstName = new Textbox(By.xpath(xpath_FirstName),"tb_FirstName");
    private final Textbox textbox_LastName = new Textbox(By.xpath(xpath_LastName),"tb_LastName");
    private final Textbox textbox_PhoneNumber = new Textbox(By.xpath(xpath_PhoneNumber),"tb_PhoneNumber");
    private final Button button_Gender = new Button(By.xpath(xpath_Gender),"btn_Gender");
    private final Select select_Gender = new Select(By.xpath(xpath_gender),"sl_Gender");
    private final Button button_Save = new Button(By.xpath(xpath_Save),"btn_Save");
    //constructor
    public AccountManager(boolean assertOpen) {super(by, name, assertOpen);}
    public void clickon_Avatar(){
        button_Avarta.waitForClickable();
        button_Avarta.click();
        waitForLoadingComplete();
    }

    public void clickon_AccountManagement(){
        button_AccountManagement.waitForClickable();
        button_AccountManagement.click();
        waitForLoadingComplete();
    }

    public void clickon_EditProfile(){
        clickon_Avatar();
        clickon_AccountManagement();
        button_EditProfile.waitForClickable();
        button_EditProfile.click();
        waitForLoadingComplete();
    }

    public void send_DisplayName(String name){
        textbox_DisplayName.waitForElementToBePresent();
        textbox_DisplayName.sendClearText(name);
        waitForJSToComplete();
    }

    public void send_Title(String title){
        textbox_Title.waitForElementToBePresent();
        textbox_Title.sendClearText(title);
        waitForJSToComplete();
    }

    public void send_FirstName(String firstName){
        textbox_FirstName.waitForElementToBePresent();
        textbox_FirstName.sendClearText(firstName);
        waitForJSToComplete();
    }

    public void send_LastName(String lastName){
        textbox_LastName.waitForElementToBePresent();
        textbox_LastName.sendClearText(lastName);
        waitForJSToComplete();
    }

    public void select_DayofBirth(String dOB){
        Calendar calendar = new Calendar(false);
        calendar.selectDate(dOB);
    }

    public void select_Gender(String gender){
        button_Gender.waitForElementToBeEnabled();
        button_Gender.click();
        select_listGender(gender);
    }

    public void select_listGender(String gender){
        ListOfElements listOfElements = new ListOfElements(By.xpath(xpath_gender),"list_gender");
        for (int i = 0; i < listOfElements.getNumberOfElement(); i++) {
            if( listOfElements.getElement(i).getText().equalsIgnoreCase(gender)){
                listOfElements.getElement(i).click();
                waitForJSToComplete();
            }
        }
    }
    public void send_PhoneNumber(String phoneNumber){
        textbox_PhoneNumber.waitForElementToBePresent();
        textbox_PhoneNumber.sendClearText(phoneNumber);
        waitForJSToComplete();
    }

    public void send_Address (String country, String region, String city, String address ){
        Address address1 = new Address(false);
        address1.select_Address(country,region,city);
        address1.send_Address(address);
    }

    public void click_Save(){
        button_Save.waitForClickable();
        button_Save.click();
        waitForJSToComplete();
    }


}