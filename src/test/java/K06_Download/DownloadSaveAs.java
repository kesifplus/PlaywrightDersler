package K06_Download;

import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Paths;

public class DownloadSaveAs {
    public static void main(String[] args) throws InterruptedException {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.setViewportSize(width, height);

        page.navigate("https://demoqa.com/upload-download");


        // Wait for the download to start
        Download download = page.waitForDownload(() -> {
            // Perform the action that initiates download
            page.getByText("Download").last().click();
        });

        // Wait for the download process to complete and save the downloaded file somewhere
        String filePath = System.getProperty("user.home") + "/Downloads/";

        download.saveAs(Paths.get(filePath, download.suggestedFilename()));
        System.out.println(download.suggestedFilename());


        Thread.sleep(2000);
        page.close();
        browser.close();
        playwright.close();


    }

}