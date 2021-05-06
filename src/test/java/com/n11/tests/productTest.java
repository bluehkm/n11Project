package com.n11.tests;

import com.n11.pages.BasePage;
import com.n11.utilities.BrowserUtils;
import com.n11.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class productTest extends TestBase{

    @Test
    public void moduleTest(){
        BasePage base = new BasePage();
        base.login();
        base.login1();
        base.whandle();
        BrowserUtils.waitForVisibility(base.tab,5);
        base.navToMod();

        BrowserUtils.waitForPageToLoad(10);
        base.marka.click();
        base.filter.sendKeys("lacoste");
        base.lacoste.click();
        BrowserUtils.waitForPageToLoad(5);


        base.itemList.get(6).click();
        BrowserUtils.waitForPageToLoad(5);

        String expectedTitle= Driver.get().getTitle();
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

}
