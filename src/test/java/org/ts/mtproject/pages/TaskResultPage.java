package org.ts.mtproject.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.ts.mtproject.testcases.MyProjTestCaseUtils;

import com.ts.commons.Validator;

public class TaskResultPage extends TasksPage{

	@FindBy (xpath=".//*[@id='progress'][contains(.,'Completed')]")
	private WebElement progressFieldCompleted;

	@FindBy (xpath=".//*[@id='progress']")
	private WebElement progressField;
	

	public Validator validateTaskResultPage() 
	{
		return new Validator() 
		{
			@Override
			public void Validate() 
			{
				try{
					Assert.assertEquals(uiInstance.getDriver()
							.findElement(By.xpath(".//*[@id='bodyDivTitle'][contains(.,'Task Result')]"))
							.getText().trim(), "Task Result");
				} catch (NullPointerException e){
					System.out.println("Test--  NullPointerException  ");
				}

			}
		};
	}
	
	public Validator validateTaskIsCompleted() 
	{
		return new Validator() 
		{
			@Override
			public void Validate() 
			{
				try{
					MyProjTestCaseUtils.waitUntilWebElemenmtIsPresent(".//*[@id='progress'][contains(.,'Completed')]");
					Assert.assertEquals(uiInstance.getDriver()
							.findElement(By.xpath(".//*[@id='progress'][contains(.,'Completed')]"))
							.getText().trim(), "Completed");
				} catch (NullPointerException e){
					System.out.println("Test--  NullPointerException  ");
				}

			}
		};
	}
	
}
