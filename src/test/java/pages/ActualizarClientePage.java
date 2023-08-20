package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ActualizarClientePage {
    private WebDriver driver;
    private By pageTitle = By.xpath("/html/body/section/div/h1");
    private By clientesButton = By.xpath("//*[@id='menucliente']/button");

    public ActualizarClientePage (WebDriver driver){
        this.driver = driver;
    }

    public void clickClient (){
        driver.findElement(clientesButton).click();
    }
    public String getTitle(){

        List<WebElement> datosTabla =  driver.findElements(By.xpath("td"));
        for (WebElement element:datosTabla){
            System.out.println(element.getText());
        }




        return driver.findElement(pageTitle).getText();



    }


}
