package mantisWithFactory.stepdefs;

import com.spbstu.MantisSite;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import mantisWithFactory.helper.LoadFromResources;
import org.testng.Assert;

/**
 * Created by luck on 23.04.17.
 */
public class MyStepdefs {
    @Given("^Log in as \"([^\"]*)\"$")
    public void logInAs(String userKey) throws Throwable {
        MantisSite.open();
        MantisSite.homePage.login(LoadFromResources.getUser(userKey));
    }

    @And("^Open create Task page and Create Task using \"([^\"]*)\"$")
    public void openCreateTaskPageAndCreateTaskUsing(String issueID) throws Throwable {
        MantisSite.createAnIssue.writeAnIssue(LoadFromResources.getIssue(issueID));
        MantisSite.createAnIssue.submitIssue();
    }

    @And("^Check that \"([^\"]*)\" was created$")
    public void checkThatWasCreated(String issueID) throws Throwable {
        Assert.assertTrue(MantisSite.testAfterDeleting.isContains(LoadFromResources.getIssue(issueID).getSummary()));   //check that the issue is creating, when i'm admin

    }

    @And("^Log out$")
    public void logOut() throws Throwable {
        MantisSite.logOut.clickOnLogOutSpan();
    }

    @Then("^\"([^\"]*)\" see that issue was created$")
    public void seeThatIssueWasCreated(String userID) throws Throwable {
        Assert.assertTrue(MantisSite.testIsAssignedToUsername.isContains(LoadFromResources.getUser(userID).getLogin()));
    }
}
