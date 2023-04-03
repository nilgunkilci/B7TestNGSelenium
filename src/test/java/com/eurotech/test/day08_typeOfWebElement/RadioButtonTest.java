package com.eurotech.test.day08_typeOfWebElement;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
    @Test
    public void testAsil() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");

        WebElement vegetablesRadio = driver.findElement(By.xpath("//div[text()='Vegetables']/../input"));

        System.out.println("vegetablesRadio.isSelected() = " + vegetablesRadio.isSelected());

        Assert.assertTrue(vegetablesRadio.isSelected(), "Verify that vegetableRadio is selected");

        WebElement legumesRadio = driver.findElement(By.xpath("//div[text()='Legumes']/../input"));

        Assert.assertFalse(legumesRadio.isSelected(), "verify that legumesRadio is NOT selected");

        //legumesRadio.click();//ElementNotInteractableException: element not interactable

        WebElement legumesClickable = driver.findElement(By.xpath("//div[text()='Legumes']/../div"));
        legumesClickable.click();

        Thread.sleep(2000);
        Assert.assertTrue(legumesRadio.isSelected());
        Assert.assertFalse(vegetablesRadio.isSelected());

        driver.close();

    }

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");
        driver.manage().window().maximize();

        //  WebElement vegetablesRadio = driver.findElement(By.xpath("//div[text()='Vegetables']"));   // Vegetables radio button a gidiyoruz
        //  System.out.println(vegetablesRadio.isSelected());       // isSelected() ile buttonun secili olup olmadigina bakiyoruz
        // sonuc false cikiyor.cünkü bit vegetables text ini kontrol ettik. butonu isaret eden web elementi locator etmeliyiz

        WebElement vegetablesRadiobutton = driver.findElement(By.xpath("//div[text()='Vegetables']/../input"));
        System.out.println("vegetablesRadiobutton.isSelected() = " + vegetablesRadiobutton.isSelected());
        // önce vegetables butonunu temsil eden elemnti locaet ettik.
        // sonra butonunun secili olup olmadigini kontrol ettik. Ve  sonuc true döner.

        Assert.assertTrue(vegetablesRadiobutton.isSelected(), "Verify that vegetableRadio is selected");
        // Assert.assertTrue() metodu kondition true mu döner demek.
        // eger true ise hicbir sonuc göstermez . yani test gecer.
        // yanlis ise test gecmez.yazilan mesaji gösterir.

        WebElement nutsButton = driver.findElement(By.xpath("//div[text()='Nuts']"));
        // Assert.assertTrue(nutsButton.isSelected(),"Verify that Nuts button is NOT selected");
        // Expected :true, actuel: False oldugu icin konsoda su hata görülür.
        // java.lang.AssertionError: Verify that Nuts button is NOT selected
        Assert.assertFalse(nutsButton.isSelected());
        // Assert.assertFalse() -->kondition false mi diye soruluyor.
        // Bundan dolayi kondition false olsugu icin test gecer.

        WebElement nutsButtons2 = driver.findElement(By.xpath("//div[text()='Nuts']/../input"));
        Assert.assertFalse(nutsButtons2.isSelected());
        //   nutsButtons2.click(); // hata verir .ElementNotInteractableException: element not interactable.
        // cunku tiklama web elementini bulmaliyiz
        WebElement nutsButton3 = driver.findElement(By.xpath("//div[text()='Nuts']/../div"));
        // nutsButtons2=driver.findElement(By.xpath("//div[text()='Nuts']/../div"));
        //nutsButton3.click();
        // Assert.assertTrue(nutsButton3.isSelected());

        WebElement legumesClickable = driver.findElement(By.xpath("//div[text()='Legumes']/../div"));
        //  legumesClickable.click();

        Thread.sleep(2000);


        Thread.sleep(2000);
        driver.close();


    }
}
