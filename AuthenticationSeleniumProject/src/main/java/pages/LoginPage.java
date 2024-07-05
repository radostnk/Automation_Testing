package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.CookieStore;
import java.util.Set;

public class LoginPage {

    private WebDriver driver;
    private final By userOrEmailField = By.id("usernameOrEmail");
    private final By passwordField = By.id("password");
    private final By rememberMeCheckbox = By.id("rememberMe");
    private final By loginButton = By.className("btn-btn-primary");
    private final By captcha = By.xpath("//input[@name='captcha-bypass']");
    private final By username = By.id("username");
    private final By logoutButton = By.xpath("//a[text()='Logout']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUsername() {
        return driver.findElement(username).getText();
    }

    public void logout() {
        driver.findElement(logoutButton).click();
    }

    public Set<Cookie> getOldSessionCookies() {
        return driver.manage().getCookies();
    }

    public void addOldCookiesToNewSession(Set<Cookie> oldCookies) {
        for (Cookie cookie : oldCookies) {
            driver.manage().addCookie(cookie);
        }
    }

    public void fullLoginProcedureNotRemember(String userOrEmail, String pass) {
        insertUserOrEmail(userOrEmail);
        insertPassword(pass);
        bypassCaptcha();
        clickLoginButton();
    }

    public void fullLoginProcedureRemember(String userOrEmail, String pass) {
        insertUserOrEmail(userOrEmail);
        insertPassword(pass);
        bypassCaptcha();
        clickRememberMeCheckbox();
        clickLoginButton();
    }

    private void insertUserOrEmail(String userOrEmail) {
        driver.findElement(userOrEmailField).sendKeys(userOrEmail);
    }

    private void insertPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    private void clickRememberMeCheckbox() {
        driver.findElement(rememberMeCheckbox).click();
    }

    private void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    private void bypassCaptcha() {
        var captchaBypass = driver.findElement(captcha);
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', arguments[1]);", captchaBypass, "10685832-cd90-4e91-9224-2ef69ce88f53");
    }

}
