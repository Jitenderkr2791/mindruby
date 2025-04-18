package AprilMavenProject.AprilMavenProject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion 
{
	SoftAssert sa;
	
	@Test(priority = 1,description = "This is Hard assertion")
	public void hard_Assertion_false()
	{
		System.out.println("=========this is hard assertion===============");
		System.out.println("testing 1!!!!!!");
		System.out.println("Testingn 2@@@@@@@");
												 //disadvantage of Hard assertion
		Assert.assertEquals(1, 2); 				// not execute the further statement assertion gets failed here
		
		System.out.println("Testing 3#######"); 
		System.out.println("Testing 4$$$$$$$");
	}
	
	@Test(priority = 2, description = "This is Soft assertion2 without sa.assertAll();")
	public void Soft_Assertion2_false()
	{
		System.out.println("================this is Soft assertion2 without sa.assertAll();====================");
		System.out.println("testing 1!!!!!!");
		System.out.println("Testingn 2@@@@@@@");
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 2); /*
								 * execute the further statement but the result of method is failed due to
								 * missing of soft assertion mandatory statement(sa.assertAll();)
								 */
		
		System.out.println("Testing 3#######");
		System.out.println("Testing 4$$$$$$$");
	}
	
	@Test(priority = 3, description  = "This is Soft assertion")
	public void Soft_Assertion_false()
	{	
		System.out.println("============this is Soft assertion==================");
		System.out.println("testing 1!!!!!!");
		System.out.println("Testingn 2@@@@@@@");
		
		SoftAssert sa = new SoftAssert(); 
		sa.assertEquals(1, 2);
		
		System.out.println("Testing 3#######");
		System.out.println("Testing 4$$$$$$$");
		sa.assertAll();
	}
	@Test(priority = 4,description = "This is Hard assertion")
	public void hard_AssertionTrue()
	{
		System.out.println("=========this is hard assertion===============");
		System.out.println("testing 1!!!!!!");
		System.out.println("Testingn 2@@@@@@@");
		
		
		Assert.assertEquals(1, 1); 				//  execute the further statement assertion gets pass
		
		System.out.println("Testing 3#######"); 
		System.out.println("Testing 4$$$$$$$");
	}
	
	@Test(priority = 5, description = "This is Soft assertion2 without sa.assertAll();")
	public void Soft_Assertion2True()
	{
		System.out.println("================this is Soft assertion2 without sa.assertAll();====================");
		System.out.println("testing 1!!!!!!");
		System.out.println("Testingn 2@@@@@@@");
		
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 1); /*
								 * execute the further statement but the result of method is failed due to
								 * missing of soft assertion mandatory statement(sa.assertAll();)
								 */
		
		System.out.println("Testing 3#######");
		System.out.println("Testing 4$$$$$$$");
	}
	
	@Test(priority = 6, description  = "This is Soft assertion")
	public void Soft_AssertionTrue()
	{	
		System.out.println("============this is Soft assertion==================");
		System.out.println("testing 1!!!!!!");
		System.out.println("Testingn 2@@@@@@@");
		
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 1);
		
		System.out.println("Testing 3#######");
		System.out.println("Testing 4$$$$$$$");
		sa.assertAll();
	}
	
}
