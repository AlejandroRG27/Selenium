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

public class TestCodebit2{
    static ChromeDriver driver;

    @BeforeAll /*Ejecutase sempre antes de ejecutar as demais etiquetas (@Test neste caso) */
    public static void start(){
         ChromeOptions options = new ChromeOptions();
         options.addArguments("start-maximized");
         driver = new ChromeDriver(options);
         driver.get("https://codebit.com/es-ES/codebit-compra/SCB210");
    }


    @Test
    public void ProbaCodebit() throws Exception{
      WebElement cantidadProducto = driver.findElement(By.name("cantidad_producto"));
      cantidadProducto.sendKeys("4");//Non modifica a opción existente, añade o número ao valor xa predeterminado
      Thread.sleep(2000);
      WebElement refrescar1 = driver.findElement(By.xpath(".//span[@class='col-md-2 fa fa-refresh compra-producto-cantidad']"));
      refrescar1.click();//Non diferencian os botóns de refrescar
      Thread.sleep(2000);
      WebElement cantidadLicencia = driver.findElement(By.name("cantidad_licencia"));
      cantidadLicencia.sendKeys("5");//Modifica Ok
      Thread.sleep(2000);
      WebElement refrescar2 = driver.findElement(By.xpath(".//span[@class='col-md-2 fa fa-refresh compra-producto-cantidad']"));
      refrescar2.click();//Non diferencian os botóns de refrescar
      Thread.sleep(2000);
      WebElement checkbox = driver.findElement(By.name("exento"));
      checkbox.click();//cliquea ok




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