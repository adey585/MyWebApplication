import org.testng.annotations.Test;

import java.io.IOException;

public class AccountFeature extends SubBase {

    public AccountFeature() throws IOException { }

//    @Test
//    public void login() throws InterruptedException{
//        loginToAccount();
//    }

    @Test
    public void logout() throws InterruptedException {
        loginToAccount();
        logoutFromAccount();
    }


}
