package org.ts.mtproject.pages;

import org.openqa.selenium.By;

import com.ts.commons.Validator;

import org.junit.Assert;
import org.ts.mtproject.utils.UI;

public class HomePage extends SystemPage{


	@Override
	public HomePage and() {
		return this;
	}

	public HomePage and(UI uiInstance) {
		this.uiInstance = uiInstance;
		return this;
	}

	@Override
	public HomePage then() {
		return this;
	}

	// ###### Validators
	public Validator validateWelcome() 
	{
		return new Validator() 
		{
			@Override
			public void Validate() 
			{
				try{
					Assert.assertEquals(uiInstance.getDriver()
							.findElement(By.xpath("//descendant::span[starts-with(normalize-space(.),'Home')]"))
							.getText().trim(), "Home");
				} catch (NullPointerException e){
					System.out.println("Test--  NullPointerException  ");
				}

			}
		};
	}

}
