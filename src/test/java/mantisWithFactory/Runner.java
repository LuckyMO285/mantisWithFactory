package mantisWithFactory;

/**
 * Created by luck on 23.04.17.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/resources/features"},
        glue = {"mantisWithFactory.stepdefs"}
)

public class Runner {

}
