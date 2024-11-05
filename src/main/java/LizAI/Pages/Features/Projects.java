package LizAI.Pages.Features;

import Core.Selenium.Button;
import Core.Selenium.Textbox;
import LizAI.Pages.BaseLizAIPages;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;

public class Projects extends BaseLizAIPages {
    public static final By by = By.xpath("");
    public static final String name = "Projects Page";

    //locators
    private final String xpath_Projects = "//app-aside-menu//mat-list-item//a[@href='/projects']";
    private final String xpath_CreateNewProject = "//app-features/app-projects/div/button";
    private final String xpath_Create = "//app-create-project-dialog/div/button[@color='primary']";
    private final String xpath_Filter = "//app-project-list//button[@color='primary']";
    private final String xpath_action_Block = "//app-project-list//table//button[2]";
    //elements
    private final Button button_Projects = new Button(By.xpath(xpath_Projects),"btn_Projects");
    private final Button button_CreateNewProject = new Button(By.xpath(xpath_CreateNewProject),"btn_CreateNewProject");
    private final Textbox textbox_Name_CreateNewProject = new Textbox(By.id("mat-input-123"),"tb_inputNameCreateNewProject");
    private final Textbox textbox_Description_CreateNewProject =  new Textbox(By.id("mat-input-123"),"tb_inputDescriptionCreateNewProject");
    private final Button button_Create = new Button(By.xpath(xpath_Create),"btn_Create");
    private final Textbox textbox_Input_Name = new Textbox(By.id("mat-input-120"),"tb_inputName");
    private final Button button_Filter = new Button(By.xpath(xpath_Filter),"btn_Filter");
    private final Button button_action_Block = new Button(By.xpath(xpath_action_Block),"btn_Block");
    //constructor
    public Projects(boolean assertOpen) {super(by,name,assertOpen);}

    public void clickon_Projects(){
        button_Projects.waitForClickable();
        button_Projects.click();
        waitForLoadingComplete();
    }

    public void clickon_CreateNewProject(){
        button_CreateNewProject.waitForClickable();
        button_CreateNewProject.click();
        waitForJSToComplete();
    }

    public void send_NameofProject(String name){
        textbox_Name_CreateNewProject.waitForElementToBePresent();
        textbox_Name_CreateNewProject.sendClearText(name);
        waitForJSToComplete();
    }

    public void send_Description(String description){
        textbox_Description_CreateNewProject.waitForElementToBePresent();
        textbox_Description_CreateNewProject.sendClearText(description);
        waitForJSToComplete();
    }

    public void clickon_Create(){
        button_Create.waitForClickable();
        button_Create.click();
        waitForJSToComplete();
    }

    public void send_NameFilter(String name){
        textbox_Input_Name.waitForElementToBePresent();
        textbox_Input_Name.sendClearText(name);
        waitForJSToComplete();
    }

    public void clickon_Filter(){
        button_Filter.waitForClickable();
        button_Filter.click();
        waitForJSToComplete();
    }

    public void clickon_Block() throws InterruptedException {
        button_action_Block.waitForClickable();
        Thread.sleep(3000);
        button_action_Block.click();
        waitForJSToComplete();
    }

}

