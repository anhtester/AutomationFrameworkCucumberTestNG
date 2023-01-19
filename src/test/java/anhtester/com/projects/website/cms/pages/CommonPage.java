package anhtester.com.projects.website.cms.pages;

import anhtester.com.keywords.WebUI;
import org.openqa.selenium.By;

public class CommonPage {

    private By menuProducts = By.xpath("//span[normalize-space()='Products']");

    public void verifyDashboardPageDisplays(){
        WebUI.waitForPageLoaded();
        WebUI.verifyElementPresent(menuProducts, 10, "Login failed. The Dashboard page not displays.");
    }

}
