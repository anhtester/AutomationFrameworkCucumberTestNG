package anhtester.com.projects.website.cms.pages;

import anhtester.com.keyword.WebUI;
import org.openqa.selenium.By;

public class CommonPage {

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");

    public void verifyDashboardPageDisplays(){
        WebUI.waitForPageLoaded();
        WebUI.verifyElementPresent(menuDashboard, 10, "Login failed. The Dashboard page not displays.");
    }

}
