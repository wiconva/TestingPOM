package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By titleText = By.xpath("/html/body/header/h1");
    By userInput = By.xpath("//*[@id='user']");
    By userPassInput = By.xpath("//*[@id='password']");
    By loginButton = By.xpath("//*[@id='login']/form/button");


    public LoginPage (WebDriver driver){
        this.driver = driver;
    }

    public void typeUser (String user){
        driver.findElement(userInput).sendKeys(user);
    }
    public void typePass (String pass){
        driver.findElement(userPassInput).sendKeys(pass);
    }
    public void login (){
        driver.findElement(loginButton).click();
    }

}
