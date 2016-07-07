package org.ts.mtproject.testcases;

import org.ts.mtproject.utils.UI;
import com.ts.commons.TestCaseUtil;
import org.testng.annotations.AfterClass;


public class MyProjTestCaseUtils extends TestCaseUtil {
	protected UI uiInstance;

	public MyProjTestCaseUtils(String browserType) {
		uiInstance = new UI(browserType);
	}

	@AfterClass
	public void after() {
		uiInstance.getDriver().quit();
	}

	public static void sleep(int seconds){
		 try {
			  Thread.sleep(seconds * 1000);
			   }catch (InterruptedException e) {}  
	 }
}
