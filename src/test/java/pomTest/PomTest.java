package pomTest;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.microsoft.playwright.options.AriaRole.TEXTBOX;
import static utilities.Hooks.page;

@Listeners(utilities.Hooks.class)
public class PomTest {



    @Epic("epic bilgisi")
    @Story("User story bilgisi")
    @Description("Aciklama bilgisi")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void login() throws InterruptedException {

        Locator phoneNumber = page.getByRole(TEXTBOX,new Page.GetByRoleOptions().setName("Telefon"));
        Allure.step("Test adimlari kismi", () -> {
            phoneNumber.click();
            phoneNumber.fill("590-345");

            Thread.sleep(2000);
        });






    }















}
