package com.automationframeworks.selenium_testng_java.utilities;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Listeners(com.automationframeworks.selenium_testng_java.utilities.Listener.class)
public class Base {
	public PropertiesReader propertiesReader = new PropertiesReader();
	public String baseURL = propertiesReader.getProperty("baseUrl");
	//Refer to these content and replace this with your own properties. Follow same design and structure
	
	public String marcomBiosHomePageEndpoint = propertiesReader.getProperty("marcomBiosBiographyHomePageEndpoint");

	public String productCatalogHomePageEndPoint = propertiesReader.getProperty("productCatalogHomePageEndPoint");
	public String productCatalogsanityTestEndPoint = propertiesReader.getProperty("sanityTestEndPoint");
	public String productCatalogProductDetailsListEndPoint=propertiesReader.getProperty("productDetailsListEndPoint");
	public String productCatalogProductRegulatoryEndPoint=propertiesReader.getProperty("productRegulatoryEndPoint");
	public String productCatalogProductDocumentsEndPoint=propertiesReader.getProperty("productDocumentsEndPoint");
	//-----------------------Product Catalog properties---------------------------------------------
	//Reading data from test data file
	public String productLandscapeFilePath = propertiesReader.getProperty("productLandscapeFilePath");
	public String namingYourProductFilePath = propertiesReader.getProperty("namingYourProductFilePath");
	public String productNamingApprovalFilePath = propertiesReader.getProperty("productNamingApprovalFilePath");
	public String architectureConsultationFilePath = propertiesReader.getProperty("architectureConsultationFilePath");
	public String consultGDPTFilePath = propertiesReader.getProperty("consultGDPTFilePath");
	public String prenotification = propertiesReader.getProperty("preNotification");
	public String notification = propertiesReader.getProperty("notification");
	public String notificationApproval = propertiesReader.getProperty("notificationApproval");

	//Reading Notifications test data
	public String ProductSitePath = propertiesReader.getProperty("productSitePath");
	public String ProductDesignPath = propertiesReader.getProperty("productDesignPath");
	public String ProductDescription = propertiesReader.getProperty("productDescription");
	public String ProductScope = propertiesReader.getProperty("productScope");
	public String ProblemSolve = propertiesReader.getProperty("problemSolve");
	public String Benefits = propertiesReader.getProperty("benefits");
	public String Differentiators = propertiesReader.getProperty("differentiators");
	public String KeyFeatures = propertiesReader.getProperty("keyFeatures");
	public String TargetMarket = propertiesReader.getProperty("targetMarket");
	public String Geography = propertiesReader.getProperty("geography");
	public String Audience = propertiesReader.getProperty("audience");
	public String businessPlan = propertiesReader.getProperty("businessPlan");

	//Reading Business Planning test data
	public String productfinancialfile = propertiesReader.getProperty("productFinancialfile");
	public String financialreviewfile = propertiesReader.getProperty("productFinancialreview");
	public String businessplanfile = propertiesReader.getProperty("businessPlanFile");
	public String underPAGReview = propertiesReader.getProperty("underPAGReview");
	public String PAGApproved = propertiesReader.getProperty("PAGApproved");
	public String productPublished = propertiesReader.getProperty("productPublished");

	//Reading Prototype test data
	public String dynamicsfile = propertiesReader.getProperty("dynamicsFile");
	public String dynamics365engagementreviewfile = propertiesReader.getProperty("dynamics365EngagementReviewFile");
	public String marketingproductsummaryfile = propertiesReader.getProperty("marketingProductSummaryFile");
	public String keywordresearchreportfile = propertiesReader.getProperty("keywordResearchReportFile");
	public String reviewlegaldocumentsfile = propertiesReader.getProperty("reviewLegalDocumentsFile");
	public String gcslegalreview = propertiesReader.getProperty("gcsLegalReviewFile");
	public String securitythreatmodelfile = propertiesReader.getProperty("securityThreatModelFile");
	public String productuxreviewfile = propertiesReader.getProperty("productUXReviewFile");
	public String registration = propertiesReader.getProperty("registration");

	//Reading Registration test data
	public String subjectMatterPeerReviewFile = propertiesReader.getProperty("subjectMatterPeerReviewFile");
	public String productTechnicalReviewFile = propertiesReader.getProperty("productTechnicalReviewFile");
	public String penetrationTestingFile = propertiesReader.getProperty("penetrationTestingFile");
	public String licensingAgreementFile = propertiesReader.getProperty("licensingAgreementFile");
	public String reviewApprovalGDPRFile = propertiesReader.getProperty("reviewApprovalGDPRFile");

