package LizAI.Pages;

import Core.BasePage;
import Core.Selenium.Label;
import Core.Support.Selenium.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.*;

public class BaseLizAIPages extends BasePage {
    //locator
    private final String xpath_circleLoading = "//div[@class='loading-container']";
    private final String xpath_thundraTraceSnackBarError = "//snack-bar-container[contains(.,'Error')]";
    private final String xpath_toolTip = "//div[@class='tooltip BR']";
    private static final String xpath_ToastContainer = "//mat-snack-bar-container//simple-snack-bar/div[@matsnackbarlabel]";

    //elements
    private final Label loading = new Label(xpath(xpath_circleLoading), "Loading");
    private final Label labelThundraSnackBarError = new Label(xpath(xpath_thundraTraceSnackBarError), "Thundra Error");
    private final Label labelToolTip = new Label(xpath(xpath_toolTip), "ToolTip");
    private static final Label labelToastContainer = new Label(xpath(xpath_ToastContainer),"labelToastContainer");

    //constructor
    public BaseLizAIPages(By pageLocator, String pageName, boolean assertPageOpen) {super(pageLocator, pageName, assertPageOpen);}

    public void waitForLoadingComplete() {
        if (loading.isElementDisplay()) {
            try {
                loading.waitForElementToBeDisappear();
            } catch (TimeoutException e) {
                Waiter.wait(1);
            }
        }
    }

    public boolean isLoadingDisplays(){
        return loading.isElementDisplay();
    }

    public boolean isThundraErrorDisplay() {
        return labelThundraSnackBarError.isElementDisplay();
    }

    public void closeToolTip() {
        waitForLoadingComplete();
        waitForJSToComplete();
        int counter = 0;
        int attempts = 3;
        while (counter < attempts) {
            if (labelToolTip.isElementDisplay()) {
                labelToolTip.click();
                labelToolTip.waitForElementToBeDisappear();
                counter++;
            } else {
                break;
            }
        }
    }

    public static String getToastMessage() {
        labelToastContainer.getText();
        return labelToastContainer.getText();
    }

    public void startUpload() {
        System.out.println("Starting upload...");
        // Simulating upload time
        try {
            Thread.sleep(3000); // Simulate a 3-second upload
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Upload interrupted.");
        }
        System.out.println("Upload complete.");
    }

        // Method to wait for an element to refresh
    public void waitForElementReload(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))));
            System.out.println("Element has been reloaded.");
        }

    public void waitForLastItemUpload() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for the last item to be uploaded
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@class, 'visibility')][last()]")));

        System.out.println("Last item has finished uploading.");
    }



    public void waitForElementAppear(By locator) {
        for (int i = 0; i < 5; i++) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // Wait for the element to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
    }
}

