package ui.engine;

import io.github.bonigarcia.wdm.WebDriverManager;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class BrowserFactory {

    private final Logger logger = LoggerFactory.getLogger(BrowserFactory.class);

    @Getter
    public WebDriver driver;

    @Getter
    public Bot bot;

    public WebDriver theTargetBrowserisOpen() {
        String browserName = PropertiesManager.getProperty("browser.name");
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                	chromeOptions.addArguments("--headless=new");
                chromeOptions.addArguments("--incognito", "--start-maximized");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                driver = new ChromeDriver(chromeOptions);
                driver.get(PropertiesManager.getProperty("base.url"));
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--incognito").addArguments("--start-maximized");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--incognito").addArguments("--start-maximized");
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                logger.error("Please pass a correct browser value");
                throw new IllegalArgumentException("Browser not supported " + browserName);
        }
        bot = new Bot(driver);
        return driver;
    }

    public Bot getBot() {
        return bot;
    }


}
