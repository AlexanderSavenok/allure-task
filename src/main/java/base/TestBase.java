package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class TestBase {

    protected WebDriver driver;
    private static Properties env;

    public static final String BASE_URL = "http://mail.ru";

    @BeforeAll
    public static void setVariables() {
        env = new Properties();
        RemoteWebDriver driver = (RemoteWebDriver) Driver.getInstance().getDriver();

        env.setProperty("Browser", driver.getCapabilities().getBrowserName());
        env.setProperty("Browser Version", driver.getCapabilities().getVersion());
        env.setProperty("Platform", driver.getCapabilities().getPlatform().name());
        env.setProperty("Platform version", driver.getCapabilities().getPlatform().getMajorVersion() + "." +
                driver.getCapabilities().getPlatform().getMinorVersion());
        env.setProperty("Url", BASE_URL);
    }

    @BeforeEach
    public void init() {
        driver = Driver.getInstance().getDriver();
        driver.get(BASE_URL);
    }

    @AfterEach
    public void tearDown() {
        Driver.getInstance().closeDriver();
    }

    @AfterAll
    public static void saveEnvironment() {
        File file = Paths.get(System.getProperty("user.dir"), "/allure-results").toAbsolutePath().toFile();
        if (!file.exists()) {
            System.out.println("Created dirs: " + file.mkdirs());
        }
        try (FileWriter out = new FileWriter("./allure-results/environment.properties")) {
            env.store(out, "Environment variables for report");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
