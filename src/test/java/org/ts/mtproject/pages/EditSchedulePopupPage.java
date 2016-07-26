package org.ts.mtproject.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.ts.mtproject.testcases.MyProjTestCaseUtils;

import com.ts.commons.Validator;

public class EditSchedulePopupPage extends TasksPage{

	public Validator validateTaskIsScheduleDaily() 
	{
		return new Validator() 
		{
			@Override
			public void Validate() 
			{
				try{
					MyProjTestCaseUtils.sleep(5);
					Assert.assertEquals(uiInstance.getDriver()
							.findElement(By.xpath(".//option[contains(.,'Daily')][@selected='selected']"))
							.getText().trim(), "Daily");
				} catch (NullPointerException e){
					System.out.println("Test--  NullPointerException  ");
				}

			}
		};
	}
}
