package testcode;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class webviewHandling extends com.Base.Base{

	@Test
    public void webViewHandling() {
        // Example test steps using the RemoteWebDriver instance from Base class
		
		    AndroidDriver driver = (AndroidDriver) this.driver; // Assigning to a local variable

		    try {
		        // Example: Selecting a country from a dropdown
		        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Belgium\"));"));
		        driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']")).click();

		        // Example: Typing name into a text field
		        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Kavitha");

		        // Example: Dismissing the keyboard
		        driver.pressKey(new KeyEvent(AndroidKey.BACK));

		        // Example: Selecting a radio button
		        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

		        // Example: Clicking a button to proceed
		        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		        // Example: Adding a product to the cart
		        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"PG 3\"));"));
		        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		        for (int i = 0; i < count; i++) {
		            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
		            if (productName.equalsIgnoreCase("PG 3")) {
		                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
		                break;
		            }
		        }

		        // Example: Navigating to the cart
		        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		        // Example: Proceeding to checkout
		        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		        // Example: Handling webview context
		        Set<String> contextNames = driver.getContextHandles();
		        for (String contextName : contextNames) {
		            System.out.println("Context: " + contextName);
		        }

		        // Example: Switching to webview context
		        driver.context("WEBVIEW_com.androidsample.generalstore");

		        // Example: Interacting with elements in webview
		        driver.findElement(By.id("APjFqb")).sendKeys("books");
		        driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);

		        // Example: Switching back to native context
		        driver.context("NATIVE_APP");

		        // Example: Continuing with native app actions
		        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Kavitha.B");

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	
}
