package example.example.context;

import org.openqa.selenium.WebDriver;


public class WebDriverContext {
	
	/** Initialize the driverinstance. */
	private static InheritableThreadLocal<WebDriver> driverinstance = new InheritableThreadLocal<>();

	/**
	 * Gets the driver.
	 */
	public static WebDriver getDriver() {
		if (driverinstance.get() == null)
			throw new IllegalStateException(
					"WebDriver has not been set, Please set WebDriver instance by WebDriverContext.setDriver...");
		else
			return driverinstance.get();
	}

	/**
	 * Sets the driver.
	 **/
	public static void setDriver(WebDriver driver) {
		driverinstance.set(driver);
	}

	/**
	 * Removes the driver.
	 */
	public static void removeDriver() {
		driverinstance.remove();
	}
}
