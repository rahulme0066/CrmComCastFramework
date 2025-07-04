import org.testng.annotations.Test;

import junit.framework.Assert;

public class InvoiceTest {
	
	
	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void activateSim() {
		System.out.println("==execute invoice test===");
		Assert.assertEquals("", "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");



		
	}

}
