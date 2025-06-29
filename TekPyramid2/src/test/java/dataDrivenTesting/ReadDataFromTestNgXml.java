package dataDrivenTesting;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromTestNgXml {
	
	@Test
	public void sampleTest(XmlTest test) {
		System.out.println("Execute sample test");
		
		System.out.println(test.getParameter("Browser"));
		System.out.println(test.getParameter("Url"));

		
	}

}
