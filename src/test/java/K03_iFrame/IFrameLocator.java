package K03_iFrame;

import com.microsoft.playwright.*;

import java.awt.*;

public class IFrameLocator {
    public static void main(String[] args) throws InterruptedException {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.setViewportSize(width, height);

        page.navigate("https://the-internet.herokuapp.com/iframe");

        Locator title = page.locator("h3");
        System.out.println("title" + title.innerText());

        // Frame locator
        FrameLocator frameLocator = page.frameLocator("#mce_0_ifr");

        Locator textArea = frameLocator.getByAltText("Your content goes here.");
        textArea.click();
        textArea.clear();

        Locator inputText = frameLocator.getByLabel("Rich Text Area. Press ALT-0 for help.");
        inputText.fill("merhabalar");


        page.frameLocator("//iframe[@title='Rich Text Area']").getByAltText("Your content goes here.").click();
        page.frameLocator("//iframe[@title='Rich Text Area']").getByLabel("Rich Text Area. Press ALT-0 for help.").fill("merhaba");



        Thread.sleep(2000);

        Locator elemantalSeleniumText = page.getByText("Elemental Selenium");
        System.out.println(elemantalSeleniumText.innerText());

        page.close();
        browser.close();
        playwright.close();

    }
}
