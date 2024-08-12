package K09_VideoRecording;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Video {
    public static void main(String[] args) throws InterruptedException {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyy").format(new Date());
        String filePath = System.getProperty("user.dir") + "/src/test/java/utilities/video/" + tarih;

        BrowserContext context = browser.newContext(new Browser.NewContextOptions().
                setRecordVideoDir(Paths.get(filePath)).setRecordVideoSize(width,height));


        Page page = context.newPage();
        page.setViewportSize(width,height);

        page.navigate("https://getir.com/");

        Locator phoneNumber = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Telefon Numarası"));
        System.out.println("phone number " + phoneNumber.innerText());

        phoneNumber.click();
        phoneNumber.fill("5555555555");

        Thread.sleep(5000);

        Path path = page.video().path();
        System.out.println("path = " + path);

        context.close();

        //page.video().saveAs(Paths.get(filePath + "test"));
        //page.video().delete();


        page.close();
        playwright.close();











    }
}
