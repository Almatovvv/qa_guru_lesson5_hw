import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestWithLambda {
    PageObjects po = new PageObjects();

    @Test
    void SearchIssueWithLambda() {
        step("Open " + po.githubUrl, () -> open(po.githubUrl));

        step("Search for Allure Repository " + po.repoPath, () -> $(po.headerSearchInput).setValue(po.repoPath).pressEnter());

        step("Click on a Repository link " + po.repoPath, () -> $(By.linkText(po.repoPath)).click());

        step("Click on an Issues tab " + po.issuesTab, () -> $(withText(po.issuesTab)).click());

        step("Issue number existence validation " + po.issueNumber, () -> $(withText(po.issueNumber)).shouldBe(Condition.visible));
    }

}