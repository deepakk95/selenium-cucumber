package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Driver {
    private WebDriver driver;
    PropertyFileHandler property;

    public WebDriver createDriver(){


        String OS = System.getProperty("os.name").toLowerCase();
        String browsername = property.getdataFromConfigurationFile("browser");
        if(OS.equals("windows 10") && browsername.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "/Users/" + System.getProperty("user.name") + "/selenium-cucumber/windowsDriver/chromedriver.exe");
            this.driver = new ChromeDriver();
            this.driver.manage().window().maximize();
        }
        else if(OS.equals("windows 10") && browsername.equalsIgnoreCase("edge"))
        {
            System.setProperty("webdriver.edge.driver","/Users/" + System.getProperty("user.name") + "/selenium-cucumber/windowsDriver/msedgedriver.exe");
            this.driver = new EdgeDriver();
            this.driver.manage().window().maximize();
        }
       return this.driver;
    }
}
