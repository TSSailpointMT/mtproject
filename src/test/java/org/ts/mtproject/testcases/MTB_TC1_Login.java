package org.ts.mtproject.testcases;

import org.ts.mtproject.data.User;
import org.ts.mtproject.pages.HomePage;
import org.ts.mtproject.pages.PolicyViolationsPage;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;
import org.ts.mtproject.testcases.MyProjTestCaseUtils;

public class MTB_TC1_Login extends MyProjTestCaseUtils{

	public MTB_TC1_Login() {
		super(BrowserType.CHROME);
	}

	private HomePage homePage;
	private PolicyViolationsPage policyViolationsPage;
	private User admin = new User("spadmin", "admin");
	
	@Test
	public void loginTC(){
		using(
				homePage = uiInstance
							.getSystemPage()
							.setUsername(admin)
							.and()
							.setPassword(admin)
							.and()
							.signIn(uiInstance)
				)
		.check(homePage.validateWelcome())
//				.using(
//						policyViolationsPage = homePage
//						.clickLeftSubMenu()
//						.and()
//						.clickMyTasks()
//						.and()
//						.clickPolicyViolationsMyTasks(uiInstance)
//								).check(policyViolationsPage.validatePolicyViolationsPage())
				;
		
	}
}
