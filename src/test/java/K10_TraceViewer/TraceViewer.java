package K10_TraceViewer;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.awt.*;
import java.nio.file.Paths;

public class TraceViewer {
    public static void main(String[] args) throws InterruptedException {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context =  browser.newContext();

        // Start tracing before creating / navigating a page.
        context.tracing().start(new Tracing.StartOptions().
                setScreenshots(true).
                setSnapshots(true).
                setSources(true));

        Page page = context.newPage();

        page.setViewportSize(width,height);

        page.navigate("https://getir.com/");

        Locator phoneNumber = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Telefon Numarası"));
        System.out.println("phone number " + phoneNumber.innerText());

        phoneNumber.click();
        phoneNumber.fill("5555555555");

        Thread.sleep(5000);

        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));



        context.close();
        page.close();
        playwright.close();


















    }
}
