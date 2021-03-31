import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TestWithSelenide {

    PageObjects po = new PageObjects();

    @Test
    void searchIssue() {
        open(po.githubUrl);

        $(po.headerSearchInput).setValue(po.repoPath).pressEnter();

        $(By.linkText(po.repoPath)).click();

        $(withText(po.issuesTab)).click();

        $(withText(po.issueNumber)).shouldBe(Condition.visible);
    }
}