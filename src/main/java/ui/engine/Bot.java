package ui.engine;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import lombok.Getter;

import java.io.File;
import java.util.Random;

@Slf4j
public class Bot {
    //   private static final Logger log = LoggerFactory.getLogger(SynchronizationManager.class);

    @Getter
    protected WebDriver driver;

    @Getter
    protected SynchronizationManager wait;

    public Bot(WebDriver driver) {
        this.driver = driver;
        this.wait = new SynchronizationManager(driver);
    }

    public String getValidationMessage(By locator) {
        try {
            WebElement element = driver.findElement(locator);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            String actualErrorMessage = (String) js.executeScript("return arguments[0].validationMessage;", element);
            log.info("Raw validation message: " + actualErrorMessage);
            return actualErrorMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error retrieving validation message";
        }
    }


    public WebElement getWebElement(By locator) {
        return driver.findElement(locator);
    }


    public Bot click(By locator) {
        try {
            wait.waitForOverLayToDisapper();
            wait.scrollToView(locator);
            WebElement element = wait.waitForTheElementToBeClickable(locator);
            new Actions(driver).moveToElement(element).perform();
            element.click();
            log.info("Clicked on the element : {} ", locator);
        } catch (Exception e) {
            log.error("Click failed for : {}", locator);
            throw new RuntimeException("An exception occured while clicking on the locator " + e);
        }
        return this;
    }


    public Bot enterText(By locator, String inputText) {
        try {
            wait.scrollToView(locator);
            WebElement element = wait.waitForTheElementToBeVisible(locator);
            new Actions(driver).moveToElement(element).perform();
            element.click();
            element.clear();
            element.sendKeys(inputText);
            //  element.sendKeys();
            log.info("Entered text '{}' into element: {} ", inputText, locator);
        } catch (Exception e) {
            log.error("Failed to enter text '{}' in element: {}", inputText, locator, e);
            throw new RuntimeException("An exception occurred while entering text in element: " + locator, e);
        }
        return this;
    }


    public Bot fileUpload(By locator, String relativePath) {
        String filePath = System.getProperty("user.dir") + File.separator + (relativePath);
        try {
            wait.scrollToView(locator);
            WebElement element = wait.waitForTheElementToBeVisible(locator);
            new Actions(driver).moveToElement(element).perform();
            element.sendKeys(filePath);
            log.info("Successfully uploaded file: '{}'", filePath);
        } catch (Exception e) {
            log.error("Exception occurred during file upload for: '{}'", filePath, e);
            throw new RuntimeException("File upload failed for: " + filePath, e);
        }
        return this;
    }


    public String getTitle() {
        try {
            String title = driver.getTitle();
            log.info("Page title is: " + title);
            return title;
        } catch (Exception e) {
            log.error("Failed to get page title", e);
            return null;
        }
    }


    public String getAlertMessage() {
        try {
            wait.waitForAlert();
            String alertMessage = driver.switchTo().alert().getText();
            log.info("Alert message captured: {}", alertMessage);
            return alertMessage;
        } catch (Exception e) {
            log.error("Failed to retrieve alert message", e);
            throw new RuntimeException("An exception occurred while fetching the alert message", e);
        }
    }


    public String getAttributValue(By locator) {
        WebElement element = driver.findElement(locator);
        String capturedValue = element.getDomAttribute("value");
        return capturedValue;

    }


    public void acceptAlert() {
        try {
            wait.waitForAlert();
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            log.info("Accepted alert with message: {}", alertText);
        } catch (NoAlertPresentException e) {
            log.warn("No alert present to accept", e);
        } catch (Exception e) {
            log.error("Failed to accept the alert", e);
            throw new RuntimeException("An exception occurred while accepting the alert", e);
        }
    }


    public void dismissAlert() {
        try {
            wait.waitForAlert();
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.dismiss();
            log.info("Dismissed alert with message: {}", alertText);
        } catch (NoAlertPresentException e) {
            log.warn("No alert present to dismiss", e);
        } catch (Exception e) {
            log.error("Failed to dismiss the alert", e);
            throw new RuntimeException("An exception occurred while dismissing the alert", e);
        }
    }

    // get text


    public String getText(By locator) {
        try {
            WebElement element = wait.waitForTheElementToBeVisible(locator);
            String text = element.getText();
            log.info("Text retrieved from element {}: {}", locator, text);
            return text;
        } catch (Exception e) {
            log.error("Failed to retrieve text from element: {}", locator, e);
            throw new RuntimeException("An exception occurred while getting text from element: " + locator, e);
        }
    }

//select by value


    public Bot selectByValue(By locator, String value) {
        try {
            WebElement dropdown = wait.waitForTheElementToBeVisible(locator);
            Select select = new Select(dropdown);
            select.selectByValue(value);
            log.info("Selected value '{}' from dropdown: {}", value, locator);
        } catch (Exception e) {
            log.error("Failed to select value '{}' from dropdown: {}", value, locator, e);
            throw new RuntimeException("An exception occurred while selecting value from dropdown: " + locator, e);
        }
        return this;
    }

//select by index


