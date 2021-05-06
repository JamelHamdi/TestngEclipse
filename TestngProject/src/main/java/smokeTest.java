import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;


public class smokeTest {
	private WebDriver driver;

	@Parameters({"browserName","url","env"})
	@BeforeTest
	public void steup(String browserName, String url, String env) {
		//String browserName ="chrome";
		System.out.println("The browser Name is : "+browserName);
        if(browserName.equalsIgnoreCase("Chrome")){
           // System.setProperty("webdriver.chrome.driver","chromedriver");
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("Firefox")) {
            //System.setProperty("webdriver.gecko.driver", "geckodriver");
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("safari")) {
            //System.setProperty("webdriver.gecko.driver", "geckodriver");
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
	}
	
	@Test(priority = 1)
    public void Login(){

        //Accept Cookis
        driver.findElement(By.xpath(("//button[@id=\"didomi-notice-agree-button\"]"))).click();
        
    }
	
	@AfterTest
	public void cleanUp(){
        driver.quit();
	}
}
