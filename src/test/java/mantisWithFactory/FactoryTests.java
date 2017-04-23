package mantisWithFactory;

import com.spbstu.MantisSite;
import mantisWithFactory.helper.LoadFromResources;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by luck on 09.04.17.
 */

public class FactoryTests extends BaseTest {

    @Test
    public void contactFormTest() throws Exception {
        MantisSite.open();
        MantisSite.homePage.login(LoadFromResources.getUser("administrator"));
        MantisSite.createAnIssue.writeAnIssue(LoadFromResources.getIssue("issue_1"));
        MantisSite.createAnIssue.submitIssue();

        // TODO
        Assert.assertTrue(MantisSite.testAfterDeleting.isContains(LoadFromResources.getIssue("issue_1").getSummary()));   //check that the issue is creating, when i'm admin

        MantisSite.logOut.clickOnLogOutSpan();

        MantisSite.homePage.login(LoadFromResources.getUser("user_1"));

        Assert.assertTrue(MantisSite.testIsAssignedToUsername.isContains(LoadFromResources.getUser("user_1").getLogin()));

        // TODO

    }

}
