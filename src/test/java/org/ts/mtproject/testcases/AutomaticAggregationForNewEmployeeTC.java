package org.ts.mtproject.testcases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;
import org.ts.mtproject.data.User;
import org.ts.mtproject.pages.EditSchedulePopupPage;
import org.ts.mtproject.pages.HomePage;
import org.ts.mtproject.pages.TasksPage;


public class AutomaticAggregationForNewEmployeeTC extends MyProjTestCaseUtils{

	public AutomaticAggregationForNewEmployeeTC() {
		super(BrowserType.CHROME);
	}

	private HomePage homePage;
	private TasksPage tasksPage;
	private EditSchedulePopupPage editSchedulePopupPage;
	private User admin = new User("spadmin", "admin");

	@Test
	public void AutomaticAddNewEmployee(){
		using(homePage = uiInstance
				.getSystemPage()
				.and()
				.setUsername(admin)
				.and()
				.setPassword(admin)
				.and()
				.signIn(uiInstance)
				)
				.check(homePage.validateWelcome())
				.using(tasksPage = homePage
				.clickSetupLinkMenuBar()
				.and()
				.clickTasksMenuBar(uiInstance)
				)
				.check(tasksPage.validateTasksPage())
				.using(editSchedulePopupPage = tasksPage
				.clickScheduledTastTab()
				.clickScheduleTaskOfMTBUltiproHRAggregation(uiInstance)
				)
				.check(editSchedulePopupPage.validateTaskIsScheduleDaily());
	}
}
