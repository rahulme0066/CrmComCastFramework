import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass2;

import junit.framework.Assert;
@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class CreateContact extends BaseClass2{
	
	@Test
	public void CreateContactTest() {
		
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");

	}
	

}
