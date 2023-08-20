package tests;


import driver.MyChromeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.manager.SeleniumManagerJsonOutput;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ActualizarClientePage;
import pages.LoginPage;
import utilities.TakeScreenShoter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class LoginPageTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        this.driver = new MyChromeDriver().getDriver();
    }

    @Test
    public void login () throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ActualizarClientePage actualizarClientePage = new ActualizarClientePage(driver);
        TakeScreenShoter.takeScreenShot(driver);
        loginPage.typeUser("admin");
        TakeScreenShoter.takeScreenShot(driver);
        loginPage.typePass("admin");
        TakeScreenShoter.takeScreenShot(driver);
        loginPage.login();
        TakeScreenShoter.takeScreenShot(driver);
        actualizarClientePage.clickClient();
        TakeScreenShoter.takeScreenShot(driver);
        Assert.assertEquals(actualizarClientePage.getTitle(),"Actualizar Cliente");

    }


    @AfterMethod
    public void tearDown (){

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String script = "window.open('http://www.google.com')";
        jse.executeScript(script);

        List <String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        TakeScreenShoter.takeScreenShot(driver);





        driver.close();
        driver.quit();

    }



}
