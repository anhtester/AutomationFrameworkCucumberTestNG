package com.anhtester.projects.website.cms.pages;

import org.openqa.selenium.By;

import static com.anhtester.keywords.WebUI.*;

public class CommonPageCMS {

    private By menuProducts = By.xpath("//span[normalize-space()='Products']");

    public void verifyDashboardPageDisplays() {
        waitForPageLoaded();
        verifyContains(getCurrentUrl(), "/anhtester", "The URL not match.");
        verifyElementPresent(menuProducts, 5, "Login failed. The Dashboard page not displays.");
    }

}
