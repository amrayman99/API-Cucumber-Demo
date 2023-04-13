package com.vodafone.page;

import com.vodafone.base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class AddToCart extends Base {
    public AddToCart() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(partialLinkText = "English")
    public WebElement English_Language;

    @FindBy( css = "img[src='https://eshop.vodafone.com.eg/eshopContent//product_images/original/applelogo.png']")
    public WebElement AppleLogo;

    @FindBy(xpath = "//*[@class='btn btn-grey productList-button']")
    public WebElement ViewMoretButton;

    @FindBy (partialLinkText = "iPhone 13 (128 GB)")
    public WebElement iPhone;

    @FindBy(xpath = "//*[@class='brandContainer-brands-list-brandCard']")
    public WebElement BrandsConatiner;

    @FindBy (css = ".btn.btn-red.btn-block.fontLightEnAr")
    public WebElement Basket_Button;
//    @FindBy (xpath = "//button[@class='btn btn-red btn-block fontLightEnAr'][contains(.,'Add to basket')]")
//    public WebElement Basket_Button;

    @FindBy (xpath ="/html/body/app-root/div/app-shoping-cart/div/div[1]/div[2]/div[2]/div[2]/div/div[3]/button")
    public WebElement proccedToCheckOut;

    @FindBy (xpath ="//*[@id=\"headingOne\"]/div[1]/select")
    public WebElement SelectGovDropDownList;

    @FindBy (xpath = "//*[@id=\"headingOne\"]/div[2]/select")
    public WebElement SelectCityDropDownList;


    @FindBy(xpath = "//p[contains(text(),'Deliver to my Address')]")
    public WebElement DliverToAddressCard;

    @FindBy(xpath = "//*[@formcontrolname='buildingNumber']")
    public WebElement BuildingNoTxtField;

    @FindBy(xpath = "//*[@formcontrolname='floorNumber']")
    public WebElement FloorNoTxtField;

    @FindBy(xpath = "//*[@formcontrolname='appartmentNumber']")
    public WebElement AppartmentNoTxtField;

    @FindBy(xpath = "//*[@formcontrolname='landLine']")
    public WebElement LandMarkTxtField;

    @FindBy(xpath = "//*[@formcontrolname='addressName']")
    public WebElement AddressNameTxtField;

    @FindBy(xpath = "//*[@formcontrolname='address1']")
    public WebElement StreetNameTxtField;

    @FindBy(xpath = "//button[contains(text(),' Continue ')]")
    public WebElement ContinueButton;

    @FindBy(xpath = "//*[@formcontrolname='email']")
    public WebElement EmailTxtField;

    @FindBy(xpath = "//*[@formcontrolname='phoneNum']")
    public WebElement PhoneNumTxtField;

    @FindBy(xpath = "//*[@formcontrolname='landLine']")
    public WebElement landLineTxtField;

//    @FindBy(xpath = "//div[contains(text(),'Please enter a valid name')]")
//    public WebElement NameErrMsg;

    @FindBy(xpath = "//*[@id='shippingAddressContinue']")
    public WebElement PrsnlInfoContinueButton;


    @FindBy(xpath = "//div[contains(text(),'Please enter a valid name')]")
    public WebElement NameErrMsg;



    public void ifIphone(){

        English_Language.click();
        js.executeScript("arguments[0].click()",AppleLogo);

        while (true) {

            if (iPhone.isDisplayed()) {

                js.executeScript("arguments[0].click()",iPhone);
                break; }

            else {

                js.executeScript("arguments[0].click()", ViewMoretButton);
            }
        }
    }

    public void click_on_viewMore(){

        for (int i = 0; i < 3; i++) {
            js.executeScript("arguments[0].click()", ViewMoretButton);
        }
    }


    public void ChooseiPhone(){

        English_Language.click();
        js.executeScript("arguments[0].click()",AppleLogo);
        click_on_viewMore();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("iPhone 13 Pro")));
        js.executeScript("arguments[0].click()",iPhone);
      // wait.until(ExpectedConditions.elementToBeClickable(Basket_Button));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        js.executeScript("arguments[0].click()",Basket_Button);
        js.executeScript("arguments[0].click()",proccedToCheckOut);
    }

    public void SelectCiy(){
        Select select = new Select(SelectGovDropDownList);
        select.selectByVisibleText(" Giza ");
        Select selCity= new Select(SelectCityDropDownList);
        selCity.selectByIndex(1);
    }

    public void fillAddress(String street, String buldiNo, String florNo, String appartNo, String landMark,String addressNa){

        wait.until(ExpectedConditions.elementToBeClickable(DliverToAddressCard));
        js.executeScript("arguments[0].click()",DliverToAddressCard);
        StreetNameTxtField.sendKeys(street);
        BuildingNoTxtField.sendKeys(buldiNo);
        FloorNoTxtField.sendKeys(florNo);
        AppartmentNoTxtField.sendKeys(appartNo);
        LandMarkTxtField.sendKeys(landMark);
        AddressNameTxtField.sendKeys(addressNa);
        js.executeScript("arguments[0].click()",ContinueButton);

    }

    public void fillPersonalInfo(){

//        EmailTxtField.sendKeys("amrayman270@gmail.com");
//        PhoneNumTxtField.sendKeys("01032843243");
//        wait.until(ExpectedConditions.elementToBeClickable(landLineTxtField));
//        landLineTxtField.sendKeys("055395614");
        js.executeScript("arguments[0].click()",PrsnlInfoContinueButton);
    }

    public void assrtFullNameErrMsg(){

        Assert.assertTrue(NameErrMsg.isDisplayed());
    }

}
