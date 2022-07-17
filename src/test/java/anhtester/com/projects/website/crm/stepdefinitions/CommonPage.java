package anhtester.com.projects.website.crm.stepdefinitions;

import anhtester.com.projects.website.crm.pages.Clients.ClientPage;
import anhtester.com.projects.website.crm.pages.Dashboard.DashboardPage;
import anhtester.com.projects.website.crm.pages.Projects.ProjectPage;
import anhtester.com.projects.website.crm.pages.SignIn.SignInPage;

public class CommonPage {

    public SignInPage signInPage;
    public DashboardPage dashboardPage;
    public ClientPage clientPage;
    public ProjectPage projectPage;

    public CommonPage() {

    }

    public SignInPage getSignInPage() {
        if(signInPage == null){
            signInPage = new SignInPage();
        }
        return signInPage;
    }

    public DashboardPage getDashboardPage() {
        if(dashboardPage == null){
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public ClientPage getClientPage() {
        if(clientPage == null){
            clientPage = new ClientPage();
        }
        return clientPage;
    }

    public ProjectPage getProjectPage() {
        if(projectPage == null){
            projectPage = new ProjectPage();
        }
        return projectPage;
    }

}
