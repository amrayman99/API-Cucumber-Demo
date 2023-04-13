package steps;

import com.vodafone.base.Base;
import io.cucumber.java.After;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Hooks extends Base {


        public Hooks() {
    }

    @After
    public void runsAfterAnyScenario(){
      //  driver.quit();
    }
}
