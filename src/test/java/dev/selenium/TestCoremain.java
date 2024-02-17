package dev.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.FileBackedOutputStream;

import java.io.File;

public class TestCoremain{
    static ChromeDriver driver;

    @BeforeAll /*Ejecutase sempre antes de ejecutar as demais etiquetas (@Test neste caso) */
    public static void start(){
         ChromeOptions options = new ChromeOptions();
         options.addArguments("start-maximized");
         driver = new ChromeDriver(options);
         driver.get("https://www.coremain.com/contacto/");
    }

    @Test
    public void CPR1() throws Exception{
    WebElement textName = driver.findElement(By.name("your-name"));
    textName.sendKeys("Proba de seguridade");
    WebElement textEmail = driver.findElement(By.name("your-email"));
    textEmail.sendKeys("probaSeguridade@proba.com");
    WebElement mensaje = driver.findElement(By.name("your-message"));
        mensaje.sendKeys("proba de páxina web");
    WebElement submit = driver.findElement(By.cssSelector("input[type=submit]"));
        submit.click();
        Thread.sleep(13000);
    WebElement compara = driver.findElement(By.xpath(".//div[@class='wpcf7-response-output']"));
        assertEquals("Thank you for your message. It has been sent.", compara.getText());
    }








    @AfterAll /*Esta etiqueta ejecutase o final de todo, neste caso esta función está reemplazando o driver.quit */
    public static void end(){
      try {
         Thread.sleep(4000);
      }catch (InterruptedException e) {
         e.printStackTrace();
      }
     driver.quit();
    }
}