package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TakeScreenShoter {
    private static int counter = 0;
    public static void takeScreenShot (WebDriver driver) {
        String path = System.getProperty("user.dir") + "/ScreenShot/";
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        counter++;
        File myScreenshot = new File(path + "myScreenshott_" +counter  + ".png");

        try {
            FileOutputStream fos = new FileOutputStream(myScreenshot);
            FileInputStream fis = new FileInputStream(screenshot);
            byte[] data = new byte[fis.available()];
            fis.read(data);
            fos.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}
