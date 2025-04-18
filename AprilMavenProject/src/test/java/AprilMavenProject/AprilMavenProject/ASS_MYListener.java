package AprilMavenProject.AprilMavenProject;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class ASS_MYListener implements ITestListener{
	
	public void onTestStart(ITestResult result) {
	   System.out.println("Test is started");
	  }

	 
	public void onTestSuccess(ITestResult result) {
	    System.out.println("Test gets Passed");
	  }

	 
	public void onTestFailure(ITestResult result) {
	    System.out.println("Test gets failed");
	  }

	 
	public void onTestSkipped(ITestResult result) {
	    System.out.println("Test gets Skipped");
	  }
	
	public void onStart(ITestContext context) {
	    System.out.println("Test execution is started");
	  }

	 
	public void onFinish(ITestContext context) {
	    System.out.println("test execution is completed");
	  }

}
