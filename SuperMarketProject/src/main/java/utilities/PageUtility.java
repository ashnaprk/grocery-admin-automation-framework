package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void scrollToElement(WebDriver driver, WebElement element)

	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void javaScriptClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollByPixel(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);

	}
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
	
    public static void selectByVisibleTextDropdowm(WebElement dropdownElement, String text) {
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(text);
    }

   
    public static void selectByValueDropdown(WebElement dropdownElement, String value) {
        Select select = new Select(dropdownElement);
        select.selectByValue(value);
    }

    
    public static void selectByIndexDropDown(WebElement dropdownElement, int index) {
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
    }

}
