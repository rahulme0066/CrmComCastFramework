import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleTest {

	@Test
	public void SampleTest(Method mtd) {
		Reporter.log(mtd.getName() + " execution started",true);
		Reporter.log("Step-1",true);
		Reporter.log("Step-2",true);
		Assert.assertEquals("home", "homePage");
		Reporter.log("Step-3",true);
		Reporter.log("Step-4",true);
		Reporter.log("Step-5",true);
		Reporter.log(mtd.getName() + " execution ended",true);

	}

	@Test 
	public void SampleTest2(Method mtd) {
		Reporter.log(mtd.getName()+" execution started",true);
		Reporter.log("Step-1--",true);
		Reporter.log("Step-2--",true);
		Reporter.log("Step-3--",true);
		Reporter.log("Step-4--",true);
		Reporter.log("Step-5--",true);
		Reporter.log(mtd.getName()+" execution ended",true);

	}
}
