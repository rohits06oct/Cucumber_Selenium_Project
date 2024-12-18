package StepDefinitions;

import Managers.chromeDriverCall;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class Hooks {

    static WebDriver driver = chromeDriverCall.driver;

    String savePath = "screenshots/";

    public void setUpOnce() {
        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
    }

    @After
    public void tearDownOnce(Scenario scenario) {
        if(scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Path destinationPath = Path.of(savePath, "screenshot_" + System.currentTimeMillis() + ".png");
                Files.createDirectories(destinationPath.getParent());
                Files.copy(screenshotFile.toPath(), destinationPath);
                System.out.println("Screenshot saved to: " + destinationPath.toString());
            } catch (Exception e) {
                System.out.println("Failed to save the screenshot: " + e.getMessage());
            }
        }
    }
}
