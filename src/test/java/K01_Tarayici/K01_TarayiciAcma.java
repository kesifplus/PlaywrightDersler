package K01_Tarayici;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class K01_TarayiciAcma {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        //Browser browser = playwright.chromium().launch(); // Bu sekilde tarayici acilmadan calisir.
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("http://playwright.dev");

        System.out.println(page.title());


        page.close();
        browser.close();
        playwright.close();

    }


}
