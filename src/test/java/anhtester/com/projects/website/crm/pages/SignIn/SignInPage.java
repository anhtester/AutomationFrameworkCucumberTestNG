package anhtester.com.projects.website.crm.pages.SignIn;

import anhtester.com.constants.FrameworkConstants;
import anhtester.com.helpers.ExcelHelpers;
import anhtester.com.projects.website.crm.models.SignInModel;
import anhtester.com.projects.website.crm.pages.Dashboard.DashboardPage;
import anhtester.com.utils.DecodeUtils;
import anhtester.com.utils.ObjectUtils;
import anhtester.com.utils.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Hashtable;

public class SignInPage {

    public String pageUrl = "/signin";
    public String pageText = "";
    public String pageTitle = "Sign in | CRM Project Manager | Anh Tester Demo";
    public String dashboardPageURL = "/dashboard";

    public By inputEmail = By.xpath("//input[@id='email']");
    public By inputPassword = By.xpath("//input[@id='password']");
    public By buttonSignIn = By.xpath("//button[normalize-space()='Sign in']");
    public By labelEmailError = By.id("email-error");
    public By labelAuthentication = By.xpath("//div[@role='alert']");

    ExcelHelpers excelHelpers;

    public SignInPage() {
        excelHelpers = new ExcelHelpers();
    }

    public DashboardPage signIn(String email, String password) {
        WebUI.getToUrl(FrameworkConstants.URL_CRM);
        Assert.assertTrue(WebUI.verifyPageUrl(pageUrl), "The url of Sign in page not match.");
        Assert.assertTrue(WebUI.verifyPageTitle(pageTitle), "Tiêu đề trang sign in chưa đúng");
        WebUI.sleep(1);
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonSignIn);
        WebUI.waitForPageLoaded();

        return new DashboardPage();
    }

    public DashboardPage signIn(Hashtable<String, String> data) {
        WebUI.getToUrl(FrameworkConstants.URL_CRM);
        Assert.assertTrue(WebUI.verifyPageUrl(pageUrl), "The url of sign in page not match.");
        Assert.assertTrue(WebUI.verifyPageTitle(pageTitle), "The title of sign in page not match.");
        WebUI.setText(inputEmail, data.get(SignInModel.getEmail()));
        WebUI.setText(inputPassword, DecodeUtils.decrypt(data.get(SignInModel.getPassword())));
        WebUI.clickElement(buttonSignIn);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyPageUrl(dashboardPageURL), "Sign in failed. Can not redirect to Dashboard page.");
        WebUI.waitForPageLoaded();

        return new DashboardPage();
    }
    
    public DashboardPage signInWithAdminRole() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "SignIn");
        WebUI.getToUrl(FrameworkConstants.URL_CRM);
        Assert.assertTrue(WebUI.verifyPageUrl(pageUrl), "The url of sign in page not match.");
        Assert.assertTrue(WebUI.verifyPageTitle(pageTitle), "The title of sign in page not match.");
        WebUI.setText(inputEmail, excelHelpers.getCellData(1, SignInModel.getEmail()));
        WebUI.setText(inputPassword, DecodeUtils.decrypt(excelHelpers.getCellData(1, SignInModel.getPassword())));
        WebUI.clickElement(buttonSignIn);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyPageUrl(dashboardPageURL), "Sign in failed. Can not redirect to Dashboard page.");
        WebUI.waitForPageLoaded();

        return new DashboardPage();
    }

    public DashboardPage signInWithTeamLeaderRole() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "SignIn");
        WebUI.getToUrl(FrameworkConstants.URL_CRM);
        Assert.assertTrue(WebUI.verifyPageUrl(pageUrl), "The url of sign in page not match.");
        Assert.assertTrue(WebUI.verifyPageTitle(pageTitle), "The title of sign in page not match.");
        WebUI.setText(inputEmail, excelHelpers.getCellData(2, SignInModel.getEmail()));
        WebUI.setText(inputPassword, DecodeUtils.decrypt(excelHelpers.getCellData(2, SignInModel.getPassword())));
        WebUI.clickElement(buttonSignIn);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyPageUrl(dashboardPageURL), "Sign in failed. Can not redirect to Dashboard page.");
        WebUI.waitForPageLoaded();

        return new DashboardPage();
    }

    public DashboardPage signInWithTeamMemberRole() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "SignIn");
        WebUI.getToUrl(FrameworkConstants.URL_CRM);
        Assert.assertTrue(WebUI.verifyPageUrl(pageUrl), "The url of sign in page not match.");
        Assert.assertTrue(WebUI.verifyPageTitle(pageTitle), "The title of sign in page not match.");
        WebUI.setText(inputEmail, excelHelpers.getCellData(3, SignInModel.getEmail()));
        WebUI.setText(inputPassword, DecodeUtils.decrypt(excelHelpers.getCellData(3, SignInModel.getPassword())));
        WebUI.clickElement(buttonSignIn);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyPageUrl(dashboardPageURL), "Sign in failed. Can not redirect to Dashboard page.");
        WebUI.waitForPageLoaded();

        return new DashboardPage();
    }

}
