package LizAI.Pages.Modules;

import Core.Selenium.ListOfElements;
import Core.Selenium.Select;
import Core.Selenium.Textbox;
import LizAI.Pages.BaseLizAIPages;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;

public class Address extends BaseLizAIPages {
    private final static By by = new By.ByXPath("");
    private final static String name = "Address";

    //locators
    private final String xpath_Country = "//mat-select[@id='mat-select-2']";
    private final String xpath_Region = "//mat-select[@id='mat-select-4']";
    private final String xpath_City = "//mat-select[@id='mat-select-6']";
    private final String xpath_Address = "//input[@formcontrolname='address']";
    private final String xpath_Options = "//mat-option[@role='option']";
    //elements
    private final Select select_Country = new Select(By.xpath(xpath_Country),"sl_Country");
    private final Select select_Region = new Select(By.xpath(xpath_Region),"sl_Region");
    private final Select select_City = new Select(By.xpath(xpath_City),"sl_City");
    private final Textbox textbox_Address = new Textbox(By.xpath(xpath_Address),"tb_Address");
    //contructor
    public Address(boolean assertOpen) {super(by,name , assertOpen);}

    public void select_Address(String country, String region, String city){
        select_Country.waitForElementToBeEnabled();
        select_Country.click();
        select_Option(country);
        waitForJSToComplete();
        select_Region.waitForElementToBeEnabled();
        select_Region.click();
        select_Option(region);
        waitForJSToComplete();
        select_City.waitForElementToBeEnabled();
        select_City.click();
        select_Option(city);
        waitForJSToComplete();
    }

    public void send_Address(String address){
        textbox_Address.waitForElementToBePresent();
        textbox_Address.sendClearText(address);
        waitForJSToComplete();
    }

    public void select_Option(String option){
        ListOfElements listOfElements = new ListOfElements(By.xpath(xpath_Options),"list_options");
        for (int i = 0; i < listOfElements.getNumberOfElement(); i++) {
            if (listOfElements.getElement(i).getText().equalsIgnoreCase(option)){
                listOfElements.getElement(i).click();
                break;
            }
        }
    }
}
