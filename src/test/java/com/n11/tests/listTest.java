package com.n11.tests;

import com.n11.pages.BasePage;
import com.n11.utilities.BrowserUtils;
import com.n11.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class listTest extends TestBase{

    @Test
    public void footerTest() throws IOException {
        BasePage base = new BasePage();
        BrowserUtils.waitForVisibility(base.tab,5);
        WebElement m= Driver.get().findElement(By.linkText("Markalar"));
        BrowserUtils.scrollToElement(m);
        base.writeToText();
        List<String> actual=new ArrayList<>();
        for (int i=2; i<=5; i++){
            String path="//*[@id=\"footer\"]/div/div[2]/div["+i+"]/div/ul/li";
            List<WebElement> foot=Driver.get().findElements(By.xpath(path));
            for(WebElement el:foot){
                actual.add(el.getText());

            }
        }

        Assert.assertEquals(actual.size(), base.readFile().size());

    }

}
