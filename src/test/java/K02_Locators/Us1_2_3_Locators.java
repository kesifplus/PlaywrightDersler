package K02_Locators;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import javax.security.auth.login.LoginContext;
import java.awt.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Us1_2_3_Locators {
    public static void main(String[] args) throws InterruptedException {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.setViewportSize(width, height);

        page.navigate("https://test.urbanicfarm.com/");
        System.out.println("title" + page.title());

        Locator blog = page.locator("//div[@id='navbarElement']").getByText("Blog");
        //blog.click();
        assertThat(blog).hasText("Blog");


        Locator farmersMarket = page.locator("#navbarElement :text('farmers market ')");
        //Matching is case-insensitive, trims whitespace and searches for a substring.

        // Locator farmersMarket = page.locator("#navbarElement :has-text('Farmers Market')"); 2 tane buldugu icin hata verdi
       // Locator farmersMarket = page.locator("#navbarElement").getByText("Farmers Market");
       // Locator farmersMarket = page.locator("#navbarElement :text-is('Farmers Market')");  it is case-sensitive
        //farmersMarket.click();
        assertThat(farmersMarket).hasText("Farmers Market");


        // Locator explore = page.locator("//a[@class='Navbar_textLink__f6_Al mr-4']").nth(2);
        Locator explore = page.locator(":nth-match(:text('Explore'), 1)");
        //explore.click();
        assertThat(explore).hasText("Explore");

        Locator aboutUs = page.getByText("About Us").first();
        assertThat(aboutUs).hasText("About Us");
        //aboutUs.click();

        Locator contactUs = page.locator("//a[@class='Navbar_textLink__f6_Al mr-4']").nth(4);
        assertThat(contactUs).hasText("Contact Us");
        //contactUs.click();

        Locator login = page.locator("//div[@id='navbarElement']//a[@href='/auth/login']");
        assertThat(login).hasText("Login");
        //login.click();

        Locator register = page.locator("#navbarElement :text('Register'), #navbarElement :text('Sign in')");
        assertThat(register).hasText("Register");
        register.click();



        Thread.sleep(3000);

        page.close();
        browser.close();
        playwright.close();

    }

}
