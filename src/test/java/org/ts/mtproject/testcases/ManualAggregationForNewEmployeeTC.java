package org.ts.mtproject.testcases;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;
import org.ts.mtproject.data.User;
import org.ts.mtproject.pages.EditTaskPage;
import org.ts.mtproject.pages.HomePage;
import org.ts.mtproject.pages.TaskResultPage;
import org.ts.mtproject.pages.TasksPage;


public class ManualAggregationForNewEmployeeTC extends MyProjTestCaseUtils{

	public ManualAggregationForNewEmployeeTC() {
		super(BrowserType.CHROME);
	}

	private HomePage homePage;
	private TasksPage tasksPage;
	private EditTaskPage editTaskPage;
	private TaskResultPage taskResult;
	private User admin = new User("spadmin", "admin");

	@Test
	public void ManualAddNewEmployee(){
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
				.using(editTaskPage = tasksPage
				.clickMTBUltiproHRAggregationlink(uiInstance)
				)
				.check(editTaskPage.validateEditTaskPage())
				.using(tasksPage = editTaskPage
				.clickSaveAndExecuteButton()
				.clickAcceptButton(uiInstance))
				.check(tasksPage.validateTasksPage())
				.using(taskResult = tasksPage 
				.clickTaskResultTab()
				.sendSearchInfoForHRAggregation()
				.clickSearchButton()
				.clickLastTaskRanOfMTBUltiproHRAggregation(uiInstance)
				).check(taskResult.validateTaskScannedAccounts());
	}
}
