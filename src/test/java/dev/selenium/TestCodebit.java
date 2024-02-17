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

public class TestCodebit{
    static ChromeDriver driver;

    @BeforeAll /*Ejecutase sempre antes de ejecutar as demais etiquetas (@Test neste caso) */
    public static void start(){
         ChromeOptions options = new ChromeOptions();
         options.addArguments("start-maximized");
         driver = new ChromeDriver(options);
         driver.get("https://codebit.com/es-ES/codebit-contacto");
    }

    @Test
    public void ProbaCodebit() throws Exception{
      WebElement name = driver.findElement(By.id("name_contact"));
      name.sendKeys("Proba nome");
      WebElement email = driver.findElement(By.id("email_contact"));
      email.sendKeys("proba@proba.com");
      WebElement tel = driver.findElement(By.id("phone_contact"));
      tel.sendKeys("999999999");
      WebElement mensaje = driver.findElement(By.id("message_contact"));
      mensaje.sendKeys("Esto é unha proba de seguridade.");
      WebElement checkbox = driver.findElement(By.xpath(".//label"));
      Thread.sleep(5000);
      checkbox.click();//Non permite facer click no checbox, solo no texto
      WebElement submit = driver.findElement(By.id("btnEnviar"));
      submit.click();
      Thread.sleep(3000);
      WebElement compara = driver.findElement(By.className("close"));
      assertEquals("×", compara.getText());//Non permite facer comparación de texto de texto, solo coa x de cerrar.

    }






    @AfterAll /*Esta etiqueta ejecutase o final de todo, neste caso esta función está reemplazando o driver.quit */
    public static void end(){
      try {
         Thread.sleep(3000);
      }catch (InterruptedException e) {
         e.printStackTrace();
      }
      driver.quit();
    }
}