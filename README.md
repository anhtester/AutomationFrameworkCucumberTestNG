![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Java CI with Maven](https://github.com/anhtester/AutomationFrameworkCucumberTestNG/actions/workflows/maven.yml/badge.svg)](https://github.com/anhtester/AutomationFrameworkCucumberTestNG/actions/workflows/maven.yml)

## Automation Framework Cucumber TestNG and Selenium Java building by Anh Tester

**SOME FEATURES IN FRAMEWORK**

1. Run the parallel Scenario on feature file
2. Cucumber Report
3. Extent Report
4. Allure Report
5. Send Mail after the run test (Report information and HTML file attachment)
6. Write Log to file
7. Record video and Screenshot test case
8. Read data test from Excel file (xlsx, csv, json,...)
9. Base function in the package: utils, helpers
10. Read data test from Json file
11. Main keyword is WebUI
12. Sample test feature

### **SYSTEM REQUIREMENTS**

- **JDK All version**
- Chrome Browser, Edge Browser
- Setup **Allure**:
  https://mvnrepository.com/artifact/io.qameta.allure/allure-java-commons
  or
  https://anhtester.com/blog/selenium-java/selenium-java-tai-nguyen-cai-dat-moi-truong)
  Download jar and setting Variable Environment as Java JDK

  ![image](https://user-images.githubusercontent.com/87883620/161661705-b8706957-5a26-4faf-8ddf-2f9aef78418e.png)

- **IntelliJ** is the best choice (to change JDK version)

![image](https://user-images.githubusercontent.com/87883620/161707184-7ad558f2-0d7d-4851-bfd6-2796d4e46593.png)

### **HOW TO USE**

**1. Run parallel the test case**

- Run Cucumber TestRunner from **src/test/java/anhtester/com/runners**
- Run Feature file (**src/test/resources/features/**)
- Run Feature in suite XML (**src/test/resources/suites/**)
- Run Feature from Maven pom.xml file
  (**mvn clean test**)

  ![image](https://user-images.githubusercontent.com/87883620/161658761-5040e527-b410-46b3-8697-3298523e201d.png)

**2. Cucumber Report**

![image](https://user-images.githubusercontent.com/87883620/194338092-1046970c-2ca4-40da-b0e8-b03f71656c09.png)


**3. Extent Report**

- Config from src/test/resources/extent.properties
- Config PDF from src/test/resources/pdf-config.yaml

![image](https://user-images.githubusercontent.com/87883620/194404333-306a6d53-514a-4229-ba47-f3c42e7cce1f.png)
![image](https://user-images.githubusercontent.com/87883620/194404351-706fb702-6efd-4783-bc1e-2b20c56c902a.png)

![image](https://user-images.githubusercontent.com/87883620/194403666-ad996860-6f53-426d-b606-609cd9689ede.png)
![image](https://user-images.githubusercontent.com/87883620/194403696-2ac21bc5-4855-49fa-8a39-c032f6f59d46.png)
![image](https://user-images.githubusercontent.com/87883620/194403721-96198d1b-b8fe-4058-9b16-403d0437f8ab.png)
![image](https://user-images.githubusercontent.com/87883620/194403743-55aa0e59-39c3-470e-92bf-14275ab2e502.png)


**4. Allure Report**

- Open Terminal: **_allure serve target/allure-results_**

![image](https://user-images.githubusercontent.com/87883620/161662507-9e4dc698-e452-4b43-a4f5-9808c81419a2.png)

- Insert **@Step("title/message")** above **_@Test_** or any **_Method_** in the project
- (As sample picture above step 3)

![image](https://user-images.githubusercontent.com/87883620/161657680-af29973d-4e52-451f-b1d6-40b12d182845.png)

![image](https://user-images.githubusercontent.com/87883620/161657689-10365747-ed8f-4ca8-9d84-8060514f216b.png)

**5. Send Mail after the run test**

- Config **true/false** in config.properties
  (**_src/test/resources/config/config.properties_**)
- send_email_to_users=**true** is enable send mail
- Config mail with email and password in **_src/main/java/anhtester/com/mail/EmailConfig.java_**
- Note: if Gmail, you use Password App

![image](https://user-images.githubusercontent.com/87883620/161658851-2aa41091-ac99-45d9-a79f-aaa828052efb.png)

![image](https://user-images.githubusercontent.com/87883620/194458308-18000685-6785-415f-9e0c-020ae6ed0ebf.png)


**6. Write Log to file**

- Call class: Log.info , Log.pass, Log.error,... (**Log** is a custom global class from Log4j2)
  (**_import anhtester.com.utils.Log.java_**)

![image](https://user-images.githubusercontent.com/87883620/161657858-d333ac1d-9e7b-4c1b-baac-151a237a1fa0.png)

**7. Record video and Screenshot**

- Setup in **_config.properties_** file
  (**_src/test/resources/config/config.properties_**)
- screenshot_passed_steps=yes or no
- screenshot_failed_steps=yes or no
- screenshot_skipped_steps=yes or no
- screenshot_all_steps=yes or no

  ![image](https://user-images.githubusercontent.com/87883620/161657881-5235139a-9982-43c0-ac37-09f22fff1206.png)

**8. Read data test from Excel file**

- Create function with annotaion **DataSupplier** on **_src/main/java/anhtester/com/utils/DataProviderUtils.java_**
- Call the name of **DataSupplier** above in the test cases as DataProvider of TestNG
- Read excel with Map and Hashtable

**9. Base function in the package**

- **_src/main/java/anhtester/com/utils_**
- **_src/main/java/anhtester/com/helpers_**

**10. Read data test from JSON file**

- **JsonUtils** class select the json file path and call **"get"** method with **key**

**11. Main keyword is WebUI**

- WebUI class is main keyword in Framework. It contains common functions
- How to use: WebUI.function_name
- Example: WebUI.setWindowSize(1024, 768), WebUI.screenshotElement(By by, String elementName),...

**12. Call test case sample**

- Run test case TestNG: src/test/java/anhtester/com/projects/website/crm/testcases
- Run test case Gherkin: src/test/resources/suites/RunSuiteFeature.xml
- Or run with maven in **pom.xml** file:  ***mvn clean test***

```
+ src/test/resources/suites/RunSuiteFeature.xml
+ ClientTest
+ SignInTest
+ TestHandle
+ TestSimpleCode
```

### Project structure

```
📦AutomationFrameworkCucumberTestNG
 ┣ 📂src
 ┃ ┣ 📂main
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┗ 📂anhtester
 ┃ ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┃ ┣ 📂annotations
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜FrameworkAnnotation.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ConfigFactory.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Configuration.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂constants
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜FrameworkConstants.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂driver
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BrowserFactory.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DriverManager.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TargetFactory.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂enums
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthorType.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Browser.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CategoryType.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FailureHandling.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Platform.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Project.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Target.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂exceptions
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FrameworkException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜HeadlessNotSupportedException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜InvalidPathForExcelException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜InvalidPathForExtentReportFileException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜InvalidPathForFilesException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜InvalidRemoteWebDriverURLException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TargetNotValidException.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂helpers
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CaptureHelpers.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DatabaseHelpers.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ExcelHelpers.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Helpers.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PropertiesHelpers.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ScreenRecoderHelpers.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TxtFileHelpers.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂keyword
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WebUI.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂mail
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailAttachmentsSender.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜EmailConfig.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂report
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AllureManager.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ExtentReportManager.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ExtentTestManager.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TelegramManager.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂utils
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BrowserInfoUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DataGenerateUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DateUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DecodeUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailSendUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜IconUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JsonUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LanguageUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LocalStorageUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Log.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ObjectUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReportUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ZipUtils.java
 ┃ ┃ ┗ 📂resources
 ┃ ┃ ┃ ┗ 📜log4j2.properties
 ┃ ┗ 📂test
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┗ 📂anhtester
 ┃ ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┃ ┣ 📂common
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BaseTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommonPage.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CommonSteps.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂dataprovider
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DataProviderManager.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂listeners
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TestListener.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂projects
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂website
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂crm
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂models
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ClientModel.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SignInModel.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂pages
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Clients
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ClientPage.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Dashboard
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DashboardPage.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Projects
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProjectPage.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂SignIn
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SignInPage.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂Tasks
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TaskPage.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂stepdefinitions
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DashboardSteps.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Hooks.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginSteps.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TestContext.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂testcases
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ClientTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SignInTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TestHandle.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TestSimpleCode.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂runners
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TestRunnerAllFeatureByTag.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TestRunnerForDashboardHRM.java
 ┃ ┃ ┗ 📂resources
 ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┣ 📜config.json
 ┃ ┃ ┃ ┃ ┣ 📜config.properties
 ┃ ┃ ┃ ┃ ┗ 📜datatest.properties
 ┃ ┃ ┃ ┣ 📂features
 ┃ ┃ ┃ ┃ ┣ 📜Dashboard.feature
 ┃ ┃ ┃ ┃ ┗ 📜SignIn.feature
 ┃ ┃ ┃ ┣ 📂objects
 ┃ ┃ ┃ ┃ ┗ 📜crm_locators.properties
 ┃ ┃ ┃ ┣ 📂suites
 ┃ ┃ ┃ ┃ ┣ 📜Clients-parallel.xml
 ┃ ┃ ┃ ┃ ┣ 📜Clients-simple.xml
 ┃ ┃ ┃ ┃ ┣ 📜Clients-testAddClient.xml
 ┃ ┃ ┃ ┃ ┣ 📜Clients-testSearch.xml
 ┃ ┃ ┃ ┃ ┣ 📜RunSuiteFeature.xml
 ┃ ┃ ┃ ┃ ┣ 📜SignIn-parallel-methods.xml
 ┃ ┃ ┃ ┃ ┣ 📜SignIn-simple.xml
 ┃ ┃ ┃ ┃ ┗ 📜SuiteAll.xml
 ┃ ┃ ┃ ┣ 📂testdata
 ┃ ┃ ┃ ┃ ┣ 📜ClientsDataExcel.xlsx
 ┃ ┃ ┃ ┃ ┣ 📜DOCX_File_01.docx
 ┃ ┃ ┃ ┃ ┣ 📜LoginCSV.csv
 ┃ ┃ ┃ ┃ ┗ 📜TxtFileData.txt
 ┃ ┃ ┃ ┣ 📜cucumber.properties
 ┃ ┃ ┃ ┣ 📜extent.properties
 ┃ ┃ ┃ ┗ 📜pdf-config.yaml
 ┣ 📜pom.xml
 ┗ 📜README.md
```

### I shall write document for my Framework. Coming soon...

## Copyright 2022 Anh Tester

> Anh Tester Blog: https://anhtester.com/

![Alt text](https://anhtester.com/uploads/logo/anhtester_logo_512.png?raw=true "Anh Tester - Automation Testing")
