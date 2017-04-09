package mantisWithFactory;

import com.spbstu.MantisSite;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by luck on 09.04.17.
 */

public class FactoryTests extends BaseTest {

    @Test
    public void contactFormTest(){
        MantisSite.open();
        MantisSite.homePage.login("administrator", "root");
        MantisSite.contactFormPage.fillContactForm("SoHelpMeGod", "Yeah! I managed to do this!");
        MantisSite.contactFormPage.submitContactForm();

        int i = MantisSite.deleteIssue.searchIssue();
        MantisSite.deleteIssue.clickOnID(i);
        MantisSite.deleteIssue.clickOnDelete();
        MantisSite.deleteIssue.clickOnDeleteIssues();

        MantisSite.testAfterDeleting.check();


        // assert
    }

}
