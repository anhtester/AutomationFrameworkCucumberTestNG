package com.anhtester.projects.website.crm.pages.Dashboard;

import com.anhtester.common.CommonPageCRM;
import com.anhtester.keywords.WebUI;
import com.anhtester.projects.website.crm.pages.Clients.ClientPageCRM;
import com.anhtester.projects.website.crm.pages.Projects.ProjectPageCRM;
import com.anhtester.projects.website.crm.pages.Tasks.TaskPage;
import org.openqa.selenium.By;

public class DashboardPageCRM extends CommonPageCRM {

    public DashboardPageCRM() {
    }

    public String pageText = "Dashboard";
    public String pageUrl = "/dashboard";

    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuClients = By.xpath("//span[normalize-space()='Clients']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    public By menuTasks = By.xpath("//span[normalize-space()='Tasks']");

    public DashboardPageCRM openDashboardPage() {
        WebUI.clickElement(menuDashboard);
        return this;
    }

    public ClientPageCRM openClientPage() {
        WebUI.clickElement(menuClients);
        return new ClientPageCRM();
    }

    public ProjectPageCRM openProjectPage() {
        WebUI.clickElement(menuProjects);
        return new ProjectPageCRM();
    }

    public TaskPage openTaskPage() {
        WebUI.clickElement(menuTasks);
        return new TaskPage();
    }
}
