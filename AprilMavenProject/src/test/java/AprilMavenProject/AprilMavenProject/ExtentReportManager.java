package AprilMavenProject.AprilMavenProject;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	 public ExtentReports extent;
	 public ExtentTest test;

	public void onStart(ITestContext context) 
	{
	    sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "//ExtentReport//report.html");
	    sparkReporter.config().setReportName("Automation Report");
	    sparkReporter.config().setDocumentTitle("Functional Testing");
	    sparkReporter.config().setTheme(Theme.STANDARD);
	    
	    extent =new ExtentReports();
	    extent.attachReporter(sparkReporter);
	    extent.setSystemInfo("computer name", "local host");
	    extent.setSystemInfo("environment", "qa");
	    extent.setSystemInfo("tester name", "jitender");
	    extent.setSystemInfo("os", "windows 11");
	    extent.setSystemInfo("browswer name", "chrome");
	  }
	
	public void onTestSuccess(ITestResult result) 
	{
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test case passed is :"+result.getName());
	  }
	
	public void onTestFailure(ITestResult result) 
	{
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case failed is :" +result.getName());
		test.log(Status.FAIL, "Test case failed is :" +result.getThrowable());
	  }
	
	public void onTestSkipped(ITestResult result) 
	{
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case skipped is :" +result.getName());
	  }
	
	public void onFinish(ITestContext context) {
	    extent.flush();
	  }
}