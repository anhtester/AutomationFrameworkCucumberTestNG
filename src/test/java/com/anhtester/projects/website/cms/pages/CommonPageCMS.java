package com.anhtester.projects.website.cms.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;

public class CommonPageCMS {

    private By menuProducts = By.xpath("//span[normalize-space()='Products']");

    public void verifyDashboardPageDisplays() {
        WebUI.waitForPageLoaded();
        WebUI.verifyElementPresent(menuProducts, 5, "Login failed. The Dashboard page not displays.");
    }

}
