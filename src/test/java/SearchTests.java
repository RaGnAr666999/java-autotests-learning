import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {

    static {
        // Google РѕРїСЂРµРґРµР»СЏРµС‚ Selenium РїРѕ РїСЂРёР·РЅР°РєР°Рј Р°РІС‚РѕРјР°С‚РёР·Р°С†РёРё Рё РїРѕРєР°Р·С‹РІР°РµС‚ РєР°РїС‡Сѓ.
        // Р­С‚Рё РЅР°СЃС‚СЂРѕР№РєРё СѓР±РёСЂР°СЋС‚ Р·Р°РјРµС‚РЅС‹Рµ РїСЂРёР·РЅР°РєРё, Рё РІС‹РґР°С‡Р° РѕС‚РєСЂС‹РІР°РµС‚СЃСЏ РєР°Рє Сѓ РѕР±С‹С‡РЅРѕРіРѕ РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        Configuration.browserCapabilities = options;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulSearchTestGoogle() {
        open("https://www.google.com/");

        $("[name=q]").setValue("selenide").pressEnter();

        $("[id=search]").shouldHave(text("selenide.org"), Duration.ofSeconds(30));
    }

    @Test
    void successfulSearchTestDuckDuckGo() {
        open("https://duckduckgo.com/");

        $("[name=q]").setValue("selenide").pressEnter();

        $("[data-testid=result]").shouldHave(text("selenide.org"), Duration.ofSeconds(30));
    }
}
