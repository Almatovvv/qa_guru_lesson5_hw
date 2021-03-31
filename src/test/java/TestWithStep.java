import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestWithStep {

    PageObjects po = new PageObjects();

    @Step("Open GitHub URL")
    public void OpenMainPage() {
        open(po.githubUrl);
    }

    @Step("Search for Allure Repository")
    public void SearchRepo() {
        $(po.headerSearchInput).setValue(po.repoPath).pressEnter();

    }

    @Step("Click on a Repository link")
    public void ClickRepo() {
        $(By.linkText(po.repoPath)).click();
    }

    @Step("Click on an Issues tab")
    public void ClickOnIssuesTab() {
        $(withText(po.issuesTab)).click();

    }

    @Step("Issue number existence validation")
    public void IssueNumberValidation() {
        $(withText(po.issueNumber)).shouldBe(Condition.visible);

    }

    @Test
    void SearchIssueWithSteps() {
        OpenMainPage();
        SearchRepo();
        ClickRepo();
        ClickOnIssuesTab();
        IssueNumberValidation();
    }
}
