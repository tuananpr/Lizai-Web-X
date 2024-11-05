package LizAI.Pages.Features;

import Core.Selenium.Button;
import Core.Selenium.ListOfElements;
import LizAI.Pages.BaseLizAIPages;
import org.openqa.selenium.By;

public class Feature extends BaseLizAIPages {
    public static final By by = By.xpath("");
    public static final String name = "Feature Page";

    private final String xpath_ChevronRight = "//mat-toolbar//mat-icon[contains(text(),'chevron_right')]/parent::button";
    //elements
    private final Button button_ChevronRight = new Button(By.xpath(xpath_ChevronRight),"btn_ChevronRight");
    //contractor
    public Feature(boolean assertOpen) {super(by,name,assertOpen);}

    public void select_Feature (String feature){
        //locators
        String xpath_Feature = "//div/a[@href]/span/span";
        ListOfElements listOfElements = new ListOfElements(By.xpath(xpath_Feature),"list_Feature");
        for (int i = 0; i < listOfElements.getNumberOfElement(); i++) {
            if (listOfElements.getElement(i).getText().contains(feature)){
                clickon_ChevronRight();
                listOfElements.getElement(i).click();
                waitForJSToComplete();
            }
        }
        waitForLoadingComplete();
    }

    public void clickon_ChevronRight() {
        if (button_ChevronRight.isElementDisplay()) {
            button_ChevronRight.waitForClickable();
            button_ChevronRight.click();
            waitForLoadingComplete();
        } else {
            System.out.println("Chevron Right button is not displayed.");
        }
    }
}
