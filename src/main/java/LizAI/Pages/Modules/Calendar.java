package LizAI.Pages.Modules;

import Core.Selenium.Button;
import Core.Selenium.Label;
import Core.Selenium.ListOfElements;
import LizAI.Pages.BaseLizAIPages;
import io.cucumber.java.en.But;
import org.openqa.selenium.By;

public class Calendar extends BaseLizAIPages {
    public static final By by = new By.ByXPath("");
    public static final String name = "Calendar module";

    //locators
    private final String xpath_buttonCalendar = "//button[@aria-label='Open calendar']";
    private final String xpath_labelSelectYear = "//mat-calendar//button/span[@class='mdc-button__label']/span";
    private final String xpath_listYear = "//mat-multi-year-view//button";
    private final String xpath_buttonPrevious = "//button[@aria-label='Previous 24 years']";
    private final String xpath_buttonNext = "//button[@aria-label='Next 24 years";
    private final String xpath_listMonth ="//mat-year-view//button";
    private final String xpath_listDay = "//mat-month-view/table/tbody//button";
    private final String xpath_buttonDayofBirth ="//mat-form-field//ng-datepicker/div";
    //elements
    private final Button button_Calendar = new Button(By.xpath(xpath_buttonCalendar),"btn_Calendar");
    private final Label label_SelectedYear = new Label(By.xpath(xpath_labelSelectYear),"lb_Year");
    private final ListOfElements listYear = new ListOfElements(By.xpath(xpath_listYear),"loe_Listyear");
    private final Button button_Previous = new Button(By.xpath(xpath_buttonPrevious),"btn_Previous");
    private final  Button button_Next = new Button(By.xpath(xpath_buttonNext),"btn_Next");
    private final ListOfElements listMonth = new ListOfElements(By.xpath(xpath_listMonth),"loe_ListMonth");
    private final ListOfElements listDay = new ListOfElements(By.xpath(xpath_listDay),"loe_ListDay");
    private final Button buttonDayofBirth = new Button(By.xpath(xpath_buttonDayofBirth),"btn_DayofBirth");
    //contructor
    public Calendar(boolean assertOpen) {super(by,name,assertOpen);}

    public void click_Calendar(){
        button_Calendar.waitForClickable();
        button_Calendar.click();
        waitForJSToComplete();
    }

    public void selectDate(String Date){
        String[] parts = Date.split("/");

        String year = parts[2];
        String month = parts[1];
        String day = parts[0];

        button_Calendar.waitForClickable();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        button_Calendar.click();
        waitForJSToComplete();
        label_SelectedYear.click();
        selectYear(year);
        selectMonth(month);
        selectDay(day);
        buttonDayofBirth.getText().equalsIgnoreCase(Date);
        waitForJSToComplete();
    }

    public void selectYear(String year){
        String yearPrecentText;
        do {
            yearPrecentText = label_SelectedYear.getText();
            int firstYearList = Integer.parseInt(listYear.getListOfElement().get(0).getText());
            int lastYearList = Integer.parseInt(listYear.getListOfElement().get((listYear.getNumberOfElement())-1).getText());
            if (Integer.parseInt(year) < firstYearList){
                button_Previous.waitForClickable();
                button_Previous.click();
            } else if (Integer.parseInt(year) > lastYearList) {
                button_Next.waitForClickable();
                button_Next.click();
            } else {
                for (int i = 0; i < listYear.getNumberOfElement(); i++) {
                    if (listYear.getListOfElement().get(i).getText().equalsIgnoreCase(year)){
                        listYear.getListOfElement().get(i).click();
                        waitForJSToComplete();
                        yearPrecentText = label_SelectedYear.getText();
                        break;
                    }
                }
            }
        } while (!(String.valueOf(Integer.parseInt(year)).equalsIgnoreCase(yearPrecentText)));
    }

    private void selectMonth(String month){
        int labelMonthNumber = Integer.parseInt(String.valueOf(month));
        switch (month){
            case "01":
                listMonth.getListOfElement().get(0).click(); break;
            case "02":
                listMonth.getListOfElement().get(1).click(); break;
            case "03":
                listMonth.getListOfElement().get(2).click(); break;
            case "04":
                listMonth.getListOfElement().get(3).click(); break;
            case "05":
                listMonth.getListOfElement().get(4).click(); break;
            case "06":
                listMonth.getListOfElement().get(5).click(); break;
            case "07":
                listMonth.getListOfElement().get(6).click(); break;
            case "08":
                listMonth.getListOfElement().get(7).click(); break;
            case "09":
                listMonth.getListOfElement().get(8).click(); break;
            case "10":
                listMonth.getListOfElement().get(9).click(); break;
            case "11":
                listMonth.getListOfElement().get(10).click(); break;
            case "12":
                listMonth.getListOfElement().get(11).click(); break;
        }

        for (int i = 0; i < listMonth.getListOfElement().size(); i++) {
            if (listMonth.getListOfElement().get(i).getText().equalsIgnoreCase(String.valueOf((labelMonthNumber)))) {
                listMonth.getListOfElement().get(i).click();
                break;
            }
        }
    }

    private void selectDay(String day) {
        int labelDayNumber = Integer.parseInt(String.valueOf(day));
        for (int i = 0; i < listDay.getListOfElement().size(); i++) {
            if (listDay.getListOfElement().get(i).getText().equalsIgnoreCase(String.valueOf(labelDayNumber))) {
                listDay.getListOfElement().get(i).click();
                break;
            }
        }
    }
}
