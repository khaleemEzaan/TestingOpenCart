package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;

public class BaseClass {
    public static WebDriver driver;
    public Logger logger;
    public Properties p;
    public ITestContext testContext;

    public void setUp(ITestContext context) {
        this.testContext = context;
    }

    @BeforeClass(groups = {"sanity", "Master", "Regression"})
    @Parameters({"os", "browser"})
    public void setup(String os, String br) throws InterruptedException, IOException {
        // Loading Config
        FileReader file = new FileReader("C:\\Users\\lenovo\\Desktop\\Selenium Practice\\openCart123\\src\\test\\resources\\config.properties");
        p = new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass());

        // Check for remote execution environment
        if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities cap = new DesiredCapabilities();

            // Set platform based on the OS parameter
            if (os.equalsIgnoreCase("windows")) {
                cap.setPlatform(Platform.WIN10);
            } else if (os.equalsIgnoreCase("mac")) {
                cap.setPlatform(Platform.MAC);
            } else {
                System.out.println("No matching OS found.");
                return;
            }

            // Set browser based on the browser parameter
            switch (br.toLowerCase()) {
                case "chrome":
                    cap.setBrowserName("chrome");
                    break;
                case "edge":
                    cap.setBrowserName("MicrosoftEdge");
                    break;
                case "firefox":
                    cap.setBrowserName("firefox");
                    break;
                default:
                    System.out.println("Invalid browser");
                    return;
            }

            // Initialize RemoteWebDriver
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        } 
        // Local execution environment
        else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (br.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("Invalid browser");
                    return;
            }
        } else {
            System.out.println("Invalid execution environment");
            return;
        }

        // Common setup for both remote and local
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appURL")); // Reading value from property file
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @AfterClass(groups = {"sanity", "Master", "Regression"})
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public String randomeString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomeNum() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomeAlphaNum() {
        return RandomStringUtils.randomAlphanumeric(15);
    }

    public String captureScreen(String name) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + name + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);
        if (sourceFile.renameTo(targetFile)) {
            return targetFilePath;
        } else {
            throw new IOException("Failed to move screenshot to " + targetFilePath);
        }
    }
}
