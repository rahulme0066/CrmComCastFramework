package java_Basics;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		
		Date dataObj=new Date();
		
		System.out.println(dataObj);
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actDate = sim.format(dataObj);
		System.out.println(actDate);

	}

}
