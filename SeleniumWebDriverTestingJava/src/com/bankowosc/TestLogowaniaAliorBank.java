package com.bankowosc;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.webdriven.commands.Click;


public class TestLogowaniaAliorBank {

    public static void main(String[] args) throws InterruptedException
    {
 
        //Uruchomienie przegl¹darki
        WebDriver driver = new FirefoxDriver();
        
        //Otworzenie strony Alior Bank
        driver.get("https://www.aliorbank.pl");
        
        //Przejœcie do bankowosci internetowej - pobranie nazwy klasy obiektu button
        driver.findElement(By.className("login")).click();

        // Przejscie do nowego okna
        for(String winHandle : driver.getWindowHandles()){
         driver.switchTo().window(winHandle);
        }
        
        //Wpisanie numeru klienta - pobranie id obiektu
        driver.findElement(By.id("inputContent")).sendKeys("1234567890");
        driver.findElement(By.className("button")).click();
        
        //Uzupe³nienie pol maskowanych jedynkami
        for(int i =0; i < 4; i++) {
            driver.switchTo().activeElement().sendKeys("1");
        }
        
        //Zalogowanie
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        
        
        //Sprawdzenie czy aplikacja wyœwietla b³¹d podczas logowania
        if(driver.getPageSource().contains("B³¹d podczas logowania")) {
            
            System.out.println(driver.getTitle());
            System.out.println("TEST PASSED"); 
        }
        
        else {
            System.out.println(driver.getTitle());
            System.err.println("TEST FAILED");  
        }
    }
}
