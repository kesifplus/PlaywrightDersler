package K05_Actions;

import com.microsoft.playwright.*;

import java.awt.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckBoxesRadioButtons {
    public static void main(String[] args) throws InterruptedException {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.setViewportSize(width, height);

        page.navigate("https://demoqa.com/automation-practice-form");

        // Checkboxes and radio buttons
        Locator maleRadioButton = page.locator("//label[@for='gender-radio-1']");
        maleRadioButton.check();
        assertThat(maleRadioButton).isChecked();
        Thread.sleep(3000);

        Locator sportsCheckboxes = page.locator("//label[@for='hobbies-checkbox-2']");
        sportsCheckboxes.check();
        assertThat(sportsCheckboxes).isChecked();
        Thread.sleep(3000);


        page.close();
        browser.close();
        playwright.close();

    }
}