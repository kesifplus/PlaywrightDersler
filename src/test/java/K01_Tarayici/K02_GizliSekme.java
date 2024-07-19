package K01_Tarayici;

import com.microsoft.playwright.*;

public class K02_GizliSekme {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("http://playwright.dev");
        System.out.println(page.title());

        page.close();
        context.close();
        browser.close();















    }
}
