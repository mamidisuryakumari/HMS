package ui.engine;

import org.openqa.selenium.WebDriver;

public class BasePage {

    private WebDriver driver;
    private Bot bot;

    public BasePage(TestContext context) {

        this.driver = context.getDriver();
        this.bot = context.getBot();

    }
}
