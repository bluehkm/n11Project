package com.n11.pages;

import com.n11.utilities.BrowserUtils;
import com.n11.utilities.ConfigurationReader;
import com.n11.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(linkText = "Giriş Yap")
    public WebElement login;

    @FindBy(css = ".facebook_large")
    public WebElement facebook;

    @FindBy(id = "email")
    public WebElement userName;

    @FindBy(id = "pass")
    public WebElement password;

    @FindBy(css = "input[id^=u_0_0]")
    public WebElement submit;

    @FindBy(css = "a.menuLink.user")
    public WebElement userLink;

    @FindBy(css = "a[href='https://www.n11.com/kozmetik-kisisel-bakim']")
    public WebElement tab;

    @FindBy //(linkText = "Parfüm & Deodorant")
            (css = "a[href='https://www.n11.com/parfum-ve-deodorant']")
    public WebElement module;

    @FindBy(css = ".filter-items:nth-child(2) > .dropdown-toggle")
    public WebElement marka;

    @FindBy(css = ".shown .dropdown-menu-item")
    public WebElement filter;

    @FindBy(css = "[for='m-Lacoste']")
    public WebElement lacoste;

    @FindBy(css = "li.itemize-piece")
    public List<WebElement> itemList;

    @FindBy(css = "a.addWishListBtn.getWishList")
    public WebElement addFavorite;

    @FindBy(id = "addToFavouriteWishListBtn")
    public WebElement myFavorite;

    @FindBy(css = "span.btn.btnBlack.confirm")
    public WebElement confirm;

    @FindBy(css = ".iconFavorites")
    public WebElement favorite;

    @FindBy(css = ".favorites .listItemTitle")
    public WebElement favList;

    @FindBy(css = "h1.pro-title_main")
    public WebElement expectedProduct;

    @FindBy(css = "h3.productName")
    public WebElement actualProduct;

    @FindBy(css = "div.columnContent.p10>ul")
    List<WebElement> footers;


    public void login() {
        login.click();
        facebook.click();
        BrowserUtils.waitForPageToLoad(3);

        String currentWindowHandle = Driver.get().getWindowHandle();

        Set<String> windowHandles = Driver.get().getWindowHandles();

        for (String handle : windowHandles) {
            System.out.println(handle);

            if (!handle.equals(currentWindowHandle)) {
                Driver.get().switchTo().window(handle);
            }
        }
    }

    public void login1() {
        String user = ConfigurationReader.get("username");
        String pass = ConfigurationReader.get("password");
        userName.sendKeys(user);
        password.sendKeys(pass);
        submit.click();


    }

    public void whandle() {
        String currentWindowHandle = Driver.get().getWindowHandle();

        Set<String> windowHandles = Driver.get().getWindowHandles();

        for (String handle : windowHandles) {
            System.out.println(handle);

            if (!handle.equals(currentWindowHandle)) {
                Driver.get().switchTo().window(handle);
            }
        }
    }

    public void navToMod() {

        BrowserUtils.hover(tab);
        BrowserUtils.waitForVisibility(module, 5);

        module.click();
    }

    public void writeToText() throws IOException {


        System.out.println(System.getProperty("os.name"));

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/textFile.txt";

        String fullPath = projectPath + "/" + filePath;
        System.out.println(fullPath);

        File file = new File(fullPath);
        FileWriter fw = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fw);

        for (WebElement footer : footers) {

            writer.write(footer.getText());
            writer.newLine();

        }

        writer.close();
    }

    public List<String> readFile() throws IOException {

        System.out.println(System.getProperty("os.name"));

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/textFile.txt";

        String fullPath = projectPath + "/" + filePath;
        System.out.println(fullPath);

        File file = new File(fullPath);
        FileReader r = new FileReader(file);
        BufferedReader reader = new BufferedReader(r);
        List<String> texts = new ArrayList<>();

        String strLine;
        //Read File Line By Line
        while ((strLine = reader.readLine()) != null) {
            // Print the content on the console

            texts.add(strLine);

        }
        reader.close();

        return texts;


    }

}
