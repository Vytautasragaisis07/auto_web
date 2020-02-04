import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {
    public static void main(String args[]){
        System.out.println("Hello world");

        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("https://www.bing.com");

        WebElement searchField =  browser.findElement(By.id("sb_form_q"));
        searchField.sendKeys("Baranauskas");
        searchField.sendKeys(Keys.ENTER);

        waitForElementById(browser, "sb_form_go");
        WebElement result = browser.findElement(By.xpath("//*[@id=\"b_tween\"]/span"));
        String resultString = result.getText().replace(" Results", "").replace(",", "");

        int resultsk = Integer.parseInt(resultString);

        if(resultsk < 50000) {

            System.out.println("Mieli skaitytojai, dažniau skaitykite Baranausko kūrybą");
        } else{
            System.out.println("Jaunimas dar neužmiršo Anykščių šilelio");
        }

        browser.close();
    }
    private static void waitForElementById(WebDriver browser, String id) {
        WebDriverWait webdriverwait2 = new WebDriverWait(browser, SECONDS);
        webdriverwait2.until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }
}