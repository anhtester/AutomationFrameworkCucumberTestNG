package com.anhtester.projects.website.crm.pages.SignIn;

import com.anhtester.common.CommonPageCRM;
import com.anhtester.constants.FrameworkConstants;
import com.anhtester.helpers.ExcelHelpers;
import com.anhtester.projects.website.crm.models.SignInModel;
import com.anhtester.projects.website.crm.pages.Dashboard.DashboardPageCRM;
import com.anhtester.utils.DecodeUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Hashtable;

import static com.anhtester.keywords.WebUI.*;

public class SignInPageCRM extends CommonPageCRM {

    private String pageUrl = "/signin";
    private String pageTitle = "Sign in | RISE CRM | Anh Tester Demo";

    public By inputEmail = By.xpath("//input[@id='email']");
    public By inputPassword = By.xpath("//input[@id='password']");
    public By buttonSignIn = By.xpath("//button[normalize-space()='Sign in']");
    public By alertErrorMessage = By.xpath("//div[@role='alert']");
    public By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot password?']");
    public By linkSignUp = By.xpath("//a[normalize-space()='Sign up']");
    public By labelEmailError = By.xpath("//span[@id='email-error']");
    public By labelPasswordError = By.xpath("//span[@id='password-error']");


    ExcelHelpers excelHelpers;

    public SignInPageCRM() {
        super();
        excelHelpers = new ExcelHelpers();
    }

    public DashboardPageCRM signInWithAdminRole() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "SignIn");
        openWebsite(FrameworkConstants.URL_CRM);
        verifyContains(getCurrentUrl(), pageUrl, "The url of sign in page not match.");
        verifyEquals(getPageTitle(), pageTitle, "The title of sign in page not match.");
        clearAndFillText(inputEmail, excelHelpers.getCellData(1, SignInModel.getEmail()));
        clearAndFillText(inputPassword, DecodeUtils.decrypt(excelHelpers.getCellData(1, SignInModel.getPassword())));
        clickElement(buttonSignIn);
        waitForPageLoaded();
        verifyContains(getCurrentUrl(), getDashboardPage().pageUrl, "Sign in failed. Can not redirect to Dashboard page.");

        return new DashboardPageCRM();
    }

    public DashboardPageCRM signInWithClientRole() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "SignIn");
        openWebsite(FrameworkConstants.URL_CRM);
        verifyContains(getCurrentUrl(), pageUrl, "The url of sign in page not match.");
        verifyEquals(getPageTitle(), pageTitle, "The title of sign in page not match.");
        clearAndFillText(inputEmail, excelHelpers.getCellData(2, SignInModel.getEmail()));
        clearAndFillText(inputPassword, DecodeUtils.decrypt(excelHelpers.getCellData(2, SignInModel.getPassword())));
        clickElement(buttonSignIn);
        waitForPageLoaded();
        verifyContains(getCurrentUrl(), getDashboardPage().pageUrl, "Sign in failed. Can not redirect to Dashboard page.");

        return new DashboardPageCRM();
    }

    public DashboardPageCRM signIn(String email, String password) {
        openWebsite(FrameworkConstants.URL_CRM);
        verifyContains(getCurrentUrl(), pageUrl, "The url of sign in page not match.");
        verifyEquals(getPageTitle(), pageTitle, "The title of sign in page not match.");
        clearAndFillText(inputEmail, email);
        clearAndFillText(inputPassword, password);
        clickElement(buttonSignIn);
        waitForPageLoaded();

        return new DashboardPageCRM();
    }

    public DashboardPageCRM signIn(Hashtable<String, String> data) {
        openWebsite(FrameworkConstants.URL_CRM);
        verifyContains(getCurrentUrl(), pageUrl, "The url of sign in page not match.");
        verifyEquals(getPageTitle(), pageTitle, "The title of sign in page not match.");
        clearAndFillText(inputEmail, data.get(SignInModel.getEmail()));
        clearAndFillText(inputPassword, DecodeUtils.decrypt(data.get(SignInModel.getPassword())));
        clickElement(buttonSignIn);
        waitForPageLoaded();
        verifyContains(getCurrentUrl(), getDashboardPage().pageUrl, "Sign in failed. Can not redirect to Dashboard page.");

        return new DashboardPageCRM();
    }

    public void verifySignInSuccess(){
        waitForPageLoaded();
        Assert.assertTrue(checkElementExist(getDashboardPage().menuDashboard), "The Dashboard page not display.");
    }

    public void verifySignInFail(){
        waitForPageLoaded();
        Assert.assertTrue(checkElementExist(alertErrorMessage), "The Dashboard page not display.");
        Assert.assertEquals(getTextElement(alertErrorMessage), "Authentication failed!", "The error message content not match.");
    }

}