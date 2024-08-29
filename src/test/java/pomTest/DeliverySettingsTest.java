package pomTest;

import Pages.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.PropertyUtils;

import static utilities.Hooks.page;

@Listeners(utilities.Hooks.class)
public class DeliverySettingsTest {

    LoginPage loginPage = new LoginPage();


    @Epic("change delivery setting")
    @Story("User story bilgisi")
    @Description("Aciklama bilgisi")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void login() throws InterruptedException {

        page.locator(loginPage.loginButton).click();

        page.getByPlaceholder(loginPage.email).fill(PropertyUtils.getProperty("email"));
        page.getByPlaceholder(loginPage.password).fill(PropertyUtils.getProperty("password"));
        page.locator(loginPage.LoginButton2).click();

        Thread.sleep(2000);





    }





















}
