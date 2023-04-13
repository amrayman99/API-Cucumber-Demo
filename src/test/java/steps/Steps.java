package steps;

import com.vodafone.base.Base;
import com.vodafone.page.AddToCart;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class Steps extends Base {

    WebDriver driver;

    AddToCart addToCart;
    public Steps() throws FileNotFoundException {
    }

    @Given("User open website and choose iPhone")
    public void user_open_website_and_choose_i_phone() {
    lunchBrowser();
    }

    @When("User fill Personal info without entering FullName")
    public void user_fill_personal_info_without_entering_full_name(DataTable addressData) {
        addToCart=new AddToCart();
        addToCart.ChooseiPhone();
       // addToCart.ifIphone();
        addToCart.SelectCiy();
        addToCart.fillAddress(addressData.cell(0,0),addressData.cell(0,1),addressData.cell(0,2),addressData.cell(0,3),addressData.cell(0,4),addressData.cell(0,5));
        addToCart.fillPersonalInfo();

    }

    @Then("Error message will appear")
    public void error_message_will_appear() {
        addToCart.assrtFullNameErrMsg();
    }
}
