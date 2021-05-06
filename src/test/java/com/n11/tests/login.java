package com.n11.tests;

import com.n11.pages.BasePage;
import com.n11.utilities.BrowserUtils;
import com.n11.utilities.ConfigurationReader;
import com.n11.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class login extends TestBase{


@Test
 public void loginTest () {
 extentLogger = report.createTest("N11 Test");
 BasePage base = new BasePage();
 base.login();
 base.login1();
 base.whandle();
 BrowserUtils.waitForVisibility(base.userLink,5);
 Assert.assertEquals(base.userLink.getText(), "Hikmet Maviyıldız");

}


@Test
public void moduleTest(){
BasePage base = new BasePage();
base.login();
base.login1();
base.whandle();
BrowserUtils.waitForVisibility(base.tab,5);
base.navToMod();
//base.whandle();
BrowserUtils.waitForPageToLoad(10);
base.marka.click();
base.filter.sendKeys("lacoste");
base.lacoste.click();
BrowserUtils.waitForPageToLoad(5);
//base.whandle();

base.itemList.get(6).click();
BrowserUtils.waitForPageToLoad(5);
//base.whandle();
String expectedTitle=Driver.get().getTitle();
System.out.println(expectedTitle);
String expectedProduct= base.expectedProduct.getText();
base.addFavorite.click();
BrowserUtils.waitForClickablility(base.myFavorite,3);
base.myFavorite.click();
BrowserUtils.waitForClickablility(base.confirm,3);
base.confirm.click();

base.favorite.click();

base.favList.click();
System.out.println(Driver.get().getTitle());

String actualProduct=base.actualProduct.getText();
 System.out.println(base.actualProduct.getText());
 Assert.assertEquals(actualProduct,expectedProduct);

 }

 @Test
 public void footerTest() throws IOException {
  BasePage base = new BasePage();
  BrowserUtils.waitForVisibility(base.tab,5);
  WebElement m=Driver.get().findElement(By.linkText("Markalar"));
  BrowserUtils.scrollToElement(m);
  base.writeToText();


List<WebElement> actual=Driver.get().findElements(By.xpath("//*[@id=\"footer\"]/div/div[2]/div[2]/div/ul"));
  System.out.println(BrowserUtils.getElementsText(actual));
List<String>actuel=new ArrayList<>();
for(WebElement el:actual){
    actuel.add(el.getText());
 System.out.println(el.getText());
 if (base.readFile().contains(el.getText())){
  System.out.println("pass");
 }else {
  System.out.println("fail");
 }
}

m.click();
BrowserUtils.waitForPageToLoad(4);

List<WebElement>markalar=Driver.get().findElements(By.cssSelector("ul.result"));

System.out.println(BrowserUtils.getElementsText(markalar).size());


  }

 }






