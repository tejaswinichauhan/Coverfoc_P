package com.Coverfox_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class filtersOfResultPage {

	@FindBy(xpath = "//div[text()='Sum Assured']")
	private WebElement sumAssured;
	@FindBy(xpath = "//span[text()='15L to 24L']")
	private WebElement selectFilter;
	// @FindBy(id = "plans-list")private WebElement actualsumAssured;

	@FindBy(xpath = "//div[@id='plans-list']/descendant::div[@class='rupee-val'][1]")
	private List<WebElement> listofPrice;
	@FindBy(xpath = "//div[@class='radio-options filter-options vb-item-flex']/div/span")
	private List<WebElement> listOfSumAssured;

	@FindBy(xpath = "//div[contains(text(),'matching')]")
	private WebElement noOfPlans;

	public filtersOfResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void validatesumassured(String priceRange) throws InterruptedException {
		sumAssured.click();
		Thread.sleep(2000);

		for (WebElement list : listOfSumAssured) {
			String text = list.getText();
			if (text.contains(priceRange)) {
				list.click();

				System.out.println("Clicked the specific range");
				break;

			}
		}
		Thread.sleep(2000);
		System.out.println("Selected the filter");

	}

	public int validatevisibleList() {

		int count = 0;
		for (WebElement l : listofPrice) {
			String stringmsg = l.getText();
			String[] newstring = stringmsg.split(" ");
			float floatValue = Float.parseFloat(newstring[0]);
			System.out.println(floatValue);

			if (floatValue >= 1 && floatValue <= 3) {
				count++;

			} else if (floatValue >= 4 && floatValue <= 5) {
				count++;

			} else if (floatValue >= 6 && floatValue <= 9) {
				count++;
			} else if (floatValue >= 10 && floatValue <= 14) {
				count++;
			} else if (floatValue >= 15 && floatValue <= 24) {
				count++;
			} else if (floatValue >= 25 && floatValue <= 99) {
				count++;
			} else {
				count++;
			}
			

		}
		System.out.println("Count=" + count);
		return count;
	}

	public int validate() throws InterruptedException {
		Thread.sleep(8000);
		String Mainresult = noOfPlans.getText();

		String[] Result2 = Mainresult.split(" ");
		System.out.println(Result2[0]);

		int resultInt = Integer.parseInt(Result2[0]);
		System.out.println(resultInt);

		Thread.sleep(3000);
		return resultInt;
	}

}
