package LizAI.Pages.Features;

import Core.Selenium.Button;
import Core.Selenium.ListOfElements;
import LizAI.Pages.BaseLizAIPages;
import org.openqa.selenium.By;

public class Taitan extends BaseLizAIPages {
    private static final By by = By.xpath("");
    private static final String name = "Taitan Page";

    //locators
    private final String xpath_NewSearch = "//app-data-insights-menu//button[@translate='newSearch']";
    private final String xpath_OutputData = "//app-create-search//h2[@translate='outputData']/parent::mat-card";
    private final String xpath_ListTemplate = "//mat-bottom-sheet-container//span[@translate]";
    //elements
    private final Button button_NewSearch = new Button(By.xpath(xpath_NewSearch),"btn_NewSearch");
    private final Button button_OutputData = new Button(By.xpath(xpath_OutputData),"btn_OutputData");
    //contructor
    public Taitan(boolean assertOpen) {super(by,name,assertOpen);}

    public void clickon_NewSearch(){
        button_NewSearch.waitForClickable();
        button_NewSearch.click();
        waitForJSToComplete();
    }

    public void clickon_OutputData(){
        button_OutputData.waitForClickable();
        button_OutputData.click();
        waitForJSToComplete();
    }

    public void select_ChooseTemplate(String nameTemplate){
        ListOfElements listOfElements = new ListOfElements(By.xpath(xpath_ListTemplate),"list_Template");
        for (int i = 0; i < listOfElements.getNumberOfElement(); i++) {
            if(listOfElements.getElement(i).getText().contains(nameTemplate)){
                listOfElements.getElement(i).click();
            } else {
                System.out.println("Template element is not clickable: " + nameTemplate);
            }
        }
    }
}
