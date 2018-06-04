package base;

import org.openqa.selenium.WebDriver;

public final class Driver {

    private static Driver instance = null;

    private DriverConfiguration driverConfiguration = new DriverConfiguration();

    private Driver() {
    }

    public static Driver getInstance() {
        if (instance == null) {
            synchronized (Driver.class) {
                if (instance == null) {
                    instance = new Driver();
                }
            }
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driverConfiguration.getWebDriver();
    }

    public void closeDriver() {
        driverConfiguration.closeWebDriver();
    }
}

