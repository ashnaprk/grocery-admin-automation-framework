package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionUtilities {
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void hoverOverElement(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target)
	{
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	public void clickAndHold(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).perform();
	}
	
    public static void selectByVisibleText(WebElement dropdownElement, String text) {
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(text);
    }

   
    public static void selectByValue(WebElement dropdownElement, String value) {
        Select select = new Select(dropdownElement);
        select.selectByValue(value);
    }

    
    public static void selectByIndex(WebElement dropdownElement, int index) {
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
    }

}