	//Reading Validation Messages
	public String prenotificationSubmissionPass = propertiesReader.getProperty("prenotificationSubmissionPass");
	public String prenotificationSubmissionFail = propertiesReader.getProperty("prenotificationSubmissionFail");
	public String notificationSubmissionPass = propertiesReader.getProperty("notificationSubmissionPass");
	public String notificationSubmissionFail = propertiesReader.getProperty("notificationSubmissionFail");
	public String notificationApprovalPass = propertiesReader.getProperty("notificationApprovalPass");
	public String notificationApprovalFail = propertiesReader.getProperty("notificationApprovalFail");
	public String businessPlanningSubmissionPass = propertiesReader.getProperty("businessPlanningSubmissionPass");
	public String businessPlanningSubmissionFail = propertiesReader.getProperty("businessPlanningSubmissionFail");
	public String businessPlanningApprovalPass = propertiesReader.getProperty("businessPlanningApprovalPass");
	public String businessPlanningApprovalFail = propertiesReader.getProperty("businessPlanningApprovalFail");
	public String prototypeSubmissionPass = propertiesReader.getProperty("prototypeSubmissionPass");
	public String prototypeSubmissionFail = propertiesReader.getProperty("prototypeSubmissionFail");
	public String registrationSubmissionPass = propertiesReader.getProperty("registrationSubmissionPass");
	public String registrationSubmissionFail = propertiesReader.getProperty("registrationSubmissionFail");
	public String registrationApprovalPass = propertiesReader.getProperty("registrationApprovalPass");
	public String registrationApprovalFail = propertiesReader.getProperty("registrationApprovalFail");
	public String scApprovalPass = propertiesReader.getProperty("scApprovalPass");
	public String scApprovalFail = propertiesReader.getProperty("scApprovalFail");
	
	// Reading Sanity Test Data
	public String webPartID=propertiesReader.getProperty("webPartID");
	public String technicalDetails=propertiesReader.getProperty("technicalDetails");
	public String value1 = propertiesReader.getProperty("value1");
	public String value2 = propertiesReader.getProperty("value2");
	public String value3 = propertiesReader.getProperty("value3");
	public String value4 = propertiesReader.getProperty("value4");
	public String somethingWentWrong = propertiesReader.getProperty("somethingWentWrong");
	public String correlationId = propertiesReader.getProperty("correlationId");
	public String errorMakingHttpClientrequest = propertiesReader.getProperty("errorMakingHttpClientrequest");

//------------------------------------------------------------------------------------------------------

	public WebDriver driver;
	public String applicationEndpoint;
	public static final Logger logger = LogManager.getLogger(Base.class);
	public CommonMethods commonMethods;
	public OffsetDateTime executionStartDateTime;

	@BeforeClass(alwaysRun = true)
	@Parameters({"browserName"})
	public void setup(@Optional("chrome")String browserName){
		this.executionStartDateTime = OffsetDateTime.now().withOffsetSameInstant(ZoneOffset.UTC);
		logger.info("Test Class Execution Start time UTC: " + executionStartDateTime);

		if (System.getProperty("browser") != null){
			browserName = System.getProperty("browser");
			logger.info("System property browser found: " + browserName);
		}
		this.driver = WebDriverProvider.getDriver(browserName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		webDriverThreadLocal.set(driver);
	}

	public static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
	@AfterClass(alwaysRun = true)
	public void tearDown()
	{
		if (this.driver != null) {
			driver.quit();
		}
	}

	public void logInfo(String actionDescription){
		try {
			Listener.extentTest.get().info(actionDescription);
		}catch (NullPointerException nullPointerException){
			logger.info("Extent Test not initialized. Creating test...");
			Listener.extentTest.set(Listener.extentReports.createTest("Configuration Methods Set Up"));
		}
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		logger.info("Screenshot taken");
	}

	private String getExceptionDetails(Throwable throwable) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		throwable.printStackTrace(pw);
		return sw.toString();
	}

	private void logError(String message, Exception e) {
		// Log the error using your preferred logging framework
		// For example, with Log4j:
		// Logger.getLogger(YourTestClass.class).error(message, e);
		System.err.println(message);
		e.printStackTrace();
	}

	public void restartBrowserSession(String browserName){
		if (System.getProperty("browser") != null) {
			browserName = System.getProperty("browser");
		}
		this.driver.quit();
		this.driver = WebDriverProvider.getDriver(browserName);
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		webDriverThreadLocal.set(this.driver);
	}
}