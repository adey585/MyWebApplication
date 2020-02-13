import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Base {
    public WebDriver driver = null;
    public Logger log = Logger.getLogger(Base.class.getName());

    @Parameters
    ({"useSaucceLab", "userName", "key", "appURL", "os", "browserName", "browserVersion"})

    @BeforeMethod
    public void setUp(boolean useSaucceLab, String userName, String key, String appURL, String os, String browserName, String browserVersion)
    throws IOException {
        if (useSaucceLab == true) {
            //getSauceLabDriver(userName, key, os, browserName,browserVersion);
        } else {
            getLocalDriver(os, browserName);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(appURL);
        driver.manage().window().maximize();
        log.info("Browser Loaded with App");
    }

    //Get Local Driver
    public WebDriver getLocalDriver(String os, String browserName) {
        if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\iamam\\Desktop\\BunceePract\\Generic\\src\\main\\driver\\chromedriver.exe");
            } else {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\iamam\\Desktop\\BunceePract\\Generic\\src\\main\\driver\\chromedriver.exe");
            }
            driver = new ChromeDriver();
        }
        return driver;
    }

    @AfterMethod
    public void cleanUp() throws InterruptedException {
        log.info("Driver is quiting");
        driver.quit();
    }

    public void clickByXpath(String xpath) throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.xpath(xpath)).click();
    }

    public void sendTextByXpath(String xpath, String data) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(xpath)).sendKeys(data);
    }

    public String readFromExcel(String fileRef, String sheetRef, String cellRef) throws IOException {
        FileInputStream fis = new FileInputStream(fileRef);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(sheetRef);
        DataFormatter formatter = new DataFormatter();
        CellReference cellReference = new CellReference(cellRef);
        Row row = sheet.getRow(cellReference.getRow());
        Cell cell = row.getCell(cellReference.getCol());
        String value = "";
        if (value != null) {
            value = formatter.formatCellValue(cell);
        }
        return value;
    }

}