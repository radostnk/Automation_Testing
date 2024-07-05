import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;

public abstract class BaseTests {

    private WebDriver driver;
    private final String url = "file:///C:/Users/koleva/Desktop/test-login-app-main/index.html";
    protected HomePage homePage;

    @BeforeAll
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to(url);
        homePage = new HomePage(driver);
    }

    @AfterAll
    public static void tearDown() {
        WebDriverManager.chromedriver().quit();
    }

}
