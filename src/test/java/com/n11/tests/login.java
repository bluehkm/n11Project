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




 }






