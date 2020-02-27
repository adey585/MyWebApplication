import pageobject.AccountPage;
import java.io.IOException;

public class SubBase extends Base {

    public String testDataFilePath = "C:\\Users\\iamam\\Desktop\\BunceePract\\Application\\src\\test\\TestData\\test_data.xlsx";

    public String userName = readFromExcel(testDataFilePath, "Account", "B2");
    public String password = readFromExcel(testDataFilePath, "Account", "C2");

    public SubBase() throws IOException { }

    public void loginToAccount() throws InterruptedException {
        clickByXpath(AccountPage.loginLinkXPath);
        sendTextByXpath(AccountPage.userNameFieldXPath, userName);
        clickByXpath(AccountPage.nextButtonXPath);
        sendTextByXpath(AccountPage.passwordFieldXPath, password);
        clickByXpath(AccountPage.loginButtonXPath);
        clickByXpath(AccountPage.profileLogoXPath);
        clickByXpath(AccountPage.profileLogoXPath);
        Thread.sleep(2000);
    }

    public void logoutFromAccount() throws InterruptedException {
        clickByXpath(AccountPage.profileLogoXPath);
        clickByXpath(AccountPage.logoutButtonXPath);
        Thread.sleep(2000);
    }

}
