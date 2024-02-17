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

public class ChromeTest{

 static ChromeDriver driver;

 @BeforeAll /*Ejecutase sempre antes de ejecutar as demais etiquetas (@Test neste caso) */
 public static void start(){
      ChromeOptions options = new ChromeOptions();
      options.addArguments("start-maximized");
      driver = new ChromeDriver(options);
      driver.get("https://www.selenium.dev/selenium/web/web-form.html");
 }

 @Test  
 public void test() throws InterruptedException{
    
    //Thread.sleep(5000);
    //System.out.println(driver.getTitle());
    WebElement textInput = driver.findElement(By.id("my-text-id"));
    textInput.sendKeys("alejandro");
    Thread.sleep(3000);
    WebElement boton = driver.findElement(By.className("btn"));
    boton.click();
    WebElement mensaje = driver.findElement(By.id("message"));
    System.out.println(mensaje.getText());
    assertEquals("Received!", mensaje.getText()); /*Compara un string e unha variable para verificar que sean iguales */
    Thread.sleep(3000);
    //driver.quit();
    
 }
 @Test  
 public void basicOption() throws InterruptedException{
   
    driver = new ChromeDriver();
    driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    WebElement checkBox = driver.findElement(By.id("my-check-1"));
    /*Facer click no elemento */
    checkBox.click();
    Thread.sleep(3000);
    assertEquals(false, checkBox.isSelected());
    //assertTrue(checkBox.isSelected());
    WebElement escrbir = driver.findElement(By.name("my-disabled"));
    escrbir.sendKeys("non deixa");
    assertEquals("non deixa", escrbir.getText());
    Thread.sleep(3000);
    //driver.quit();

 }

 @Test  
 public void subirFoto() throws Exception{
   driver = new ChromeDriver();
   String nombreImagen = "perro.jpg";
   driver.get("https://the-internet.herokuapp.com/upload");
   File uploadFile = new File("src/test/files/"+nombreImagen);
   WebElement fileInput  = driver.findElement(By.cssSelector("input[type=file]"));
   fileInput.sendKeys(uploadFile.getAbsolutePath());
   WebElement enviar = driver.findElement(By.id("file-submit"));
   enviar.click();
   WebElement comprobar = driver.findElement(By.id("uploaded-files"));
   assertEquals(nombreImagen, comprobar.getText());  /*Compara perro.jpg co texto */
   Thread.sleep(3000);
   //driver.quit();
}

 @Test
 public void selectFormularios() throws Exception{
   WebElement select = driver.findElement(By.name("my-select"));
   Select comboSelect = new Select(select);
   comboSelect.selectByIndex(2);
 }
 @Test
 public void calendario() throws Exception{
   WebElement calendario = driver.findElement(By.name("my-date"));
   calendario.sendKeys("01/30/2024");
   Thread.sleep(2000);
   calendario.sendKeys(Keys.TAB);
 }

 @Test
 public void radio () throws Exception{
   
 }

 @AfterAll /*Esta etiqueta ejecutase o final de todo, neste caso esta función está reemplazando o driver.quit */
 public static void end(){
   try {
      Thread.sleep(2000);
   }catch (InterruptedException e) {
      e.printStackTrace();
   }
   driver.quit();
 }
}