    public Bot selectByIndex(By locator, int index) {
        try {
            WebElement dropdown = wait.waitForTheElementToBeVisible(locator);
            Select select = new Select(dropdown);
            select.selectByIndex(index);
            log.info("Selected index '{}' from dropdown: {}", index, locator);
        } catch (Exception e) {
            log.error("Failed to select index '{}' from dropdown: {}", index, locator, e);
            throw new RuntimeException("An exception occurred while selecting index from dropdown: " + locator, e);
        }
        return this;
    }

//select by visible text


    public Bot selectByVisibleText(By locator, String visibleText) {
        try {
            WebElement dropdown = wait.waitForTheElementToBeVisible(locator);
            Select select = new Select(dropdown);
            select.selectByVisibleText(visibleText);
            log.info("Selected visible text '{}' from dropdown: {}", visibleText, locator);
        } catch (Exception e) {
            log.error("Failed to select visible text '{}' from dropdown: {}", visibleText, locator, e);
            throw new RuntimeException("An exception occurred while selecting visible text from dropdown: " + locator,
                    e);
        }
        return this;
    }

    // js click


    public Bot jsClick(By locator) {
        try {
            wait.scrollToView(locator);
            WebElement element = wait.waitForTheElementToBeVisible(locator);
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", element);
            log.info("Performed JavaScript click on element: {}", locator);
        } catch (Exception e) {
            log.error("JavaScript click failed for element: {}", locator, e);
            throw new RuntimeException("An exception occurred while performing JS click on: " + locator, e);
        }
        return this;
    }


    public Bot jsSendKeys(By locator, String inputText) {
        try {
            WebElement element = wait.waitForTheElementToBeVisible(locator);
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].value = arguments[1];", element, inputText);
            log.info("Set value '{}' using JavaScript in element: {}", inputText, locator);
        } catch (Exception e) {
            log.error("Failed to set value '{}' using JavaScript in element: {}", inputText, locator, e);
            throw new RuntimeException("An exception occurred while sending keys via JS to: " + locator, e);
        }
        return this;
    }


    public Bot checkCheckbox(By locator) {
        try {
            wait.scrollToView(locator);
            WebElement checkbox = wait.waitForTheElementToBeClickable(locator);
            if (!checkbox.isSelected()) {
                checkbox.click();
                log.info("Checkbox selected: {}", locator);
            } else {
                log.info("Checkbox already selected: {}", locator);
            }
        } catch (Exception e) {
            log.error("Failed to select checkbox: {}", locator, e);
            throw new RuntimeException("An exception occurred while selecting checkbox: " + locator, e);
        }
        return this;
    }


    public Bot uncheckCheckbox(By locator) {
        try {
            wait.scrollToView(locator);
            WebElement checkbox = wait.waitForTheElementToBeClickable(locator);
            if (checkbox.isSelected()) {
                checkbox.click();
                log.info("Checkbox unselected: {}", locator);
            } else {
                log.info("Checkbox already unselected: {}", locator);
            }
        } catch (Exception e) {
            log.error("Failed to unselect checkbox: {}", locator, e);
            throw new RuntimeException("An exception occurred while unchecking checkbox: " + locator, e);
        }
        return this;
    }


    public Bot pressEnterUsingActions(By locator) {
        try {
            WebElement element = wait.waitForTheElementToBeVisible(locator);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).sendKeys(Keys.ENTER).build().perform();
            log.info("Pressed ENTER using Actions on element: {}", locator);
        } catch (Exception e) {
            log.error("Failed to press ENTER using Actions on element: {}", locator, e);
            throw new RuntimeException("An exception occurred while pressing ENTER with Actions on: " + locator, e);
        }
        return this;
    }

    public Bot pressTabUsingActions(By locator) {
        try {
            WebElement element = wait.waitForTheElementToBeVisible(locator);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).sendKeys(Keys.TAB).build().perform();
            log.info("Pressed TAB using Actions on element: {}", locator);
        } catch (Exception e) {
            log.error("Failed to press TAB using Actions on element: {}", locator, e);
            throw new RuntimeException("An exception occurred while pressing TAB with Actions on: " + locator, e);
        }
        return this;
    }

    public Bot searchAccount(By locator, String text) {
        try {
            WebElement element = wait.waitForTheElementToBeVisible(locator);
            element.clear();
            element.sendKeys(text + Keys.ENTER);
            log.info("Entered text '{}' and pressed ENTER on element: {}", text, locator);
        } catch (Exception e) {
            log.error("Failed to enter text and press ENTER on element: {}", locator, e);
            throw new RuntimeException("An error occurred while entering text and pressing ENTER on: " + locator, e);
        }
        return this;
    }


    public int getRandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public void scrollTillBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

        while (true) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            try {
                Thread.sleep(5000); // Wait for more rows to load
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            long newHeight = (long) js.executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) {
                break; // No more new rows loaded
            }
            lastHeight = newHeight;
        }
    }


}
