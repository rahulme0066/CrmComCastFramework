package dataDrivenTesting;

import org.testng.annotations.Test;

public class JavaClassReadRunTimeParameterTest {
    
	@Test
	public void runTimeParameterTest() {
		String url = System.getProperty("Url");
		
		System.out.println("Env Data==>URL===>"+url);

	}

}
