import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class AccountFeature extends SubBase {

    public AccountFeature() throws IOException { }

    @Test(priority = 1, enabled = true)
    public void login() throws Exception {
        try {
            loginToAccount();
            Assert.assertEquals(driver.getTitle(), "Dashboard");
        } catch (Exception e) {
            takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());
            Assert.fail();//Example of taking screening shot when test fails: if code gets interrupted
            //in try block it will fail the test also it wil take a screen shot
        }
    }

    @Test(priority = 2, enabled = false)
    public void logout() throws InterruptedException {
        loginToAccount();
        logoutFromAccount();
        System.out.println("Committing and pushing newly added test cases to git hub");
    }

}
